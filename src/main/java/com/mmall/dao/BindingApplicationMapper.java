package com.mmall.dao;

import com.mmall.model.BindingApplication;
import com.mmall.model.BindingApplicationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BindingApplicationMapper {
    long countByExample(BindingApplicationExample example);

    int deleteByExample(BindingApplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BindingApplication record);

    int insertSelective(BindingApplication record);

    List<BindingApplication> selectByExample(BindingApplicationExample example);

    BindingApplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BindingApplication record, @Param("example") BindingApplicationExample example);

    int updateByExample(@Param("record") BindingApplication record, @Param("example") BindingApplicationExample example);

    int updateByPrimaryKeySelective(BindingApplication record);

    int updateByPrimaryKey(BindingApplication record);

//    通过touserId查询未处理的绑定请求
    List<BindingApplication> selectByToUserId(@Param("toUserId") Integer toUserId);

    List<BindingApplication> selectByToUserIdAndState(@Param("toUserId") Integer toUserId,@Param("satate") Integer state);

    BindingApplication selectByfromUserIdAndToUserId(@Param("fromUserId") Integer fromUserId,@Param("toUserId") Integer toUserId);

    List<BindingApplication> selectByfromUserId(@Param("fromUserId") Integer fromUserId);

    List<BindingApplication> selectByfromUserIdAndState(@Param("fromUserId") Integer fromUserId,@Param("satate") Integer state);

//    查询用户a相关的所有绑定关系
    List<BindingApplication> selectByfromUserIdOrToUserId(@Param("aimId") Integer aimId);

//    查询  a-->b   b-->a
    BindingApplication selectByfromUserIdOrToUerId(@Param("fromUserId") Integer fromUserId,@Param("toUserId") Integer toUserId);

}