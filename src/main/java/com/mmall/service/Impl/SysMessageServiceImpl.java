package com.mmall.service.Impl;

import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.dao.SkinTypeMapper;
import com.mmall.dao.SysMessageMapper;
import com.mmall.model.SkinType;
import com.mmall.model.SysMessage;
import com.mmall.service.SkinTypeService;
import com.mmall.service.SysMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SysMessageServiceImpl implements SysMessageService {
    @Autowired
    private LearnbookDetailMapper learnbookDetailMapper;

    @Autowired
    private OperaDetailMapper operaDetailMapper;

    @Autowired
    private SysMessageMapper sysMessageMapper;

    /**
     * 提现详情列表
     *
     * @param param
     * @return
     */
    @Override
    public List<SysMessage> getAllSysMessage(String param,String startTime,String endTime) {
        log.info("消息条件");
        List<SysMessage> WitdrawDetailList = sysMessageMapper.getAllSysMessage(param,startTime,endTime);
        log.info("返回个数=" + WitdrawDetailList.size());
        return WitdrawDetailList;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysMessageMapper.deleteByPrimaryKey(id);
    }



    @Override
    public SysMessage selectByPrimaryKey(Integer id) {
        return sysMessageMapper.selectByPrimaryKey(id);
    }



    @Override
    public int updateByPrimaryKeySelective(SysMessage record) {
        return sysMessageMapper.updateByPrimaryKeySelective(record);
    }



    @Override
    public int insertSelective(SysMessage record) {
        return sysMessageMapper.insertSelective(record);
    }

}
