package com.mmall.dao;

import com.mmall.model.Teacher;
import com.mmall.model.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher>  selectAll(@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Teacher>  selectAllByService(@Param("uid")Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Teacher>  selectAllByOrganization(@Param("userId")Integer userId,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Teacher>  selectAllByPianoShop(@Param("uid") Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<Teacher>  selectAllByOrganizationByid(@Param("uid")Integer uid);

    Teacher selectAllMaxId();


    List<Teacher>  selectAllByPianoshop(@Param("userId")Integer userId);
    //查询一个老师的学生
    Teacher gettescherAndStudents(@Param("tid") Integer tid);
    //学生个数
    int SelstudentCount(@Param("teacherId")Integer teacherId);

    Long selectIsNotPhone(@Param("telephone") String phone);   //验证手机号是被注册了

    Teacher  selectAllByPianoshopTongguo(@Param("shopId") Integer shopId);
}