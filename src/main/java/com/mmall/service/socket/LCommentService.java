package com.mmall.service.socket;


import com.mmall.dao.*;
import com.mmall.model.*;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service("l")
public class LCommentService {
    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private CommentParentTeacherMapper commentParentTeacherMapper;
    @Autowired
    private CommentTeacToStuMapper commentTeacToStuMapper;
    @Autowired
    private HomeworkDatailMapper homeworkDatailMapper;
    @Autowired
    private CommentMapper commentMapper;

    //发送寄语
    public Map<String, Object> sendMessage(final ChannelHandlerContext ctx, String id, String message) {
        try {
            log.info("孩子ID" + id + "寄语内容" + message);
            Map<String, Object> result = new HashMap<String, Object>();
            //学生获得家长的id
            Students students = studentsMapper.selectByPrimaryKey(Integer.parseInt(id));
            //学生获得老师ID ,再获得琴行名
            Teacher teacher = teacherMapper.selectByPrimaryKey(students.getTeacherId());
            //获得琴行名称

            log.info("家长id为=" + students.getParentId() + "老师id为=" + students.getTeacherId());
            CommentParentTeacher commentParentTeacher = new CommentParentTeacher();
            commentParentTeacher.setPianoShop(teacher.getBelongtoPianoShop());
            commentParentTeacher.setParentsId(students.getParentId());
            commentParentTeacher.setParents(students.getParentName());
            commentParentTeacher.setStudentId(students.getId());
            commentParentTeacher.setStudent(students.getStundentName());
            commentParentTeacher.setTeacherId(students.getTeacherId());
            commentParentTeacher.setTeacher(students.getTeacherName());
            commentParentTeacher.setComment(message);
            commentParentTeacher.setCommentTime(new Date());
            int num = commentParentTeacherMapper.insertSelective(commentParentTeacher);
            if (num > 0) {
                result.put("success", "1");
                result.put("message", "发生成功");
            } else {
                result.put("success", "0");
                result.put("message", "发生失败");
            }
            return result;
        } catch (Exception e) {
            Map<String, Object> err = new HashMap<String, Object>();
            err.put("success", "0");
            err.put("message", "系统异常");
            return err;
        }
    }

    //一键发送寄语
    public Map<String, Object> sendMessageAll(final ChannelHandlerContext ctx, String id, String message) {
        try {
            String[] arrayid = id.split("\\|");
            Map<String, Object> result = new HashMap<String, Object>();
            log.info(id + "孩子ID数组为" + Arrays.toString(arrayid) + "寄语内容" + message);
            for (int i = 0; i < arrayid.length; i += 1) {
                System.out.println("学生的id为=" + arrayid[i]);
                //学生获得家长的id
                Students students = studentsMapper.selectByPrimaryKey(Integer.parseInt(arrayid[i]));
                //学生获得老师ID ,再获得琴行名
                Teacher teacher = teacherMapper.selectByPrimaryKey(students.getTeacherId());
                //获得琴行名称

                log.info("家长id为=" + students.getParentId() + "老师id为=" + students.getTeacherId());
                CommentParentTeacher commentParentTeacher = new CommentParentTeacher();
                commentParentTeacher.setPianoShop(teacher.getBelongtoPianoShop());
                commentParentTeacher.setParents(students.getParentName());
                commentParentTeacher.setStudent(students.getStundentName());
                commentParentTeacher.setTeacher(students.getTeacherName());
                commentParentTeacher.setComment(message);
                commentParentTeacher.setCommentTime(new Date());
                int num = commentParentTeacherMapper.insertSelective(commentParentTeacher);
                if (num == 0) {
                    result.put("success", "0");
                    result.put("message", "发生失败");
                    return result;
                }
            }
            result.put("success", "1");
            result.put("message", "发生成功");
            return result;
        } catch (Exception e) {
            Map<String, Object> err = new HashMap<String, Object>();
            err.put("success", "0");
            err.put("message", "系统异常");
            return err;
        }
    }
    //删除寄语
    public Map<String,Object> deleteMessage(final ChannelHandlerContext ctx,String id){
        try{
            log.info("孩子iD"+"寄语id"+id);
            Map<String,Object> result = new HashMap<>();
            int num=commentParentTeacherMapper.deleteByPrimaryKey(Integer.parseInt(id));
            if(num==0){
                result.put("success", "0");
                result.put("message", "删除失败");
                return result;
            }
            result.put("success", "1");
            result.put("message", "删除成功");
            return result;
        }catch (Exception e){
            Map<String,Object> err = new HashMap<>();
            err.put("success","0");
            err.put("message","系统异常");
            return err;
        }
    }

    //评论某人
    public Map<String, Object> evaluate(final ChannelHandlerContext ctx, String studentId,String xiji, String comment,String message) {
        try {
            log.info("孩子ID" + studentId +"星级"+xiji+ "简评内容" + comment+"详细评论"+message);
            Map<String, Object> result = new HashMap<String, Object>();
            //学生获得家长的id
            Students students = studentsMapper.selectByPrimaryKey(Integer.parseInt(studentId));
            //学生获得老师ID ,再获得琴行名
            Teacher teacher = teacherMapper.selectByPrimaryKey(students.getTeacherId());
            //获得琴行名称

            log.info("家长id为=" + students.getParentId() + "老师id为=" + students.getTeacherId());
            CommentTeacToStu commentParentTeacher = new CommentTeacToStu();
            commentParentTeacher.setPianoShop(teacher.getBelongtoPianoShop());
            commentParentTeacher.setParentId(students.getParentId());
            commentParentTeacher.setParent(students.getParentName());
            commentParentTeacher.setStudentId(students.getId());
            commentParentTeacher.setStudent(students.getStundentName());
            commentParentTeacher.setTeacherId(students.getTeacherId());
            commentParentTeacher.setTeacher(students.getTeacherName());
            //简评内容
            if (comment.equals("")){
//          当comment内容为空时
                commentParentTeacher.setComment(comment);
            }else {
//                将 comment表中  ##|##|##  转化为对应id  1|2|3
                String successComment = "";
                String[] aimComment = comment.split("\\|");
                for (String aim : aimComment){
                    List<Comment> commentList = commentMapper.getComments();
                    for (Comment comment1 : commentList){
                        if (comment1.getContent().equals(aim)){
                            successComment=successComment+comment1.getId()+"|";
                            break;
                        }
                    }
                }

                commentParentTeacher.setComment(successComment);
            }
//            String[] aimComment = commentMapper
//            commentParentTeacher.setComment(comment);
            //星级
            commentParentTeacher.setStartLevel(Integer.parseInt(xiji));
            //评论细节
            commentParentTeacher.setCommentDetail(message);
            commentParentTeacher.setCommentTime(new Date());
            int num = commentTeacToStuMapper.insertSelective(commentParentTeacher);
            if (num > 0) {
                result.put("success", "1");
                result.put("message", "评论成功");
            } else {
                result.put("success", "0");
                result.put("message", "评论失败");
            }
            return result;
        } catch (Exception e) {
            Map<String, Object> err = new HashMap<String, Object>();
            err.put("success", "0");
            err.put("message", "系统异常");
            return err;
        }
    }
    //一键评论
    public Map<String, Object> evaluateAll(final ChannelHandlerContext ctx, String studentIdArray,String xiji, String comment,String message) {
        try {
            String[] arrayid = studentIdArray.split("\\|");
            Map<String, Object> result = new HashMap<String, Object>();
            log.info("孩子数组ID" + studentIdArray +"星级"+xiji+ "简评内容" + comment+"详细评论"+message);
            for (int i = 0; i < arrayid.length; i += 1) {
                System.out.println("学生的id为=" + arrayid[i]);
                //学生获得家长的id
                Students students = studentsMapper.selectByPrimaryKey(Integer.parseInt(arrayid[i]));
                //学生获得老师ID ,再获得琴行名
                Teacher teacher = teacherMapper.selectByPrimaryKey(students.getTeacherId());
                //获得琴行名称

                log.info("家长id为=" + students.getParentId() + "老师id为=" + students.getTeacherId());
                CommentTeacToStu commentParentTeacher = new CommentTeacToStu();
                commentParentTeacher.setPianoShop(teacher.getBelongtoPianoShop());
                commentParentTeacher.setParentId(students.getParentId());
                commentParentTeacher.setParent(students.getParentName());
                commentParentTeacher.setStudentId(students.getId());
                commentParentTeacher.setStudent(students.getStundentName());
                commentParentTeacher.setTeacherId(students.getTeacherId());
                commentParentTeacher.setTeacher(students.getTeacherName());
                //简评内容
                commentParentTeacher.setComment(comment);
                //星级
                commentParentTeacher.setStartLevel(Integer.parseInt(xiji));
                //评论细节
                commentParentTeacher.setCommentDetail(message);
                commentParentTeacher.setCommentTime(new Date());
                int num = commentTeacToStuMapper.insertSelective(commentParentTeacher);
                if (num == 0) {
                    result.put("success", "0");
                    result.put("message", "发生失败");
                    return result;
                }
            }
            result.put("success", "1");
            result.put("message", "发生成功");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> err = new HashMap<String, Object>();
            err.put("success", "0");
            err.put("message", "系统异常");
            return err;
        }
    }

    //删除评论
    public Map<String,Object> deleteEvaluate(final ChannelHandlerContext ctx,String id){
        try{
            log.info("孩子iD"+"评论id"+id);
            Map<String,Object> result = new HashMap<>();
            int num=commentTeacToStuMapper.deleteByPrimaryKey(Integer.parseInt(id));
            if(num==0){
                result.put("success", "0");
                result.put("message", "删除失败");
                return result;
            }
            result.put("success", "1");
            result.put("message", "删除成功");
            return result;
        }catch (Exception e){
            Map<String,Object> err = new HashMap<>();
            err.put("success","0");
            err.put("message","系统异常");
            return err;
        }
    }
    //删除作业
    public Map<String,Object> deleteHomework(final ChannelHandlerContext ctx,String id){
        try{
            log.info("孩子iD"+"作业id"+id);
            Map<String,Object> result = new HashMap<>();
            int num=homeworkDatailMapper.deleteByPrimaryKey(Integer.parseInt(id));
            if(num==0){
                result.put("success", "0");
                result.put("message", "删除失败");
                return result;
            }
            result.put("success", "1");
            result.put("message", "删除成功");
            return result;
        }catch (Exception e){
            Map<String,Object> err = new HashMap<>();
            err.put("success","0");
            err.put("message","系统异常");
            return err;
        }
    }
}
