package com.dlut.dao;

import com.dlut.pojo.Recover;
import com.dlut.pojo.RecoverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecoverMapper {
    long countByExample(RecoverExample example);

    int deleteByExample(RecoverExample example);

    int deleteByPrimaryKey(Integer recoverId);

    int insert(Recover record);

    int insertSelective(Recover record);

    List<Recover> selectByExample(RecoverExample example);

    Recover selectByPrimaryKey(Integer recoverId);

    int updateByExampleSelective(@Param("record") Recover record, @Param("example") RecoverExample example);

    int updateByExample(@Param("record") Recover record, @Param("example") RecoverExample example);

    int updateByPrimaryKeySelective(Recover record);

    int updateByPrimaryKey(Recover record);
}