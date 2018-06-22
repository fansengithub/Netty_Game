package com.mmall.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
// 返回前端的实体类
public class Company {
    Integer id;
    String  url;
}
