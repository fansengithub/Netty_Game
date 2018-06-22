package com.mmall.service;

import com.mmall.model.LayUIResult;
import com.mmall.model.LearnbookDetail;

import java.util.List;

public interface LearnBookService {

    public List<LearnbookDetail> getAllLean(String param);

    public LayUIResult delLearn(int lid);

    LearnbookDetail selLearnbook(int lid);

    int addLearn(LearnbookDetail learnbookDetail);

    int updateLearn(LearnbookDetail learnbookDetail);

    LearnbookDetail selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(LearnbookDetail record);

}
