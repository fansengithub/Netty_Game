package com.mmall.service.Impl;

import com.mmall.dao.LearnbookStyleMapper;
import com.mmall.model.LearnbookStyle;
import com.mmall.service.StyleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 风格管理
 */
@Service
@Slf4j
public class StyleServiceImpl implements StyleService{
    @Autowired
    private LearnbookStyleMapper learnbookStyleMapper;

    @Override
    public List<LearnbookStyle> selAllStyle() {
        List<LearnbookStyle> learnbookStyles=learnbookStyleMapper.selAllStyle();
        return learnbookStyles;
    }

    @Override
    public int addStyle(LearnbookStyle learnbookStyle) {
        return learnbookStyleMapper.insert(learnbookStyle);
    }

    @Override
    public int delStyle(int sid) {
        return learnbookStyleMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public int updateStype(LearnbookStyle learnbookStyle) {
        return learnbookStyleMapper.updateByPrimaryKeySelective(learnbookStyle);
    }
}
