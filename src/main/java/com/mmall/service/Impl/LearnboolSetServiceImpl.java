package com.mmall.service.Impl;

import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.LearnbookSetMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.dao.SkinTypeMapper;
import com.mmall.model.LearnbookSet;
import com.mmall.model.SkinType;
import com.mmall.service.LearnboolSetService;
import com.mmall.service.SkinTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@Slf4j
public class LearnboolSetServiceImpl implements LearnboolSetService {

    @Autowired
    private LearnbookSetMapper learnbookSetMapper;

    //修改教材设置
    @Override
    public int updateByPrimaryKeySelective(LearnbookSet record) {
        return learnbookSetMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public LearnbookSet getMaxLearnbookSet(){
        return learnbookSetMapper.getMaxLearnbookSet();
    }


}
