package com.dlut.service.impl;

import com.dlut.dao.AlgorithmMapper;
import com.dlut.dao.DataMapper;
import com.dlut.pojo.*;
import com.dlut.service.IAlgorithmService;
import com.dlut.service.IDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
@Service("dataService")
public class DataServiceImpl implements IDataService{

    @Resource
    private DataMapper dataMapper;


    @Override
    public List<Data> getDataListByClassId(int classId) {
        DataExample dataExample = new DataExample();
        DataExample.Criteria criteria = dataExample.createCriteria();
        criteria.andClassIdEqualTo(classId);
        List<Data> datas = dataMapper.selectByExample(dataExample);
        return datas;

    }

    @Override
    public int add(Data data) {
        return dataMapper.insert(data);
    }

    @Override
    public Data getDataByFileName(String fileName) {
        DataExample dataExample = new DataExample();
        DataExample.Criteria criteria = dataExample.createCriteria();
        criteria.andDataFilenameEqualTo(fileName);
        List<Data> datas = dataMapper.selectByExample(dataExample);
        if(datas == null || datas.size() == 0)
            return null;
        else
            return datas.get(0);
    }

    @Override
    public List<Data> selectByExample(DataExample dataExample) {
        return dataMapper.selectByExample(dataExample);
    }
}
