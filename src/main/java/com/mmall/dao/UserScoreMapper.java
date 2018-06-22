package com.mmall.dao;

import com.mmall.model.UserScore;
import com.mmall.model.UserScoreExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserScoreMapper {
    int countByExample(UserScoreExample example);

    int deleteByExample(UserScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserScore record);

    int insertSelective(UserScore record);

    List<UserScore> selectByExample(UserScoreExample example);

    UserScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserScore record, @Param("example") UserScoreExample example);

    int updateByExample(@Param("record") UserScore record, @Param("example") UserScoreExample example);

    int updateByPrimaryKeySelective(UserScore record);

    int updateByPrimaryKey(UserScore record);
    //获取用户积分记录
    List<UserScore> getUserScoreByUid(@Param("uid")Integer uid);


    List<UserScore> selectAll(@Param("param")String param, @Param("startTime")String startTime, @Param("endTime")String endTime);

    UserScore getScoreByInfo(@Param("uid")Integer uid,@Param("info")Integer info);
}