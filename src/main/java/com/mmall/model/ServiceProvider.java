package com.mmall.model;

import java.math.BigDecimal;
import java.util.Date;

public class ServiceProvider {
    private Integer id;

    private Integer providerId;

    private String name;

    private String contacts;

    private Integer isDisable;

    private String telephone;

    private Integer organiztionNum;

    private Integer pianoShopNum;

    private String bossName;

    private String bossTelephone;

    private BigDecimal income;

    private String area;

    private String address;

    private Integer remind;

    private Integer state;

    private String fengmianPicture;

    private String idcardPicture;

    private String businessLicensePicture;

    private BigDecimal balance;

    private BigDecimal withdrawBalance;

    private Date registerTime;

    private Date memeberTime;

    private Date examineTime;

    private BigDecimal divideMoneyRate;

    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getOrganiztionNum() {
        return organiztionNum;
    }

    public void setOrganiztionNum(Integer organiztionNum) {
        this.organiztionNum = organiztionNum;
    }

    public Integer getPianoShopNum() {
        return pianoShopNum;
    }

    public void setPianoShopNum(Integer pianoShopNum) {
        this.pianoShopNum = pianoShopNum;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName == null ? null : bossName.trim();
    }

    public String getBossTelephone() {
        return bossTelephone;
    }

    public void setBossTelephone(String bossTelephone) {
        this.bossTelephone = bossTelephone == null ? null : bossTelephone.trim();
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getRemind() {
        return remind;
    }

    public void setRemind(Integer remind) {
        this.remind = remind;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFengmianPicture() {
        return fengmianPicture;
    }

    public void setFengmianPicture(String fengmianPicture) {
        this.fengmianPicture = fengmianPicture == null ? null : fengmianPicture.trim();
    }

    public String getIdcardPicture() {
        return idcardPicture;
    }

    public void setIdcardPicture(String idcardPicture) {
        this.idcardPicture = idcardPicture == null ? null : idcardPicture.trim();
    }

    public String getBusinessLicensePicture() {
        return businessLicensePicture;
    }

    public void setBusinessLicensePicture(String businessLicensePicture) {
        this.businessLicensePicture = businessLicensePicture == null ? null : businessLicensePicture.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getWithdrawBalance() {
        return withdrawBalance;
    }

    public void setWithdrawBalance(BigDecimal withdrawBalance) {
        this.withdrawBalance = withdrawBalance;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getMemeberTime() {
        return memeberTime;
    }

    public void setMemeberTime(Date memeberTime) {
        this.memeberTime = memeberTime;
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public BigDecimal getDivideMoneyRate() {
        return divideMoneyRate;
    }

    public void setDivideMoneyRate(BigDecimal divideMoneyRate) {
        this.divideMoneyRate = divideMoneyRate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}