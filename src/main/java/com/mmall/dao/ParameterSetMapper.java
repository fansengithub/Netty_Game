package com.mmall.dao;

import com.mmall.model.ParameterSet;
import com.mmall.model.ParameterSetExample;
import java.util.List;

import com.mmall.model.SkinType;
import org.apache.ibatis.annotations.Param;

public interface ParameterSetMapper {
    long countByExample(ParameterSetExample example);

    int deleteByExample(ParameterSetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParameterSet record);

    int insertSelective(ParameterSet record);

    List<ParameterSet> selectByExample(ParameterSetExample example);

    ParameterSet selectByPrimaryKey(Integer type);

    int updateByExampleSelective(@Param("record") ParameterSet record, @Param("example") ParameterSetExample example);

    int updateByExample(@Param("record") ParameterSet record, @Param("example") ParameterSetExample example);

    int updateByPrimaryKeySelective(ParameterSet record);

    int updateByPrimaryKey(ParameterSet record);

    List<ParameterSet> getAllParameterSet(@Param("param")String param);
}