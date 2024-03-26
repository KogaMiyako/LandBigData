package com.dlut.service;

import com.dlut.algorithm.PCA;
import com.dlut.pojo.AlgorithmWithBLOBs;
import com.dlut.pojo.Rank;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
public interface IAlgorithmService {

    List<AlgorithmWithBLOBs> getAlgorithmListByClassId(int classId);

    AlgorithmWithBLOBs getAlgorithmTooltipById(int algorithmId);

    int addAlgorithm(AlgorithmWithBLOBs algorithm) throws Exception;

    List<Rank> getMonthRank();

    List<Rank> getYearRank();

    PCA doPCA(String input,String output)throws Exception;
}
