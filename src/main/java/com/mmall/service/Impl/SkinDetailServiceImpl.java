package com.mmall.service.Impl;

import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.dao.SkinDetailMapper;
import com.mmall.dao.SkinStyleMapper;
import com.mmall.model.SkinDetail;
import com.mmall.model.SkinStyle;
import com.mmall.service.SkinDetailService;
import com.mmall.service.SkinStyleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SkinDetailServiceImpl implements SkinDetailService {

    @Autowired
    private SkinDetailMapper skinDetailMapper;

    /**
     * 提现详情列表
     *
     * @param param
     * @return
     */
    @Override
    public List<SkinDetail> getAllSkinDetail(String param,String startTime,String endTime) {
        log.info("体现条件");
        List<SkinDetail> WitdrawDetailList = skinDetailMapper.getAllSkinDetail(param,startTime,endTime);
        log.info("返回个数=" + WitdrawDetailList.size());
        return WitdrawDetailList;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return skinDetailMapper.deleteByPrimaryKey(id);
    }



    @Override
    public SkinDetail selectByPrimaryKey(Integer id) {
        return skinDetailMapper.selectByPrimaryKey(id);
    }



    @Override
    public int updateByPrimaryKeySelective(SkinDetail record) {
        log.info("liname"+record.getName());
        return skinDetailMapper.updateByPrimaryKeySelective(record);
    }



    @Override
    public int insertSelective(SkinDetail record) {
        return skinDetailMapper.insertSelective(record);
    }

}
