package com.mmall.service;

import com.mmall.model.LearnbookStage;

import java.util.List;

/**
 * 阶段管理
 */
public interface StageService {

    public List<LearnbookStage> selAllStage();

    public int addStage(LearnbookStage learnbookStage);

    public int delStage(Integer sid);

    public int updateStage(LearnbookStage learnbookStage);

}
