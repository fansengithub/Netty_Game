package com.mmall.dao;

import com.mmall.model.LearnbookStyle;
import com.mmall.model.LearnbookStyleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LearnbookStyleMapper {
    int countByExample(LearnbookStyleExample example);

    int deleteByExample(LearnbookStyleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LearnbookStyle record);

    int insertSelective(LearnbookStyle record);

    List<LearnbookStyle> selectByExample(LearnbookStyleExample example);

    LearnbookStyle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LearnbookStyle record, @Param("example") LearnbookStyleExample example);

    int updateByExample(@Param("record") LearnbookStyle record, @Param("example") LearnbookStyleExample example);

    int updateByPrimaryKeySelective(LearnbookStyle record);

    int updateByPrimaryKey(LearnbookStyle record);

    List<LearnbookStyle> selAllStyle();

    List<LearnbookStyle> selectStyleByParam(@Param("Param")String param );
}