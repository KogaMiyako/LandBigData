package com.dlut.dao;

import com.dlut.pojo.Laws;
import com.dlut.pojo.LawsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LawsMapper {
    long countByExample(LawsExample example);

    int deleteByExample(LawsExample example);

    int deleteByPrimaryKey(Integer lawsId);

    int insert(Laws record);

    int insertSelective(Laws record);

    List<Laws> selectByExample(LawsExample example);

    Laws selectByPrimaryKey(Integer lawsId);

    int updateByExampleSelective(@Param("record") Laws record, @Param("example") LawsExample example);

    int updateByExample(@Param("record") Laws record, @Param("example") LawsExample example);

    int updateByPrimaryKeySelective(Laws record);

    int updateByPrimaryKey(Laws record);
}