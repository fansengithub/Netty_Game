package com.mmall.service;

import com.mmall.entity.IncomeDetailCount;
import com.mmall.model.BankcardDetail;
import com.mmall.model.IncomeDetail;

import java.util.HashMap;
import java.util.List;

public interface IncomeDetailService {

//    public List<LearnbookDetail> getAllLean(String param);
//
//    public LayUIResult delLearn(int lid);
//
//    LearnbookDetail selLearnbook(int lid);
//
//    int addLearn(LearnbookDetail learnbookDetail);
//
//    int updateLearn(LearnbookDetail learnbookDetail);

       List<IncomeDetail> getAllIncomeDetail(String param,String consumpType1,String startTime,String endTime);
       List<IncomeDetail> selectAllByService(Integer uid,String param,String consumpType1,String startTime,String endTime);
       List<IncomeDetail> selectAllByOrganization(Integer uid,String param,String consumpType1,String startTime,String endTime);
       List<IncomeDetail> selectAllByPianoShop(Integer uid,String param,String consumpType1,String startTime,String endTime);
       List<IncomeDetailCount> getGroupIncomeDetail(String param, String consumpType1, String startTime, String endTime);
       List<IncomeDetailCount> getGroupIncomeDetailByService(Integer uid,String param, String consumpType1, String startTime, String endTime);
       List<IncomeDetailCount> getGroupIncomeDetailByOrganization(Integer uid,String param, String consumpType1, String startTime, String endTime);
       List<IncomeDetailCount> getGroupIncomeDetailByPianoShop(Integer uid,String param, String consumpType1, String startTime, String endTime);
       IncomeDetailCount getMinTimeIncomeDetail(String param, String consumpType1, String startTime, String endTime);
}
