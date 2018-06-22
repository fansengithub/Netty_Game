package com.mmall.dao;

import com.mmall.model.OperaPrice;
import com.mmall.model.OperaPriceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperaPriceMapper {
    long countByExample(OperaPriceExample example);

    int deleteByExample(OperaPriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperaPrice record);

    int insertSelective(OperaPrice record);

    List<OperaPrice> selectByExample(OperaPriceExample example);

    OperaPrice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperaPrice record, @Param("example") OperaPriceExample example);

    int updateByExample(@Param("record") OperaPrice record, @Param("example") OperaPriceExample example);

    int updateByPrimaryKeySelective(OperaPrice record);

    int updateByPrimaryKey(OperaPrice record);

    int deleteByOperaId(@Param("operaId")Integer operaId);

    List<OperaPrice> selectByOperaId(@Param("operaId")Integer operaId);

    List<OperaPrice> selectSpecialByOperaId(@Param("operaId")Integer operaId);

    List<OperaPrice> selectByOperaIdAndIsSpecial(@Param("operaId")Integer operaId,@Param("isSpecial")Integer isSpecial);

    OperaPrice  selectIsFree(@Param("operaId")Integer operaId);

}