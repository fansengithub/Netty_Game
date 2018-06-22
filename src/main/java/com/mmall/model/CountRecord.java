package com.mmall.model;

import java.util.Date;

public class CountRecord {
    private Integer id;

    private Integer userId;

    private String userAccount;

    private String userRole;

    private String userNick;

    private String pianoShop;

    private String teacher;

    private String countTime;

    private String counterSpeed;

    private Integer counterCount;

    private Date recordTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick == null ? null : userNick.trim();
    }

    public String getPianoShop() {
        return pianoShop;
    }

    public void setPianoShop(String pianoShop) {
        this.pianoShop = pianoShop == null ? null : pianoShop.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getCountTime() {
        return countTime;
    }

    public void setCountTime(String countTime) {
        this.countTime = countTime == null ? null : countTime.trim();
    }

    public String getCounterSpeed() {
        return counterSpeed;
    }

    public void setCounterSpeed(String counterSpeed) {
        this.counterSpeed = counterSpeed == null ? null : counterSpeed.trim();
    }

    public Integer getCounterCount() {
        return counterCount;
    }

    public void setCounterCount(Integer counterCount) {
        this.counterCount = counterCount;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}