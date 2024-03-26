package com.dlut.controller.soil;

import com.dlut.pojo.AlgHistory;
import com.dlut.pojo.User;
import com.dlut.service.IAlgHistoryService;
import com.dlut.util.PathHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Resource
    private IAlgHistoryService algHistoryService;

    @RequestMapping(value = "/getHistories",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getHistories(HttpServletRequest request) throws IOException {

        Map<String,Object> map = new HashMap<>();

        User user = (User) request.getSession().getAttribute("user");

        System.out.println(user.getUserId());
        String filePath = PathHelper.UPLOAD_PATH;

        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        System.out.println("path:" + path);
        System.out.println("basePath:" + basePath);


        List<AlgHistory> histories = algHistoryService.getHistoryByUserId(user.getUserId());

        map.put("histories", histories);
        map.put("basePath", basePath);

        return map;

    }
}
