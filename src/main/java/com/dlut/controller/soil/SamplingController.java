package com.dlut.controller.soil;

import com.alibaba.fastjson.JSON;
import com.dlut.pojo.Metalelem;
import com.dlut.pojo.Organic;
import com.dlut.service.IMetalElemService;
import com.dlut.service.IOrganicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/soilSample")
public class SamplingController {

    @Resource
    IOrganicService organicService;

    @Resource
    IMetalElemService metalElemService;

    @RequestMapping("/dumpIntro")
    public String dumpIntro(){
        return "sample/dumpIntro";
    }

    @RequestMapping("/cameraShow")
    public String cameraShow(){
        return "sample/cameraShow";
    }

    @RequestMapping("/cherryIntro")
    public String cherryIntro(){
        return "sample/cherryIntro";
    }

    @RequestMapping("/organicShow")
    public String organicShow(Model model){
        return "sample/organicShow";
    }

    @RequestMapping("/farmIntro")
    public String farmIntro(){
        return "sample/farmIntro";
    }

    @RequestMapping("/InorganicShow")
    public String InorganicShow(){
        return "sample/InorganicShow";
    }

    @RequestMapping(value = "/getOrganic", method = RequestMethod.POST)
    public void getOrganic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        Map<String, Object> map = new HashMap<String , Object>();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Organic organic = organicService.getNewOrgan();
        map.put("organ1", organic.getOrgan1());
        map.put("organ2", organic.getOrgan2());
        map.put("organ3", organic.getOrgan3());

        String json = JSON.toJSONString(map);
        out.print(json);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/getNewMetal", method = RequestMethod.POST)
    public void getNewMetal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        Map<String, Object> map = new HashMap<String , Object>();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Metalelem metalelem = metalElemService.getNewestElem()  ;
        map.put("metal1", metalelem.getElem1());
        map.put("metal2", metalelem.getElem2());
        map.put("metal3", metalelem.getElem3());

        String json = JSON.toJSONString(map);
        out.print(json);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/getFiveMetal", method = RequestMethod.POST)
    public void getFiveMetal(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        Map<String, Object> map = new HashMap<String , Object>();
        float[] metal1 = new float[5];
        float[] metal2 = new float[5];
        float[] metal3 = new float[5];

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        List<Metalelem> metalelems = metalElemService.getFiveNewestElems()  ;
        for (int i = 0; i < metalelems.size(); i++) {
            /*Map<String, Object> innerMap = new HashMap<String, Object>();
            innerMap.put("metal1", metalelems.get(i).getElem1());
            innerMap.put("metal2", metalelems.get(i).getElem2());
            innerMap.put("metal3", metalelems.get(i).getElem3());
            map.put("elem"+ i,innerMap);*/

            metal1[4-i] = metalelems.get(i).getElem1();
            metal2[4-i] = metalelems.get(i).getElem2();
            metal3[4-i] = metalelems.get(i).getElem3();
        }

        map.put("metal1", metal1);
        map.put("metal2", metal2);
        map.put("metal3", metal3);

        String json = JSON.toJSONString(map);
        out.print(json);
        out.flush();
        out.close();
    }




}
