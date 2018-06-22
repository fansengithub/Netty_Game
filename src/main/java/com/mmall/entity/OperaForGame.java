package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Setter
@Getter
@ToString
//    返回给前端打地鼠游戏的实体类
public class OperaForGame {
    String operaId;         //曲谱id
    String  classifyName;      //分类名称
    String  operaName;          //曲谱名称
    String  textbookName;   //教材名称
    String  author;     //作者
    Date expiryTime;   //到期时间s
    String imgUrl;    //封面图片
}
