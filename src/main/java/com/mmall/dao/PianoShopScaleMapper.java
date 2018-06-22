package com.mmall.dao;

import com.mmall.model.PianoShopScale;
import com.mmall.model.PianoShopScaleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PianoShopScaleMapper {
    long countByExample(PianoShopScaleExample example);

    int deleteByExample(PianoShopScaleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PianoShopScale record);

    int insertSelective(PianoShopScale record);

    List<PianoShopScale> selectByExample(PianoShopScaleExample example);

    PianoShopScale selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PianoShopScale record, @Param("example") PianoShopScaleExample example);

    int updateByExample(@Param("record") PianoShopScale record, @Param("example") PianoShopScaleExample example);

    int updateByPrimaryKeySelective(PianoShopScale record);

    int updateByPrimaryKey(PianoShopScale record);

    List<PianoShopScale> selectAll();

    List<PianoShopScale> selectByParam(@Param("param")String param);

}