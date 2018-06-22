package com.mmall.dao;

import com.mmall.model.CommentParentTeacher;
import com.mmall.model.CommentParentTeacherExample;
import com.mmall.model.CommentTeacToStu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentParentTeacherMapper {
    long countByExample(CommentParentTeacherExample example);

    int deleteByExample(CommentParentTeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentParentTeacher record);

    int insertSelective(CommentParentTeacher record);

    List<CommentParentTeacher> selectByExample(CommentParentTeacherExample example);

    CommentParentTeacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentParentTeacher record, @Param("example") CommentParentTeacherExample example);

    int updateByExample(@Param("record") CommentParentTeacher record, @Param("example") CommentParentTeacherExample example);

    int updateByPrimaryKeySelective(CommentParentTeacher record);

    int updateByPrimaryKey(CommentParentTeacher record);

    List<CommentParentTeacher>  selectAll(@Param("param") String param);
    List<CommentParentTeacher>  selectAllByService(@Param("uid")Integer uid,@Param("param") String param);
    List<CommentParentTeacher>  selectAllByOrganization(@Param("uid")Integer uid,@Param("param") String param);
    List<CommentParentTeacher>  selectAllByPianoShop(@Param("uid")Integer uid,@Param("param") String param);
   //deleteByStudentId
   int deleteByStudentId(Integer id);

   //获取所有寄语
   List<CommentParentTeacher> getAllWishesBysid(@Param("sid")Integer sid);

   List<CommentParentTeacher> selectByTeacherIdAndStudentId(@Param("teacherId")Integer teacherId, @Param("studentId") Integer studentId);

    List<CommentParentTeacher> selectByParentIdAndStudentId(@Param("parentId")Integer parentId, @Param("studentId") Integer studentId);

    List<CommentParentTeacher> selectByParentIdAndTeacherId(@Param("parentId")Integer parentId,@Param("teacherId")Integer teacherId);

    List<CommentParentTeacher> selectByParentId(@Param("parentId")Integer parentId);

    List<CommentParentTeacher> selectByTeacherId(@Param("teacherId")Integer teacherId);



}