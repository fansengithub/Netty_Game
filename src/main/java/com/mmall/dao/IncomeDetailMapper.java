package com.mmall.dao;

import com.mmall.entity.IncomeDetailCount;
import com.mmall.model.IncomeDetail;
import com.mmall.model.IncomeDetailExample;

import java.util.HashMap;
import java.util.List;

import com.mmall.model.ShareProfit;
import org.apache.ibatis.annotations.Param;

public interface IncomeDetailMapper {
    long countByExample(IncomeDetailExample example);

    int deleteByExample(IncomeDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IncomeDetail record);

    int insertSelective(IncomeDetail record);

    List<IncomeDetail> selectByExample(IncomeDetailExample example);

    IncomeDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IncomeDetail record, @Param("example") IncomeDetailExample example);

    int updateByExample(@Param("record") IncomeDetail record, @Param("example") IncomeDetailExample example);

    int updateByPrimaryKeySelective(IncomeDetail record);

    int updateByPrimaryKey(IncomeDetail record);

    List<IncomeDetail> getAllIncomeDetail(@Param("param")String param,@Param("consumpType1")String consumpType1,@Param("startTime")String startTime,@Param("endTime")String endTime);//,consumpType1,startTime,endTime
    List<IncomeDetail> selectAllByService(@Param("uid")Integer uid,@Param("param")String param,@Param("consumpType1")String consumpType1,@Param("startTime")String startTime,@Param("endTime")String endTime);//,consumpType1,startTime,endTime
    List<IncomeDetail> selectAllByOrganization(@Param("uid")Integer uid,@Param("param")String param,@Param("consumpType1")String consumpType1,@Param("startTime")String startTime,@Param("endTime")String endTime);//,consumpType1,startTime,endTime
    List<IncomeDetail> selectAllByPianoShop(@Param("uid")Integer uid,@Param("param")String param,@Param("consumpType1")String consumpType1,@Param("startTime")String startTime,@Param("endTime")String endTime);//,consumpType1,startTime,endTime

    Integer getIncomeDetailById(@Param("role")String role,@Param("userId")Integer userId);  //得到个人总收入



    List<IncomeDetailCount> getGroupIncomeDetail(@Param("param")String param, @Param("consumpType1")String consumpType1, @Param("startTime")String startTime, @Param("endTime")String endTime);//,consumpType1,startTime,endTime
    List<IncomeDetailCount> getGroupIncomeDetailByService(@Param("uid")Integer uid,@Param("param")String param, @Param("consumpType1")String consumpType1, @Param("startTime")String startTime, @Param("endTime")String endTime);//,consumpType1,startTime,endTime
    List<IncomeDetailCount> getGroupIncomeDetailByOrganization(@Param("uid")Integer uid,@Param("param")String param, @Param("consumpType1")String consumpType1, @Param("startTime")String startTime, @Param("endTime")String endTime);//,consumpType1,startTime,endTime
    List<IncomeDetailCount> getGroupIncomeDetailByPianoShop(@Param("uid")Integer uid,@Param("param")String param, @Param("consumpType1")String consumpType1, @Param("startTime")String startTime, @Param("endTime")String endTime);//,consumpType1,startTime,endTime
    IncomeDetailCount getMinTimeIncomeDetail(@Param("param")String param, @Param("consumpType1")String consumpType1, @Param("startTime")String startTime, @Param("endTime")String endTime);//,consumpType1,startTime,endTime
}