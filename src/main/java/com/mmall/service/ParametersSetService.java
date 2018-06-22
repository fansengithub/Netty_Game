package com.mmall.service;

import com.mmall.model.ParametersSet;

public interface ParametersSetService {



       ParametersSet selectByPrimaryKey(Integer id);

       int updateByPrimaryKeySelective(ParametersSet record);

}
