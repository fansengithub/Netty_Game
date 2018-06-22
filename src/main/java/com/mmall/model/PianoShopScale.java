package com.mmall.model;

public class PianoShopScale {
    private Integer id;

    private String type;

    private Integer maxTeacherNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getMaxTeacherNum() {
        return maxTeacherNum;
    }

    public void setMaxTeacherNum(Integer maxTeacherNum) {
        this.maxTeacherNum = maxTeacherNum;
    }
}