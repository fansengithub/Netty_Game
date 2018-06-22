package com.mmall.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
/**
 *
 * 返回给前端的申请绑定实体类
 *
 * @author fansen
 * @date
 */
public class AimADS {
    String  type;
    String  textContent;
    String  coverPicture;
}
