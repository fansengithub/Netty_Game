package com.mmall.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
//返回给前端的教材信息封装
public class AimLearnBook {
    Integer id;       //教材id
    String  url;     //教材图片
    String name;   //教材名称
    String  author;     //作者
    String   summary;
}
