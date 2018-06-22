package com.mmall.service;

import com.mmall.model.BankcardDetail;
import com.mmall.model.ShareProfit;
import com.mmall.model.SkinStyle;
import com.mmall.model.SkinType;

import java.util.List;

public interface BankcardDetailService {

//    public List<LearnbookDetail> getAllLean(String param);
//
//    public LayUIResult delLearn(int lid);
//
//    LearnbookDetail selLearnbook(int lid);
//
//    int addLearn(LearnbookDetail learnbookDetail);
//
//    int updateLearn(LearnbookDetail learnbookDetail);

       List<BankcardDetail> getAllBankcardDetail(String param);

       int insertSelective(BankcardDetail record);

       int updateByPrimaryKeySelective(BankcardDetail record);
       int updateAllisDefault(BankcardDetail record);


}
