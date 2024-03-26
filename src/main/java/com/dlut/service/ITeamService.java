package com.dlut.service;

import com.dlut.pojo.Class;
import com.dlut.pojo.ClassExample;
import com.dlut.pojo.TeamWithBLOBs;

import java.util.List;

/**
 * Created by liuyu on 2019/3/20.
 * 课题组类
 */
public interface ITeamService {


    public List<TeamWithBLOBs> selectAll();
}
