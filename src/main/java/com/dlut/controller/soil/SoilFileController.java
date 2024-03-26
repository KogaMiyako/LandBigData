package com.dlut.controller.soil;

import com.alibaba.fastjson.JSON;
import com.dlut.util.PathHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/soilFile")
public class SoilFileController {



    @RequestMapping("/upload")
    public void uploadAlgFile(@RequestParam("file") MultipartFile file,@RequestParam("algMode") int algMode,
                             HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

        String path = PathHelper.TEMP_PATH;
        String FileName = file.getOriginalFilename();
        System.out.println("upload to "+path+"\\"+FileName);

        String[] fileNameSplit = FileName.split("\\.");

        File uploadFile = new File(path, FileName);
        if(!uploadFile.exists()){
            uploadFile.mkdirs();
        }
        try {
            file.transferTo(uploadFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(fileNameSplit[1]);

        // zlx: 为了通用的上传 保存上传路径和算法的模式
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("filePath",path+"/"+FileName);
        fileMap.put("algMode",String.valueOf(algMode));
        fileMap.put("fileType", fileNameSplit[1]);

        request.getSession().setAttribute("uploadFileMap",fileMap);


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

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public void checkAlgFile(@RequestParam("algMode") int algMode, HttpServletRequest request,HttpServletResponse response) throws IOException{
        PrintWriter out=response.getWriter();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");
        Map<String,Object> resMap=new HashMap<String, Object>();

        String filePath = "";
        String algModeInSession = "";

        if (uploadFileMap!=null && uploadFileMap.containsKey("filePath") && uploadFileMap.containsKey("algMode")){
            filePath = uploadFileMap.get("filePath");
            algModeInSession = uploadFileMap.get("algMode");
        }

        if (algModeInSession.equals(String.valueOf(algMode)) && !"".equals(filePath)){
            resMap.put("result","bothYes");
        }else{
            resMap.put("result", "noFile");
        }


        String json= JSON.toJSONString(resMap);
        out.print(json);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/check2", method = RequestMethod.POST)
    public void checkAlgFile2(@RequestParam("algMode") int algMode,@RequestParam("cluster") int cluster, HttpServletRequest request,HttpServletResponse response) throws IOException{
        PrintWriter out=response.getWriter();
        Map<String, String> uploadFileMap =(Map<String,String>)request.getSession().getAttribute("uploadFileMap");
        Map<String,Object> resMap=new HashMap<String, Object>();

        request.getSession().setAttribute("cluster", cluster);

        String filePath = "";
        String algModeInSession = "";

        if (uploadFileMap!=null && uploadFileMap.containsKey("filePath") && uploadFileMap.containsKey("algMode")){
            filePath = uploadFileMap.get("filePath");
            algModeInSession = uploadFileMap.get("algMode");
        }

        if (algModeInSession.equals(String.valueOf(algMode)) && !"".equals(filePath)){
            resMap.put("result","bothYes");
        }else{
            resMap.put("result", "noFile");
        }


        String json= JSON.toJSONString(resMap);
        out.print(json);
        out.flush();
        out.close();
    }

}
