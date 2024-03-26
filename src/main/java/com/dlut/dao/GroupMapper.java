package com.dlut.dao;

import com.dlut.pojo.Group;
import com.dlut.pojo.GroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper {
    long countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(Integer gourpId);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExampleWithBLOBs(GroupExample example);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(Integer gourpId);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExampleWithBLOBs(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKeyWithBLOBs(Group record);

    int updateByPrimaryKey(Group record);
}