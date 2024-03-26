package com.dlut.service.impl;

import com.dlut.dao.InorganincMapper;
import com.dlut.pojo.Inorganinc;
import com.dlut.service.IInorganicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("inorganicService")
public class InorganicServiceImpl implements IInorganicService {

    @Resource
    private InorganincMapper inorganincMapper;

    @Override
    public Inorganinc getInorganicByID(int id){
        return inorganincMapper.selectByPrimaryKey(id);
    }
}
