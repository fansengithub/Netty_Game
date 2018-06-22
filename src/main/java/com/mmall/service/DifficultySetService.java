package com.mmall.service;

import com.mmall.model.DifficultySet;
import com.mmall.model.SkinType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DifficultySetService {

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
       DifficultySet selectByPrimaryKey(Integer id);
       List<DifficultySet> getAllDifficulty(String param);
       int updateByPrimaryKeySelective(DifficultySet record);
       int insertSelective(DifficultySet record);
       //获取所有
       List<DifficultySet> selAllDifficulty();
}
