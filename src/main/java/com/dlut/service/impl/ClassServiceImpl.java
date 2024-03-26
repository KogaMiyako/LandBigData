package com.dlut.service.impl;

import com.dlut.dao.ClassMapper;
import com.dlut.pojo.*;
import com.dlut.pojo.Class;
import com.dlut.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
@Service("classService")
public class ClassServiceImpl implements IClassService {
    @Autowired
    private ClassMapper classMapper;


    public Class getClassDetails(int classId) {

        return classMapper.selectByPrimaryKey(classId);
    }

    public int addClass(String className, Integer classType, String classDescribe) throws Exception {
        return classMapper.insert(new Class(className,classType,classDescribe));
    }
    public List<Class> getAllClass(){
        return classMapper.selectByExample(new ClassExample());
    }

    @Override
    public List<Class> getByExample(ClassExample classExample) {
        return classMapper.selectByExample(classExample);
    }

    @Override
    public List<Class> getByClassType(Integer classType) {
        ClassExample example = new ClassExample();
        ClassExample.Criteria algCriteria = example.createCriteria();
        algCriteria.andClassTypeEqualTo(classType);
        return getByExample(example);
    }
}
