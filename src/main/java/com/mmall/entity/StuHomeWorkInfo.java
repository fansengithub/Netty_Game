package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 作业信息返回
 */
@Slf4j
@Setter
@Getter
public class StuHomeWorkInfo {
    private String id;
    private String type;//类型  0,已完成 1,进行中 2,未完成
    private String teacher;//老师
    private String name;//名字
    private String startTime;//起时间
    private String endTime;//止时间
    private String count;//总次数
    private String nowCount;//已练次数
    private List<String> trainingList;//练习记录

}
