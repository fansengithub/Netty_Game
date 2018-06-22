package com.mmall.dao;

import com.mmall.model.WaitingMember;
import com.mmall.model.WaitingMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WaitingMemberMapper {
    long countByExample(WaitingMemberExample example);

    int deleteByExample(WaitingMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaitingMember record);

    int insertSelective(WaitingMember record);

    List<WaitingMember> selectByExample(WaitingMemberExample example);

    WaitingMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaitingMember record, @Param("example") WaitingMemberExample example);

    int updateByExample(@Param("record") WaitingMember record, @Param("example") WaitingMemberExample example);

    int updateByPrimaryKeySelective(WaitingMember record);

    int updateByPrimaryKey(WaitingMember record);

    List<WaitingMember> selectAll();
}