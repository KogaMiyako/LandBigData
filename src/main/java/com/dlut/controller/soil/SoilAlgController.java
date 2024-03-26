package com.dlut.controller.soil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dlut.algorithm.KMeans;
import com.dlut.pojo.AlgHistory;
import com.dlut.pojo.Sourcetable;
import com.dlut.pojo.User;
import com.dlut.service.IAlgHistoryService;
import com.dlut.service.IResourceService;
import com.dlut.util.PathHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/soilAlg")
public class SoilAlgController {

    @Resource
    private IResourceService resourceService;

    @Resource
    private IAlgHistoryService algHistoryService;

    private String nowTimeString;

    public static Map<String,Object> reloadRes(String pathname) throws IOException{
        Reader reader = new InputStreamReader(Files.newInputStream(Paths.get(pathname)), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1){
            sb.append((char) ch);
        }
        reader.close();
        String jsonStr = sb.toString();
        System.out.println(jsonStr);

        Map<String, Object> map = new HashMap<>();
        map = JSON.parseObject(jsonStr, Map.class);
        return map;
    }


    @RequestMapping(value = "/resourceAlg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> resourceAlg(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        String filePath = uploadFileMap.get("filePath");
        String fileType = uploadFileMap.get("fileType");

        /*        try {
           Path outputPath = new Path(PathHelper.TEMP_PATH + "/output");
            Configuration conf = new Configuration();
//            HadoopUtil.delete(conf, outputPath);

            // zlx:结果文件
            resultPath = PathHelper.TEMP_PATH + "/result-kmeans.txt";
            Path inputPath = new Path(filePath);

            org.apache.mahout.clustering.syntheticcontrol.kmeans.Job.run(conf,inputPath,outputPath,new EuclideanDistanceMeasure(),k,convergenceDelta,maxIterations,resultPath);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("error","error input,please check again");
            return map;
        }

        // zlx: 以下是读取结果文件
        /*BufferedReader reader = new BufferedReader(new FileReader(resultPath));
        StringBuilder sb = new StringBuilder();
        String temp;
        while((temp = reader.readLine()) != null){
            sb.append(temp);
            sb.append("</br>");
        }
        map.put("expression",sb.toString());*/
        
        // zlx 测试一下
        map.put("filePath", filePath);
        map.put("fileType", fileType);

        return map;

    }

    @RequestMapping(value = "/resourcePieData",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> resourcePieData(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();

        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");
        String filePath = uploadFileMap.get("filePath");

        // 找主要污染物
        Map<String, Double> resMap = resourceService.getMainElem(filePath, 1, 8);

        String mainElemName = "";
        double mainElemData = 0.0;

        ArrayList<String> legend = new ArrayList<>();

        for (Map.Entry<String, Double> entry: resMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
            legend.add(entry.getKey());
            if (mainElemData < entry.getValue()){
                mainElemData = entry.getValue();
                mainElemName = entry.getKey();
            }
        }
        System.out.println("主要污染物：");
        System.out.println(mainElemName);
        request.getSession().setAttribute("mainElemName", mainElemName);

        map.put("result", resMap);
        map.put("legend", legend);
        map.put("mainElemName", mainElemName);
        map.put("mainElemData", mainElemData);

        String s = JSONObject.toJSONString(map);

        String resPath = PathHelper.CALCULTATOR_RESULT_PATH;
        User user = (User)request.getSession().getAttribute("user");
        String userId = Integer.toString(user.getUserId());

        String[] dataSplit = filePath.split("/");
        String dataNameO = dataSplit[dataSplit.length-1];
        String dataName = dataNameO.split("\\.")[0];
        System.out.println(dataName);

        String dataType = uploadFileMap.get("fileType");

        //format time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());
        nowTimeString = dateStr;


        String fileName = "1_" + userId + "_" + dataName + "_" + dataType + "_" + dateStr  ;

        algHistoryService.addHistory(new AlgHistory(1, user.getUserId(), dataNameO, dataType, dateStr, fileName));

        fileName = fileName + "_" + "part1";

        File file = new File(resPath + "\\" + fileName + ".json");
        PrintWriter ps = new PrintWriter(Files.newOutputStream(file.toPath()));
        ps.print(s);
        ps.close();

        return map;

    }


    @RequestMapping(value = "/resourceBarData",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> resourceBarData(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();

        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");
        String filePath = uploadFileMap.get("filePath");
        String mainElemName = (String)request.getSession().getAttribute("mainElemName");

        // 找最相关两个污染
        Map<Double, String> relevantMap = resourceService.getMostRelevantElem(mainElemName,
                filePath, 1, 8);


        int length = relevantMap.size();
        String[] x_data = new String[length];
        double[] y_data = new double[length];
        int i = length - 1;

        for (Map.Entry<Double, String> entry: relevantMap.entrySet()){
            x_data[i] = entry.getValue();
            y_data[i] = entry.getKey()  ;
            i--;
        }

        /*for (int j = 0; j < length; j++){
            System.out.println(x_data[j] + ":" + y_data[j]);
        }*/

        map.put("x_data", x_data);
        map.put("y_data", y_data);

        String s = JSONObject.toJSONString(map);

        String resPath = PathHelper.CALCULTATOR_RESULT_PATH;
        User user = (User)request.getSession().getAttribute("user");
        String userId = Integer.toString(user.getUserId());

        String[] dataSplit = filePath.split("/");
        String dataName = dataSplit[dataSplit.length-1];
        dataName = dataName.split("\\.")[0];
        System.out.println(dataName);

        String dataType = uploadFileMap.get("fileType");

        //format time
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String dateStr = sdf.format(new Date());
        String dateStr = nowTimeString;

        String fileName = "1_" + userId + "_" + dataName + "_" + dataType + "_" + dateStr + "_" + "part2";

        File file = new File(resPath + "\\" + fileName + ".json");
        PrintWriter ps = new PrintWriter(Files.newOutputStream(file.toPath()));
        ps.print(s);
        ps.close();

        return  map;
    }

    @RequestMapping(value = "/resourceDescribeData", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> resourceDescribeData(String mainElem, String elem1, String elem2, HttpServletRequest request) throws IOException {

        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");
        String filePath = uploadFileMap.get("filePath");

        System.out.println(mainElem);
        System.out.println(elem1);
        System.out.println(elem2);

        Sourcetable sourcetable = resourceService.getSourcePollution(mainElem, elem1, elem2);

        System.out.println(sourcetable.getDescribe());
        System.out.println(sourcetable.getPollutionname());

        Map<String, Object> map = new HashMap<>();
        map.put("sourceName", sourcetable.getPollutionname());
        map.put("describe", sourcetable.getDescribe());

        String s = JSONObject.toJSONString(map);

        String resPath = PathHelper.CALCULTATOR_RESULT_PATH;
        User user = (User)request.getSession().getAttribute("user");
        String userId = Integer.toString(user.getUserId());

        String[] dataSplit = filePath.split("/");
        String dataName = dataSplit[dataSplit.length-1];
        dataName = dataName.split("\\.")[0];
        System.out.println(dataName);

        String dataType = uploadFileMap.get("fileType");

        //format time
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String dateStr = sdf.format(new Date());
        String dateStr = nowTimeString;

        String fileName = "1_" + userId + "_" + dataName + "_" + dataType + "_" + dateStr + "_" + "part3";

        File file = new File(resPath + "\\" + fileName + ".json");
        PrintWriter ps = new PrintWriter(Files.newOutputStream(file.toPath()));
        ps.print(s);
        ps.close();

        return map;
    }

    @RequestMapping(value = "/resourcePieData2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> resourcePieData2(HttpServletRequest request) throws IOException {
        String fileName = (String)request.getSession().getAttribute("historyFileName");
        String pathname = PathHelper.CALCULTATOR_RESULT_PATH + "/" + fileName + "_part1.json";
        /*Reader reader = new InputStreamReader(Files.newInputStream(Paths.get(pathname)), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1){
            sb.append((char) ch);
        }
        reader.close();
        String jsonStr = sb.toString();
        System.out.println(jsonStr);

        Map<String, Object> map = new HashMap<>();
        map = JSON.parseObject(jsonStr, Map.class);*/
        return reloadRes(pathname);
    }

    @RequestMapping(value = "/resourceBarData2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> resourceBarData2(HttpServletRequest request) throws IOException {
        String fileName = (String)request.getSession().getAttribute("historyFileName");
        String pathname = PathHelper.CALCULTATOR_RESULT_PATH + "/" + fileName + "_part2.json";
        /*Reader reader = new InputStreamReader(Files.newInputStream(Paths.get(pathname)), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1){
            sb.append((char) ch);
        }
        reader.close();
        String jsonStr = sb.toString();
        System.out.println(jsonStr);

        Map<String, Object> map = new HashMap<>();
        map = JSON.parseObject(jsonStr, Map.class);*/
        return reloadRes(pathname);
    }

    @RequestMapping(value = "/resourceDescribeData2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> resourceDescribeData2(HttpServletRequest request) throws IOException {
        String fileName = (String)request.getSession().getAttribute("historyFileName");
        String pathname = PathHelper.CALCULTATOR_RESULT_PATH + "/" + fileName + "_part3.json";
        /*Reader reader = new InputStreamReader(Files.newInputStream(Paths.get(pathname)), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1){
            sb.append((char) ch);
        }
        reader.close();
        String jsonStr = sb.toString();
        System.out.println(jsonStr);

        Map<String, Object> map = new HashMap<>();
        map = JSON.parseObject(jsonStr, Map.class);*/
        return reloadRes(pathname);
    }

    @RequestMapping(value = "/siteSelectData",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> siteSelectData(HttpServletRequest request) throws IOException, InterruptedException {
        Map<String, Object> map = new HashMap<>();

        // 设置 Anaconda 虚拟环境的路径和需要运行的 Python 脚本
        String pythonEnvPath = PathHelper.CONDA_PATH;
        String pythonPreScriptPath = PathHelper.PY_PATH + "/SDCN/sdcn.py";
        String pythonScriptPath = PathHelper.PY_PATH + "/SDCN/test.py";

        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");
        String filePath = uploadFileMap.get("filePath");

        // ********* step 1 SDCN.py + .xlsx => res.txt
        // data was fixed... res.txt was also fixed... there was no need to run to get res.txt ......
        // ore no se jya nai kono alg kaida no senpai no sei

        // ********* step 2 test.py + .xlsx => two list
        // 激活 Anaconda 虚拟环境并运行 Python 脚本
        String command = "cmd /c \"activate " + pythonEnvPath + " && python " + pythonScriptPath + "\"";
        Process process = Runtime.getRuntime().exec(command);

        // 获取Python脚本的标准输出流
        InputStream stdout = process.getInputStream();
        BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));

        // 获取Python脚本的标准错误流
        InputStream stderr = process.getErrorStream();
        BufferedReader stderrReader = new BufferedReader(new InputStreamReader(stderr));

        // 读取Python脚本的标准输出流
        String line;
        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        List<Double> list = list1;

        while ((line = stdoutReader.readLine()) != null) {

            String[] parts = line.split("\\s+");
            for (String part : parts) {

                if (Objects.equals(part, "")){
                    continue;
                }

                if (part.startsWith("[")) {
                    part = part.substring(1);
                    list.add(Double.parseDouble(part));
                }else if (part.endsWith("]")) {
                    part = part.substring(0, part.length() - 1);
                    list.add(Double.parseDouble(part));
                    if (list == list1) {
                        list = list2;
                    }
                }else {
                    list.add(Double.parseDouble(part));
                }
            }
        }

        // 读取Python脚本的标准错误流
        while ((line = stderrReader.readLine()) != null) {
            System.err.println(line);
        }

        // 等待 Python 脚本执行结束
        int exitCode = process.waitFor();
        System.out.println("Python script exited with code " + exitCode);

        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());

        map.put("data_x", list1);
        map.put("data_y", list2);


        // ********* step 3 get old data

        String filename = PathHelper.PY_PATH + "/SDCN/soil_data_before.xlsx"; // 文件名
        ArrayList<Double> ArrayList1 = new ArrayList<>();
        ArrayList<Double> ArrayList2 = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0); // 获取第一个sheet
            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
                if (cell1 == null || cell2 == null) {
                    continue;
                }
                Double value1 = cell1.getNumericCellValue();
                Double value2 = cell2.getNumericCellValue();
                ArrayList1.add(value1);
                ArrayList2.add(value2);
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ArrayList1);
        System.out.println(ArrayList2);

        map.put("data_old_x", ArrayList1);
        map.put("data_old_y", ArrayList2);

        // ********* step 4 calculate the valid res
        String pythonScriptPath2 = PathHelper.PY_PATH + "/SDCN/soil_eval.py";


        // 激活 Anaconda 虚拟环境并运行 Python 脚本
        String command2 = "cmd /c \"activate " + pythonEnvPath + " && python " + pythonScriptPath2 + "\"";
        Process process2 = Runtime.getRuntime().exec(command2);

        // 获取Python脚本的标准输出流
        InputStream stdout2 = process2.getInputStream();
        BufferedReader stdoutReader2 = new BufferedReader(new InputStreamReader(stdout2));

        // 获取Python脚本的标准错误流
        InputStream stderr2 = process2.getErrorStream();
        BufferedReader stderrReader2 = new BufferedReader(new InputStreamReader(stderr2));

        // 读取Python脚本的标准输出流
        String line2 = stdoutReader2.readLine();
        Double eval_res = Double.parseDouble(line2);

        // 读取Python脚本的标准错误流
        while ((line = stderrReader2.readLine()) != null) {
            System.err.println(line);
        }

        // 等待 Python 脚本执行结束
        int exitCode2 = process2.waitFor();
        System.out.println("Python script exited with code " + exitCode2);
        System.out.println(eval_res);

        map.put("eval_res", eval_res);

        // 激活 Anaconda 虚拟环境并运行 Python 脚本
        command2 = "cmd /c \"activate " + pythonEnvPath + " && python " + pythonScriptPath2 + " -opt " + "\"";
        process2 = Runtime.getRuntime().exec(command2);

        // 获取Python脚本的标准输出流
        stdout2 = process2.getInputStream();
        stdoutReader2 = new BufferedReader(new InputStreamReader(stdout2));

        // 获取Python脚本的标准错误流
        stderr2 = process2.getErrorStream();
        stderrReader2 = new BufferedReader(new InputStreamReader(stderr2));

        // 读取Python脚本的标准输出流
        line2 = stdoutReader2.readLine();
        eval_res = Double.parseDouble(line2);

        // 读取Python脚本的标准错误流
        while ((line = stderrReader2.readLine()) != null) {
            System.err.println(line);
        }

        // 等待 Python 脚本执行结束
        exitCode2 = process2.waitFor();
        System.out.println("Python script exited with code " + exitCode2);
        System.out.println(eval_res);

        map.put("eval_res_old", eval_res);

        // ********* step 5 save all res to json
        // todo: save
        String s = JSONObject.toJSONString(map);

        String resPath = PathHelper.CALCULTATOR_RESULT_PATH;
        User user = (User)request.getSession().getAttribute("user");
        String userId = Integer.toString(user.getUserId());

        String[] dataSplit = filePath.split("/");
        String dataNameO = dataSplit[dataSplit.length-1];
        String dataName = dataNameO.split("\\.")[0];
        System.out.println(dataName);

        String dataType = uploadFileMap.get("fileType");

        //format time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());
        String fileName = "2_" + userId + "_" + dataName + "_" + dataType + "_" + dateStr;

        algHistoryService.addHistory(new AlgHistory(2, user.getUserId(), dataNameO, dataType, dateStr, fileName));

        File file = new File(resPath + "\\" + fileName + ".json");
        PrintWriter ps = new PrintWriter(Files.newOutputStream(file.toPath()));
        ps.print(s);
        ps.close();

        return map;
    }

    @RequestMapping(value = "/siteSelectData2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> siteSelectData2(HttpServletRequest request) throws IOException, InterruptedException {
        String fileName = (String)request.getSession().getAttribute("historyFileName");
        String pathname = PathHelper.CALCULTATOR_RESULT_PATH + "/" + fileName + ".json";
        return reloadRes(pathname);
    }

    @RequestMapping(value = "/siteSelectAlg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> siteSelectAlg(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        String filePath = uploadFileMap.get("filePath");
        String fileType = uploadFileMap.get("fileType");

        // zlx 测试一下
        map.put("filePath", filePath);
        map.put("fileType", fileType);

        return map;

    }

    //classificationOne

    public void copyFile(String fromPath, String goPath) throws IOException{
//        String fromPath = "D://akari.jpg";
        File fromFile = new File(fromPath);

        if (!fromFile.exists()){

            fromFile.createNewFile();

        }

//        String goPath = "D://test3/akari.jpg";
        File goFile = new File(goPath);

        if (!goFile.exists()){
            goFile.createNewFile();
        }

        InputStream in = new FileInputStream(fromFile);
        OutputStream out = new FileOutputStream(goFile);
        int i = 0;
        while ((i = in.read()) != -1){
            char j = (char) i;
            out.write(j);
        }
        out.flush();
        out.close();
        in.close();
    }

    @RequestMapping(value = "/classificationOne",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> classificationOne(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        String filePath = uploadFileMap.get("filePath");
        // todo: warning: the way to get file name may be bad......
        String fileName = filePath.split(String.valueOf('/'))[1];
//        System.out.println(fileName);

        String toPath = PathHelper.RES_TEMP_PATH;
        toPath = toPath + "/" + fileName;
        copyFile(filePath, toPath);


        String fileType = uploadFileMap.get("fileType");

        request.getSession().setAttribute("fileName", fileName);

        // zlx 测试一下
        map.put("filePath", filePath);
        map.put("fileType", fileType);
        map.put("toPath", toPath);

        return map;

    }

    @RequestMapping(value = "/classificationTwo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> classificationTwo(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        String filePath = uploadFileMap.get("filePath");
        // todo: warning: the way to get file name may be bad......
        String fileName = filePath.split(String.valueOf('/'))[1];
        // to debug
//        System.out.println(fileName);

        String toPath = PathHelper.RES_TEMP_PATH;
        toPath = toPath + "/" + fileName;
        copyFile(filePath, toPath);
        System.out.println("FORM: " + filePath);
        System.out.println("COPY TO:" + toPath);

        String fileType = uploadFileMap.get("fileType");

        request.getSession().setAttribute("fileName", fileName);

        map.put("filePath", filePath);
        map.put("fileType", fileType);
        map.put("toPath", toPath);

        return map;

    }

    @RequestMapping(value = "/clsOneAlgRun",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> clsOneAlgRun(HttpServletRequest request) throws IOException, InterruptedException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        // 设置 Anaconda 虚拟环境的路径和需要运行的 Python 脚本
        String pythonEnvPath = PathHelper.CONDA_PATH;
        String pythonScriptPath = PathHelper.PY_PATH + "/yolov7_1/detect.py";
        String imgSource = uploadFileMap.get("filePath");

        // 激活 Anaconda 虚拟环境并运行 Python 脚本
        String command = "cmd /c \"activate " + pythonEnvPath + " && python " + pythonScriptPath
                + " --source " + imgSource + "\"";
        System.out.println(command);
        Process process = Runtime.getRuntime().exec(command);

        // 获取Python脚本的标准输出流
        InputStream stdout = process.getInputStream();
        BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));

        // 获取Python脚本的标准错误流
        InputStream stderr = process.getErrorStream();
        BufferedReader stderrReader = new BufferedReader(new InputStreamReader(stderr));

        String line;
        while ((line = stdoutReader.readLine()) != null) {
            System.out.println(line);
        }

        // 读取Python脚本的标准错误流
        while ((line = stderrReader.readLine()) != null) {
            System.err.println(line);
        }

        // 等待 Python 脚本执行结束
        int exitCode = process.waitFor();
        System.out.println("Python script exited with code " + exitCode);

        assert exitCode == 0;

        // ********** result: 1. detected img 2. res txt
        // **********  copy img to 'temp' dir and set session
        String fileName = uploadFileMap.get("filePath").split(String.valueOf('/'))[1];
        String resultImg = PathHelper.PY_PATH + "/yolov7_1/runs/detect/" + fileName;
        String toPath = PathHelper.RES_TEMP_PATH;
        toPath = toPath + "/" + fileName;

        System.out.println("*****************");
        System.out.println("file name: " + fileName);

        // copy img for showing in jsp
        copyFile(resultImg, toPath);
        System.out.println("FORM: " + resultImg);
        System.out.println("COPY TO:" + toPath);

        // **********  read res txt put the result in map
        String resultTxt = PathHelper.PY_PATH + "/yolov7_1/runs/detect/labels/" + fileName.split("\\.")[0] + ".txt";
        System.out.println(resultTxt);

        File file = new File(resultTxt);
        Scanner scanner = new Scanner(file);

        ArrayList<ArrayList<Double>> resTxt = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String resLine = scanner.nextLine();
            String[] data = resLine.split(" ");
            String first = data[0];
            String last = data[data.length - 1];

            ArrayList<Double> tempRes = new ArrayList<>();
            tempRes.add(Double.parseDouble(first));
            tempRes.add(Double.parseDouble(last));

            resTxt.add(tempRes);
        }

        scanner.close();

        // ********** post resTxt
        map.put("resTxt", resTxt);
        map.put("showImgPath", request.getSession().getAttribute("fileName"));

        // ********** todo save json info for reload

        String s = JSONObject.toJSONString(map);

        String resPath = PathHelper.CALCULTATOR_RESULT_PATH;
        User user = (User)request.getSession().getAttribute("user");
        String userId = Integer.toString(user.getUserId());

        String[] dataSplit = uploadFileMap.get("filePath").split("/");
        String dataNameO = dataSplit[dataSplit.length-1];
        String dataName = dataNameO.split("\\.")[0];
        System.out.println(dataName);

        String dataType = uploadFileMap.get("fileType");

        //format time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());
        String fileName_ = "3_" + userId + "_" + dataName + "_" + dataType + "_" + dateStr;

        algHistoryService.addHistory(new AlgHistory(3, user.getUserId(), dataNameO, dataType, dateStr, fileName_));

        File file_ = new File(resPath + "\\" + fileName_ + ".json");
        PrintWriter ps = new PrintWriter(Files.newOutputStream(file_.toPath()));
        ps.print(s);
        ps.close();


        return map;

    }

    @RequestMapping(value = "/clsTwoAlgRun",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> clsTwoAlgRun(HttpServletRequest request) throws IOException, InterruptedException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        // 设置 Anaconda 虚拟环境的路径和需要运行的 Python 脚本
        String pythonEnvPath = PathHelper.CONDA_PATH;
        String pythonScriptPath = PathHelper.PY_PATH + "/detection/detect.py";
        String imgSource = uploadFileMap.get("filePath");

        // 激活 Anaconda 虚拟环境并运行 Python 脚本
        String command = "cmd /c \"activate " + pythonEnvPath + " && python " + pythonScriptPath
                + " --source " + imgSource + "\"";
        System.out.println(command);
        Process process = Runtime.getRuntime().exec(command);

        // 获取Python脚本的标准输出流
        InputStream stdout = process.getInputStream();
        BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));

        // 获取Python脚本的标准错误流
        InputStream stderr = process.getErrorStream();
        BufferedReader stderrReader = new BufferedReader(new InputStreamReader(stderr));

        String line;
        while ((line = stdoutReader.readLine()) != null) {
            System.out.println(line);
        }

        // 读取Python脚本的标准错误流
        while ((line = stderrReader.readLine()) != null) {
            System.err.println(line);
        }

        // 等待 Python 脚本执行结束
        int exitCode = process.waitFor();
        System.out.println("Python script exited with code " + exitCode);

        assert exitCode == 0;

        // ********** result: 1. detected img 2. res txt
        // **********  copy img to 'temp' dir and set session
        String fileName = uploadFileMap.get("filePath").split(String.valueOf('/'))[1];
        String resultImg = PathHelper.PY_PATH + "/detection/runs/detect/" + fileName;
        String toPath = PathHelper.RES_TEMP_PATH;
        toPath = toPath + "/" + fileName;

        System.out.println("*****************");
        System.out.println("file name: " + fileName);

        // copy img for showing in jsp
        copyFile(resultImg, toPath);
        System.out.println("FORM: " + resultImg);
        System.out.println("COPY TO:" + toPath);

        // **********  read res txt put the result in map
        String resultTxt = PathHelper.PY_PATH + "/detection/runs/detect/" + fileName.split("\\.")[0] + ".txt";
        System.out.println(resultTxt);

        File file = new File(resultTxt);
        Scanner scanner = new Scanner(file);

        ArrayList<ArrayList<Double>> resTxt = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String resLine = scanner.nextLine();
            String[] data = resLine.split(" ");
            String first = data[0];
            String last = data[data.length - 1];

            ArrayList<Double> tempRes = new ArrayList<>();
            tempRes.add(Double.parseDouble(first));
            tempRes.add(Double.parseDouble(last));

            resTxt.add(tempRes);
        }

        scanner.close();

        // ********** post resTxt
        map.put("resTxt", resTxt);
        map.put("showImgPath", request.getSession().getAttribute("fileName"));

        // ********** todo save json info for reload

        String s = JSONObject.toJSONString(map);

        String resPath = PathHelper.CALCULTATOR_RESULT_PATH;
        User user = (User)request.getSession().getAttribute("user");
        String userId = Integer.toString(user.getUserId());

        String[] dataSplit = uploadFileMap.get("filePath").split("/");
        String dataNameO = dataSplit[dataSplit.length-1];
        String dataName = dataNameO.split("\\.")[0];
        System.out.println(dataName);

        String dataType = uploadFileMap.get("fileType");

        //format time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());
        String fileName_ = "4_" + userId + "_" + dataName + "_" + dataType + "_" + dateStr;

        algHistoryService.addHistory(new AlgHistory(4, user.getUserId(), dataNameO, dataType, dateStr, fileName_));

        File file_ = new File(resPath + "\\" + fileName_ + ".json");
        PrintWriter ps = new PrintWriter(Files.newOutputStream(file_.toPath()));
        ps.print(s);
        ps.close();


        return map;

    }

    @RequestMapping(value = "/clsOneAlgRun2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> clsOneAlgRun2(HttpServletRequest request) throws IOException, InterruptedException {
        String fileName = (String)request.getSession().getAttribute("historyFileName");
        String pathname = PathHelper.CALCULTATOR_RESULT_PATH + "/" + fileName + ".json";
        return reloadRes(pathname);
    }

    @RequestMapping(value = "/clsTwoAlgRun2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> clsTwoAlgRun2(HttpServletRequest request) throws IOException, InterruptedException {
        String fileName = (String)request.getSession().getAttribute("historyFileName");
        String pathname = PathHelper.CALCULTATOR_RESULT_PATH + "/" + fileName + ".json";
        return reloadRes(pathname);
    }

        @RequestMapping(value = "/kMeans",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> kMeans(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        String filePath = uploadFileMap.get("filePath");
        String fileType = uploadFileMap.get("fileType");

        // zlx 测试一下
        map.put("filePath", filePath);
        map.put("fileType", fileType);

        return map;

    }

    @RequestMapping(value = "/kMeansRes",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> kMeansRes(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        String filePath = uploadFileMap.get("filePath");

        int cluster = (int)(request.getSession().getAttribute("cluster"));
        System.out.println(cluster);
        System.out.println(filePath);
        //3
        //E:\LandBigData\target\LandBigData\WEB-INF\temp/kmeans_data.txt

        File file = new File(filePath); //""
        ArrayList<double[]> points = new ArrayList<>();
        int dim = 0;

        if (file.isFile() && file.exists()) {
            InputStreamReader reader = new InputStreamReader(Files.newInputStream(file.toPath()));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText = null;

            lineText = bufferedReader.readLine();
            dim = lineText.split(" ").length;
        }

        KMeans kMeans = new KMeans(cluster, dim, 0.00001);
        points = kMeans.runKMeans("D:\\kmeans_data.txt");
        kMeans.initialCenters(points);
        kMeans.kmeans(points);
        kMeans.printResult(points);
        ArrayList<double[]> centers = kMeans.centerResult();
        map.put("centers", centers);
        map.put("cluster", cluster);
        map.put("dim", dim);

        map.put("filePath", filePath);

        return map;

    }

    @RequestMapping(value = "/kMeanspp",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> kMeanspp(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        String filePath = uploadFileMap.get("filePath");
        String fileType = uploadFileMap.get("fileType");

        // zlx 测试一下
        map.put("filePath", filePath);
        map.put("fileType", fileType);

        return map;

    }

    @RequestMapping(value = "/kMeansppRes",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> kMeansppRes(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");

        String filePath = uploadFileMap.get("filePath");

        int cluster = (int)(request.getSession().getAttribute("cluster"));
        System.out.println(cluster);
        System.out.println(filePath);
        //3
        //E:\LandBigData\target\LandBigData\WEB-INF\temp/kmeans_data.txt

        File file = new File(filePath); //""
        ArrayList<double[]> points = new ArrayList<>();
        int dim = 0;

        if (file.isFile() && file.exists()) {
            InputStreamReader reader = new InputStreamReader(Files.newInputStream(file.toPath()));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText = null;

            lineText = bufferedReader.readLine();
            dim = lineText.split(" ").length;
        }

        KMeans kMeans = new KMeans(cluster, dim, 0.00001);
        points = kMeans.runKMeans("D:\\kmeans_data.txt");
        kMeans.initialCenters2(points);
        kMeans.kmeans(points);
        kMeans.printResult(points);
        ArrayList<double[]> centers = kMeans.centerResult();
        map.put("centers", centers);
        map.put("cluster", cluster);
        map.put("dim", dim);

        map.put("filePath", filePath);

        return map;

    }



}
