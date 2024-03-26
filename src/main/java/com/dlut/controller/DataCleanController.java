package com.dlut.controller;

import com.alibaba.fastjson.JSON;
import com.dlut.algorithm.MetalCluster;
import com.dlut.algorithm.MetalModel;
import com.dlut.pojo.Class;
import com.dlut.pojo.Pollution;
import com.dlut.pojo.wrapper.PollutionAnalysis;
import com.dlut.pojo.wrapper.PollutionWrapper;
import com.dlut.service.IAlgorithmService;
import com.dlut.service.IClassService;
import com.dlut.service.IPollutionService;
import com.dlut.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhonghua on 2016/7/18.
 * updated by febiven on 2018/10/27
 */
@Controller
@RequestMapping("/dataClean")
public class DataCleanController {

    @Resource
    private IPollutionService pollutionService;
    @Resource
    private IAlgorithmService algorithmService;
    @Resource
    private IClassService classService;

    /**
     * 列出某类算法列表
     * @param response
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)

    //TODO   需要
    public String list(int id,HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {

        Class cs=classService.getClassDetails(id);
//        List<AlgorithmWithBLOBs> algorithms=algorithmService.getAlgorithmListByClassId(id);
        model.addAttribute("cls", cs);
//        model.addAttribute("algorithms", algorithms);
//        return "dataclean/list";
        if(id == 9)
            return "dataclean/adminManager";
        if(id == 7)
            return "dataclean/nemerowList1";
        else
            return "dataclean/boxList";
    }

    /**
     * 算法详情页数据显示
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/tooltip",method = RequestMethod.GET)
    public String tooltip(int id,Model model){
        model.addAttribute("algorithm",algorithmService.getAlgorithmTooltipById(id));
        return "algorithm/tooltip";
    }

    /**
     * 检测上传文件状态，如果判断没有文件，返回前端command无法执行
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public void checkFile(String command,HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        String fileStatus=(String)request.getSession().getAttribute("uploadfile");
        System.out.println(fileStatus);
        Map<String,Object> map=new HashMap<String, Object>();

        String cmdRegex="[#]?\\s*\\w+\\s*\\w+[.]\\w+\\s*";
        Pattern p=Pattern.compile(cmdRegex);
        Matcher m=p.matcher(command);
//        map.put("result","bothyes");
        if(fileStatus!=null && m.matches()){
            map.put("result","bothyes");
        }else if(fileStatus!=null && !m.matches()){
            map.put("result","nomatch");
        }else if(fileStatus==null && m.matches()){
            if(command.startsWith("#"))
                map.put("result","bothyes");
            else
                map.put("result", "nofile");
        }else if(fileStatus==null && !m.matches()){
            map.put("result","bothno");
        }

        String json= JSON.toJSONString(map);
        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 接收前端ajax.post的command请求,建立ssh的connection与session连接
     * 如果改进该方法，规范从数据库读取command命令
     * @param command
     * @throws IOException
     */
    @Deprecated
    @RequestMapping(value = "/execute",method = RequestMethod.POST)
    public void execute(HttpServletRequest request,HttpServletResponse response,String command,PrintWriter out) throws IOException {
        /**
         * 这块还需进一步细化，规范从数据库读取command命令
         */
//        String[] strs = command.split(" ");
//        String resultFile = path + "/" + strs[strs.length-1]+".txt";
        if(command.startsWith("#"))
            command = command.substring(1);
        SSHHelper.ssh(command);
//        FileWriter writer = new FileWriter(resultFile);
//        String resultLine = SSHHelper.readStdout();
//        while(resultLine != null){
//            writer.write(resultLine);
//            resultFile = SSHHelper.readStdout();
//        }
//        writer.close();


    }

    @RequestMapping("/upload")
    //TODO   需要
    public void upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, Model model) {
        String path = PathHelper.DATACLEAN_PATH;
        String fileName=file.getOriginalFilename();
        System.out.println("upload to "+path+"\\"+fileName);

        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("excelName",fileName);


        PrintWriter out= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print("{\"result\":\"upload success\"}");
        out.flush();
        out.close();
    }

    /**
     * 前端ajax.get轮询请求,获取实时log返回前端
     * 如果返回为null，前端判断停止
     * 该方法为重载方法，主要负责ajax的轮询请求
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/execute",method = RequestMethod.GET)
    public void execute(HttpServletResponse response) throws IOException {
        System.out.println("**********************************************************");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        /*
         *获取实时log,如果为空返回前端null，停止发送请求
         */
        String logs=SSHHelper.getLogs();
        if(logs==null){
            out.print("null");
            SSHHelper.close();
        }else{
            /*
             *返回日志字符串截取，输出有效内容
             */
//            logs = EncodingHelper.utf_8_2gbk(logs);
            if(logs.contains("Welcome to Ubuntu 15.04") && logs.contains("slave@master:~$")){
                int sIndex=logs.indexOf("slave@master:~$");
                int len=logs.length();
                logs=logs.substring(sIndex,len);
                /*替换部分无意义内容*/
                logs=logs.replace("slave@master:~$","");
            }

            System.out.println("logs:"+logs);
            out.print(logs.trim());
        }
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/addNemerow",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public Map<String,Object> addNemerowData(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        File file = new File(PathHelper.DATACLEAN_PATH+"/"+request.getSession().getAttribute("excelName"));
        if(!file.exists()){
            map.put("addStatus", "failed");
            return map;
        }

        try {

            Object[][] data = ExcelUtil.getObjectData(file,4);
            //已经包含了nemerow综合参数，在第九（index 为 8）列
            Object[][] nemerow = ExcelUtil.getStandard(data);
            ArrUtils.fillArrayByOriginValueIfBlank(data,nemerow);
//            fillArrayByOriginValueIfBlank()
            String[] elements = ExcelUtil.getElementNames();
            String[] elementsName = new String[9];
            //在名称数组上去掉pH项，增加Nemerow项
            System.arraycopy(elements,1,elementsName,0,8);
            elementsName[8] = "Nemerow";
            List list = ExcelUtil.data2FormatNemerow(nemerow,elementsName);
            //计算污染的重金属,并整合到pluMetals中
            List<Integer> pluMetals = new ArrayList<>();
            String allPlus = "";
            int commaCount = 0;
            int length = nemerow.length;
            for(int i=1;i<9;i++){
                double count = 0;
//                System.out.println(HeavyMetalConstant.int2StringMetal.get(i));
                for(int j=0;j<length;j++){
                    if((double)nemerow[j][i-1]>1.0) {
                        count++;
                    }
                }
                double result = count/length;
                if(result>HeavyMetalConstant.threshold){
                    pluMetals.add(i-1);
                    if(commaCount > 0)
                        allPlus += " , ";
                    allPlus += HeavyMetalConstant.int2StringMetal.get(i-1);
                    commaCount++;
                }

            }
            request.getSession().setAttribute("pluMetals",pluMetals);
            //计算可能的污染源
            List<PollutionAnalysis> pa = new ArrayList<>();
            List<PollutionWrapper> pluWrs = new ArrayList<>();
            List<Pollution> plus = pollutionService.getAllPollution();

            PollutionWrapper.convert(plus,pluWrs);
            for(PollutionWrapper plu : pluWrs){
                pa.add(new PollutionAnalysis(plu));
            }

            MetalModel model = MetalCluster.createMetalModel(PathHelper.DATACLEAN_PATH+"/"+request.getSession().getAttribute("excelName"));
            Object[][] relationMatrix = MetalCluster.calculateAllScoreMatrix(model);
            double[][] result = MetalCluster.calculateScore2Matrix(model);
            List<Pollution> pluResult = new ArrayList<>();

            //三种不同的等级的污染
            List<PollutionAnalysis> highLevel = new ArrayList<>();
            List<PollutionAnalysis> middleLevel = new ArrayList<>();
            List<PollutionAnalysis> lowLevel = new ArrayList<>();


            //对于每一种超标元素
            for(Integer pluInt : pluMetals){
                double[] percents = result[pluInt];
                //计算相同增长趋势的同比元素
                boolean[] metalSimilar = new boolean[8];

                for(int i=0;i<percents.length;i++){
                    metalSimilar[i] = false;
                    if(percents[i] > HeavyMetalConstant.MetalModelThreshold && i != pluInt)
                        metalSimilar[i] = true;
                }

                //  计算每一种源的评分
                for(PollutionAnalysis paTemp : pa){
                    PollutionWrapper plu = paTemp.getPlu();
                    //主判定一套，非主判定一套
                    if(plu.getPluArrs()[pluInt] == 2){
                        paTemp.setMain(paTemp.getMain()+1);
                        for(int j=0;j<metalSimilar.length;j++){
                            if(metalSimilar[j]){
                                if(plu.getPluArrs()[j] == 2)
                                    paTemp.setSimilarIsMain(true);
                                else if(plu.getPluArrs()[j] == 1)
                                    paTemp.setMainSimilar(paTemp.getMainSimilar()+1);
                            }
                        }
                    }
                    else if(plu.getPluArrs()[pluInt] == 1){
                        paTemp.setNotMain(paTemp.getNotMain()+1);
                        for(int j=0;j<metalSimilar.length;j++){
                            if(metalSimilar[j]){
                                paTemp.setNotMainSimilar(paTemp.getNotMainSimilar()+1);
                            }
                        }
                    }
                }


                for(PollutionAnalysis paTemp : pa){
                    if(paTemp.isSimilarIsMain())
                        highLevel.add(paTemp);
                    else if(paTemp.getMain()>0)
                        middleLevel.add(paTemp);
                    else{
                        lowLevel.add(paTemp);
                    }
                }
            }

            MetalCluster.levelPluSort(highLevel);
            map.put("highLevel",highLevel);

            MetalCluster.levelPluSort(middleLevel);
            map.put("middleLevel",middleLevel);

            MetalCluster.levelPluSort(lowLevel);
            map.put("lowLevel",lowLevel);

            int[] levelNums = new int[]{highLevel.size(),middleLevel.size(),lowLevel.size()};
            map.put("relationMatrix",relationMatrix);
            map.put("levelNums",levelNums);
            map.put("addStatus","success");
            map.put("result",list);
            map.put("pluList",pluMetals);
            map.put("pluStr",allPlus);
            map.put("nemerowArr",nemerow);
            map.put("data",data);
            map.put("standard",HeavyMetalConstant.standards);

        }catch (Exception e){
            e.printStackTrace();
            map.put("addStatus", "failed");
        }
        return map;
    }

    @RequestMapping(value = "/addBox",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public Map<String,Object> addBoxData(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        File file = new File(PathHelper.DATACLEAN_PATH+"/"+request.getSession().getAttribute("excelName"));
        if(!file.exists()){
            map.put("addStatus", "failed");
            return map;
        }

        try {

            double[][] data = ExcelUtil.getData(file,4);
            String[] elements = ExcelUtil.getElementNames();
            ExcelDataModel model = ExcelUtil.convertDoubleArrayToExcelModel(data,elements);
            request.getSession().setAttribute("excelModel",model);
            List list = ExcelUtil.data2FormatBox(model,elements);
            if (true) {
                map.put("addStatus","success");
                map.put("result",list);
            } else {
                map.put("addStatus", "failed");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("addStatus", "failed");
        }
        return map;
    }

    @RequestMapping(value = "/fixBox",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public Map<String,Object> fixBox(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        Object object = request.getSession().getAttribute("excelModel");
        if(object == null){
            map.put("errormsg", "the Excel file not exists");
            return map;
        }
        try {
            ExcelDataModel model = (ExcelDataModel) object;
            ExcelDataModel.findErrorPoints(model);
            String errormsg = model.getErrorInfoFormat();
            List<ExcelDataModel.Point> errorList = model.getErrorPoints();
            List<ExcelDataModel.Point> errorList1 = new ArrayList<>(errorList);
            Collections.copy(errorList1,errorList);
            map.put("errormsg",errormsg);
            model.fixAllErrorPoint();
            String fileName = PathHelper.TEMP_PATH + "/" + StringUtil.SplitAndMergeFileName((String)(request.getSession().getAttribute("excelName")),"_fix");
            ExcelUtil.exportArrayToXlsxWithHighLight(model.getData(),fileName,model.getElements(),errorList1);
            List list = ExcelUtil.data2FormatBox(model,model.getElements());
            map.put("result",list);

        }catch (Exception e){
            e.printStackTrace();
            map.put("errormsg", "resolve file failed");
        }
        return map;
    }

    @RequestMapping(value = "/downloadFixedExcel",method = RequestMethod.GET)
    public void downloadFixedExcel(HttpServletRequest request,HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        try {
            OutputStream out=response.getOutputStream();
            //将model先导入WEB-INF/temp文件夹，然后再通过response输出
            String fileName = StringUtil.SplitAndMergeFileName((String)(request.getSession().getAttribute("excelName")),"_fix");
            String filePath = PathHelper.TEMP_PATH + "/" + fileName;
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
            FileInputStream fis = new FileInputStream(filePath);
            byte[] buffer=new byte[1024];
            int len=0;
            while((len=fis.read(buffer))>0){
                out.write(buffer,0,len);
            }
            fis.close();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }





}
