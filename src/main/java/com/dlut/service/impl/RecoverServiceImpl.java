package com.dlut.service.impl;

import com.dlut.dao.AlgorithmMapper;
import com.dlut.dao.RecoverMapper;
import com.dlut.pojo.*;
import com.dlut.service.IAlgorithmService;
import com.dlut.service.IRecoverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
@Service("recoverService")
public class RecoverServiceImpl implements IRecoverService{

    @Resource
    private RecoverMapper recoverMapper;

    @Override
    public List<Recover> getRecoverByMetalId(int metalId) {
        RecoverExample example = new RecoverExample();
        RecoverExample.Criteria criteria = example.createCriteria();
        criteria.andRecoverMetalIdEqualTo(metalId);
        return recoverMapper.selectByExample(example);
    }
}
