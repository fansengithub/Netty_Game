package com.mmall.dao;

import com.mmall.model.CmsAdver;
import com.mmall.model.CmsAdverExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmsAdverMapper {
    long countByExample(CmsAdverExample example);

    int deleteByExample(CmsAdverExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsAdver record);

    int insertSelective(CmsAdver record);

    List<CmsAdver> selectByExample(CmsAdverExample example);

    CmsAdver selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsAdver record, @Param("example") CmsAdverExample example);

    int updateByExample(@Param("record") CmsAdver record, @Param("example") CmsAdverExample example);

    int updateByPrimaryKeySelective(CmsAdver record);

    int updateByPrimaryKey(CmsAdver record);

    List<CmsAdver> selAllCMSbyType(@Param("param")String param,@Param("type")Integer type);

    List<CmsAdver>  selectByColunmName(@Param("colunmName")Integer colunmName);

}