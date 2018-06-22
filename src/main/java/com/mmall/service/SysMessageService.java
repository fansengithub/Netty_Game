package com.mmall.service;

import com.mmall.model.SkinType;
import com.mmall.model.SysMessage;

import java.util.List;

public interface SysMessageService {

//    public List<LearnbookDetail> getAllLean(String param);
//
//    public LayUIResult delLearn(int lid);
//
//    LearnbookDetail selLearnbook(int lid);
//
//    int addLearn(LearnbookDetail learnbookDetail);
//
//    int updateLearn(LearnbookDetail learnbookDetail);
       int deleteByPrimaryKey(Integer id);
       SysMessage selectByPrimaryKey(Integer id);
       List<SysMessage> getAllSysMessage(String param,String startTime,String endTime);
       int updateByPrimaryKeySelective(SysMessage record);
       int insertSelective(SysMessage record);
}
