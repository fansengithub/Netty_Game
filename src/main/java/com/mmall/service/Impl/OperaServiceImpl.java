package com.mmall.service.Impl;

import com.mmall.dao.OperaDetailMapper;
import com.mmall.model.OperaDetail;
import com.mmall.service.OperaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 曲谱管理
 */
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class OperaServiceImpl implements OperaService {
    @Autowired
    private OperaDetailMapper operaDetailMapper;

    /**
     * 曲谱列表
     * @param param
     * @return
     */
    @Override
    public List<OperaDetail> selOperas(String param) {
       List<OperaDetail> operaDetails= operaDetailMapper.selOperasByauthorOroperaName(param);
        return operaDetails;
    }

    /**
     * 删除
     * @param operaId
     * @return
     */
    @Override
    public int delOpera(Integer operaId) {
        int num=operaDetailMapper.deleteByPrimaryKey(operaId);
        return num;
    }

    /**
     * 曲谱详情
     * @param operaId
     * @return
     */
    @Override
    public OperaDetail selOperaDetail(Integer operaId) {
       OperaDetail operaDetail= operaDetailMapper.selectByPrimaryKey(operaId);
        return operaDetail;
    }

    /**
     * 修改曲谱
     * @param operaDetail
     * @return
     */
    @Override
    public int updateOpera(OperaDetail operaDetail) {
        operaDetail.setCreateTime(new Date());
        int num=operaDetailMapper.updateByPrimaryKeySelective(operaDetail);
        return num;
    }
}
