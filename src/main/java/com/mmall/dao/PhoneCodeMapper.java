package com.mmall.dao;

import com.mmall.model.PhoneCode;
import com.mmall.model.PhoneCodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhoneCodeMapper {
    int countByExample(PhoneCodeExample example);

    int deleteByExample(PhoneCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PhoneCode record);

    int insertSelective(PhoneCode record);

    List<PhoneCode> selectByExample(PhoneCodeExample example);

    PhoneCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PhoneCode record, @Param("example") PhoneCodeExample example);

    int updateByExample(@Param("record") PhoneCode record, @Param("example") PhoneCodeExample example);

    int updateByPrimaryKeySelective(PhoneCode record);

    int updateByPrimaryKey(PhoneCode record);

    //通过手机号查询验证码
    PhoneCode selectByPhone(@Param("phone")String phone);
}