package com.mmall.service;

import com.mmall.model.LearnbookStyle;

import java.util.List;

public interface StyleService {

    public List<LearnbookStyle> selAllStyle();

    public int addStyle(LearnbookStyle learnbookStyle);

    int delStyle(int sid);

    int updateStype(LearnbookStyle learnbookStyle);
}
