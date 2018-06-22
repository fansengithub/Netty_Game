package com.mmall.service;

import com.mmall.model.PlayerOpera;

import java.util.List;

/**
 * 玩家-曲谱
 */
public interface PlayerOperaService {

    //通过曲谱id查询是否有玩家使用
    public List<PlayerOpera> getOperaByOid(Integer oid);
}
