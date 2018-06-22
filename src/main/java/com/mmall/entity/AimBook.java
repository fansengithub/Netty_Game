package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
//返回给前端的申请绑定实体类
public class AimBook {

    String id;     //教材id
    String  url;     //教材图片
    String  name;    //教材名称
    String  author;   //作者
    String  summary;    //描述
}
