package com.dlut.service.impl;

import com.dlut.algorithm.PCA;
import com.dlut.dao.AlgorithmMapper;
import com.dlut.pojo.Algorithm;
import com.dlut.pojo.AlgorithmExample;
import com.dlut.pojo.AlgorithmWithBLOBs;
import com.dlut.pojo.Rank;
import com.dlut.service.IAlgorithmService;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
@Service("algorithmService")
public class AlgorithmServiceImpl implements IAlgorithmService{

    @Resource
    private AlgorithmMapper algorithmMapper;

    public List<AlgorithmWithBLOBs> getAlgorithmListByClassId(int classId) {

        AlgorithmExample algorithmExample=new AlgorithmExample();
        AlgorithmExample.Criteria criteria=algorithmExample.createCriteria();
        criteria.andClassIdEqualTo(classId);
        List<AlgorithmWithBLOBs> algorithms = algorithmMapper.selectByExampleWithBLOBs(algorithmExample);
        return algorithms;
    }

    public AlgorithmWithBLOBs getAlgorithmTooltipById(int algorithmId) {
        return algorithmMapper.selectByPrimaryKey(algorithmId);
    }

    public int addAlgorithm(AlgorithmWithBLOBs algorithm) throws Exception {
        return algorithmMapper.insert(algorithm);
    }

    public List<Rank> getMonthRank() {
        return algorithmMapper.getMonthRank();
    }

    public List<Rank> getYearRank() {
        return algorithmMapper.getYearRank();
    }

    @Override
    public PCA doPCA(String input, String output) throws Exception {
        PCA pca = new PCA(output);
        pca.doPCA(input);
        return pca;
    }
}
