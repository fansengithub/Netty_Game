package com.mmall.dao;

import com.mmall.model.RechargePackage;
import com.mmall.model.RechargePackageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RechargePackageMapper {
    long countByExample(RechargePackageExample example);

    int deleteByExample(RechargePackageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RechargePackage record);

    int insertSelective(RechargePackage record);

    List<RechargePackage> selectByExample(RechargePackageExample example);

    RechargePackage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RechargePackage record, @Param("example") RechargePackageExample example);

    int updateByExample(@Param("record") RechargePackage record, @Param("example") RechargePackageExample example);

    int updateByPrimaryKeySelective(RechargePackage record);

    int updateByPrimaryKey(RechargePackage record);

    List<RechargePackage>  selectByParam(@Param("param")String param);

    List<RechargePackage>  selectAll();

}