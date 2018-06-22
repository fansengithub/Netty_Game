package com.mmall.dao;

import com.mmall.model.MembershipDues;
import com.mmall.model.MembershipDuesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MembershipDuesMapper {
    long countByExample(MembershipDuesExample example);

    int deleteByExample(MembershipDuesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MembershipDues record);

    int insertSelective(MembershipDues record);

    List<MembershipDues> selectByExample(MembershipDuesExample example);

    MembershipDues selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MembershipDues record, @Param("example") MembershipDuesExample example);

    int updateByExample(@Param("record") MembershipDues record, @Param("example") MembershipDuesExample example);

    int updateByPrimaryKeySelective(MembershipDues record);

    int updateByPrimaryKey(MembershipDues record);

    List<MembershipDues> selectAll(@Param("param")String param,@Param("consumpType1")String consumpType1, @Param("startTime")String startTime, @Param("endTime")String endTime);
    Integer selectAllCountByRole(@Param("param")String param,@Param("consumpType1")String consumpType1, @Param("startTime")String startTime, @Param("endTime")String endTime);
    MembershipDues selectByLastTwoTime(@Param("userId")Integer userId,@Param("role")String role);
}