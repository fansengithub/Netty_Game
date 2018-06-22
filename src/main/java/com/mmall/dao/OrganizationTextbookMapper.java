package com.mmall.dao;

import com.mmall.model.OrganizationTextbook;
import com.mmall.model.OrganizationTextbookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationTextbookMapper {
    long countByExample(OrganizationTextbookExample example);

    int deleteByExample(OrganizationTextbookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrganizationTextbook record);

    int insertSelective(OrganizationTextbook record);

    List<OrganizationTextbook> selectByExample(OrganizationTextbookExample example);

    OrganizationTextbook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrganizationTextbook record, @Param("example") OrganizationTextbookExample example);

    int updateByExample(@Param("record") OrganizationTextbook record, @Param("example") OrganizationTextbookExample example);

    int updateByPrimaryKeySelective(OrganizationTextbook record);

    int updateByPrimaryKey(OrganizationTextbook record);

    Integer getCountByOrganizationId(@Param("organizationTd") Integer organizationTd);
//    Integer getCountByOperaId(@Param("operaId") Integer operaId);

}