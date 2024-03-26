package com.dlut.dao;

import com.dlut.pojo.File;
import com.dlut.pojo.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    long countByExample(FileExample example);

    int deleteByExample(FileExample example);

    int deleteByPrimaryKey(Integer fileId);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExample(FileExample example);

    File selectByPrimaryKey(Integer fileId);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}