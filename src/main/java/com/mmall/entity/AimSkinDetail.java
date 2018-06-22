package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
//返回给前端的皮肤风格详细信息
public class AimSkinDetail {
    String itemID;
    String itemName;
    String itemImg;
    String itemPawPrice;
    String itemScorePrice;
    String isHave;      //当前用户是否拥有
    String currentType;  //购买消耗的货币类型  0熊掌1积分2都可以
}
