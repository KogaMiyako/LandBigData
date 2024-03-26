package com.dlut.controller;

import com.alibaba.fastjson.JSON;
import com.dlut.algorithm.PCA;
import com.dlut.algorithm.RandomForest.RandomForest;
import com.dlut.algorithm.TrainLogisticTest;
import com.dlut.pojo.AlgorithmWithBLOBs;
import com.dlut.pojo.Class;
import com.dlut.pojo.Rank;
import com.dlut.pojo.User;
import com.dlut.service.IAlgorithmService;
import com.dlut.service.IClassService;
import com.dlut.util.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.mahout.classifier.sgd.RunLogistic;
import org.apache.mahout.classifier.sgd.TrainLogistic;
import org.apache.mahout.common.HadoopUtil;
import org.apache.mahout.common.distance.EuclideanDistanceMeasure;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuyu on 2018/04/14.
 */
@Controller
@RequestMapping("/algorithm")
public class AlgorithmController {

    @Resource
    private IAlgorithmService algorithmService;
    @Resource
    private IClassService classService;

    /**
     * 列出某类算法列表
     * @param id
     * @param response
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(int id, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {

        Class cs=classService.getClassDetails(id);
        List<AlgorithmWithBLOBs> algorithms=algorithmService.getAlgorithmListByClassId(id);
        for(AlgorithmWithBLOBs algorithm : algorithms){
            String describe = algorithm.getAlgorithmDescribe();
            if(describe.length()>50)
                describe = describe.substring(0,50)+"...";
            algorithm.setAlgorithmDescribe(describe);
        }
        model.addAttribute("cls", cs);
        model.addAttribute("algorithms", algorithms);
        return "algorithm/list";
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
        if(id == 9){
            return "algorithm/logisticlist";
        }
        else if(id == 1){
            return "algorithm/kmeanslist";
        }
        else if(id == 12) {
            return "algorithm/pcalist";
        }
        else if(id == 16){//土壤重金属重点污染区域指标筛选技术
            return "algorithm/al26";
        }
        else if(id == 17){//土壤-大气界面汞交换估测模型
            return "algorithm/al29";
        }
        else if(id == 18){//随机森林
            return "algorithm/randomForest";
        }

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

//        String cmdRegex="[#]?\\s*\\w+\\s*\\w+[.]\\w+\\s*";
        String cmdRegex="[#]?\\s*\\w+\\s*\\w+[.]\\w+\\s*[\\s*\\w+]*";
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
    public void upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, Model model) {
        String path = PathHelper.ALGORITHM_PATH;
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

        request.getSession().setAttribute("uploadfile",path+"\\"+fileName);

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


    //TODO
    @RequestMapping(value = "/checklogistic",method = RequestMethod.POST)
    public void checkLogisticFile(String rate,String features,String passes,HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        String trainFileFlag =(String)request.getSession().getAttribute("trainFile");
        String testFileFlag =(String)request.getSession().getAttribute("testFile");
        int count = 0;
        count += trainFileFlag == null?0:1;
        count += testFileFlag == null?0:1;
        System.out.println(count);
        Map<String,Object> map=new HashMap<String, Object>();

//        String cmdRegex="[#]?\\s*\\w+\\s*\\w+[.]\\w+\\s*";
        if(count == 2){
            map.put("result","bothyes");
        }else if(count < 2){
            map.put("result", "nofile");
        }

        String json= JSON.toJSONString(map);
        out.print(json);
        out.flush();
        out.close();
    }


    //pH,T_Ca,T_Cr,T_Mn,T_Ni,T_Cu,T_Zn,T_As,T_Cd,T_Pb
    @RequestMapping("/uploadlogisticTrain")
    public void uploadlogisticTrain(@RequestParam("trainfile") MultipartFile trainfile ,HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //文件1是训练样本集，文件2是测试样本集
        String path = PathHelper.TEMP_PATH;
        String trainFileName = trainfile.getOriginalFilename();

        System.out.println("upload to "+path+"/"+trainFileName);

        File trainFile = new File(path, trainFileName);
        if(!trainFile.exists()){
            trainFile.mkdirs();
        }
        try {
            trainfile.transferTo(trainFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("trainFile",path+"/"+trainFileName);
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

    @RequestMapping("/uploadlogisticTest")
    public void uploadlogistic(@RequestParam("testfile") MultipartFile testfile, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //文件1是训练样本集，文件2是测试样本集
        String path = PathHelper.TEMP_PATH;
        String testFileName = testfile.getOriginalFilename();
        System.out.println("upload to "+path+"/"+testFileName);
        File testFile = new File(path, testFileName);
        if(!testFile.exists()){
            testFile.mkdirs();
        }
        try {
            testfile.transferTo(testFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("testFile",path+"/"+testFileName);

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


    @Deprecated
    @RequestMapping(value = "/executelogistic",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> executeLogistic(HttpServletRequest request,String prediction,String target,String features,String rate,String passes) throws IOException {
        /**
         * 这块还需进一步细化，规范从数据库读取command命令
         */
        long startTime = new Date().getTime();
        Map<String,Object> map = new HashMap<>();
        String[] predictorStrs = prediction.split(",");
        for(int i=0;i<predictorStrs.length;i++){
            predictorStrs[i] = predictorStrs[i].trim();
        }
        TrainLogisticTest test = new TrainLogisticTest();
        String trainFile = (String)request.getSession().getAttribute("trainFile");
        String testFile = (String)request.getSession().getAttribute("testFile");
        if(trainFile == null || testFile == null){
            map.put("result","files count less than 2");
            return map;
        }
        try {
            test.example132(trainFile,testFile,target,predictorStrs,features,passes,rate);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error","error input,please check again");
            return map;
        }
        String expression = TrainLogistic.expression;
        DecimalFormat df =  new DecimalFormat("0.00000");
        Map<String,Double> propertionMap = TrainLogistic.propertionMap;
        List<String[]> propertions = new ArrayList<>();
        for(String key : propertionMap.keySet()){
            if("Intercept Term".equals(key)){
                propertions.add(new String[]{"ITArg",df.format(propertionMap.get(key))});
            }else{
                propertions.add(new String[]{key,df.format(propertionMap.get(key))});
            }
        }
        List<Integer> targets = RunLogistic.targets;

        List<Double> scores = RunLogistic.scores;
        List<String> scoress = new ArrayList<>();

        for(int i=0;i<scores.size();i++){
            scoress.add(df.format(scores.get(i)));
        }

        List<Double> likelihoods = RunLogistic.likelyhoods;
        map.put("expression",expression);
        map.put("propertions",propertions);
        map.put("targets",targets);
        map.put("scores",scoress);
        map.put("likelihoods",likelihoods);
        map.put("auc",(df.format(RunLogistic.auc*100)+"%"));
        long endTime = new Date().getTime();
        System.out.println("al spend "+(endTime-startTime)+"ms");
        return map;

    }

    @RequestMapping(value = "/checkkmeans",method = RequestMethod.POST)
    public void checkKmeansFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        String kmeansFileFlag =(String)request.getSession().getAttribute("kmeansFile");
        int count = 0;
        count += kmeansFileFlag == null?0:1;
        System.out.println(count);
        Map<String,Object> map=new HashMap<String, Object>();

//        String cmdRegex="[#]?\\s*\\w+\\s*\\w+[.]\\w+\\s*";
        if(count == 1){
            map.put("result","bothyes");
        }else if(count < 1){
            map.put("result", "nofile");
        }

        String json= JSON.toJSONString(map);
        out.print(json);
        out.flush();
        out.close();
    }


    @RequestMapping("/uploadkmeans")
    public void uploadkmeans(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //文件1是训练样本集，文件2是测试样本集
        String path = PathHelper.TEMP_PATH;
        String FileName = file.getOriginalFilename();
        System.out.println("upload to "+path+"/"+FileName);
        File kmeansFile = new File(path, FileName);
        if(!kmeansFile.exists()){
            kmeansFile.mkdirs();
        }
        try {
            file.transferTo(kmeansFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("kmeansFile",path+"/"+FileName);

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

    @Deprecated
    @RequestMapping(value = "/executekmeans",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> executekmeans(HttpServletRequest request,int k,double convergenceDelta,int maxIterations) throws IOException {
        /**
         * 这块还需进一步细化，规范从数据库读取command命令
         */
        Map<String,Object> map = new HashMap<>();

        String kmeansFile = (String)request.getSession().getAttribute("kmeansFile");
        String resultPath;
        if(kmeansFile == null){
            map.put("error","kmeans data file not upload");
            return map;
        }
        try {
            Path outputPath = new Path(PathHelper.TEMP_PATH + "/output");
            Configuration conf = new Configuration();
            HadoopUtil.delete(conf, outputPath);
            resultPath = PathHelper.TEMP_PATH + "/result-kmeans.txt";
            Path inputPath = new Path(kmeansFile);

            org.apache.mahout.clustering.syntheticcontrol.kmeans.Job.run(conf,inputPath,outputPath,new EuclideanDistanceMeasure(),k,convergenceDelta,maxIterations,resultPath);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error","error input,please check again");
            return map;
        }
        BufferedReader reader = new BufferedReader(new FileReader(resultPath));
        StringBuilder sb = new StringBuilder();
        String temp;
        while((temp = reader.readLine()) != null){
            sb.append(temp);
            sb.append("</br>");
        }
        map.put("expression",sb.toString());


        return map;

    }

    @RequestMapping("/uploadpca")
    public void uploadpca(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //文件1是训练样本集，文件2是测试样本集
        String path = PathHelper.PCA_PATH;
        String fileName = file.getOriginalFilename();
        System.out.println("upload to "+path+"/"+fileName);
        File testFile = new File(path, fileName);
        if(!testFile.exists()){
            testFile.mkdirs();
        }
        try {
            file.transferTo(testFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("pcaFile",path+"\\"+fileName);

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


    @RequestMapping(value = "/checkpca",method = RequestMethod.POST)
    public void checkpca(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        String pcaFileFlag =(String)request.getSession().getAttribute("pcaFile");
        File file = new File(pcaFileFlag);
        int count = 0;
        if(file.exists())
            count++;
        System.out.println(count);
        Map<String,Object> map=new HashMap<String, Object>();

        if(count == 1){
            map.put("result","bothyes");
        }else if(count < 1){
            map.put("result", "nofile");
        }

        String json= JSON.toJSONString(map);
        out.print(json);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/executepca",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> executepca(HttpServletRequest request) throws Exception {
        /**
         * 这块还需进一步细化，规范从数据库读取command命令
         */
        Map<String,Object> map = new HashMap<>();

        String pcaFile = (String)request.getSession().getAttribute("pcaFile");
        String[] strs = pcaFile.split("\\\\");

        if(pcaFile == null){
            map.put("error","pca data file not upload");
            return map;
        }
        String fileName = strs[strs.length-1];
        String[] fileSp = fileName.split("\\.");
        String resultFileName = fileSp[0] + "Result.txt";
        PCA pca = algorithmService.doPCA(pcaFile,PathHelper.PCA_PATH+"/"+resultFileName);
        double[] eigenvalues = pca.eigenvalues;
        Object[][] formatResult = pca.formatResult;
        formatResult = ArrUtils.reserveArrByCloumn(formatResult);
        double[] fourEigen = new double[4];
        if(eigenvalues.length>4){
            for(int i=eigenvalues.length-1;i>0;i--){
                if(i>eigenvalues.length-4)
                    fourEigen[eigenvalues.length-i-1] = eigenvalues[i];
                else
                    fourEigen[3] += eigenvalues[i];
            }
        }
        map.put("fileName",fileName);
        map.put("eigenvalues",fourEigen);
        map.put("formatResult",formatResult);
        return map;

    }


    //pH,T_Ca,T_Cr,T_Mn,T_Ni,T_Cu,T_Zn,T_As,T_Cd,T_Pb
    @RequestMapping("/uploadRFTrain")
    public void uploadRFTrain(@RequestParam("trainfile") MultipartFile trainfile ,HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //文件1是训练样本集，文件2是测试样本集
        String path = PathHelper.RF_PATH;
        String trainFileName = trainfile.getOriginalFilename();

        System.out.println("upload to "+path+"/"+trainFileName);

        File trainFile = new File(path, trainFileName);
        if(!trainFile.exists()){
            trainFile.mkdirs();
        }
        try {
            trainfile.transferTo(trainFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("RFtrainFile",path+"/"+trainFileName);
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

    @RequestMapping("/uploadRFTest")
    public void uploadRFTest(@RequestParam("testfile") MultipartFile testfile, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //文件1是训练样本集，文件2是测试样本集
        String path = PathHelper.RF_PATH;
        String testFileName = testfile.getOriginalFilename();
        System.out.println("upload to "+path+"/"+testFileName);
        File testFile = new File(path, testFileName);
        if(!testFile.exists()){
            testFile.mkdirs();
        }
        try {
            testfile.transferTo(testFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("RFtestFile",path+"/"+testFileName);

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

    @RequestMapping(value = "/checkrf",method = RequestMethod.POST)
    public void checkRFFile(String target,HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        String trainFileFlag =(String)request.getSession().getAttribute("RFtrainFile");
        String testFileFlag =(String)request.getSession().getAttribute("RFtestFile");
        int count = 0;
        count += trainFileFlag == null?0:1;
        count += testFileFlag == null?0:1;
        System.out.println(count);
        Map<String,Object> map=new HashMap<String, Object>();

//        String cmdRegex="[#]?\\s*\\w+\\s*\\w+[.]\\w+\\s*";
        if(count == 2){
            map.put("result","bothyes");
        }else if(count < 2){
            map.put("result", "nofile");
        }

        String json= JSON.toJSONString(map);
        out.print(json);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/executeRF",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> executeRF(HttpServletRequest request,String target,int hasPoint) throws IOException {
        /**
         * 这块还需进一步细化，规范从数据库读取command命令
         */
        long startTime = new Date().getTime();
        Map<String,Object> map = new HashMap<>();
        boolean hasPointFlag = false;
        double[][] points = null;
        ArrayList<Integer> predictionResult;
        if(hasPoint == 1)
            hasPointFlag = true;
        String trainFile = (String)request.getSession().getAttribute("RFtrainFile");
        String testFile = (String)request.getSession().getAttribute("RFtestFile");
        if(trainFile == null || testFile == null){
            map.put("result","files count less than 2");
            return map;
        }

        try {
            RandomForest rf = RandomForest.doRandomForest(Integer.parseInt(target),trainFile,testFile,hasPointFlag);
            if(hasPointFlag){
                points = rf.getPoints();
            }
            predictionResult = rf.getVal();
            int[] pre = new int[predictionResult.size()];
            //获取放大或者缩小的这个基数
            int ori = ArrUtils.getPrecisionResult(HeavyMetalConstant.precision);
            for(int i=0;i<predictionResult.size();i++){
                pre[i] = predictionResult.get(i)/ori;
            }
            map.put("points",points);
            map.put("prediction",pre);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error","error input,please check again");
            return map;
        }

        return map;

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

    /**
     * 添加算法，ajax传JSON数据请求
     * 绑定pojo实体AlgorithmWithBLOBs
     * @param algorithm
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public Map<String,String> addAlgorithm(@RequestBody AlgorithmWithBLOBs algorithm, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        String describe = algorithm.getAlgorithmDescribe();
        describe = describe.replaceAll("\n","<br>");
        algorithm.setAlgorithmDescribe(describe);
        String tip = algorithm.getAlgorithmTip();
        tip = tip.replaceAll("\n","<br>");
        algorithm.setAlgorithmTip(tip);
        algorithm.setAlgorithmAuthor(user.getUserName());
        algorithm.setAlgorithmTime(new Date());

        Map<String,String> map=new HashMap<String, String>();
        try {

            int insertFlag=algorithmService.addAlgorithm(algorithm);
            if (insertFlag==1) {
                map.put("addStatus","success");
            } else {
                map.put("addStatus", "failed");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("addStatus", "failed");
        }
        return map;
    }

}
