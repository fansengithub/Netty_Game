package com.mmall.dao;

import com.mmall.model.GameintegrationSet;
import com.mmall.model.GameintegrationSetExample;
import java.util.List;

import com.mmall.model.IntegrationSet;
import org.apache.ibatis.annotations.Param;

public interface GameintegrationSetMapper {
    long countByExample(GameintegrationSetExample example);

    int deleteByExample(GameintegrationSetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameintegrationSet record);

    int insertSelective(GameintegrationSet record);

    List<GameintegrationSet> selectByExample(GameintegrationSetExample example);

    GameintegrationSet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameintegrationSet record, @Param("example") GameintegrationSetExample example);

    int updateByExample(@Param("record") GameintegrationSet record, @Param("example") GameintegrationSetExample example);

    int updateByPrimaryKeySelective(GameintegrationSet record);

    int updateByPrimaryKey(GameintegrationSet record);

    List<GameintegrationSet> getAllGameintegrationSet(@Param("typeid") Integer typeid);
}