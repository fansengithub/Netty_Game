package com.mmall.dao;

import com.mmall.model.LearnbookStage;
import com.mmall.model.LearnbookStageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LearnbookStageMapper {
    int countByExample(LearnbookStageExample example);

    int deleteByExample(LearnbookStageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LearnbookStage record);

    int insertSelective(LearnbookStage record);

    List<LearnbookStage> selectByExample(LearnbookStageExample example);

    LearnbookStage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LearnbookStage record, @Param("example") LearnbookStageExample example);

    int updateByExample(@Param("record") LearnbookStage record, @Param("example") LearnbookStageExample example);

    int updateByPrimaryKeySelective(LearnbookStage record);

    int updateByPrimaryKey(LearnbookStage record);

    List<LearnbookStage> selAllStage();

    List<LearnbookStage> selectByParam(@Param("param") String param);
}