package com.mmall.service;

import com.mmall.model.BankcardDetail;
import com.mmall.model.SkinType;

import java.util.List;

public interface SkinTypeService {

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
       SkinType selectByPrimaryKey(Integer id);
       List<SkinType> getAllSkinType(String param);
       int updateByPrimaryKeySelective(SkinType record);
       int insertSelective(SkinType record);
}
