package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 消费记录返回
 */
@Slf4j
@Setter
@Getter
public class ConsumptionInfo {

    private String id;
    private String money;
    private String content;
    private String time;
}
