package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
//返回给前端的 --  家长给学生评语  -- 实体详细信息
public class AimCommentParentToTeacher {
    String id;
    String parentName;
    String time;
    String content;
}
