package com.mmall.dao;

import com.mmall.model.ElecPlayer;
import com.mmall.model.Parents;
import com.mmall.model.ParentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParentsMapper {
    long countByExample(ParentsExample example);

    int deleteByExample(ParentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Parents record);

    int insertSelective(Parents record);

    List<Parents> selectByExample(ParentsExample example);

    Parents selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Parents record, @Param("example") ParentsExample example);

    int updateByExample(@Param("record") Parents record, @Param("example") ParentsExample example);

    int updateByPrimaryKeySelective(Parents record);

    int updateByPrimaryKey(Parents record);

    List<Parents>  selectAll(@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Parents>  selectAllByService(@Param("uid")Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Parents>  selectAllByOrganization(@Param("uid")Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Parents>  selectAllByPianoShop(@Param("uid") Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);

    //查询家长下面的孩子
    List<ElecPlayer> selParentsAndstus(@Param("parentId")Integer parentId);
}