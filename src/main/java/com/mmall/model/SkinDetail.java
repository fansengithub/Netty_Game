package com.mmall.model;

import java.util.Date;

public class SkinDetail {
    private Integer id;

    private String name;

    private String type;

    private String style;

    private Long price1;

    private Long price2;

    private Integer priceChoice;

    private Long discount1;

    private Long discount2;

    private Integer discountChoice;

    private Integer discountUse;

    private Integer purchaseTime;

    private Date lastBuyTime;

    private Integer status;

    private Date createTime;

    private Date offShelfTime;

    private Date onShelfTime;

    private String founder;

    private String skinPicture;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public Long getPrice1() {
        return price1;
    }

    public void setPrice1(Long price1) {
        this.price1 = price1;
    }

    public Long getPrice2() {
        return price2;
    }

    public void setPrice2(Long price2) {
        this.price2 = price2;
    }

    public Integer getPriceChoice() {
        return priceChoice;
    }

    public void setPriceChoice(Integer priceChoice) {
        this.priceChoice = priceChoice;
    }

    public Long getDiscount1() {
        return discount1;
    }

    public void setDiscount1(Long discount1) {
        this.discount1 = discount1;
    }

    public Long getDiscount2() {
        return discount2;
    }

    public void setDiscount2(Long discount2) {
        this.discount2 = discount2;
    }

    public Integer getDiscountChoice() {
        return discountChoice;
    }

    public void setDiscountChoice(Integer discountChoice) {
        this.discountChoice = discountChoice;
    }

    public Integer getDiscountUse() {
        return discountUse;
    }

    public void setDiscountUse(Integer discountUse) {
        this.discountUse = discountUse;
    }

    public Integer getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Integer purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Date getLastBuyTime() {
        return lastBuyTime;
    }

    public void setLastBuyTime(Date lastBuyTime) {
        this.lastBuyTime = lastBuyTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOffShelfTime() {
        return offShelfTime;
    }

    public void setOffShelfTime(Date offShelfTime) {
        this.offShelfTime = offShelfTime;
    }

    public Date getOnShelfTime() {
        return onShelfTime;
    }

    public void setOnShelfTime(Date onShelfTime) {
        this.onShelfTime = onShelfTime;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getSkinPicture() {
        return skinPicture;
    }

    public void setSkinPicture(String skinPicture) {
        this.skinPicture = skinPicture == null ? null : skinPicture.trim();
    }
}