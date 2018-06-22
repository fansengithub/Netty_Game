package com.mmall.dao;

import com.mmall.entity.Area;
import com.mmall.model.ZnArea;
import com.mmall.model.ZnAreaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZnAreaMapper {
    int countByExample(ZnAreaExample example);

    int deleteByExample(ZnAreaExample example);

    int deleteByPrimaryKey(String id);

    int insert(ZnArea record);

    int insertSelective(ZnArea record);

    List<ZnArea> selectByExample(ZnAreaExample example);

    ZnArea selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ZnArea record, @Param("example") ZnAreaExample example);

    int updateByExample(@Param("record") ZnArea record, @Param("example") ZnAreaExample example);

    int updateByPrimaryKeySelective(ZnArea record);

    int updateByPrimaryKey(ZnArea record);

    List<Area> selectAreaListByParentId(@Param("parentId")String parentId);

    List<ZnArea> selectAllAreaListByParentId(@Param("parentId")String parentId);

    List<ZnArea> selectAll();   //得到所有一级区域
    ZnArea selectByName(@Param("name")String name);   //得到所有一级区域

}