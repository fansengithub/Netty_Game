package com.mmall.dao;

import com.mmall.model.SongRecord;
import com.mmall.model.SongRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongRecordMapper {
    int countByExample(SongRecordExample example);

    int deleteByExample(SongRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SongRecord record);

    int insertSelective(SongRecord record);

    List<SongRecord> selectByExample(SongRecordExample example);

    SongRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SongRecord record, @Param("example") SongRecordExample example);

    int updateByExample(@Param("record") SongRecord record, @Param("example") SongRecordExample example);

    int updateByPrimaryKeySelective(SongRecord record);

    int updateByPrimaryKey(SongRecord record);

    //通过userId查询用户基础练习记录
    List<SongRecord> getSongRecord(@Param("uid")Integer uid, @Param("page")Integer page,@Param("size")Integer size);

    //通过userId查询用户基础练习记录
    List<SongRecord> getSongRecordByUid(@Param("uid")Integer uid, @Param("time")String time, @Param("endtime")String endtime, @Param("page")Integer page,@Param("size")Integer size);

    int selectWeek(@Param("date")String date,@Param("userid")Integer userid);

    int selectSumByDay(@Param("date")String date,@Param("userid")Integer userid);

    int selectMonthTime(@Param("userid")Integer userid);

    int selectWeekTime(@Param("userid")Integer userid);

    int selectLastWeekTime(@Param("userid")Integer userid);

    //
//    Integer getCount(@Param("time")String time,@Param("endtime")String endtime,@Param("uid")Integer uid,@Param("oid")Integer oid);

    //获取用户某时间段练习记录
    List<SongRecord> getSongRecords(@Param("time")String time,@Param("endtime")String endtime,@Param("uid")Integer uid,@Param("oid")Integer oid);

    List<SongRecord> selectAll(@Param("param")String param, @Param("startTime")String startTime, @Param("endTime")String endTime);
}