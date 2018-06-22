package com.mmall.dao;

import com.mmall.model.PlayerOpera;
import com.mmall.model.PlayerOperaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayerOperaMapper {
    int countByExample(PlayerOperaExample example);

    int deleteByExample(PlayerOperaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlayerOpera record);

    int insertSelective(PlayerOpera record);

    List<PlayerOpera> selectByExample(PlayerOperaExample example);

    PlayerOpera selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlayerOpera record, @Param("example") PlayerOperaExample example);

    int updateByExample(@Param("record") PlayerOpera record, @Param("example") PlayerOperaExample example);

    int updateByPrimaryKeySelective(PlayerOpera record);

    int updateByPrimaryKey(PlayerOpera record);

    Integer getCountByOperaId(@Param("operaId") Integer operaId);


}