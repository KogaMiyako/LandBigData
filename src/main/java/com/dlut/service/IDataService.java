package com.dlut.service;

import com.dlut.pojo.AlgorithmWithBLOBs;
import com.dlut.pojo.Data;
import com.dlut.pojo.DataExample;
import com.dlut.pojo.Rank;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
public interface IDataService {


    List<Data> getDataListByClassId(int classId);

    int add(Data data);

    Data getDataByFileName(String fileName);
    List<Data> selectByExample(DataExample dataExample);

}
