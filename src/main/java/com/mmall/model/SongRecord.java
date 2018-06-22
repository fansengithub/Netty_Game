package com.mmall.model;

import java.util.Date;

public class SongRecord {
    private Integer id;

    private Integer userId;

    private String userAccount;

    private String userRole;

    private String userNick;

    private String pianoShop;

    private String teacher;

    private Integer userType;

    private Integer songId;

    private Integer difficulty;

    private Integer playspeed;

    private Integer success;

    private Integer times;

    private Date recordTime;

    private Integer firstParam;

    private Double secondParam;

    private Integer thirdParam;

    private Integer combo;

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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getPlayspeed() {
        return playspeed;
    }

    public void setPlayspeed(Integer playspeed) {
        this.playspeed = playspeed;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getFirstParam() {
        return firstParam;
    }

    public void setFirstParam(Integer firstParam) {
        this.firstParam = firstParam;
    }

    public Double getSecondParam() {
        return secondParam;
    }

    public void setSecondParam(Double secondParam) {
        this.secondParam = secondParam;
    }

    public Integer getThirdParam() {
        return thirdParam;
    }

    public void setThirdParam(Integer thirdParam) {
        this.thirdParam = thirdParam;
    }

    public Integer getCombo() {
        return combo;
    }

    public void setCombo(Integer combo) {
        this.combo = combo;
    }
}