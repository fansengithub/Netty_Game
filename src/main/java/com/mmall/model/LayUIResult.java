package com.mmall.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义返回数据格式
 */
@Slf4j
@Setter
@Getter
public class LayUIResult {

    private Integer code;

    private String msg;

    private Object data;

    private Long count;

}
