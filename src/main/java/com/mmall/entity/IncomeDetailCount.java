package com.mmall.entity;

import java.util.Date;

public class IncomeDetailCount {
    private Integer id;

    private Integer userId;

    private String userName;

    private String role;

    private String consumpType;

    private Long incomeMoney;

    private Long accountBalance;

    private Date createTime;

    private Integer incomeCount;
    private Integer accountCount;
    private Date minTime;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getConsumpType() {
        return consumpType;
    }

    public void setConsumpType(String consumpType) {
        this.consumpType = consumpType == null ? null : consumpType.trim();
    }

    public Long getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(Long incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIncomeCount() {
        return incomeCount;
    }

    public void setIncomeCount(Integer incomeCount) {
        this.incomeCount = incomeCount;
    }

    public Integer getAccountCount() {
        return accountCount;
    }

    public void setAccountCount(Integer accountCount) {
        this.accountCount = accountCount;
    }

    public Date getMinTime() {
        return minTime;
    }

    public void setMinTime(Date minTime) {
        this.minTime = minTime;
    }
}