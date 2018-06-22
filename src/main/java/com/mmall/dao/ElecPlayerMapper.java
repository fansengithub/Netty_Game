package com.mmall.dao;

import com.mmall.dto.ScoreTopNum;
import com.mmall.model.ElecPlayer;
import com.mmall.model.ElecPlayerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ElecPlayerMapper {
    int countByExample(ElecPlayerExample example);

    int deleteByExample(ElecPlayerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ElecPlayer record);

    int insertSelective(ElecPlayer record);

    List<ElecPlayer> selectByExample(ElecPlayerExample example);

    ElecPlayer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ElecPlayer record, @Param("example") ElecPlayerExample example);

    int updateByExample(@Param("record") ElecPlayer record, @Param("example") ElecPlayerExample example);

    int updateByPrimaryKeySelective(ElecPlayer record);

    int updateByPrimaryKey(ElecPlayer record);

    //通过手机号查找玩家
    public ElecPlayer selPlayerByPhone(@Param("phone")String phone);

    //通家长id查询学生
    List<ElecPlayer> getStuByPid(@Param("pid")Integer pid);

    //通老师id查询学生
    List<ElecPlayer> getStuByTid(@Param("tid")Integer tid);

    //三方登陆
    ElecPlayer selectByWX(@Param("openId")String openId);//微信

    ElecPlayer selectByQQ(@Param("openId")String openId);//QQ

    ElecPlayer selectByWB(@Param("openId")String openId);//微博

    //积分排行榜
    List<ScoreTopNum> getScoreTopNum(@Param("topNum")Integer topNum);

    ElecPlayer selectAllByPlayeridAndRole(@Param("playerId")Integer playerId,@Param("roleType")Integer roleType);

}