package com.mmall.dao;

import com.mmall.model.LearnbookDetail;
import com.mmall.model.LearnbookDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LearnbookDetailMapper {
    long countByExample(LearnbookDetailExample example);

    int deleteByExample(LearnbookDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LearnbookDetail record);

    int insertSelective(LearnbookDetail record);

    List<LearnbookDetail> selectByExample(LearnbookDetailExample example);

    LearnbookDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LearnbookDetail record, @Param("example") LearnbookDetailExample example);

    int updateByExample(@Param("record") LearnbookDetail record, @Param("example") LearnbookDetailExample example);

    int updateByPrimaryKeySelective(LearnbookDetail record);

    int updateByPrimaryKey(LearnbookDetail record);

    List<LearnbookDetail> selAllLearnBook(@Param("param") String param);

    List<LearnbookDetail> getTop3();

    List<LearnbookDetail> selectByRecommend();

//    查询推荐教材
    List<LearnbookDetail> selectByAuthor();
}