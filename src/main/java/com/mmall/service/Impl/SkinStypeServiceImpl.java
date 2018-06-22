package com.mmall.service.Impl;

import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.dao.SkinStyleMapper;
import com.mmall.dao.SkinTypeMapper;
import com.mmall.model.SkinStyle;
import com.mmall.model.SkinType;
import com.mmall.service.SkinStyleService;
import com.mmall.service.SkinTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SkinStypeServiceImpl implements SkinStyleService {
    @Autowired
    private LearnbookDetailMapper learnbookDetailMapper;

    @Autowired
    private OperaDetailMapper operaDetailMapper;

    @Autowired
    private SkinStyleMapper skinStyleMapper;

    /**
     * 提现详情列表
     *
     * @param param
     * @return
     */
    @Override
    public List<SkinStyle> getAllSkinStyle(String param) {
        log.info("体现条件");
        List<SkinStyle> WitdrawDetailList = skinStyleMapper.getAllSkinStyle(param);
        log.info("返回个数=" + WitdrawDetailList.size());
        return WitdrawDetailList;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return skinStyleMapper.deleteByPrimaryKey(id);
    }



    @Override
    public SkinStyle selectByPrimaryKey(Integer id) {
        return skinStyleMapper.selectByPrimaryKey(id);
    }



    @Override
    public int updateByPrimaryKeySelective(SkinStyle record) {
        return skinStyleMapper.updateByPrimaryKeySelective(record);
    }



    @Override
    public int insertSelective(SkinStyle record) {
        return skinStyleMapper.insertSelective(record);
    }

}
