package com.dlut.service.impl;

import com.dlut.dao.ClassMapper;
import com.dlut.dao.TeamMapper;
import com.dlut.pojo.Class;
import com.dlut.pojo.ClassExample;
import com.dlut.pojo.TeamExample;
import com.dlut.pojo.TeamWithBLOBs;
import com.dlut.service.IClassService;
import com.dlut.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
@Service("teamService")
public class TeamServiceImpl implements ITeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<TeamWithBLOBs> selectAll() {
        return teamMapper.selectByExampleWithBLOBs(new TeamExample());
    }
}
