package com.mmall.dao;

import com.mmall.model.WitdrawDetail;
import com.mmall.model.WitdrawDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WitdrawDetailMapper {
    long countByExample(WitdrawDetailExample example);

    int deleteByExample(WitdrawDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WitdrawDetail record);

    int insertSelective(WitdrawDetail record);

    List<WitdrawDetail> selectByExample(WitdrawDetailExample example);

    WitdrawDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WitdrawDetail record, @Param("example") WitdrawDetailExample example);

    int updateByExample(@Param("record") WitdrawDetail record, @Param("example") WitdrawDetailExample example);

    int updateByPrimaryKeySelective(WitdrawDetail record);

    int updateByPrimaryKey(WitdrawDetail record);

    List<WitdrawDetail> selAllWitdrawDetail(@Param("param")String param,@Param("stage")String stage, @Param("startTime")String startTime, @Param("endTime")String endTime);
    List<WitdrawDetail> selAllWitdrawDetailByService(@Param("uid")Integer uid,@Param("param")String param, @Param("stage")String stage,@Param("startTime")String startTime, @Param("endTime")String endTime);
    List<WitdrawDetail> selAllWitdrawDetailByOrganization(@Param("uid")Integer uid,@Param("param")String param,@Param("stage")String stage, @Param("startTime")String startTime, @Param("endTime")String endTime);
    List<WitdrawDetail> selAllWitdrawDetailByPianoShop(@Param("uid")Integer uid,@Param("param")String param, @Param("stage")String stage,@Param("startTime")String startTime, @Param("endTime")String endTime);

    //通过tid获取提现记录
    List<WitdrawDetail> getWitdrawByUid(@Param("tid")Integer tid,@Param("time")String time,@Param("endtime")String endtime);

    Integer getWitdrawDetaiCount(@Param("role")String role,@Param("userId")Integer userId);  //得到个人总提现
}