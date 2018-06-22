package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class MessageInfo {

    private String name;//系统消息/个人消息

    private String time;

    private String content;
}
