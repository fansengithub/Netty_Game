package com.mmall.model;

import java.util.Date;

public class RechargeDetail {
    private Integer id;

    private String tradNo;

    private Integer userId;

    private String name;

    private String role;

    private Long beforeRecharge;

    private Long afterRecharge;

    private Long rechargeMoney;

    private Integer state;

    private Long rechargeObject;

    private Integer rechargeType;

    private Date rechargeTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradNo() {
        return tradNo;
    }

    public void setTradNo(String tradNo) {
        this.tradNo = tradNo == null ? null : tradNo.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Long getBeforeRecharge() {
        return beforeRecharge;
    }

    public void setBeforeRecharge(Long beforeRecharge) {
        this.beforeRecharge = beforeRecharge;
    }

    public Long getAfterRecharge() {
        return afterRecharge;
    }

    public void setAfterRecharge(Long afterRecharge) {
        this.afterRecharge = afterRecharge;
    }

    public Long getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(Long rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getRechargeObject() {
        return rechargeObject;
    }

    public void setRechargeObject(Long rechargeObject) {
        this.rechargeObject = rechargeObject;
    }

    public Integer getRechargeType() {
        return rechargeType;
    }

    public void setRechargeType(Integer rechargeType) {
        this.rechargeType = rechargeType;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }
}