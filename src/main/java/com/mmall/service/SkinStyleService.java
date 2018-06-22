package com.mmall.service;

import com.mmall.model.SkinStyle;
import com.mmall.model.SkinType;

import java.util.List;

public interface SkinStyleService {

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
       SkinStyle selectByPrimaryKey(Integer id);
       List<SkinStyle> getAllSkinStyle(String param);
       int updateByPrimaryKeySelective(SkinStyle record);
       int insertSelective(SkinStyle record);
}
