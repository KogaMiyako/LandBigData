package com.dlut.service.impl;

import com.dlut.dao.ClassMapper;
import com.dlut.dao.PollutionMapper;
import com.dlut.pojo.Class;
import com.dlut.pojo.ClassExample;
import com.dlut.pojo.Pollution;
import com.dlut.pojo.PollutionExample;
import com.dlut.service.IClassService;
import com.dlut.service.IPollutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
@Service("pollutionService")
public class PollutionServiceImpl implements IPollutionService {
    @Autowired
    private PollutionMapper pollutionMapper;


    public Pollution getPollutionDetails(int pollutionId) {

        return pollutionMapper.selectByPrimaryKey(pollutionId);
    }

    @Override
    public int addPollution(String pollutionName, String pollutionDescribe, int cr, int ni, int cu, int zn, int as, int cd, int hg, int pb) throws Exception {
        return pollutionMapper.insert(new Pollution(pollutionName,pollutionDescribe,cr,ni,cu,zn,as,cd,hg,pb));
    }

    @Override
    public List<Pollution> getAllPollution() {
        return pollutionMapper.selectByExample(new PollutionExample());
    }

    @Override
    public List<Pollution> getByExample(PollutionExample pollutionExample) {
        return pollutionMapper.selectByExample(pollutionExample);
    }

}
