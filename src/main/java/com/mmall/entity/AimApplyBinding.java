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
public class AimApplyBinding {
    String name;
    String sate;
    String type;
    String applyTime;

    String requestId;
    String requestUrl;
    String hadleTime;
}
