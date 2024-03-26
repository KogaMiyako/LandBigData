package com.dlut.service;

import com.dlut.pojo.*;
import com.dlut.pojo.Class;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
public interface IClassService {

    /**
     * 获取类详情
     * @param classId
     * @return
     */
    public com.dlut.pojo.Class getClassDetails(int classId);

    public int addClass(String className, Integer classType, String classDescribe) throws Exception;

    public List<Class> getAllClass();

    public List<Class> getByExample(ClassExample classExample);

    public List<Class> getByClassType(Integer classType);
}
