package com.dlut.controller;

import com.dlut.pojo.Class;
import com.dlut.pojo.Data;
import com.dlut.pojo.DataExample;
import com.dlut.pojo.User;
import com.dlut.service.IAlgorithmService;
import com.dlut.service.IClassService;
import com.dlut.service.IDataService;
import com.dlut.util.EncodingHelper;
import com.dlut.util.PathHelper;
import com.dlut.util.TimeFormat;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ly on 2018/10/18.
 */
@Controller
@RequestMapping("/laws")
public class LawsController {

    private static Logger log = Logger.getLogger(LawsController.class);

    @Autowired
    private IAlgorithmService algorithmService;
    @Autowired
    private IClassService classService;
    @Autowired
    private IDataService dataService;

    /**
     * 列出某类资源列表
     * @param id
     * @param response
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(int id, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {

        Class cs=classService.getClassDetails(id);
        List<Data> datas=dataService.getDataListByClassId(id);
        model.addAttribute("cls", cs);
        model.addAttribute("datas", datas);
        return "data/list";
    }

    /**
     * 算法详情页数据显示
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/tooltip",method = RequestMethod.GET)
    public String tooltip(int id,Model model){
        model.addAttribute("algorithm",algorithmService.getAlgorithmTooltipById(id));
        return "data/tooltip";
    }

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void download(String fileName,HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");


        String lawsPath = PathHelper.LAWS_PATH;
        String resultPath = PathHelper.CALCULTATOR_RESULT_PATH;

        File file = new File(lawsPath+"/"+fileName);
        FileInputStream fis = null;
        if(!file.exists()){
            log.info("user: "+((User)(request.getSession().getAttribute("user"))).getUserName()+" download the file "+fileName+"failed,because the file is not exist");
            response.setHeader("Content-Disposition", "attachment;fileName=" + "wrongResult.txt");
            fis=new FileInputStream(resultPath+"/"+"wrongResult.txt");
            System.out.println("download path:"+resultPath+"/"+"wrongResult.txt");
        }
        else{
            log.info("user: "+((User)(request.getSession().getAttribute("user"))).getUserName()+" download the file "+fileName+" successed");

            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
            fis=new FileInputStream(lawsPath+"/"+fileName);
            System.out.println("download path:"+lawsPath+"/"+fileName);
        }
        OutputStream out=response.getOutputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        while((len=fis.read(buffer))>0){
            out.write(buffer,0,len);
        }
        fis.close();
        out.close();

    }

    @RequestMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response, Model model) {
        String path = PathHelper.DATA_PATH;
        String fileName=file.getOriginalFilename();
        System.out.println("upload to "+path+"\\"+fileName);

        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("uploadfile",path+"\\"+fileName);

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
    /**
     * 添加算法，ajax传JSON数据请求
     * 绑定pojo实体AlgorithmWithBLOBs
     * @param data
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String,String> addData(@RequestBody Data data, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        data.setDataCreateuser(user.getUserName());
        data.setDataCreatetime(new Date());
        Map<String,String> map=new HashMap<String, String>();
        if(dataService.getDataByFileName(data.getDataFilename()) != null){
            map.put("addStatus", EncodingHelper.gbk2utf_8("该文件名的数据集文件已存在，请确认文件名"));
            return map;
        }

        try {

            int insertFlag=dataService.add(data);
            if (insertFlag==1) {
                map.put("addStatus", EncodingHelper.gbk2utf_8("success"));
            } else {
                map.put("addStatus", EncodingHelper.gbk2utf_8("failed"));
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("addStatus", "failed");
        }
        return map;
    }
    @RequestMapping("/simpleSearch")
    @ResponseBody
    public List<Data> simpleSearch(String kw,Integer classId,HttpServletRequest request){
        DataExample example = new DataExample();
        DataExample.Criteria criteria = example.createCriteria();
        criteria.andDataNameLike("%"+kw+"%");
        criteria.andClassIdEqualTo(classId);
        List<Data> list =  dataService.selectByExample(example);
        return list;
    }

    @RequestMapping("/multiSearch")
    @ResponseBody
    public List<Data> multiSearch(String title,String content,String city,String startDate,String endDate,Integer classId,HttpServletRequest request){
        DataExample example = new DataExample();
        DataExample.Criteria criteria = example.createCriteria();

        criteria.andClassIdEqualTo(classId);
        if(!StringUtils.isEmpty(title))
            criteria.andDataNameLike("%"+title+"%");
        if(!StringUtils.isEmpty(content))
            criteria.andDataDescribeLike("%"+content+"%");
        if(!StringUtils.isEmpty(city))
            criteria.andDataCityLike("%"+city+"%");

        Date start = TimeFormat.stringToDate(startDate);
        Date end = TimeFormat.stringToDate(endDate);
        criteria.andDataCreatetimeGreaterThanOrEqualTo(start);
        criteria.andDataCreatetimeLessThanOrEqualTo(end);


        List<Data> list =  dataService.selectByExample(example);
        return list;
    }


}
