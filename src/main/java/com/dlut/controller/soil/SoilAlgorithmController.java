package com.dlut.controller.soil;

import com.dlut.util.PathHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlut.controller.soil.SoilAlgController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/soilAlgorithm")
public class SoilAlgorithmController {

    @RequestMapping("/test")
    public String Test(){
        System.out.println("hello");
        return "soil/test";
    }

    @RequestMapping("/pollutionResource")
    public String pollutionResource(){
        return "soil/pollutionResource";
    }

    @RequestMapping("/siteSelect")
    public String siteSelect(){
        return "soil/siteSelect";
    }

    @RequestMapping("/classificationOne")
    public String classificationOne(){
        return "soil/classificationOne";
    }

    @RequestMapping("/classificationTwo")
    public String classificationTwo(){
        return "soil/classificationTwo";
    }

    @RequestMapping("/pollutionResourceShow")
    public String pollutionResourceShow(){
        return "soil/pollutionResourceShow";
    }

    @RequestMapping("/pollutionResourceShow2")
    public String pollutionResourceShow2(String filename,HttpServletRequest request){
        System.out.println(filename);
        request.getSession().setAttribute("historyFileName", filename);



        return "soil/pollutionResourceShow2";
    }

    @RequestMapping("/siteSelectShow2")
    public String siteSelectShow2(String filename,HttpServletRequest request){
        System.out.println(filename);
        request.getSession().setAttribute("historyFileName", filename);
        return "soil/siteSelectShow2";
    }

    @RequestMapping("/classificationOneShow2")
    public String classificationOneShow2(String filename,HttpServletRequest request) throws IOException {
        System.out.println(filename);

        String pathname = PathHelper.CALCULTATOR_RESULT_PATH + "/" + filename + ".json";
        Map<String,Object> map = SoilAlgController.reloadRes(pathname);
        request.getSession().setAttribute("fileName", map.get("showImgPath"));
        request.getSession().setAttribute("historyFileName", filename);
        return "soil/classificationOneShow2";
    }

    @RequestMapping("/classificationTwoShow2")
    public String classificationTwoShow2(String filename,HttpServletRequest request) throws IOException {
        System.out.println(filename);

        String pathname = PathHelper.CALCULTATOR_RESULT_PATH + "/" + filename + ".json";
        Map<String,Object> map = SoilAlgController.reloadRes(pathname);
        request.getSession().setAttribute("fileName", map.get("showImgPath"));
        request.getSession().setAttribute("historyFileName", filename);
        return "soil/classificationTwoShow2";
    }

    @RequestMapping("/classificationOneShow")
    public String classificationOneShow(){
        return "soil/classificationOneShow";
    }

    @RequestMapping("/classificationTwoShow")
    public String classificationTwoShow(){
        return "soil/classificationTwoShow";
    }



    @RequestMapping("/siteSelectShow")
    public String siteSelectShow(){
        return "soil/siteSelectShow";
    }

    @RequestMapping("/kmeans")
    public String kmeans(){
        return "soil/kmeans";
    }

    @RequestMapping("/kmeansShow")
    public String kmeansShow(){
        return "soil/kmeansShow";
    }

    @RequestMapping("/kmeanspp")
    public String kmeanspp(){
        return "soil/kmeanspp";
    }

    @RequestMapping("/kmeansppShow")
    public String kmeansppShow(){
        return "soil/kmeansppShow";
    }
}
