package com.mmall.dao;

import com.mmall.model.RechargeDetail;
import com.mmall.model.RechargeDetailExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RechargeDetailMapper {
    long countByExample(RechargeDetailExample example);

    int deleteByExample(RechargeDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RechargeDetail record);

    int insertSelective(RechargeDetail record);

    List<RechargeDetail> selectByExample(RechargeDetailExample example);

    RechargeDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RechargeDetail record, @Param("example") RechargeDetailExample example);

    int updateByExample(@Param("record") RechargeDetail record, @Param("example") RechargeDetailExample example);

    int updateByPrimaryKeySelective(RechargeDetail record);

    int updateByPrimaryKey(RechargeDetail record);

    List<RechargeDetail>  selectAll(@Param("param") String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<RechargeDetail>  selectAllByService(@Param("uid")Integer uid,@Param("param") String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<RechargeDetail>  selectAllByOrganization(@Param("uid")Integer uid,@Param("param") String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<RechargeDetail>  selectAllByPianoShop(@Param("uid")Integer uid,@Param("param") String param,@Param("startTime")String startTime,@Param("endTime")String endTime);

    //通过uid获取用户充值记录
    List<RechargeDetail> getRechargeByUid(@Param("uid")Integer uid,@Param("time")String time,@Param("endtime")String endtime);

    Map<String,BigDecimal> getRechargeCountByUid(@Param("userId")Integer userId, @Param("role")String role);

    Integer getRechargeDetaiCount(@Param("role")String role,@Param("userId")Integer userId);  //得到个人总提现
}