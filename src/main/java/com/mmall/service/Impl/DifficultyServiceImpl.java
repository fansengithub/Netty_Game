package com.mmall.service.Impl;

import com.mmall.dao.DifficultySetMapper;
import com.mmall.model.DifficultySet;
import com.mmall.service.DifficultySetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DifficultyServiceImpl implements DifficultySetService {


    @Autowired
    private DifficultySetMapper difficultySetMapper;

    /**
     * 提现详情列表
     *
     * @param param
     * @return
     */
    @Override
    public List<DifficultySet> getAllDifficulty(String param) {
        log.info("体现条件");
        List<DifficultySet> WitdrawDetailList = difficultySetMapper.getAllDifficulty(param);
        log.info("返回个数=" + WitdrawDetailList.size());
        return WitdrawDetailList;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return difficultySetMapper.deleteByPrimaryKey(id);
    }



    @Override
    public DifficultySet selectByPrimaryKey(Integer id) {
        return difficultySetMapper.selectByPrimaryKey(id);
    }



    @Override
    public int updateByPrimaryKeySelective(DifficultySet record) {
        return difficultySetMapper.updateByPrimaryKeySelective(record);
    }



    @Override
    public int insertSelective(DifficultySet record) {
        return difficultySetMapper.insertSelective(record);
    }

    //获取所有
    @Override
    public List<DifficultySet> selAllDifficulty(){
        return difficultySetMapper.selAllDifficulty();
    }
}
