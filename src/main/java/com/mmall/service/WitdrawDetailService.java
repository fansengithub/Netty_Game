package com.mmall.service;

import com.mmall.model.SkinType;
import com.mmall.model.WitdrawDetail;

import java.text.ParseException;
import java.util.List;

public interface WitdrawDetailService {

//    public List<LearnbookDetail> getAllLean(String param);
//
//    public LayUIResult delLearn(int lid);
//
//    LearnbookDetail selLearnbook(int lid);
//
//    int addLearn(LearnbookDetail learnbookDetail);
//
//    int updateLearn(LearnbookDetail learnbookDetail);
       int insert(WitdrawDetail record);

       List<WitdrawDetail> getAllWitdrawDetail(String param,String stage,String startTime,String endTime);
       List<WitdrawDetail> getAllWitdrawDetailByService(Integer uid,String param,String stage,String startTime,String endTime);
       List<WitdrawDetail> getAllWitdrawDetailByOrganization(Integer uid,String param,String stage,String startTime,String endTime);
       List<WitdrawDetail> getAllWitdrawDetailByPianoShop(Integer uid,String param,String stage,String startTime,String endTime);

       int updateByPrimaryKeySelective(WitdrawDetail record);
}
