package com.mmall.service.Impl;

import com.mmall.dao.BankcardDetailMapper;
import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.model.BankcardDetail;
import com.mmall.service.BankcardDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BankcardDetailServiceImpl implements BankcardDetailService {
    @Autowired
    private LearnbookDetailMapper learnbookDetailMapper;

    @Autowired
    private OperaDetailMapper operaDetailMapper;

    @Autowired
    private BankcardDetailMapper bnkcardDetailMapper;
    /**
     * 提现详情列表
     * @param param
     * @return
     */
    @Override
    public List<BankcardDetail> getAllBankcardDetail(String param) {
        log.info("分润条件");
        List<BankcardDetail> ShareProfitListList= bnkcardDetailMapper.getAllBankcardDetail(param);
        log.info("返回个数="+ShareProfitListList.size());
        return ShareProfitListList;
    }
    @Override
    public int insertSelective(BankcardDetail record){
        return bnkcardDetailMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(BankcardDetail record) {
        return bnkcardDetailMapper.updateByPrimaryKeySelective(record);
    }
    @Override
    public int updateAllisDefault(BankcardDetail record) {
        return bnkcardDetailMapper.updateAllisDefault(record);
    }
}
