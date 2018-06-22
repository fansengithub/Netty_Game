package com.mmall.dao;

import com.mmall.model.SkinStyle;
import com.mmall.model.SkinStyleExample;
import java.util.List;

import com.mmall.model.SkinType;
import org.apache.ibatis.annotations.Param;

public interface SkinStyleMapper {
    long countByExample(SkinStyleExample example);

    int deleteByExample(SkinStyleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkinStyle record);

    int insertSelective(SkinStyle record);

    List<SkinStyle> selectByExample(SkinStyleExample example);

    SkinStyle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SkinStyle record, @Param("example") SkinStyleExample example);

    int updateByExample(@Param("record") SkinStyle record, @Param("example") SkinStyleExample example);

    int updateByPrimaryKeySelective(SkinStyle record);

    int updateByPrimaryKey(SkinStyle record);

    List<SkinStyle> getAllSkinStyle(@Param("param")String param);
}