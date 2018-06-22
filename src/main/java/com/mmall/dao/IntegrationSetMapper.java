package com.mmall.dao;

import com.mmall.model.IntegrationSet;
import com.mmall.model.IntegrationSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntegrationSetMapper {
    long countByExample(IntegrationSetExample example);

    int deleteByExample(IntegrationSetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IntegrationSet record);

    int insertSelective(IntegrationSet record);

    List<IntegrationSet> selectByExample(IntegrationSetExample example);

    IntegrationSet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IntegrationSet record, @Param("example") IntegrationSetExample example);

    int updateByExample(@Param("record") IntegrationSet record, @Param("example") IntegrationSetExample example);

    int updateByPrimaryKeySelective(IntegrationSet record);

    int updateByPrimaryKey(IntegrationSet record);

    List<IntegrationSet> getAllIntegrationSet(@Param("typeid") Integer typeid);
}