package com.mmall.dao;

import com.mmall.model.CommentTeacToStu;
import com.mmall.model.CommentTeacToStuExample;
import com.mmall.model.HomeworkDatail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentTeacToStuMapper {
    long countByExample(CommentTeacToStuExample example);

    int deleteByExample(CommentTeacToStuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentTeacToStu record);

    int insertSelective(CommentTeacToStu record);

    List<CommentTeacToStu> selectByExample(CommentTeacToStuExample example);

    CommentTeacToStu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentTeacToStu record, @Param("example") CommentTeacToStuExample example);

    int updateByExample(@Param("record") CommentTeacToStu record, @Param("example") CommentTeacToStuExample example);

    int updateByPrimaryKeySelective(CommentTeacToStu record);

    int updateByPrimaryKey(CommentTeacToStu record);

    List<CommentTeacToStu>  selectAll(@Param("param") String param);
    List<CommentTeacToStu>  selectAllByService(@Param("uid")Integer uid,@Param("param") String param);
    List<CommentTeacToStu>  selectAllByOrganization(@Param("uid")Integer uid,@Param("param") String param);
    List<CommentTeacToStu>  selectAllByPianoShop(@Param("uid")Integer uid,@Param("param") String param);

    List<CommentTeacToStu> selectByTeacherIdAndStudentId(@Param("teacherId")Integer teacherId,@Param("studentId") Integer studentId);

    List<CommentTeacToStu> selectByTeacherId(@Param("teacherId")Integer teacherId);

}