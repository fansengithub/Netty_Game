package com.mmall.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
//返回给前端的owner_opera 信息
public class AimOwnerOpera {
    String name;     //operaNames   曲谱名称
    String author;     //曲谱作者
    String limitTime;     //到期时间
    String price;   //原价
    String  discountPrice;   //折扣价
    String id;  //曲谱id
    String  typeID;   //曲谱分类id

}
