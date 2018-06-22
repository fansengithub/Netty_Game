package com.mmall.service.Impl;

import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.dao.ParameterSetMapper;
import com.mmall.dao.SkinTypeMapper;
import com.mmall.model.ParameterSet;
import com.mmall.model.SkinType;
import com.mmall.service.ParameterSetService;
import com.mmall.service.SkinTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ParameterSetServiceImpl implements ParameterSetService {

    @Autowired
    private ParameterSetMapper parameterSetMapper;
    /**
     * 提现详情列表
     *
     * @param param
     * @return
     */
    @Override
    public List<ParameterSet> getAllParameterSet(String param) {
        log.info("体现条件");
        List<ParameterSet> WitdrawDetailList = parameterSetMapper.getAllParameterSet(null);
        log.info("返回个数=" + WitdrawDetailList.size());
        return WitdrawDetailList;
    }


    @Override
    public ParameterSet selectByPrimaryKey(Integer id) {
        return parameterSetMapper.selectByPrimaryKey(id);
    }



    @Override
    public int updateByPrimaryKeySelective(ParameterSet record) {
        return parameterSetMapper.updateByPrimaryKeySelective(record);
    }



}
