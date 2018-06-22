package com.mmall.service;

import com.mmall.model.ShareProfit;
import com.mmall.model.SkinType;
import com.mmall.model.WitdrawDetail;

import java.util.List;

public interface ShareProfitService {

    ShareProfit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShareProfit record);


       List<ShareProfit> getAllShareProfit(String param);
}
