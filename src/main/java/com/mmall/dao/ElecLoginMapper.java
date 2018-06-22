package com.mmall.dao;

import com.mmall.model.ElecLogin;
import com.mmall.model.ElecLoginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ElecLoginMapper {
    int countByExample(ElecLoginExample example);

    int deleteByExample(ElecLoginExample example);

    int insert(ElecLogin record);

    int insertSelective(ElecLogin record);

    List<ElecLogin> selectByExample(ElecLoginExample example);

    int updateByExampleSelective(@Param("record") ElecLogin record, @Param("example") ElecLoginExample example);

    int updateByExample(@Param("record") ElecLogin record, @Param("example") ElecLoginExample example);

    ElecLogin selectUserEntTime( Integer playerId);
}