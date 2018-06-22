package com.mmall.model;

import java.util.Date;

public class MembershipDues {
    private Integer id;

    private String name;

    private Integer userId;

    private String role;

    private String amount;

    private Date time;

    private Date realityTime;

    private Date twoTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getRealityTime() {
        return realityTime;
    }

    public void setRealityTime(Date realityTime) {
        this.realityTime = realityTime;
    }

    public Date getTwoTime() {
        return twoTime;
    }

    public void setTwoTime(Date twoTime) {
        this.twoTime = twoTime;
    }
}