package com.mmall.model;

import java.math.BigDecimal;
import java.util.Date;

public class ConsumptionDetail {
    private Integer id;

    private Integer userId;

    private String name;

    private String role;

    private BigDecimal consumptionMoney;

    private String consumptionDetail;

    private BigDecimal restMoney;

    private Date createtime;

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

    public BigDecimal getConsumptionMoney() {
        return consumptionMoney;
    }

    public void setConsumptionMoney(BigDecimal consumptionMoney) {
        this.consumptionMoney = consumptionMoney;
    }

    public String getConsumptionDetail() {
        return consumptionDetail;
    }

    public void setConsumptionDetail(String consumptionDetail) {
        this.consumptionDetail = consumptionDetail == null ? null : consumptionDetail.trim();
    }

    public BigDecimal getRestMoney() {
        return restMoney;
    }

    public void setRestMoney(BigDecimal restMoney) {
        this.restMoney = restMoney;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}