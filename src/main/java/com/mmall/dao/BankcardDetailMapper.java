package com.mmall.dao;

import com.mmall.model.BankcardDetail;
import com.mmall.model.BankcardDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankcardDetailMapper {
    long countByExample(BankcardDetailExample example);

    int deleteByExample(BankcardDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BankcardDetail record);

    int insertSelective(BankcardDetail record);

    List<BankcardDetail> selectByExample(BankcardDetailExample example);

    BankcardDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BankcardDetail record, @Param("example") BankcardDetailExample example);

    int updateByExample(@Param("record") BankcardDetail record, @Param("example") BankcardDetailExample example);

    int updateByPrimaryKeySelective(BankcardDetail record);

    int updateByPrimaryKey(BankcardDetail record);

    int updateAllisDefault(BankcardDetail record);
    List<BankcardDetail> getAllBankcardDetail(@Param("param")String param);

    String getRoleNameByuserID(@Param("userID")Integer userID);

    //获取用户绑定的银行卡
    List<BankcardDetail> getBankCardByUid(@Param("uid")Integer uid);
}