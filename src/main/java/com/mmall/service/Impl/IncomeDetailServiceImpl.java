package com.mmall.service.Impl;

import com.mmall.dao.IncomeDetailMapper;
import com.mmall.entity.IncomeDetailCount;
import com.mmall.model.IncomeDetail;
import com.mmall.service.IncomeDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IncomeDetailServiceImpl implements IncomeDetailService {


    @Autowired
    private IncomeDetailMapper incomeDetailMapper;
    /**
     * 提现详情列表
     * @param param
     * @return
     */
    @Override
    public List<IncomeDetail> getAllIncomeDetail(String param,String consumpType1,String startTime,String endTime) {
        log.info("收入明细条件");
        List<IncomeDetail> ShareProfitListList= incomeDetailMapper.getAllIncomeDetail(param,consumpType1,startTime,endTime);
        log.info("返回个数="+ShareProfitListList.size());
        return ShareProfitListList;
    }
    @Override
    public List<IncomeDetail> selectAllByService(Integer uid,String param,String consumpType1,String startTime,String endTime) {
        log.info("收入明细条件");
        List<IncomeDetail> ShareProfitListList= incomeDetailMapper.selectAllByService(uid,param,consumpType1,startTime,endTime);
        log.info("返回个数="+ShareProfitListList.size());
        return ShareProfitListList;
    }
    @Override
    public List<IncomeDetail> selectAllByOrganization(Integer uid,String param,String consumpType1,String startTime,String endTime) {
        log.info("收入明细条件");
        List<IncomeDetail> ShareProfitListList= incomeDetailMapper.selectAllByOrganization(uid,param,consumpType1,startTime,endTime);
        log.info("返回个数="+ShareProfitListList.size());
        return ShareProfitListList;
    }
    @Override
    public List<IncomeDetail> selectAllByPianoShop(Integer uid,String param,String consumpType1,String startTime,String endTime) {
        log.info("收入明细条件");
        List<IncomeDetail> ShareProfitListList= incomeDetailMapper.selectAllByPianoShop(uid,param,consumpType1,startTime,endTime);
        log.info("返回个数="+ShareProfitListList.size());
        return ShareProfitListList;
    }
    @Override
    public List<IncomeDetailCount> getGroupIncomeDetail(String param, String consumpType1, String startTime, String endTime) {
        log.info("收入分组统计");
        List<IncomeDetailCount> ShareProfitListList= incomeDetailMapper.getGroupIncomeDetail(param,consumpType1,startTime,endTime);
        log.info("返回个数="+ShareProfitListList.size());
        return ShareProfitListList;
    }
    @Override
    public List<IncomeDetailCount> getGroupIncomeDetailByService(Integer uid,String param, String consumpType1, String startTime, String endTime) {
        log.info("收入分组统计");
        List<IncomeDetailCount> ShareProfitListList= incomeDetailMapper.getGroupIncomeDetailByService(uid,param,consumpType1,startTime,endTime);
        log.info("返回个数="+ShareProfitListList.size());
        return ShareProfitListList;
    }
    @Override
    public List<IncomeDetailCount> getGroupIncomeDetailByOrganization(Integer uid,String param, String consumpType1, String startTime, String endTime) {
        log.info("收入分组统计");
        List<IncomeDetailCount> ShareProfitListList= incomeDetailMapper.getGroupIncomeDetailByOrganization(uid,param,consumpType1,startTime,endTime);
        log.info("返回个数="+ShareProfitListList.size());
        return ShareProfitListList;
    }
    @Override
    public List<IncomeDetailCount> getGroupIncomeDetailByPianoShop(Integer uid,String param, String consumpType1, String startTime, String endTime) {
        log.info("收入分组统计");
        List<IncomeDetailCount> ShareProfitListList= incomeDetailMapper.getGroupIncomeDetailByPianoShop(uid,param,consumpType1,startTime,endTime);
        log.info("返回个数="+ShareProfitListList.size());
        return ShareProfitListList;
    }
    @Override
    public IncomeDetailCount getMinTimeIncomeDetail(String param, String consumpType1, String startTime, String endTime) {
        log.info("收入分组统计");
        IncomeDetailCount ShareProfitListList= incomeDetailMapper.getMinTimeIncomeDetail(param,consumpType1,startTime,endTime);
        log.info("返回个数="+ShareProfitListList.getMinTime());
        return ShareProfitListList;
    }


}
