package com.dlut.controller.soil;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserCenterController {

    @RequestMapping("/infoUpdate")
    public String pollutionResource(){
        return "user/infoUpdate";
    }

    @RequestMapping("/algoHistory")
    public String siteSelect(){
        return "user/algoHistory";
    }

    @RequestMapping("/report")
    public String report(){
        return "user/report";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "user/edit";
    }

    @RequestMapping("/reportShow")
    public String reportShow(String textName,HttpServletRequest request){
        System.out.println(textName);
        request.getSession().setAttribute("textName", textName);
        return "user/reportShow";
    }

}
