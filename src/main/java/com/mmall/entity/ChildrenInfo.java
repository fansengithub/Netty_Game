package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class ChildrenInfo {

    private String uid;
    private String name;
    private String limit;//消费限额
}
