package com.mmall.service.Impl;

import com.mmall.dao.LearnbookStageMapper;
import com.mmall.model.LearnbookStage;
import com.mmall.service.StageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class StageServiceImpl implements StageService {
    @Autowired
    private LearnbookStageMapper learnbookStageMapper;

    @Override
    public List<LearnbookStage> selAllStage() {
        List<LearnbookStage> learnbookStages=learnbookStageMapper.selAllStage();

        return learnbookStages;
    }

    @Override
    public int addStage(LearnbookStage learnbookStage) {

        return learnbookStageMapper.insertSelective(learnbookStage);
    }

    @Override
    public int delStage(Integer sid) {

        return learnbookStageMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public int updateStage(LearnbookStage learnbookStage) {
        return learnbookStageMapper.updateByPrimaryKeySelective(learnbookStage);
    }
}
