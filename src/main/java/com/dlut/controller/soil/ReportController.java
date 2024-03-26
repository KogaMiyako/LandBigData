package com.dlut.controller.soil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dlut.pojo.AlgHistory;
import com.dlut.pojo.Report;
import com.dlut.pojo.User;
import com.dlut.service.IReportService;
import com.dlut.util.PathHelper;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Resource
    private IReportService reportService;

    // 查询
    @RequestMapping(value = "/getReports",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getReports(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();

        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        System.out.println("path:" + path);
        System.out.println("basePath:" + basePath);

        List<Report> reports = reportService.getAllReport();

        map.put("reports", reports);
        map.put("basePath", basePath);
        return map;

    }

    // 添加
    @RequestMapping(value = "/addReports",method = RequestMethod.POST)
    @ResponseBody
    public void addReports(String title, String user, String content, HttpServletRequest request) throws IOException {

        System.out.println(title);
        System.out.println(user);
        System.out.println(content);

        Map<String,Object> map = new HashMap<>();
        map.put("title", title);
        map.put("user", user)   ;
        map.put("content", content);


        String resPath = PathHelper.CALCULTATOR_RESULT_PATH;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());

        map.put("date", dateStr);
        String s = JSONObject.toJSONString(map);

        String fileName = "file_" + dateStr;
        reportService.addReport(new Report(title, user, dateStr, fileName));

        File file = new File(resPath + "\\" + fileName + ".json");
        PrintWriter ps = new PrintWriter(Files.newOutputStream(file.toPath()));
        ps.print(s);
        ps.close();

    }

    // 删除
    @RequestMapping(value = "/delReports",method = RequestMethod.POST)
    @ResponseBody
    public void delReports(Integer id, HttpServletRequest request) throws IOException {
        reportService.delReport(id);
    }

    //发送
    @RequestMapping(value = "/sendReports",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> sendReports(String fileName, HttpServletRequest request) throws IOException {

        System.out.println(fileName);

        String pathname = PathHelper.CALCULTATOR_RESULT_PATH + "/" + fileName + ".json";

        System.out.println(pathname);

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


}
