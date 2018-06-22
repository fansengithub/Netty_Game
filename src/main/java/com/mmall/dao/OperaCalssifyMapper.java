package com.mmall.dao;

import com.mmall.model.OperaCalssify;
import com.mmall.model.OperaCalssifyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperaCalssifyMapper {
    long countByExample(OperaCalssifyExample example);

    int deleteByExample(OperaCalssifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperaCalssify record);

    int insertSelective(OperaCalssify record);

    List<OperaCalssify> selectByExample(OperaCalssifyExample example);

    OperaCalssify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperaCalssify record, @Param("example") OperaCalssifyExample example);

    int updateByExample(@Param("record") OperaCalssify record, @Param("example") OperaCalssifyExample example);

    int updateByPrimaryKeySelective(OperaCalssify record);

    int updateByPrimaryKey(OperaCalssify record);

    Integer getCountByClassifyName(@Param("name") String  name);

    OperaCalssify selectByClassifyName(@Param("name") String  name);

//    获取所有未被删除的分类
    List<OperaCalssify>  getAllRecordAvailable();
}