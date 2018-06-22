package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 提现记录返回
 */
@Slf4j
@Setter
@Getter
public class WithdrawInfo {

    private String id;
    private String count;//熊掌数
    private String money;//到账金额
    private String time;//提现时间
    private String state;//状态
}
