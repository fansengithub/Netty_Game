package com.mmall.dao;

import com.mmall.model.LearnbookSet;
import com.mmall.model.LearnbookSetExample;
import java.util.List;

import com.mmall.model.SysMessage;
import org.apache.ibatis.annotations.Param;

public interface LearnbookSetMapper {
    long countByExample(LearnbookSetExample example);

    int deleteByExample(LearnbookSetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LearnbookSet record);

    int insertSelective(LearnbookSet record);

    List<LearnbookSet> selectByExample(LearnbookSetExample example);

    LearnbookSet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LearnbookSet record, @Param("example") LearnbookSetExample example);

    int updateByExample(@Param("record") LearnbookSet record, @Param("example") LearnbookSetExample example);

    int updateByPrimaryKeySelective(LearnbookSet record);

    int updateByPrimaryKey(LearnbookSet record);
    //获取最小id的数据
    LearnbookSet getMaxLearnbookSet();
}