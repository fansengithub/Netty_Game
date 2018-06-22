package com.mmall.dao;

import com.mmall.model.SkinType;
import com.mmall.model.SkinTypeExample;
import java.util.List;

import com.mmall.model.WitdrawDetail;
import org.apache.ibatis.annotations.Param;

public interface SkinTypeMapper {
    long countByExample(SkinTypeExample example);

    int deleteByExample(SkinTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkinType record);

    int insertSelective(SkinType record);

    List<SkinType> selectByExample(SkinTypeExample example);

    SkinType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SkinType record, @Param("example") SkinTypeExample example);

    int updateByExample(@Param("record") SkinType record, @Param("example") SkinTypeExample example);

    int updateByPrimaryKeySelective(SkinType record);

    int updateByPrimaryKey(SkinType record);
    List<SkinType> getAllSkinType(@Param("param")String param);
}