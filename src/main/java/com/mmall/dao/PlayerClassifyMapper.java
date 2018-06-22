package com.mmall.dao;

import com.mmall.model.PlayerClassify;
import com.mmall.model.PlayerClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayerClassifyMapper {
    long countByExample(PlayerClassifyExample example);

    int deleteByExample(PlayerClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlayerClassify record);

    int insertSelective(PlayerClassify record);

    List<PlayerClassify> selectByExample(PlayerClassifyExample example);

    PlayerClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlayerClassify record, @Param("example") PlayerClassifyExample example);

    int updateByExample(@Param("record") PlayerClassify record, @Param("example") PlayerClassifyExample example);

    int updateByPrimaryKeySelective(PlayerClassify record);

    int updateByPrimaryKey(PlayerClassify record);
}