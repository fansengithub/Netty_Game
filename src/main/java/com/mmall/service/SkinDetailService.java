package com.mmall.service;

import com.mmall.model.SkinDetail;
import com.mmall.model.SkinStyle;

import java.util.List;

public interface SkinDetailService {


       int deleteByPrimaryKey(Integer id);
       SkinDetail selectByPrimaryKey(Integer id);

       int updateByPrimaryKeySelective(SkinDetail record);
       int insertSelective(SkinDetail record);

       List<SkinDetail> getAllSkinDetail(String param,String startTime,String endTime);
}
