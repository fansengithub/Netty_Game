package com.mmall.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
//返回给前端的学生评论实体详细信息
public class AimCommentToStudent {
        String id;
        String name;
        String  time;
        String level;
        String evaluate;
        String detail;
}
