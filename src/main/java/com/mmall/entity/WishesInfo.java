package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 寄语返回信息
 */
@Slf4j
@Setter
@Getter
public class WishesInfo {
    private String id;
    private String name;
    private String time;
    private String content;

}
