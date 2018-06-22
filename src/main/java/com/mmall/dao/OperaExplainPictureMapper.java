package com.mmall.dao;

import com.mmall.model.OperaExplainPicture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperaExplainPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperaExplainPicture record);

    int insertSelective(OperaExplainPicture record);

    OperaExplainPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperaExplainPicture record);

    int updateByPrimaryKey(OperaExplainPicture record);

    List<OperaExplainPicture> selectByOperaId(@Param("operaId")Integer operaId);

}