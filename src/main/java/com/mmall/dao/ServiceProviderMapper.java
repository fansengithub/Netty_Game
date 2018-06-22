package com.mmall.dao;

import com.mmall.model.ServiceProvider;
import com.mmall.model.ServiceProviderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceProviderMapper {
    long countByExample(ServiceProviderExample example);

    int deleteByExample(ServiceProviderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceProvider record);

    int insertSelective(ServiceProvider record);

    List<ServiceProvider> selectByExample(ServiceProviderExample example);

    ServiceProvider selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceProvider record, @Param("example") ServiceProviderExample example);

    int updateByExample(@Param("record") ServiceProvider record, @Param("example") ServiceProviderExample example);

    int updateByPrimaryKeySelective(ServiceProvider record);

    int updateByPrimaryKey(ServiceProvider record);


    List<ServiceProvider>  selectAll(@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    ServiceProvider  getServiceProviderByZnArea(@Param("param")String param);
    List<ServiceProvider>  getServiceProviderByZnAreaLike(@Param("param")String param);
    Long selectIsNotPhone(@Param("telephone") String phone);
}