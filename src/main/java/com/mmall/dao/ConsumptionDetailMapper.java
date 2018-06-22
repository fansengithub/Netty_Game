package com.mmall.dao;

import com.mmall.model.ConsumptionDetail;
import com.mmall.model.ConsumptionDetailExample;
import java.util.List;

import com.mmall.model.RechargeDetail;
import org.apache.ibatis.annotations.Param;

public interface ConsumptionDetailMapper {
    long countByExample(ConsumptionDetailExample example);

    int deleteByExample(ConsumptionDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConsumptionDetail record);

    int insertSelective(ConsumptionDetail record);

    List<ConsumptionDetail> selectByExample(ConsumptionDetailExample example);

    ConsumptionDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConsumptionDetail record, @Param("example") ConsumptionDetailExample example);

    int updateByExample(@Param("record") ConsumptionDetail record, @Param("example") ConsumptionDetailExample example);

    int updateByPrimaryKeySelective(ConsumptionDetail record);

    int updateByPrimaryKey(ConsumptionDetail record);


    List<ConsumptionDetail>  selectAll(@Param("param") String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<ConsumptionDetail>  selectAllByService(@Param("uid")Integer uid,@Param("param") String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<ConsumptionDetail>  selectAllByOrganization(@Param("uid")Integer uid,@Param("param") String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<ConsumptionDetail>  selectAllByPianoShop(@Param("uid")Integer uid,@Param("param") String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    //获取学生该天消费金额
    Integer consumptionSUM(@Param("uid")Integer uid);

    //通过uid获取消费记录
    List<ConsumptionDetail> getConsumtionByUid(@Param("uid")Integer uid,@Param("time")String time,@Param("endtime")String endtime);

    Integer getConsumtionDetaiCount(@Param("role")String role,@Param("userId")Integer userId);  //得到个人总消费

}