package com.mmall.dao;

import com.mmall.model.GameDetail;
import com.mmall.model.GameDetailExample;
import java.util.List;

import com.mmall.model.SkinDetail;
import org.apache.ibatis.annotations.Param;

public interface GameDetailMapper {
    long countByExample(GameDetailExample example);

    int deleteByExample(GameDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameDetail record);

    int insertSelective(GameDetail record);

    List<GameDetail> selectByExample(GameDetailExample example);

    GameDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameDetail record, @Param("example") GameDetailExample example);

    int updateByExample(@Param("record") GameDetail record, @Param("example") GameDetailExample example);

    int updateByPrimaryKeySelective(GameDetail record);

    int updateByPrimaryKey(GameDetail record);

    List<GameDetail> getAllGameDetail(@Param("param")String param, @Param("startTime")String startTime, @Param("endTime")String endTime);
}