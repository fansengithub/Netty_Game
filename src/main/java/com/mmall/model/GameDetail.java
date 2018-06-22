package com.mmall.model;

import java.util.Date;

public class GameDetail {
    private Integer id;

    private String name;

    private Long pirce;

    private Long discount;

    private Integer dicountUse;

    private Integer freeCount;

    private Integer status;

    private Integer playCount;

    private Date lastPlayTime;

    private Date createTime;

    private Date onShelfTime;

    private Date offShelfTime;

    private String founder;

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

    public Long getPirce() {
        return pirce;
    }

    public void setPirce(Long pirce) {
        this.pirce = pirce;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Integer getDicountUse() {
        return dicountUse;
    }

    public void setDicountUse(Integer dicountUse) {
        this.dicountUse = dicountUse;
    }

    public Integer getFreeCount() {
        return freeCount;
    }

    public void setFreeCount(Integer freeCount) {
        this.freeCount = freeCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public Date getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(Date lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOnShelfTime() {
        return onShelfTime;
    }

    public void setOnShelfTime(Date onShelfTime) {
        this.onShelfTime = onShelfTime;
    }

    public Date getOffShelfTime() {
        return offShelfTime;
    }

    public void setOffShelfTime(Date offShelfTime) {
        this.offShelfTime = offShelfTime;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }
}