package com.mmall.service.Impl;

import com.mmall.dao.PlayerOperaMapper;
import com.mmall.model.PlayerOpera;
import com.mmall.model.PlayerOperaExample;
import com.mmall.service.PlayerOperaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 玩家-曲谱
 */
@Slf4j
@Service
public class PlayerOperaServiceImpl implements PlayerOperaService{

    @Autowired
    private PlayerOperaMapper playerOperaMapper;

    @Override
    public List<PlayerOpera> getOperaByOid(Integer oid) {
        PlayerOperaExample playerOperaExample=new PlayerOperaExample();
        PlayerOperaExample.Criteria criteria=playerOperaExample.createCriteria();
        criteria.andOperaIdEqualTo(oid);
        List<PlayerOpera> playerOperas=playerOperaMapper.selectByExample(playerOperaExample);
        return playerOperas;
    }
}
