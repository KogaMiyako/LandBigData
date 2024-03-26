package com.dlut.controller;

import com.dlut.pojo.Pollution;
import com.dlut.pojo.PollutionStr;
import com.dlut.pojo.Recover;
import com.dlut.pojo.wrapper.PollutionWrapper;
import com.dlut.service.IClassService;
import com.dlut.service.IPollutionService;
import com.dlut.service.IRecoverService;
import com.dlut.util.HeavyMetalConstant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhonghua on 2016/7/17.
 */
@Controller
@RequestMapping("/pollution")
public class PollutionController {

    @Resource
    private IPollutionService pollutionService;

    @Resource
    private IRecoverService recoverService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String eachClassNum(Model model){
        List<Pollution> list = pollutionService.getAllPollution();
        List<PollutionStr> pluList = new ArrayList<>();
        for(Pollution plu: list){
            PollutionStr str = new PollutionStr();
            str.setPluId(plu.getPollutionId());
            str.setPluName(plu.getPollutionName());
            str.setPluDesc(plu.getPollutionDescribe());
            str.setPluMetalStr(plu);
            pluList.add(str);
        }
        model.addAttribute("pollutions",pluList);
        try {
//            pollutionService.addPollution("name","desc",1,1,1,1,1,1,1,1);
            System.out.println(11);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "pollution/list";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public void classDetails(int id, RedirectAttributes redirectAttributes,HttpServletResponse response) throws IOException {
//        redirectAttributes.addFlashAttribute("class",classService.getClassDetails(id));

        PrintWriter out=response.getWriter();
        out.print(id);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/add",method=RequestMethod.POST)
    public void addClass(String pluName, String pluDescribe,Integer cr,Integer ni,Integer cu,Integer zn,Integer as,Integer cd,Integer hg,Integer pb,PrintWriter out){
        int insertFlag = 0;
        if(!pluName.trim().equals("") && !pluDescribe.trim().equals("") && cr != null && ni != null && cu != null && zn != null && as != null && cd != null && hg != null && pb != null) {
            try {
                insertFlag = pollutionService.addPollution(pluName, pluDescribe, cr,ni,cu,zn,as,cd,hg,pb);
                if (insertFlag == 1) {
                    out.write("success");
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.write("failed");
            }
        }else {
            out.write("failed,args are blank");
        }
        out.flush();
        out.close();
    }
    @RequestMapping(value = "/showDetails", method = RequestMethod.GET)
    public String showDetails(int pluId, HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {
        List<Integer> pluMetals = (List<Integer>)request.getSession().getAttribute("pluMetals");
        Pollution pollution = pollutionService.getPollutionDetails(pluId);
        PollutionWrapper wrapper = PollutionWrapper.convert(pollution);
        List<String[]> strs = new ArrayList<>();

        for(int i=0;i<wrapper.getPluArrs().length;i++){
            double s = wrapper.getPluArrs()[i];
            String[] str = new String[3];
            str[0] = HeavyMetalConstant.int2StringMetal.get(i);
            if(s == 0)
                str[1] = "几乎不相关";
            else if(s == 1)
                str[1] = "相关";
            else
                str[1] = "非常相关";

            if(pluMetals.contains(i))
                str[2] = "超标";
            else
                str[2] = "未超标";

            strs.add(str);

        }
        List<Recover> recovers = new ArrayList<>();
        for(int metalId : pluMetals){
            recovers.addAll(recoverService.getRecoverByMetalId(metalId));
        }
        model.addAttribute("plu",pollution);
        model.addAttribute("strs",strs);
        model.addAttribute("recovers",recovers);
        return "pollution/details";
    }
}

