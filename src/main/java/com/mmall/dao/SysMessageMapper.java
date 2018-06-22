package com.mmall.dao;

import com.mmall.model.SysMessage;
import com.mmall.model.SysMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMessageMapper {
    long countByExample(SysMessageExample example);

    int deleteByExample(SysMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysMessage record);

    int insertSelective(SysMessage record);

    List<SysMessage> selectByExample(SysMessageExample example);

    SysMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

    int updateByExample(@Param("record") SysMessage record, @Param("example") SysMessageExample example);

    int updateByPrimaryKeySelective(SysMessage record);

    int updateByPrimaryKey(SysMessage record);

    List<SysMessage> getAllSysMessage(@Param("param")String param, @Param("startTime")String startTime,@Param("endTime") String endTime);

    //获取发给指定用户消息以及系统消息
    List<SysMessage> getMessageList(@Param("uid")Integer uid);


}