package com.mmall.service;

import com.mmall.model.ParameterSet;
import com.mmall.model.SkinType;

import java.util.List;

public interface ParameterSetService {



       ParameterSet selectByPrimaryKey(Integer id);
       List<ParameterSet> getAllParameterSet(String param);
       int updateByPrimaryKeySelective(ParameterSet record);
}
