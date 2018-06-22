package com.mmall.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
//返回给前端的申请绑定实体详细信息
public class AimBindStudent {
    String id;
    String name;
    String level;   //学生等级
    String score;
    String headUrl;
}
