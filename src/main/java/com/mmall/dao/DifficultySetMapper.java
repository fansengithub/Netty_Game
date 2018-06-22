package com.mmall.dao;

import com.mmall.model.DifficultySet;
import com.mmall.model.DifficultySetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DifficultySetMapper {
    long countByExample(DifficultySetExample example);

    int deleteByExample(DifficultySetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DifficultySet record);

    int insertSelective(DifficultySet record);

    List<DifficultySet> selectByExample(DifficultySetExample example);

    DifficultySet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DifficultySet record, @Param("example") DifficultySetExample example);

    int updateByExample(@Param("record") DifficultySet record, @Param("example") DifficultySetExample example);

    int updateByPrimaryKeySelective(DifficultySet record);

    int updateByPrimaryKey(DifficultySet record);

    List<DifficultySet> selAllDifficulty();

    List<DifficultySet> getAllDifficulty(@Param("param")String param);
}