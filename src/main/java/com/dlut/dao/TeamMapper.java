package com.dlut.dao;

import com.dlut.pojo.Team;
import com.dlut.pojo.TeamExample;
import com.dlut.pojo.TeamWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeamMapper {
    long countByExample(TeamExample example);

    int deleteByExample(TeamExample example);

    int deleteByPrimaryKey(Integer teamId);

    int insert(TeamWithBLOBs record);

    int insertSelective(TeamWithBLOBs record);

    List<TeamWithBLOBs> selectByExampleWithBLOBs(TeamExample example);

    List<Team> selectByExample(TeamExample example);

    TeamWithBLOBs selectByPrimaryKey(Integer teamId);

    int updateByExampleSelective(@Param("record") TeamWithBLOBs record, @Param("example") TeamExample example);

    int updateByExampleWithBLOBs(@Param("record") TeamWithBLOBs record, @Param("example") TeamExample example);

    int updateByExample(@Param("record") Team record, @Param("example") TeamExample example);

    int updateByPrimaryKeySelective(TeamWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TeamWithBLOBs record);

    int updateByPrimaryKey(Team record);
}