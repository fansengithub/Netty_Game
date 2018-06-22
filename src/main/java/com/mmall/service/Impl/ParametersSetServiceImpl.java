package com.mmall.service.Impl;

import com.mmall.dao.ParametersSetMapper;
import com.mmall.model.ParametersSet;
import com.mmall.service.ParametersSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ParametersSetServiceImpl implements ParametersSetService {


    @Autowired
    private ParametersSetMapper parametersSetMapper;




    @Override
    public ParametersSet selectByPrimaryKey(Integer id) {
        return parametersSetMapper.selectByPrimaryKey2(id);
    }



    @Override
    public int updateByPrimaryKeySelective(ParametersSet record) {
        return parametersSetMapper.updateByPrimaryKeySelective2(record);
    }



}
