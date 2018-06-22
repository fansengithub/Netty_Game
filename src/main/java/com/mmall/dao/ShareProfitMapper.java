package com.mmall.dao;

import com.mmall.model.ShareProfit;
import com.mmall.model.ShareProfitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShareProfitMapper {
    long countByExample(ShareProfitExample example);

    int deleteByExample(ShareProfitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShareProfit record);

    int insertSelective(ShareProfit record);

    List<ShareProfit> selectByExample(ShareProfitExample example);

    ShareProfit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShareProfit record, @Param("example") ShareProfitExample example);

    int updateByExample(@Param("record") ShareProfit record, @Param("example") ShareProfitExample example);

    int updateByPrimaryKeySelective(ShareProfit record);

    int updateByPrimaryKey(ShareProfit record);


    ShareProfit selectByPrimaryKeyByRole(Integer id);
    int updateByPrimaryKeySelectiveByRole(ShareProfit record);
    List<ShareProfit> selAllShareProfit(@Param("param")String param);
}