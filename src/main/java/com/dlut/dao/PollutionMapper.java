package com.dlut.dao;

import com.dlut.pojo.Pollution;
import com.dlut.pojo.PollutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PollutionMapper {
    long countByExample(PollutionExample example);

    int deleteByExample(PollutionExample example);

    int deleteByPrimaryKey(Integer pollutionId);

    int insert(Pollution record);

    int insertSelective(Pollution record);

    List<Pollution> selectByExample(PollutionExample example);

    Pollution selectByPrimaryKey(Integer pollutionId);

    int updateByExampleSelective(@Param("record") Pollution record, @Param("example") PollutionExample example);

    int updateByExample(@Param("record") Pollution record, @Param("example") PollutionExample example);

    int updateByPrimaryKeySelective(Pollution record);

    int updateByPrimaryKey(Pollution record);
}