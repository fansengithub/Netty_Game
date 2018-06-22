package com.mmall.dao;

import com.mmall.model.ScoreSet;
import com.mmall.model.ScoreSetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreSetMapper {
    int countByExample(ScoreSetExample example);

    int deleteByExample(ScoreSetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScoreSet record);

    int insertSelective(ScoreSet record);

    List<ScoreSet> selectByExample(ScoreSetExample example);

    ScoreSet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScoreSet record, @Param("example") ScoreSetExample example);

    int updateByExample(@Param("record") ScoreSet record, @Param("example") ScoreSetExample example);

    int updateByPrimaryKeySelective(ScoreSet record);

    int updateByPrimaryKey(ScoreSet record);
}