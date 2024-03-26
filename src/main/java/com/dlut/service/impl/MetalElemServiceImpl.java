package com.dlut.service.impl;

import com.dlut.dao.MetalelemMapper;
import com.dlut.pojo.Metalelem;
import com.dlut.pojo.MetalelemExample;
import com.dlut.service.IMetalElemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("metalElemService")
public class MetalElemServiceImpl implements IMetalElemService {

    @Resource
    private MetalelemMapper metalelemMapper;

    @Override
    public Metalelem getNewestElem() {
        MetalelemExample example = new MetalelemExample();
        example.setOrderByClause("timestamp desc limit 1");

        List<Metalelem> metalelems = metalelemMapper.selectByExample(example);
        return metalelems.get(0);
    }

    @Override
    public List<Metalelem> getFiveNewestElems() {
        MetalelemExample example = new MetalelemExample();
        example.setOrderByClause("timestamp desc limit 5");

        List<Metalelem> metalelems = metalelemMapper.selectByExample(example);
        return metalelems;
    }
}
