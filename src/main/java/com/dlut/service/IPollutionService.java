package com.dlut.service;

import com.dlut.pojo.Class;
import com.dlut.pojo.ClassExample;
import com.dlut.pojo.Pollution;
import com.dlut.pojo.PollutionExample;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
public interface IPollutionService {

    /**
     * 获取类详情
     * @param pollutionId
     * @return
     */
    public Pollution getPollutionDetails(int pollutionId);

    public int addPollution(String pollutionName, String pollutionDescribe,int cr,int ni,int cu,int zn,int as,int cd,int hg,int pb) throws Exception;

    public List<Pollution> getAllPollution();

    public List<Pollution> getByExample(PollutionExample pollutionExample);

}
