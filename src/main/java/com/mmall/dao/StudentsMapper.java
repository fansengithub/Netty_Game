package com.mmall.dao;

import com.mmall.model.Parents;
import com.mmall.model.Students;
import com.mmall.model.StudentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentsMapper {
    long countByExample(StudentsExample example);

    int deleteByExample(StudentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Students record);

    int insertSelective(Students record);

    List<Students> selectByExample(StudentsExample example);

    Students selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Students record, @Param("example") StudentsExample example);

    int updateByExample(@Param("record") Students record, @Param("example") StudentsExample example);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    List<Students>  selectAll(@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Students>  selectAllByService(@Param("uid")Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Students>  selectAllByOrganization(@Param("uid")Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    List<Students>  selectAllByPianoShop(@Param("uid") Integer uid,@Param("param")String param,@Param("startTime")String startTime,@Param("endTime")String endTime);
    //通过家长id查询下面的孩子
    List<Students> getStuNameByPid(@Param("pid")Integer pid);

    //老师下的学生个数getStuCountByTid
    int getStuCountByTid(@Param("tid")Integer tid);
}