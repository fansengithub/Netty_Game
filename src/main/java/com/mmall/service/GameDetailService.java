package com.mmall.service;

import com.mmall.model.GameDetail;
import com.mmall.model.SkinDetail;

import java.util.List;

public interface GameDetailService {


       int deleteByPrimaryKey(Integer id);
       GameDetail selectByPrimaryKey(Integer id);

       int updateByPrimaryKeySelective(GameDetail record);
       int insertSelective(GameDetail record);

       List<GameDetail> getAllGameDetail(String param, String startTime, String endTime);
}
