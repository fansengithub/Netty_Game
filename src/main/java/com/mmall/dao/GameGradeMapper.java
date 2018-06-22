package com.mmall.dao;

import com.mmall.model.GameGrade;
import com.mmall.model.GameGradeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GameGradeMapper {
    long countByExample(GameGradeExample example);

    int deleteByExample(GameGradeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameGrade record);

    int insertSelective(GameGrade record);

    List<GameGrade> selectByExample(GameGradeExample example);

    GameGrade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameGrade record, @Param("example") GameGradeExample example);

    int updateByExample(@Param("record") GameGrade record, @Param("example") GameGradeExample example);

    int updateByPrimaryKeySelective(GameGrade record);

    int updateByPrimaryKey(GameGrade record);

    List<GameGrade> selectAll();
}