package com.mmall.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExerciseBase {

    private String fail; //是否胜利
    private String name;
    private String miss;
    private String correct; //正确数
    private String totalscore; //总分
    private String type;//类型
    private String time;


}
