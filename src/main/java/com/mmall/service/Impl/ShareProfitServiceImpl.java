package com.mmall.service.Impl;

import com.mmall.dao.ShareProfitMapper;
import com.mmall.model.ShareProfit;
import com.mmall.service.ShareProfitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShareProfitServiceImpl implements ShareProfitService {


    @Autowired
    private ShareProfitMapper shareProfitMapper;

    @Override
    public ShareProfit selectByPrimaryKey(Integer id) {
        return shareProfitMapper.selectByPrimaryKeyByRole(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ShareProfit record) {
        return shareProfitMapper.updateByPrimaryKeySelectiveByRole(record);
    }

    /**
     * 提现详情列表
     * @param param
     * @return
     */
    @Override
    public List<ShareProfit> getAllShareProfit(String param) {
        log.info("分润条件");
        List<ShareProfit> ShareProfitList= shareProfitMapper.selAllShareProfit(param);
        log.info("返回个数="+ShareProfitList.size());
        return ShareProfitList;
    }


}
