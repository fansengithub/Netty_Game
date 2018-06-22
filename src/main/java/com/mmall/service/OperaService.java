package com.mmall.service;

import com.mmall.model.OperaDetail;

import java.util.List;

public interface OperaService {

    //曲谱列表
    public List<OperaDetail> selOperas(String param);

    //删除曲谱
    public int delOpera(Integer operaId);

    //曲谱详情
    public OperaDetail selOperaDetail(Integer operaId);

    //修改曲谱
    public int updateOpera(OperaDetail operaDetail);
}
