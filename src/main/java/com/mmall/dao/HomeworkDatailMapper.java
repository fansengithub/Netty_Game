package com.mmall.dao;

import com.mmall.model.HomeworkDatail;
import com.mmall.model.HomeworkDatailExample;
import com.mmall.model.RechargeDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeworkDatailMapper {
    long countByExample(HomeworkDatailExample example);

    int deleteByExample(HomeworkDatailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HomeworkDatail record);

    int insertSelective(HomeworkDatail record);

    List<HomeworkDatail> selectByExample(HomeworkDatailExample example);

    HomeworkDatail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HomeworkDatail record, @Param("example") HomeworkDatailExample example);

    int updateByExample(@Param("record") HomeworkDatail record, @Param("example") HomeworkDatailExample example);

    int updateByPrimaryKeySelective(HomeworkDatail record);

    int updateByPrimaryKey(HomeworkDatail record);

    List<HomeworkDatail>  selectAll(@Param("param") String param);
    List<HomeworkDatail>  selectAllByService(@Param("uid")Integer uid,@Param("param") String param);
    List<HomeworkDatail>  selectAllByOrganization(@Param("uid")Integer uid,@Param("param") String param);
    List<HomeworkDatail>  selectAllByPianoShop(@Param("uid")Integer uid,@Param("param") String param);
    //获取用户所有作业
    List<HomeworkDatail> getHomeworkByUid(@Param("uid")Integer uid);

    //获取全部作业
    List<HomeworkDatail> getAllHomeWork();

    //家长获取孩子的全部作业
    List<HomeworkDatail> getAllHomeWorkByPid(@Param("pid")Integer pid);

    //老师获下属所有学生的作业
    List<HomeworkDatail> getAllHomeWorkByTid(@Param("tid")Integer tid);
}