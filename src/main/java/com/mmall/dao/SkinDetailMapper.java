package com.mmall.dao;

import com.mmall.model.SkinDetail;
import com.mmall.model.SkinDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkinDetailMapper {
    long countByExample(SkinDetailExample example);

    int deleteByExample(SkinDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkinDetail record);

    int insertSelective(SkinDetail record);

    List<SkinDetail> selectByExample(SkinDetailExample example);

    SkinDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SkinDetail record, @Param("example") SkinDetailExample example);

    int updateByExample(@Param("record") SkinDetail record, @Param("example") SkinDetailExample example);

    int updateByPrimaryKeySelective(SkinDetail record);

    int updateByPrimaryKey(SkinDetail record);

    //getAllSkinDetail
    List<SkinDetail> getAllSkinDetail(@Param("param")String param, @Param("startTime")String startTime, @Param("endTime")String endTime);
}