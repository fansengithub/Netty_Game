package com.mmall.dao;

import com.mmall.model.ParametersSet;
import com.mmall.model.ParametersSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParametersSetMapper {
    long countByExample(ParametersSetExample example);

    int deleteByExample(ParametersSetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParametersSet record);

    int insertSelective(ParametersSet record);

    List<ParametersSet> selectByExample(ParametersSetExample example);

    ParametersSet selectByPrimaryKey(Integer type);


    int updateByExampleSelective(@Param("record") ParametersSet record, @Param("example") ParametersSetExample example);

    int updateByExample(@Param("record") ParametersSet record, @Param("example") ParametersSetExample example);

    int updateByPrimaryKeySelective(ParametersSet record);

    int updateByPrimaryKey(ParametersSet record);

    int updateByPrimaryKeySelective2(ParametersSet record);
    ParametersSet selectByPrimaryKey2(Integer type);
}