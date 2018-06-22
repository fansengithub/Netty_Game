package com.mmall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 积分排行
 */
@Slf4j
@Setter
@Getter
@ToString
public class ScoreTopNum {
    private String uid;
    private String name;
    private String score;
    private String head;
    private String rank;
}
