package com.dlut.service.impl;

import com.dlut.dao.OrganicMapper;
import com.dlut.pojo.Organic;
import com.dlut.pojo.OrganicExample;
import com.dlut.service.IOrganicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("organicService")
public class OrganicServiceImpl implements IOrganicService {

    @Resource
    private OrganicMapper organicMapper;

    @Override
    public Organic getNewOrgan() {
        OrganicExample example = new OrganicExample();
        example.setOrderByClause("id desc limit 1");

        List<Organic> organics = organicMapper.selectByExample(example);
        return organics.get(0);
    }
}
