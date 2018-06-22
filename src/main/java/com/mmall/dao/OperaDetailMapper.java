package com.mmall.dao;

import com.mmall.dto.OperaDiffcultyDto;
import com.mmall.dto.OperaDto;
import com.mmall.model.OperaDetail;
import com.mmall.model.OperaDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

public interface OperaDetailMapper {
    long countByExample(OperaDetailExample example);

    int deleteByExample(OperaDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperaDetail record);

    int insertSelective(OperaDetail record);

    List<OperaDetail> selectByExample(OperaDetailExample example);

    OperaDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperaDetail record, @Param("example") OperaDetailExample example);

    int updateByExample(@Param("record") OperaDetail record, @Param("example") OperaDetailExample example);

    int updateByPrimaryKeySelective(OperaDetail record);

    int updateByPrimaryKey(OperaDetail record);

    //查询曲谱列表
    List<OperaDetail> selOperasByauthorOroperaName(@Param("param")String param);

    //查询所有未指定教材的曲谱
    List<OperaDetail> getNoLearnOpera();

    List<OperaDetail> selectByStartAndSize(@Param("start")Integer start,@Param("size")Integer size);

    int  getCount();

    OperaDetail selectByPrimaryKeyAndDifficulty(@Param("id") Integer id,@Param("difficulty")Integer difficulty);

    List<OperaDetail> selectByLearnbookId(@Param("learnbookId")Integer learnbookId);

    List<OperaDetail> getAllOpera();

    //查询用户已购买的指定难度曲谱
    List<OperaDetail> getOperaByUidAndDiffculty(@Param("uid")Integer uid,@Param("difficulty")String difficulty);

    //模糊查询某个难度下的曲谱
    List<OperaDiffcultyDto> getOperaByDiffculty(@Param("param")String param, @Param("difficulty")String difficulty, @Param("uid")Integer uid);

}