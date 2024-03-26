package com.dlut.controller;

import com.dlut.pojo.Rank;
import com.dlut.pojo.User;
import com.dlut.service.IAlgorithmService;
import com.dlut.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by zhonghua on 2016/7/17.
 */

@Controller
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private IAlgorithmService algorithmService;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, Model model){
        System.out.println(user.toString());
        userService.register(user);
        model.addAttribute("result","yes");
        return "success";

    }

//    @RequestMapping(value="/ranking",method = RequestMethod.GET)
//    public String getRanking(){
//        return "rankpage";
//    }

//    @RequestMapping(value = "/ranking",method = RequestMethod.GET)
//    public @ResponseBody ModelAndView getMonthRank(ModelAndView m){
//        List<Rank> monthRank = algorithmService.getMonthRank();
//        List<Rank> yearRank = algorithmService.getYearRank();
//
//        m.addObject("month",monthRank);
//        m.addObject("year",yearRank);
//        m.setViewName("rankpage");
//        return m;
//    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updateUserInfo(@ModelAttribute("user") User user, ModelAndView m, HttpServletRequest request){
        userService.update(user);
        request.getSession().setAttribute("user", user);
        return "main1";
    }

    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    public ModelAndView getUserInfo(HttpServletRequest request, ModelAndView m){
        User sessionUser=(User)request.getSession().getAttribute("user");
        User updateUser= userService.selectById(sessionUser.getUserId());
        m.addObject("user",updateUser);
        return m;
    }

    @RequestMapping(value = "/user/addGroup",method = RequestMethod.GET)
    public ModelAndView addGroup(HttpServletRequest request, ModelAndView m){
        User sessionUser=(User)request.getSession().getAttribute("user");
        User updateUser= userService.selectById(sessionUser.getUserId());
        m.addObject("user",updateUser);
        return m;
    }
    @RequestMapping(value = "/user/adminManager",method = RequestMethod.GET)
    public String adminManager(HttpServletRequest request, ModelAndView m){
        User sessionUser=(User)request.getSession().getAttribute("user");
        User updateUser= userService.selectById(sessionUser.getUserId());
        m.addObject("user",updateUser);
        return "dataclean/adminManager";
    }
    @RequestMapping(value = "/user/abc",method = RequestMethod.GET)
    public String a(HttpServletRequest request, ModelAndView m){
        User sessionUser=(User)request.getSession().getAttribute("user");
        User updateUser= userService.selectById(sessionUser.getUserId());
        m.addObject("user",updateUser);
        return "dropdown";
    }

    /*@RequestMapping(value="/user_info_update",method = RequestMethod.POST)
    public @ResponseBody ModelAndView updateUserInfo2(@ModelAttribute("user") User user, ModelAndView m){
        userService.update(user);
        m.addObject("result","yes");
        m.setViewName("list");
        return m;
    }*/
}
