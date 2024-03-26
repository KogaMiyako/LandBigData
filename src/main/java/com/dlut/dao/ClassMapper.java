package com.dlut.dao;

import com.dlut.pojo.Class;
import com.dlut.pojo.ClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface ClassMapper {
    long countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExampleWithBLOBs(ClassExample example);

    List<Class> selectByExample(ClassExample example);

    Class selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExampleWithBLOBs(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKeyWithBLOBs(Class record);

    int updateByPrimaryKey(Class record);
}