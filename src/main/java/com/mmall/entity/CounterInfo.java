package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 计数器记录返回数据
 */
@Getter
@Setter
@Slf4j
public class CounterInfo {
    private String time; //持续时间
    private String speed;//速度
    private String hit;//打击数
    private String recordTime;//创建时间

}
