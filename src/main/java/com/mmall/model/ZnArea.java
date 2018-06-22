package com.mmall.model;

public class ZnArea {
    private String id;

    private String areaName;

    private String areaType;

    private String areaCede;

    private String areaParent;

    private String num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType == null ? null : areaType.trim();
    }

    public String getAreaCede() {
        return areaCede;
    }

    public void setAreaCede(String areaCede) {
        this.areaCede = areaCede == null ? null : areaCede.trim();
    }

    public String getAreaParent() {
        return areaParent;
    }

    public void setAreaParent(String areaParent) {
        this.areaParent = areaParent == null ? null : areaParent.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }
}