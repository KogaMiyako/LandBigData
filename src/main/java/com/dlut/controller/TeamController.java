package com.dlut.controller;

import com.dlut.pojo.*;
import com.dlut.pojo.Class;
import com.dlut.service.IAlgorithmService;
import com.dlut.service.IClassService;
import com.dlut.service.IDataService;
import com.dlut.service.ITeamService;
import com.dlut.util.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.File;
import java.util.*;

/**
 * Created by ly on 2019/3/18.
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    private static Logger log = Logger.getLogger(TeamController.class);

    @Autowired
    private ITeamService teamService;
    @Autowired
    private IAlgorithmService algorithmService;


/*    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(int id, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {

        Class cs=classService.getClassDetails(id);
        List<AlgorithmWithBLOBs> algorithms=algorithmService.getAlgorithmListByClassId(id);
        model.addAttribute("cls", cs);
        model.addAttribute("algorithms", algorithms);
        return "algorithm/list";
    }*/
    @RequestMapping(value = "/team1/al1",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public Map<String,Object> doTeam1Al1(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();
        String al1_1File = (String)request.getSession().getAttribute("al1_1File");
        try {
            double[][] data = ExcelUtil.getData(al1_1File);
            double[][] scores = AlgorithmUtils.al1_1(data);
            List<Map<String,Object>> result = new ArrayList<>();
            result = AlgorithmUtils.data2FormatTeamAl1_1(scores,AlgorithmUtils.judgeName1_1);
            map.put("result",result);
            map.put("addStatus","success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/uploadAl1_1")
    public void uploadlogistic(@RequestParam("al1_1File") MultipartFile al1_1File, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

        String path = PathHelper.TEMP_PATH;
        String alFileName = al1_1File.getOriginalFilename();
        System.out.println("upload to "+path+"/"+alFileName);
        File file = new File(path, alFileName);
        if(!file.exists()){
            file.mkdirs();
        }
        try {
            al1_1File.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("al1_1File",path+"/"+alFileName);
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

    @RequestMapping(value = "/team2/al1",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> doTeam2Al1(String temperature,String ozone,String Hg,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();
        double[] result = AlgorithmUtils.al2_1(Double.parseDouble(temperature),Double.parseDouble(ozone),Double.parseDouble(Hg));
        map.put("data",result);
        return map;
    }


}
