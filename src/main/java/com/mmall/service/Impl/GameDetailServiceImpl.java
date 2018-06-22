package com.mmall.service.Impl;

import com.mmall.dao.GameDetailMapper;
import com.mmall.dao.SkinDetailMapper;
import com.mmall.model.GameDetail;
import com.mmall.model.SkinDetail;
import com.mmall.service.GameDetailService;
import com.mmall.service.SkinDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GameDetailServiceImpl implements GameDetailService {

    @Autowired
    private GameDetailMapper gameDetailMapper;

    /**
     * 提现详情列表
     *
     * @param param
     * @return
     */
    @Override
    public List<GameDetail> getAllGameDetail(String param, String startTime, String endTime) {
        log.info("体现条件");
        List<GameDetail> WitdrawDetailList = gameDetailMapper.getAllGameDetail(param,startTime,endTime);
        log.info("返回个数=" + WitdrawDetailList.size());
        return WitdrawDetailList;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return gameDetailMapper.deleteByPrimaryKey(id);
    }



    @Override
    public GameDetail selectByPrimaryKey(Integer id) {
        return gameDetailMapper.selectByPrimaryKey(id);
    }



    @Override
    public int updateByPrimaryKeySelective(GameDetail record) {
        log.info("liname"+record.getName());
        return gameDetailMapper.updateByPrimaryKeySelective(record);
    }



    @Override
    public int insertSelective(GameDetail record) {
        return gameDetailMapper.insertSelective(record);
    }

}
