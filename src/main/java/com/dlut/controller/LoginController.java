package com.dlut.controller;

import com.dlut.pojo.Class;
import com.dlut.pojo.ClassExample;
import com.dlut.pojo.User;
import com.dlut.service.IClassService;
import com.dlut.service.IUserService;
import com.dlut.util.AlgorithmUtils;
import com.dlut.util.PathHelper;
import com.dlut.util.SSHHelper;
//import com.sun.javafx.sg.prism.NGShape;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhonghua on 2016/7/14.
 */
@Controller
public class LoginController {

    @Resource
    private IUserService userService;
    @Resource
    private IClassService classService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect("/landbigdata");
    }

    /**
     * 检测用户名与密码
     * 返回1表示成功登录，返回0表示登录失败
     * @return int(1,0)
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public void login(String username, String password, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        AlgorithmUtils.init1_1();
        SSHHelper.uploadPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
        SSHHelper.downloadPath = request.getSession().getServletContext().getRealPath("/WEB-INF/download");
        PathHelper.DATA_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/data");
        PathHelper.LAWS_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/laws");
        PathHelper.DATACLEAN_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/dataClean");
        PathHelper.ALGORITHM_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/algorithm");
        PathHelper.CALCULTATOR_RESULT_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/calculateResult");
        PathHelper.UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
        PathHelper.TEMP_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/temp");
        PathHelper.PCA_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/pca");
        PathHelper.RF_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/rf");
        PathHelper.PY_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/py_scripts");
        PathHelper.RES_TEMP_PATH = request.getSession().getServletContext().getRealPath("/app/temp");
        PathHelper.CONDA_PATH = "D:/miniconda3/envs/project";
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        User user=new User();
        user.setUserName(username);
        user.setUserPassword(password);

        User checkedUser=this.userService.checkUser(user);

        if(checkedUser == null){
            out.print("no");

        }else{
            request.getSession().setAttribute("user", checkedUser);
            //System.out.println("login success:" + checkedUser.toString());
            out.print("yes");
        }
        out.flush();
        out.close();
    }

    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String showMain(HttpServletRequest request,Model model){
        User user=(User)request.getSession().getAttribute("user");
        if(user == null){
            return "404";
        }else{
            model.addAttribute(user);
            //算法
            model.addAttribute("classes1",classService.getByClassType(1));

            //已上传数据
            model.addAttribute("classes2",classService.getByClassType(2));

            //数据清洗
            model.addAttribute("classes3",classService.getByClassType(3));

            return "main1";
        }
    }

    @RequestMapping(value="/dashboard", method=RequestMethod.GET)
    public String toBashBoard(){

        return "redirect:/class/number";
    }


    @RequestMapping(value="/success",method = RequestMethod.GET)
    public String success(){
        return "success";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }

}
