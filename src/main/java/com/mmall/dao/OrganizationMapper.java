package com.mmall.dao;

import com.mmall.model.Organization;
import com.mmall.model.OrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {
    long countByExample(OrganizationExample example);

    int deleteByExample(OrganizationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    List<Organization> selectAll(@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Organization> selectAllByService(@Param("uid")Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Organization> selectAllByOrganization(@Param("uid")Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);

    Long selectIsNotPhone(@Param("telephone") String phone);
}