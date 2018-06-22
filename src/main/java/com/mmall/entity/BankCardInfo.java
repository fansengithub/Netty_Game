package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 银行卡信息
 */
@Setter
@Getter
@Slf4j
public class BankCardInfo {

    private String id;
    private String card;//卡号  交通银行(123123123412341234)
}
