package com.mmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 *在线课堂中返回给前端的--曲谱详细信息
 * @author  fan
 * @date 18/6/19
 */

@Slf4j
@Setter
@Getter
@ToString
public class AimOpera {
    String name;
    String  author;
    String  id;
    /**
     *   原价
     */
    String  price;
    /**
     * 折扣价,   -1 表示没有折扣价
     */
    String  discountPrice;
    /**
     * 到期时间,-1 表示没有购买,其它表示购买.-2表示免费.
     */
    String  limitTime;
}
