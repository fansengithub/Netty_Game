package com.mmall.dao;

import com.mmall.model.Version;
import com.mmall.model.VersionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VersionMapper {
    long countByExample(VersionExample example);

    int deleteByExample(VersionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Version record);

    int insertSelective(Version record);

    List<Version> selectByExample(VersionExample example);

    Version selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Version record, @Param("example") VersionExample example);

    int updateByExample(@Param("record") Version record, @Param("example") VersionExample example);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);

    Version selectByType(@Param("type") Integer type);
}