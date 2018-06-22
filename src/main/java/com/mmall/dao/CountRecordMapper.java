package com.mmall.dao;

import com.mmall.model.CountRecord;
import com.mmall.model.CountRecordExample;
import com.mmall.model.UserScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountRecordMapper {
    int countByExample(CountRecordExample example);

    int deleteByExample(CountRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CountRecord record);

    int insertSelective(CountRecord record);

    List<CountRecord> selectByExample(CountRecordExample example);

    CountRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CountRecord record, @Param("example") CountRecordExample example);

    int updateByExample(@Param("record") CountRecord record, @Param("example") CountRecordExample example);

    int updateByPrimaryKeySelective(CountRecord record);

    int updateByPrimaryKey(CountRecord record);

    //通过玩家id获取计数器记录
    List<CountRecord> getCountRecordByUid(@Param("uid") Integer uid,@Param("time")String time,@Param("endtime")String endtime,@Param("page")Integer page,@Param("size")Integer size);
    List<CountRecord> selectAll(@Param("param")String param, @Param("startTime")String startTime, @Param("endTime")String endTime);
}