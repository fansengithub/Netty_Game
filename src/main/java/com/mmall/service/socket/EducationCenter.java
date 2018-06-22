package com.mmall.service.socket;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.Object.GameWorld;
import com.mmall.dao.*;
import com.mmall.entity.*;
import com.mmall.model.*;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 教务中心接口
 */
@Slf4j
@Service("e")
public class EducationCenter {
    @Autowired
    private OperaDetailMapper operaDetailMapper;

    @Autowired
    private SongRecordMapper songRecordMapper;
    @Autowired
    private HomeworkDatailMapper homeworkDatailMapper;

    @Autowired
    private ElecPlayerMapper elecPlayerMapper;
    @Autowired
    private BindingApplicationMapper bindingApplicationMapper;
    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    private GameGradeMapper gameGradeMapper;
    @Autowired
    private CommentTeacToStuMapper commentTeacToStuMapper;
    @Autowired
    private CommentMapper commentMapper;


    @Autowired
    private CountRecordMapper countRecordMapper;

    @Autowired
    private CommentParentTeacherMapper commentParentTeacherMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ParentsMapper parentsMapper;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取审核列表  ---  获取当前登录用户的所有审核列表
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getExamineList(final ChannelHandlerContext ctx) {

        Map<String, Object> result = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");

        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
                List<BindingApplication> bindingApplicationList = bindingApplicationMapper.selectByToUserId(userId);
                List<AimApplyBinding> aimApplyBindingList = new ArrayList<>();
                if (bindingApplicationList.size() > 0) {
                    for (BindingApplication temp : bindingApplicationList) {
                        AimApplyBinding aimApplyBinding = new AimApplyBinding();
                        aimApplyBinding.setApplyTime(formatter.format(temp.getCreateTime()));
                        aimApplyBinding.setName(temp.getFromUserName());
                        aimApplyBinding.setSate(temp.getApplyState() + "");
                        aimApplyBinding.setType(temp.getFromUserType() + "");
                        aimApplyBinding.setRequestId(temp.getFromUserId() + "");

                        aimApplyBindingList.add(aimApplyBinding);
                    }
                }
                result.put("aimList", aimApplyBindingList);
            result.put("success", 1);
            result.put("message", "操作成功!");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "操作失败!");
        }
        return result;
    }

    /**
     * 获取绑定列表   --   已经审核通过的列表s
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getAccountList(final ChannelHandlerContext ctx) {

        Map<String, Object> result = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer temp1 = elecPlayerMapper.selectByPrimaryKey(userId);
            if (temp1.getRoleType() == 3) {
//                当前用户登录的身份是老师的时候 ---  查询老师和学生的所有记录
                List<BindingApplication> bindingApplicationList = bindingApplicationMapper.selectByfromUserIdOrToUserId(userId);
                List<AimApplyBinding> aimApplyBindingList = new ArrayList<>();
                if (bindingApplicationList.size() > 0) {
                    for (BindingApplication application : bindingApplicationList) {

                        if (application.getFromUserType() == 0) {
//                            发起申请的角色是老师   ---  目标角色就是学生
                            AimApplyBinding aimApplyBinding = new AimApplyBinding();
                            aimApplyBinding.setName(application.getToUserName());
                            aimApplyBinding.setRequestId(application.getToUserId() + "");
                            aimApplyBinding.setType("2");    //目标是当前用户的学生
                            aimApplyBinding.setHadleTime(formatter.format(application.getHandleTime()));

                            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(application.getToUserId());
                            if (elecPlayer != null) {
//                                关联到ele_player中查询
                                Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                                aimApplyBinding.setRequestUrl(students.getHeadUrl());
                            } else {
                                aimApplyBinding.setRequestUrl("未找到相关联用户头像!");
                            }
                            log.info("当前登录是老师,查找学生!<老师发出的申请!>");
                            aimApplyBindingList.add(aimApplyBinding);
                        } else if (application.getFromUserType() == 2) {
                            //      发起申请的角色是学生   ---  目标角色就是老师
                            AimApplyBinding aimApplyBinding = new AimApplyBinding();
                            aimApplyBinding.setName(application.getFromUserName());
                            aimApplyBinding.setRequestId(application.getFromUserId() + "");
                            aimApplyBinding.setType("2");
                            aimApplyBinding.setHadleTime(formatter.format(application.getHandleTime()));


                            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(application.getFromUserId());
                            if (elecPlayer != null) {
//                                关联到ele_player中查询
                                Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                                aimApplyBinding.setRequestUrl(students.getHeadUrl());
                            } else {
                                aimApplyBinding.setRequestUrl("未找到相关联用户头像!");
                            }
                            log.info("当前登录是老师,查找学生!<学生发出的申请!>");
                            aimApplyBindingList.add(aimApplyBinding);
                        }

                    }
                }
                result.put("aimList", aimApplyBindingList);
            } else if (temp1.getRoleType() == 1) {
//                以学生身份登录     ----  查询相关联家长和老师数据
                List<BindingApplication> bindingApplicationList = bindingApplicationMapper.selectByfromUserIdOrToUserId(userId);
                List<AimApplyBinding> aimApplyBindingList = new ArrayList<>();
                if (bindingApplicationList.size() > 0) {
                    for (BindingApplication application : bindingApplicationList) {

                        if (application.getFromUserType() == 0) {
//                            发起申请的角色是老师   ---  申请的目标角色就是学生
                            AimApplyBinding aimApplyBinding = new AimApplyBinding();
                            aimApplyBinding.setName(application.getFromUserName());
                            aimApplyBinding.setRequestId(application.getFromUserId() + "");
                            aimApplyBinding.setType("0");
                            aimApplyBinding.setHadleTime(formatter.format(application.getHandleTime()));


                            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(application.getFromUserId());
                            if (elecPlayer != null) {
//                                关联到ele_player中查询
                                Teacher teacher = teacherMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                                aimApplyBinding.setRequestUrl(teacher.getHeadUrl());
                            } else {
                                aimApplyBinding.setRequestUrl("未找到相关联用户头像!");
                            }
                            aimApplyBindingList.add(aimApplyBinding);
                            log.info("当前登录是学生,查找老师!<老师发出的申请!>");

                        } else if (application.getFromUserType() == 1) {
//                            发起申请的角色是家长  ---   目标角色就是学生
                            AimApplyBinding aimApplyBinding = new AimApplyBinding();
                            aimApplyBinding.setName(application.getFromUserName());
                            aimApplyBinding.setRequestId(application.getFromUserId() + "");
                            aimApplyBinding.setType("1");
                            aimApplyBinding.setHadleTime(formatter.format(application.getHandleTime()));

                            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(application.getFromUserId());
                            if (elecPlayer != null) {
                                Parents parents = parentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                                aimApplyBinding.setRequestUrl(parents.getHeadUrl());

                            } else {
                                aimApplyBinding.setRequestUrl("未找到相关联用户头像!");
                            }

                            aimApplyBindingList.add(aimApplyBinding);
                            log.info("当前登录是学生,查找家长!<家长发出的申请!>");

                        } else if (application.getFromUserType() == 2) {
//                            发起申请的角色是学生的时候    ---  目标角色可能是老师也可能是家长
                            AimApplyBinding aimApplyBinding = new AimApplyBinding();
                            aimApplyBinding.setName(application.getToUserName());
                            aimApplyBinding.setRequestId(application.getToUserId() + "");
                            aimApplyBinding.setHadleTime(formatter.format(application.getHandleTime()));

                            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(application.getToUserId());
                            if (elecPlayer != null) {
                                if (elecPlayer.getRoleType() == 2) {
//                                    当申请对象是家长的时候
                                    Parents parents = parentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                                    aimApplyBinding.setRequestUrl(parents.getHeadUrl());
                                    aimApplyBinding.setType("1");

                                } else if (elecPlayer.getRoleType() == 3) {
//                                    当申请对象是老师的时候
                                    Teacher teacher = teacherMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                                    aimApplyBinding.setRequestUrl(teacher.getHeadUrl());
                                    aimApplyBinding.setType("0");
                                }
                            }
                            aimApplyBindingList.add(aimApplyBinding);
                            log.info("当前登录是学生,查找家长或者老师!  ----- <家长或老师发出的申请!>");
                        }

                    }

                }
                result.put("aimList", aimApplyBindingList);

            } else if (temp1.getRoleType() == 2) {
//                以家长身份登录       ---  查询关联学生数据
                List<BindingApplication> bindingApplicationList = bindingApplicationMapper.selectByfromUserIdOrToUserId(userId);
                List<AimApplyBinding> aimApplyBindingList = new ArrayList<>();
                if (bindingApplicationList.size() > 0) {
                    for (BindingApplication application : bindingApplicationList) {

                        if (application.getFromUserType() == 1) {
//                            发起申请的角色是家长   ---  目标角色就是学生
                            AimApplyBinding aimApplyBinding = new AimApplyBinding();
                            aimApplyBinding.setName(application.getToUserName());
                            aimApplyBinding.setRequestId(application.getToUserId() + "");
                            aimApplyBinding.setType("3");
                            aimApplyBinding.setHadleTime(formatter.format(application.getHandleTime()));

                            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(application.getToUserId());
                            if (elecPlayer != null) {
//                                关联到ele_player中查询
                                Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                                aimApplyBinding.setRequestUrl(students.getHeadUrl());
                            } else {
                                aimApplyBinding.setRequestUrl("未找到相关联用户头像!");
                            }

                            aimApplyBindingList.add(aimApplyBinding);
                            log.info("当前登录是家长,查找学生!  ----- <家长发出的申请!>");

                        }else  if (application.getFromUserType() == 2){
//                            当发起申请的角色是学生   ----
                            AimApplyBinding aimApplyBinding = new AimApplyBinding();
                            aimApplyBinding.setName(application.getFromUserName());
                            aimApplyBinding.setRequestId(application.getFromUserId() + "");
                            aimApplyBinding.setType("3");
                            aimApplyBinding.setHadleTime(formatter.format(application.getHandleTime()));

                            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(application.getFromUserId());
                            if (elecPlayer != null) {
//                                关联到ele_player中查询
                                Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                                aimApplyBinding.setRequestUrl(students.getHeadUrl());
                            } else {
                                aimApplyBinding.setRequestUrl("未找到相关联用户头像!");
                            }
                            aimApplyBindingList.add(aimApplyBinding);
                            log.info("当前登录是家长,查找学生!  ----- <学生发出的申请!>");
                        }
                    }
                }

                result.put("aimList", aimApplyBindingList);
            }
            result.put("success", 1);
            result.put("message", "操作成功!");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "操作失败!");
        }
        return result;
    }

    /**
     * 回应请求
     *
     * @param ctx
     * @param requesterId 请求者id
     * @param response    回应信息   0 --  同意请求    1-- 拒绝请求
     * @return
     */
    public Map<String, Object> responseExamine(final ChannelHandlerContext ctx, String requesterId, String response) {
        Map<String, Object> result = new HashMap<>();
        try {
            //首先进行校验判断,数据库中是否已经存在和当前用户有关的绑定关系  -- 老师和老师角色

            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId---" + userId);
            ElecPlayer elecPlayer1 = elecPlayerMapper.selectByPrimaryKey(userId);

            if (elecPlayer1.getRoleType() == 3){
//                当前登录用户身份是老师    --   判断该学生与别的老师是否存在绑定关系
                    List<BindingApplication> bindingApplicationList =  bindingApplicationMapper.selectByfromUserIdOrToUserId(Integer.parseInt(requesterId));
                    for (BindingApplication bindingApplication : bindingApplicationList){
                        if (bindingApplication.getFromUserType() == 0){
//                            当是老师发起的申请
                            result.put("success", 0);
                            result.put("message", "已经与老师存在绑定关系!");
                            return  result;

                        }else if (bindingApplication.getFromUserType() == 1){
                            //                            当是家长发起的申请 -- 直接跳过
                            continue;
                        }else if (bindingApplication.getFromUserType() == 2){
                            //                            当是学生发起的申请  --- 查找对应实体
                            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(bindingApplication.getToUserId());
                            if (elecPlayer != null){
                                if (elecPlayer.getRoleType() == 3){
//                                    对应实体是老师的时候
                                    result.put("success", 0);
                                    result.put("message", "已经与老师存在绑定关系!");
                                    return  result;

                                }
                            }
                        }
                    }

            }else  if(elecPlayer1.getRoleType() == 2){
//                当前登录用户是家长  --   判断该学生与别的家长是否存在绑定关系
                List<BindingApplication> bindingApplicationList =  bindingApplicationMapper.selectByfromUserIdOrToUserId(Integer.parseInt(requesterId));
                for (BindingApplication bindingApplication : bindingApplicationList){
                    if(bindingApplication.getFromUserType() == 1){
//                      当发起申请的是家长
                        result.put("success", 0);
                        result.put("message", "已经与家长存在绑定关系!");
                        return  result;
                    }else if (bindingApplication.getFromUserType() == 0){
//                    当是由老师发起的申请   ---  跳过
                        continue;
                    }else if (bindingApplication.getFromUserType() == 2){
                        //                            当是学生发起的申请  --- 查找对应实体
                        ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(bindingApplication.getToUserId());
                        if (elecPlayer != null){
                            if (elecPlayer.getRoleType() == 2){
//                                    对应实体是家长的时候
                                result.put("success", 0);
                                result.put("message", "已经与家长存在绑定关系!");
                                return  result;

                            }
                        }
                    }


                }
            }else if (elecPlayer1.getRoleType() == 1){
                //                当前登录用户是学生  --   判断该学生与别的家长,老师是否存在绑定关系
                ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(Integer.parseInt(requesterId));
                if (elecPlayer != null){
                    if (elecPlayer.getRoleType() == 2){
//                        目标用户是家长的时候
                List<BindingApplication> bindingApplicationList =  bindingApplicationMapper.selectByfromUserIdOrToUserId(userId);
                        for (BindingApplication bindingApplication : bindingApplicationList){
                            if(bindingApplication.getFromUserType() == 1){
//                      当发起申请的是家长
                                result.put("success", 0);
                                result.put("message", "已经与家长存在绑定关系!");
                                return  result;
                            }
                            else if (bindingApplication.getFromUserType() == 0){
//                    当是由老师发起的申请   ---  跳过
                                continue;
                            }else if (bindingApplication.getFromUserType() == 2){
                                //                            当是学生发起的申请  --- 查找对应实体
                                ElecPlayer elecPlayer2 = elecPlayerMapper.selectByPrimaryKey(bindingApplication.getToUserId());
                                if (elecPlayer2 != null){
                                    if (elecPlayer2.getRoleType() == 2){
//                                    对应实体是家长的时候
                                        result.put("success", 0);
                                        result.put("message", "已经与家长存在绑定关系!");
                                        return  result;

                                    }
                                }
                            }


                        }
                    }else if (elecPlayer.getRoleType() == 3){
//                        目标用户是老师的时候
                        List<BindingApplication> bindingApplicationList =  bindingApplicationMapper.selectByfromUserIdOrToUserId(userId);
                        for (BindingApplication bindingApplication : bindingApplicationList){
                            if (bindingApplication.getFromUserType() == 0){
//                            当是老师发起的申请
                                result.put("success", 0);
                                result.put("message", "已经与老师存在绑定关系!");
                                return  result;

                            }else if (bindingApplication.getFromUserType() == 1){
                                //                            当是家长发起的申请 -- 直接跳过
                                continue;
                            }else if (bindingApplication.getFromUserType() == 2){
                                //                            当是学生发起的申请  --- 查找对应实体
                                ElecPlayer elecPlayer4 = elecPlayerMapper.selectByPrimaryKey(bindingApplication.getToUserId());
                                if (elecPlayer4 != null){
                                    if (elecPlayer4.getRoleType() == 3){
//                                    对应实体是老师的时候
                                        result.put("success", 0);
                                        result.put("message", "已经与老师存在绑定关系!");
                                        return  result;

                                    }
                                }
                            }
                        }

                    }
                }

            }

//            校验判断之后进行,数据库修改操作
            BindingApplication bindingApplication = bindingApplicationMapper.selectByfromUserIdAndToUserId(Integer.parseInt(requesterId), userId);
            if (bindingApplication != null) {
                if (response.equals("0")) {
//                拒绝请求时
                    bindingApplication.setApplyState(2);
                } else if (response.equals("1")) {
                    bindingApplication.setApplyState(1);
//                    发起申请的用户是家长
                    if (bindingApplication.getFromUserType() == 1){
//                        to_userId就是学生
                        studentsMapper.selectByPrimaryKey(bindingApplication.getToUserId());

                    }else if (bindingApplication.getFromUserType() == 2){
                        //                    发起申请的用户是学生
//                        to_user可能是学生也可能是老师


                    }else if (bindingApplication.getFromUserType() == 0){
                        //                    发起申请的用户是老师


                    }
                }
                bindingApplication.setHandleTime(new Date());
                int num = bindingApplicationMapper.updateByPrimaryKeySelective(bindingApplication);

                if (num == 1) {
                    result.put("success", 1);
                    result.put("message", "操作成功!");
                } else {
                    result.put("success", 0);
                    result.put("message", "操作失败!");
                }
            } else {
                result.put("success", 0);
                result.put("message", "当前用户未收到请求!");
            }


        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 1);
            result.put("message", "操作失败!");
        }
        return result;
    }

    /**
     * 发送绑定的请求
     *
     * @param ctx
     * @param requestName 目标姓名
     * @param requestId   目标id
     * @param requestType 目标类型
     * @return
     */
    public Map<String, Object> bindPerson(final ChannelHandlerContext ctx, String requestName, String requestId, String requestType) {
        Map<String, Object> result = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId---" + userId);
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(userId);

            BindingApplication bindingApplication = new BindingApplication();
//            查询表中是否已经存在记录
            if (bindingApplicationMapper.selectByfromUserIdAndToUserId(userId, Integer.parseInt(requestId)) != null) {
                result.put("success", 0);
                result.put("message", "已经存在添加申请!");
            } else {
                bindingApplication.setFromUserId(userId);
                bindingApplication.setFromUserName(elecPlayer.getName());
                bindingApplication.setCreateTime(new Date());
                bindingApplication.setToUserId(Integer.parseInt(requestId));
                bindingApplication.setToUserName(requestName);
                bindingApplication.setApplyState(0);     //设置绑定状态未   未处理

//                设置发起绑定类型
                if (elecPlayer.getRoleType() == 1) {
//                    当前身份是学生
                    bindingApplication.setFromUserType(2);
                } else if (elecPlayer.getRoleType() == 2) {
//                    当前身份是家长
                    bindingApplication.setFromUserType(1);
                } else if (elecPlayer.getRoleType() == 3) {
//                    当前身份是老师
                    bindingApplication.setFromUserType(0);
                }

//                向表中插入一条数据
                int num = bindingApplicationMapper.insertSelective(bindingApplication);
                if (num == 1) {
                    result.put("success", 1);
                    result.put("message", "操作成功!");
                } else {
                    result.put("success", 0);
                    result.put("message", "数据库插入失败!");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "操作失败!");
        }
        return result;
    }

    /**
     * 解除绑定关系
     *
     * @param ctx
     * @param aimId 目标id
     * @return
     */
    public Map<String, Object> relieveBind(final ChannelHandlerContext ctx, String aimId) {
        Map<String, Object> result = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId---" + userId);
            BindingApplication bindingApplication = bindingApplicationMapper.selectByfromUserIdOrToUerId(userId, Integer.parseInt(aimId));
//            通过标志位字段作删除操作
            if (bindingApplication != null) {
                bindingApplication.setIsDelete(1);
                bindingApplication.setHandleTime(new Date());
                bindingApplicationMapper.updateByPrimaryKeySelective(bindingApplication);
                result.put("success", 1);
                result.put("message", "操作成功!");
            } else {

                result.put("success", 0);
                result.put("message", "不存在该记录!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "操作失败!");
        }
        return result;
    }

    /**
     * 获取所有绑定关系
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getBindList(final ChannelHandlerContext ctx) {
        Map<String, Object> result = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
//            获取当前登录用户的所有绑定关系
            List<BindingApplication> bindingApplicationList = bindingApplicationMapper.selectByfromUserId(userId);
            List<AimBindStudent> aimBindStudentList = new ArrayList<>();
//            当存在绑定关系的时候
            if (bindingApplicationList.size() > 0) {
                for (BindingApplication bindingApplication : bindingApplicationList) {
//                    找到学生的具体信息
                    ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(bindingApplication.getToUserId());
                    Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                    AimBindStudent aimBindStudent = new AimBindStudent();
                    aimBindStudent.setHeadUrl(students.getHeadUrl());
                    aimBindStudent.setId(students.getId() + "");
//                    aimBindStudent.setLevel();
                    aimBindStudent.setName(students.getStundentName());
                    aimBindStudent.setScore(students.getScore() + "");
                    List<GameGrade> gameGradeList = gameGradeMapper.selectAll();
                    int flage = 0;   //用于标志
                    for (GameGrade gameGrade : gameGradeList) {
//                        根据学生分数进行
                        if (students.getScore() >= gameGrade.getMinScore()
                                && students.getScore() <= gameGrade.getMaxScore()) {
                            aimBindStudent.setLevel(gameGrade.getGradeName());
                            flage = 1;
                            break;
                        }
                    }
                    if (flage == 0) {
//                        如果等级没有改变
                        aimBindStudent.setLevel("未能获得对应等级.!");
                    }

                    aimBindStudentList.add(aimBindStudent);

                }
                result.put("aimList", aimBindStudentList);
                result.put("success", 1);
                result.put("message", "操作成功!");
            } else {
                result.put("success", 0);
                result.put("message", "当前用户不存在绑定关系!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "操作失败!");
        }
        return result;
    }

    /**
     * 获取目标学生的所有评价
     *
     * @param ctx
     * @param aimId 目标学生的id
     * @return
     */
    public Map<String, Object> getEvaluates(final ChannelHandlerContext ctx, String aimId,String page,String size) {

        Map<String, Object> result = new HashMap<>();
        try {
//            获取当前登录用户id
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer temp1 = elecPlayerMapper.selectByPrimaryKey(userId);
            if (temp1.getRoleType() == 3) {
//                当前用户是老师身份时,获取目标学生的所有评价
                PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                List<CommentTeacToStu> commentTeacToStuList = commentTeacToStuMapper.selectByTeacherIdAndStudentId(temp1.getPlayerId(), Integer.parseInt(aimId));

                PageInfo pageInfo = new PageInfo(commentTeacToStuList);
                if(pageInfo.isIsLastPage()){
                    result.put("isLastPage",0);
                }else{
                    result.put("isLastPage",1);
                }

                List<AimCommentToStudent> aimCommentToStudents = new ArrayList<>();
                for (CommentTeacToStu commentTeacToStu : commentTeacToStuList) {
                    AimCommentToStudent aimCommentToStudent = new AimCommentToStudent();
                    aimCommentToStudent.setId(commentTeacToStu.getId() + "");
                    aimCommentToStudent.setLevel(commentTeacToStu.getStartLevel() + "");
                    aimCommentToStudent.setName(commentTeacToStu.getStudent());
                    aimCommentToStudent.setDetail(commentTeacToStu.getCommentDetail());
                    aimCommentToStudent.setTime(format.format(commentTeacToStu.getCommentTime()));

                    String evaluate = "";
//                        commentTeacToStu.getComment()和comment表相关联
                    if (commentTeacToStu.getComment() != null && !"".equals(commentTeacToStu.getComment())) {
//                    非空判断之后进行字符串过滤
                        String[] temp = commentTeacToStu.getComment().split("\\|");
                        for (String aim : temp) {
                            Comment comment = commentMapper.selectByPrimaryKey(Integer.parseInt(aim));
                            evaluate += comment.getContent();
                        }
                    }
                    aimCommentToStudent.setEvaluate(evaluate);

                    aimCommentToStudents.add(aimCommentToStudent);
                }
                result.put("list", aimCommentToStudents);
                result.put("success", 1);
                result.put("message", "操作成功!");
            } else {
                result.put("success", 0);
                result.put("message", "当前用户身份不是老师!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "操作失败!");
        }

        return result;
    }

    /**
     * 获取当前用户名下所有学生的评论
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getAllEvaluates(final ChannelHandlerContext ctx,String page,String size) {

        Map<String, Object> result = new HashMap<>();
        try {

            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer temp1 = elecPlayerMapper.selectByPrimaryKey(userId);
            if (temp1.getRoleType() == 3) {
//                当前用户是老师身份时,获取目标学生的所有评价
                PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                List<CommentTeacToStu> commentTeacToStuList = commentTeacToStuMapper.selectByTeacherId(temp1.getPlayerId());
                PageInfo pageInfo = new PageInfo(commentTeacToStuList);
                if(pageInfo.isIsLastPage()){
                    result.put("isLastPage",0);
                }else{
                    result.put("isLastPage",1);
                }


                List<AimCommentToStudent> aimCommentToStudents = new ArrayList<>();
                for (CommentTeacToStu commentTeacToStu : commentTeacToStuList) {
                    AimCommentToStudent aimCommentToStudent = new AimCommentToStudent();
                    aimCommentToStudent.setId(commentTeacToStu.getId() + "");
                    aimCommentToStudent.setLevel(commentTeacToStu.getStartLevel() + "");
                    aimCommentToStudent.setName(commentTeacToStu.getStudent());
                    aimCommentToStudent.setDetail(commentTeacToStu.getCommentDetail());
                    aimCommentToStudent.setTime(format.format(commentTeacToStu.getCommentTime()));

                    String evaluate = "";
//                        commentTeacToStu.getComment()和comment表相关联
                    if (commentTeacToStu.getComment() != null && !"".equals(commentTeacToStu.getComment())) {
//                    非空判断之后进行字符串过滤
                        String[] temp = commentTeacToStu.getComment().split("\\|");
                        for (String aim : temp) {
                            Comment comment = commentMapper.selectByPrimaryKey(Integer.parseInt(aim));
                            evaluate += comment.getContent();
                        }
                    }
                    aimCommentToStudent.setEvaluate(evaluate);
                    aimCommentToStudents.add(aimCommentToStudent);
                }
                result.put("list", aimCommentToStudents);
                result.put("success", 1);
                result.put("message", "操作成功!");
            } else {
                result.put("success", 0);
                result.put("message", "当前用户身份不是老师!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "操作失败!");
        }

        return result;
    }


    /**
     * 获取所有曲谱
     *
     * @return
     */
    public Map<String, Object> getAllSpectrum(final ChannelHandlerContext ctx) {

        Map<String, Object> map = new HashMap<>();
        try {
            List<OperaDetail> operaDetails = operaDetailMapper.getAllOpera();
            List<OperaInfo> operaInfos = new ArrayList<>();

            for (OperaDetail operaDetail : operaDetails) {
                OperaInfo operaInfo = new OperaInfo();
                operaInfo.setId(operaDetail.getId() + "");
                operaInfo.setName(operaDetail.getOperaName());//曲谱名
                operaInfos.add(operaInfo);
            }
            map.put("success", 1);
            map.put("message", "获取成功！");
            map.put("list", operaInfos);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "获取失败！");
        }
        return map;
    }

    /**
     * 一键布置作业
     *
     * @return
     */
    public Map<String, Object> assignmentAll(final ChannelHandlerContext ctx, String uid, String oid, String num, String start, String end) throws Exception {
        Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
        Map<String, Object> map = new HashMap<>();
        ElecPlayer elecPlayer=elecPlayerMapper.selectByPrimaryKey(userId);
        if(elecPlayer==null){
            map.put("success", 0);
            map.put("message", "获取用户失败!");
            return map;
        }
        String[] str = uid.split("\\|");

        try {
            if (str.length > 0) {
                for (int i = 0; i < str.length; i++) {
                    log.info("uid====" + str[i]);
                    HomeworkDatail homeworkDatail = new HomeworkDatail();
                    homeworkDatail.setOperaId(Integer.parseInt(oid));//曲谱id
                    homeworkDatail.setStuId(Integer.parseInt(str[i]));//学生id
                    Students students=studentsMapper.selectByPrimaryKey(Integer.parseInt(str[i]));
                    if(students!=null){
                        homeworkDatail.setStudent(students.getStundentName());//学生名
                    }
                    homeworkDatail.setState(0);
                    homeworkDatail.setSendTime(day.parse(start));//开始时间
                    homeworkDatail.setTeacherId(elecPlayer.getPlayerId());//老师id
                    homeworkDatail.setTeacherName(elecPlayer.getName());//老师名
                    homeworkDatail.setPractice(Integer.parseInt(num));//练习次数
                    homeworkDatail.setWantFinishTime(day.parse(end));//要求完成时间
                    homeworkDatailMapper.insert(homeworkDatail);
                }
                map.put("success", 1);
                map.put("message", "布置成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "布置失败！");
        }
        return map;
    }
    /**
     * 获取某人作业
     *
     * @param ctx
     * @param uid
     * @return
     */
    public Map<String, Object> getHomework(final ChannelHandlerContext ctx, String uid,String page,String size) {
        log.info("获取某人作业" + uid);
        Map<String, Object> map = new HashMap<>();
        List<StuHomeWorkInfo> returnlist=new ArrayList<>();
        StuHomeWorkInfo stuHomeWorkInfo = null;
        List<String> list = new ArrayList<>();
        Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
        log.info("userId"+userId);
        ElecPlayer elecPlayer=elecPlayerMapper.selectByPrimaryKey(userId);
        try {
            //如果uid为-1查全部
            if(!uid.equals("-1")){
                PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                List<HomeworkDatail> homeworkDatails = homeworkDatailMapper.getHomeworkByUid(Integer.parseInt(uid));
                PageInfo pageInfo = new PageInfo(homeworkDatails);
                if(pageInfo.isIsLastPage()){
                    map.put("isLastPage",0);
                }else{
                    map.put("isLastPage",1);
                }

                for (HomeworkDatail homeworkDatail : homeworkDatails) {
                    stuHomeWorkInfo = new StuHomeWorkInfo();
                    stuHomeWorkInfo.setCount(homeworkDatail.getPractice() + "");//总次数
                    stuHomeWorkInfo.setId(homeworkDatail.getId() + "");
                    stuHomeWorkInfo.setType(homeworkDatail.getState() + "");//状态
                    stuHomeWorkInfo.setTeacher(elecPlayer.getRoleType()==3?homeworkDatail.getStudent():homeworkDatail.getTeacherName());
                    OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(homeworkDatail.getOperaId());//曲谱
                    stuHomeWorkInfo.setName(operaDetail.getOperaName());//曲谱名
                    stuHomeWorkInfo.setStartTime(format.format(homeworkDatail.getSendTime()));//起时间
                    stuHomeWorkInfo.setEndTime(format.format(homeworkDatail.getWantFinishTime()));//要求完成时间
                    log.info("参数" + homeworkDatail.getSendTime() + "" + homeworkDatail.getWantFinishTime() + "" + homeworkDatail.getOperaId() + "" + uid);

                    List<SongRecord> songRecords = songRecordMapper.getSongRecords(format.format(homeworkDatail.getSendTime()), format.format(homeworkDatail.getWantFinishTime()), Integer.parseInt(uid), homeworkDatail.getOperaId());
                    stuHomeWorkInfo.setNowCount(songRecords.size()+"");//已练次数
                    if (songRecords.size() > 0) {
                        log.info("记录" + songRecords.size());
                        for (int i = 0; i < songRecords.size(); i++) {
                            list.add(format.format(songRecords.get(i).getRecordTime()));//练习记录
                        }
                    }
                    stuHomeWorkInfo.setTrainingList(list);
                    returnlist.add(stuHomeWorkInfo);
                }
            }else{
                log.info("对应角色获取作业=========");

                if(elecPlayer==null){
                    map.put("success", 0);
                    map.put("message", "获取用户失败!");
                    return map;
                }
                List<HomeworkDatail> homeworkDatails=null;
                log.info("角色"+elecPlayer.getRoleType());
                switch (elecPlayer.getRoleType()){
                    case 2:{//家长
                        log.info("家长查看孩子作业");
                        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                        homeworkDatails=homeworkDatailMapper.getAllHomeWorkByPid(elecPlayer.getPlayerId());
                        PageInfo pageInfo = new PageInfo(homeworkDatails);
                        if(pageInfo.isIsLastPage()){
                            map.put("isLastPage",0);
                        }else{
                            map.put("isLastPage",1);
                        }
                        break;
                    }
                    case 3:{
                        log.info("老师查看学生作业");
                        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));

                        homeworkDatails=homeworkDatailMapper.getAllHomeWorkByTid(elecPlayer.getPlayerId());
                        PageInfo pageInfo = new PageInfo(homeworkDatails);
                        if(pageInfo.isIsLastPage()){
                            map.put("isLastPage",0);
                        }else{
                            map.put("isLastPage",1);
                        }
                        break;
                    }
                }
//                List<HomeworkDatail> homeworkDatails = homeworkDatailMapper.getAllHomeWork();
                if(homeworkDatails.size()>0){
                    for (HomeworkDatail homeworkDatail : homeworkDatails) {
                        stuHomeWorkInfo = new StuHomeWorkInfo();
                        stuHomeWorkInfo.setCount(homeworkDatail.getPractice() + "");//总次数
                        stuHomeWorkInfo.setId(homeworkDatail.getId() + "");
                        stuHomeWorkInfo.setType(homeworkDatail.getState() + "");//状态
                        if(elecPlayer.getRoleType()==2){//家长查看  显示布置作业的老师名字
                            if(homeworkDatail.getTeacherName()!=null&&!homeworkDatail.getTeacherName().equals("")){
                                stuHomeWorkInfo.setTeacher(homeworkDatail.getTeacherName());//老师
                            }else{
                                stuHomeWorkInfo.setTeacher("");//老师
                            }
                        }else if(elecPlayer.getRoleType()==3){ //老师查看 显示学生名字
                            if(homeworkDatail.getTeacherName()!=null&&!homeworkDatail.getTeacherName().equals("")){
                                stuHomeWorkInfo.setTeacher(homeworkDatail.getStudent());//学生
                            }else{
                                stuHomeWorkInfo.setTeacher("");//学生
                            }
                        }
                        OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(homeworkDatail.getOperaId());//曲谱
                        if(operaDetail!=null){
                            if(operaDetail.getOperaName()!=null&&!operaDetail.getOperaName().equals("")){
                                stuHomeWorkInfo.setName(operaDetail.getOperaName());//曲谱名
                            }else{
                                stuHomeWorkInfo.setName("");//曲谱名
                            }
                        }
                        stuHomeWorkInfo.setStartTime(format.format(homeworkDatail.getSendTime()));//起时间
                        stuHomeWorkInfo.setEndTime(format.format(homeworkDatail.getWantFinishTime()));//要求完成时间

                        log.info("参数" + homeworkDatail.getSendTime() + "" + homeworkDatail.getWantFinishTime() + "" + homeworkDatail.getOperaId() + "学生id" + homeworkDatail.getStuId());

                        List<SongRecord> songRecords = songRecordMapper.getSongRecords(format.format(homeworkDatail.getSendTime()), format.format(homeworkDatail.getWantFinishTime()),homeworkDatail.getStuId(), homeworkDatail.getOperaId());
                        stuHomeWorkInfo.setNowCount(songRecords.size()+"");//已练次数
                        if (songRecords.size() > 0) {
                            log.info("记录" + songRecords.size());
                            for (int i = 0; i < songRecords.size(); i++) {
                                list.add(format.format(songRecords.get(i).getRecordTime()));//练习记录
                            }
                        }
                        stuHomeWorkInfo.setTrainingList(list);
                        returnlist.add(stuHomeWorkInfo);
                    }
                }
            }
            map.put("success", 1);
            map.put("message", "获取成功！");
            map.put("list", returnlist);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "获取失败！");
        }
        return map;
    }
    /**
     * 获取练习列表
     *
     * @return
     */
    public Map<String, Object> getTrainingList() {
        Map<String, Object> map = new HashMap<>();
        return map;
    }
    /**
     * 获取用户基础练习记录
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getTrainingRecord(final ChannelHandlerContext ctx, String uid,String time,String endtime,int page,int size) {
        Map<String, Object> map = new HashMap<>();
        try {
//            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(Integer.parseInt(uid));
            if (elecPlayer == null) {
                map.put("success", 0);
                map.put("message", "用户不存在！");
            }
            List<SongRecord> songRecords = songRecordMapper.getSongRecordByUid(Integer.parseInt(uid),time,endtime,(page-1)*size,size);
            List<ExerciseBase> bases = new ArrayList<>();
            if(songRecords.size()>0){
                for (SongRecord songRecord : songRecords) {
                    ExerciseBase base = new ExerciseBase();
                    base.setFail(songRecord.getSuccess() + ""); //是否成功
                    base.setMiss(songRecord.getFirstParam() + "");//miss数
                    base.setCorrect(songRecord.getSecondParam() + "");//正确数
                    base.setTotalscore(songRecord.getThirdParam() + "");//分数
                    //获取曲谱名
                    OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(songRecord.getSongId());
                    base.setName(operaDetail == null ? "" : operaDetail.getOperaName());
                    base.setTime(format.format(songRecord.getRecordTime()));//生成时间
                    base.setType(songRecord.getPlayspeed() + "");
                    bases.add(base);
                }
                map.put("success",1);
                map.put("message","获取成功");
                map.put("record",bases);
                map.put("isLastPage",1);
            }else{
                map.put("success", "1");
                map.put("message", "");
                map.put("record", bases);
                map.put("isLastPage",0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", "0");
            map.put("message", "获取失败");
        }
        return map;
    }

    /**
     * 计数器记录
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getCounterRecord(final ChannelHandlerContext ctx, String uid,String time,String endtime,int page,int size) {
        Map<String, Object> map = new HashMap<>();
        try {
//            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(Integer.parseInt(uid));
            if (elecPlayer == null) {
                map.put("success", 0);
                map.put("message", "用户不存在！");
            }
            List<CountRecord> countRecords = countRecordMapper.getCountRecordByUid(Integer.parseInt(uid),time,endtime,(page-1)*size,size);
            List<CounterInfo> counterInfos = new ArrayList<>();
            if(counterInfos.size()>0){
                for (CountRecord countRecord : countRecords) {
                    CounterInfo info = new CounterInfo();
                    info.setHit(countRecord.getCounterCount() + "");//打击数
                    info.setRecordTime(format.format(countRecord.getRecordTime())); //生成时间
                    info.setSpeed(countRecord.getCounterSpeed());//速度
                    info.setTime(countRecord.getCountTime());//持续时间
                    counterInfos.add(info);
                }
                map.put("success", "1");
                map.put("message", "获取成功");
                map.put("record", counterInfos);
                map.put("isLastPage",1);
            }else{
                map.put("success", "1");
                map.put("message", "");
                map.put("record", counterInfos);
                map.put("isLastPage",0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", "0");
            map.put("message", "获取失败");
        }
        return map;
    }

    /**
     * 获取练习报表
     *
     * @param ctx
     * @param time
     * @return
     */
    public Map<String, Object> getTrainingTable(final ChannelHandlerContext ctx, String uid, String time) {
        Map<String, Object> result = new HashMap<>();
        try {
//            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer user = elecPlayerMapper.selectByPrimaryKey(Integer.parseInt(uid));
            if (user == null) {
                result.put("success", 0);
                log.info("无此用户");
                return result;
            }
            List<String> monthInfo = new ArrayList<>();
            String info = "";
            Date date = null;
            if (time.equals("0"))
                date = new Date();
            else
                date = day.parse(time + "-01");

            log.info(day.format(date));

            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.MONTH, 1);
            Date nextMonthDate = rightNow.getTime();
            log.info(1 - songRecordMapper.selectWeek(day.format(date), user.getId()) + "");
            rightNow.add(Calendar.MONTH, 1 - songRecordMapper.selectWeek(day.format(date), user.getId()));
            Date lastDay = rightNow.getTime();

            for (int i = 1; i < songRecordMapper.selectWeek(day.format(date), user.getId()); i++) {
                info += songRecordMapper.selectSumByDay(day.format(lastDay), user.getId()) + "|";
                log.info("day:" + day.format(date) + ";" + info);
                rightNow.setTime(lastDay);
                rightNow.add(Calendar.DAY_OF_MONTH, 1);
                lastDay = rightNow.getTime();
            }
            while (date.getTime() < nextMonthDate.getTime()) {
                int sum = songRecordMapper.selectSumByDay(day.format(date), user.getId());
                info += sum + "|";
                log.info("day:" + day.format(date) + ";" + info);
                if (songRecordMapper.selectWeek(day.format(date), user.getId()) == 0) {
                    info = info.substring(0, info.length() - 1);
                    monthInfo.add(info);
                    info = "";
                }
                rightNow.setTime(date);
                rightNow.add(Calendar.DAY_OF_MONTH, 1);
                date = rightNow.getTime();
            }
            for (int i = songRecordMapper.selectWeek(day.format(nextMonthDate), user.getId()); i < 8; i++) {
                info += songRecordMapper.selectSumByDay(day.format(nextMonthDate), user.getId()) + "|";
                log.info("day:" + day.format(date) + ";" + info);
                rightNow.setTime(nextMonthDate);
                rightNow.add(Calendar.DAY_OF_MONTH, 1);
                nextMonthDate = rightNow.getTime();
            }
            info = info.substring(0, info.length() - 1);
            monthInfo.add(info);
            info = "";
            log.info(monthInfo.size() + "");
            int thisMonth = songRecordMapper.selectMonthTime(user.getId());
            int thisWeek = songRecordMapper.selectWeekTime(user.getId());
            int lastWeek = songRecordMapper.selectLastWeekTime(user.getId());
            result.put("success", 1);
            result.put("message", "获取成功");
            result.put("thisWeek", thisWeek + "");
            result.put("lastWeek", lastWeek + "");
            result.put("thisMoon", thisMonth + "");
            result.put("valueMoon", monthInfo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "获取失败");
            return result;
        }
    }


    /**
     * 获取全部寄语
     *
     * @param ctx
     * @param
     * @return
     */
    public Map<String, Object> getAllMessages(final ChannelHandlerContext ctx,String page,String size) {
        Map<String, Object> result = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(userId);
            List<AimCommentParentToTeacher> aimCommentParentToTeacherList = new ArrayList<>();
            if (elecPlayer != null) {
                switch (elecPlayer.getRoleType()) {
                    case 1: { //学生 查看家长发给老师的
                        Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));

                        List<CommentParentTeacher> commentParentTeacherList = commentParentTeacherMapper.selectByParentIdAndTeacherId(students.getParentId(), students.getTeacherId());
                        PageInfo pageInfo = new PageInfo(commentParentTeacherList);
                        if(pageInfo.isIsLastPage()){
                            result.put("isLastPage",0);
                        }else{
                            result.put("isLastPage",1);
                        }

                        for (CommentParentTeacher commentParentTeacher : commentParentTeacherList) {
                            AimCommentParentToTeacher aimCommentParentToTeacher = new AimCommentParentToTeacher();
                            aimCommentParentToTeacher.setParentName(commentParentTeacher.getParents());
                            aimCommentParentToTeacher.setId(commentParentTeacher.getId() + "");
                            aimCommentParentToTeacher.setTime(format.format(commentParentTeacher.getCommentTime()));
                            aimCommentParentToTeacher.setContent(commentParentTeacher.getComment());

                            aimCommentParentToTeacherList.add(aimCommentParentToTeacher);
                        }

                        break;
                    }
                    case 2: {//家长  查看自己发给老师的
                        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                        List<CommentParentTeacher> commentParentTeacherList = commentParentTeacherMapper.selectByParentId(elecPlayer.getPlayerId());
                        PageInfo pageInfo = new PageInfo(commentParentTeacherList);
                        if(pageInfo.isIsLastPage()){
                            result.put("isLastPage",0);
                        }else{
                            result.put("isLastPage",1);
                        }

                        for (CommentParentTeacher commentParentTeacher : commentParentTeacherList) {
                            AimCommentParentToTeacher aimCommentParentToTeacher = new AimCommentParentToTeacher();
                            aimCommentParentToTeacher.setParentName(commentParentTeacher.getParents());
                            aimCommentParentToTeacher.setId(commentParentTeacher.getId() + "");
                            aimCommentParentToTeacher.setContent(commentParentTeacher.getComment());
                            aimCommentParentToTeacher.setTime(format.format(commentParentTeacher.getCommentTime()));

                            aimCommentParentToTeacherList.add(aimCommentParentToTeacher);
                        }
                        break;
                    }
                    case 3: {//老师 查看所有发给自己的
                        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));

                        List<CommentParentTeacher> commentParentTeacherList = commentParentTeacherMapper.selectByTeacherId(elecPlayer.getPlayerId());
                        PageInfo pageInfo = new PageInfo(commentParentTeacherList);
                        if(pageInfo.isIsLastPage()){
                            result.put("isLastPage",0);
                        }else{
                            result.put("isLastPage",1);
                        }

                        for (CommentParentTeacher commentParentTeacher : commentParentTeacherList) {
                            AimCommentParentToTeacher aimCommentParentToTeacher = new AimCommentParentToTeacher();
                            aimCommentParentToTeacher.setId(commentParentTeacher.getId() + "");
                            aimCommentParentToTeacher.setContent(commentParentTeacher.getComment());
                            aimCommentParentToTeacher.setParentName(commentParentTeacher.getParents());
                            aimCommentParentToTeacher.setTime(format.format(commentParentTeacher.getCommentTime()));

                            aimCommentParentToTeacherList.add(aimCommentParentToTeacher);
                        }
                        break;
                    }
                }
                result.put("success", 1);
                result.put("message", "操作成功!");
                result.put("list", aimCommentParentToTeacherList);
            } else {
                result.put("success", 0);
                result.put("message", "获取失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "获取失败");
        }
        return result;
    }

    /**
     * 获取某人寄语
     *
     * @param ctx
     * @param aimId --  目标学生的id
     * @return
     */
    public Map<String, Object> getMessages(final ChannelHandlerContext ctx, String aimId,String page,String size) {
        Map<String, Object> result = new HashMap<>();
        try {
            //            获取当前登录用户id
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(userId);
            List<AimCommentParentToTeacher> aimCommentParentToTeacherList = new ArrayList<>();

            if (elecPlayer != null) {
                switch (elecPlayer.getRoleType()) {
                    case 1: { //学生 查看家长发给老师的
                        Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));

                        List<CommentParentTeacher> commentParentTeacherList = commentParentTeacherMapper.selectByParentIdAndTeacherId(students.getParentId(), students.getTeacherId());
                        PageInfo pageInfo = new PageInfo(commentParentTeacherList);
                        if(pageInfo.isIsLastPage()){
                            result.put("isLastPage",0);
                        }else{
                            result.put("isLastPage",1);
                        }

                        for (CommentParentTeacher commentParentTeacher : commentParentTeacherList) {
                            AimCommentParentToTeacher aimCommentParentToTeacher = new AimCommentParentToTeacher();
                            aimCommentParentToTeacher.setContent(commentParentTeacher.getComment());
                            aimCommentParentToTeacher.setParentName(commentParentTeacher.getParents());
                            aimCommentParentToTeacher.setId(commentParentTeacher.getId() + "");
                            aimCommentParentToTeacher.setTime(format.format(commentParentTeacher.getCommentTime()));

                            aimCommentParentToTeacherList.add(aimCommentParentToTeacher);
                        }

                        break;
                    }
                    case 2: {//家长  查看自己发给老师的
                        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                        List<CommentParentTeacher> commentParentTeacherList = commentParentTeacherMapper.selectByParentIdAndStudentId(elecPlayer.getPlayerId(), Integer.parseInt(aimId));

                        PageInfo pageInfo = new PageInfo(commentParentTeacherList);
                        if(pageInfo.isIsLastPage()){
                            result.put("isLastPage",0);
                        }else{
                            result.put("isLastPage",1);
                        }

                        for (CommentParentTeacher commentParentTeacher : commentParentTeacherList) {
                            AimCommentParentToTeacher aimCommentParentToTeacher = new AimCommentParentToTeacher();
                            aimCommentParentToTeacher.setContent(commentParentTeacher.getComment());
                            aimCommentParentToTeacher.setId(commentParentTeacher.getId() + "");

                            aimCommentParentToTeacher.setParentName(commentParentTeacher.getParents());
                            aimCommentParentToTeacher.setTime(format.format(commentParentTeacher.getCommentTime()));


                            aimCommentParentToTeacherList.add(aimCommentParentToTeacher);
                        }
                        break;
                    }
                    case 3: {//老师 查看所有发给自己的
                        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));

                        List<CommentParentTeacher> commentParentTeacherList = commentParentTeacherMapper.selectByTeacherIdAndStudentId(elecPlayer.getPlayerId(), Integer.parseInt(aimId));
                        PageInfo pageInfo = new PageInfo(commentParentTeacherList);
                        if(pageInfo.isIsLastPage()){
                            result.put("isLastPage",0);
                        }else{
                            result.put("isLastPage",1);
                        }

                        for (CommentParentTeacher commentParentTeacher : commentParentTeacherList) {
                            AimCommentParentToTeacher aimCommentParentToTeacher = new AimCommentParentToTeacher();
                            aimCommentParentToTeacher.setId(commentParentTeacher.getId() + "");
                            aimCommentParentToTeacher.setContent(commentParentTeacher.getComment());

                            aimCommentParentToTeacher.setTime(format.format(commentParentTeacher.getCommentTime()));
                            aimCommentParentToTeacher.setParentName(commentParentTeacher.getParents());

                            aimCommentParentToTeacherList.add(aimCommentParentToTeacher);
                        }
                        break;
                    }
                }
                result.put("success", 1);
                result.put("message", "操作成功!");
                result.put("list", aimCommentParentToTeacherList);
            } else {
                result.put("success", 0);
                result.put("message", "获取失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "操作失败!");
        }

        return result;
    }

    /**
     * 获取所有评价标签
     * @return
     */
    public Map<String,Object> getAllTag(final ChannelHandlerContext ctx){
        Map<String,Object> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        try {
            List<Comment> comments=commentMapper.getAllComment();
            for (Comment comment : comments) {
                list.add(comment.getContent());
            }
            map.put("success", 1);
            map.put("message", "操作成功!");
            map.put("list",list);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "获取失败!");
        }
        return map;
    }
}
