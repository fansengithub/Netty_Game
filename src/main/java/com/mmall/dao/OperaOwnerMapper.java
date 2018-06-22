package com.mmall.dao;

import com.mmall.model.OperaOwner;
import com.mmall.model.OperaOwnerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperaOwnerMapper {
    long countByExample(OperaOwnerExample example);

    int deleteByExample(OperaOwnerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperaOwner record);

    int insertSelective(OperaOwner record);

    List<OperaOwner> selectByExample(OperaOwnerExample example);

    OperaOwner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperaOwner record, @Param("example") OperaOwnerExample example);

    int updateByExample(@Param("record") OperaOwner record, @Param("example") OperaOwnerExample example);

    int updateByPrimaryKeySelective(OperaOwner record);

    int updateByPrimaryKey(OperaOwner record);
    /**
     * 通过ownerId查询
     * @param userId
     * @return
     */
    List<OperaOwner> getAllByUserId(@Param("userId") Integer userId);

    List<OperaOwner> selectByClassifyIdAndUserId(@Param("classfyId") Integer classfyId,@Param("userId") Integer userId);

    List<OperaOwner> getAllByClassifyId(@Param("classfyId") Integer classfyId);

    /**
     * 现在只是显示第一条数据   后续需要和owner_id 联合查询
     * @param operaId
     * @return
     */
    OperaOwner  selectByOperaId(@Param("operaId")Integer operaId);

}