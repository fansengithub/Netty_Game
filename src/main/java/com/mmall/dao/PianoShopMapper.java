package com.mmall.dao;

import com.mmall.model.PianoShop;
import com.mmall.model.PianoShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PianoShopMapper {
    long countByExample(PianoShopExample example);

    int deleteByExample(PianoShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PianoShop record);

    int insertSelective(PianoShop record);

    List<PianoShop> selectByExample(PianoShopExample example);

    PianoShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PianoShop record, @Param("example") PianoShopExample example);

    int updateByExample(@Param("record") PianoShop record, @Param("example") PianoShopExample example);

    int updateByPrimaryKeySelective(PianoShop record);

    int updateByPrimaryKey(PianoShop record);

    List<PianoShop>  selectAll(@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    // <!--查询所有锁定的琴行-->
    List<PianoShop>  selectAllState(@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<PianoShop> selectAllNotUser(@Param("orginazeID") Integer id);
    List<PianoShop> selectAllByService(@Param("uid") Integer id,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<PianoShop> selectAllByOrganization(@Param("uid") Integer id,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
}