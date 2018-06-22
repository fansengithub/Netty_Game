package com.mmall.service.Impl;

import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.dao.SkinTypeMapper;
import com.mmall.model.SkinType;
import com.mmall.service.SkinTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SkinTypeServiceImpl implements SkinTypeService {
    @Autowired
    private LearnbookDetailMapper learnbookDetailMapper;

    @Autowired
    private OperaDetailMapper operaDetailMapper;

    @Autowired
    private SkinTypeMapper skinTypeMapper;

    /**
     * 提现详情列表
     *
     * @param param
     * @return
     */
    @Override
    public List<SkinType> getAllSkinType(String param) {
        log.info("体现条件");
        List<SkinType> WitdrawDetailList = skinTypeMapper.getAllSkinType(param);
        log.info("返回个数=" + WitdrawDetailList.size());
        return WitdrawDetailList;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return skinTypeMapper.deleteByPrimaryKey(id);
    }



    @Override
    public SkinType selectByPrimaryKey(Integer id) {
        return skinTypeMapper.selectByPrimaryKey(id);
    }



    @Override
    public int updateByPrimaryKeySelective(SkinType record) {
        return skinTypeMapper.updateByPrimaryKeySelective(record);
    }



    @Override
    public int insertSelective(SkinType record) {
        return skinTypeMapper.insertSelective(record);
    }

}
