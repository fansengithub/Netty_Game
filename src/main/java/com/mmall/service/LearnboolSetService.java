package com.mmall.service;

import com.mmall.model.LearnbookSet;
import com.mmall.model.SkinType;

import java.util.List;

public interface LearnboolSetService {


       int updateByPrimaryKeySelective(LearnbookSet record);

       LearnbookSet getMaxLearnbookSet();

}
