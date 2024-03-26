package com.dlut.service.impl;

import com.dlut.dao.AlgHistoryMapper;
import com.dlut.pojo.AlgHistory;
import com.dlut.pojo.AlgHistoryExample;
import com.dlut.service.IAlgHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("algHistoryService")
public class AlgHistoryServiceImpl implements IAlgHistoryService {

    @Resource
    private AlgHistoryMapper algHistoryMapper;

    @Override
    public List<AlgHistory> getHistoryByUserId(int UserId){
        AlgHistoryExample example = new AlgHistoryExample();
        AlgHistoryExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(UserId);
        List<AlgHistory> histories = algHistoryMapper.selectByExample(example);
        return histories;
    }

    @Override
    public boolean addHistory(AlgHistory algHistory) {
        algHistoryMapper.insert(algHistory);
        return true;
    }
}
