package com.dlut.controller;

import com.dlut.pojo.Class;
import com.dlut.service.IClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by zhonghua on 2016/7/17.
 */
@Controller
@RequestMapping("/class")
public class ClassController {

    @Resource
    private IClassService classService;

    @RequestMapping(value = "/number",method = RequestMethod.GET)
    public String eachClassNum(Model model){

        model.addAttribute("algClasses",classService.getByClassType(1));
        model.addAttribute("resClasses",classService.getByClassType(2));
        model.addAttribute("dataCleanClasses",classService.getByClassType(3));
        model.addAttribute("teamClasses",classService.getByClassType(5));

        return "dashboard";
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
    public void addClass(String className, String classDescribe,Integer classType,PrintWriter out){
        int insertFlag = 0;
        if(!className.trim().equals("") && !classDescribe.trim().equals("")) {
            try {
                insertFlag = classService.addClass(className, classType, classDescribe);
                if (insertFlag == 1) {
                    out.write("success");
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.write("failed");
            }
        }else {
            out.write("failed");
        }
        out.flush();
        out.close();
    }
}
