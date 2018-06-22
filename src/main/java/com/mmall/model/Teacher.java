package com.mmall.model;

import java.math.BigDecimal;
import java.util.Date;

public class Teacher {
    private Integer id;

    private Integer teacherId;

    private String name;

    private String workType;

    private String belongtoPianoShop;

    private Integer belongtoPianoShopid;

    private String telephone;

    private Integer memberLevel;

    private Integer state;

    private BigDecimal score;

    private BigDecimal income;

    private String area;

    private String address;

    private Integer remind;

    private BigDecimal recharge;

    private Integer isDefaultTeacher;

    private BigDecimal gameScore;

    private String idcardPicture;

    private BigDecimal balance;

    private BigDecimal withdrawBalance;

    private BigDecimal divideMoneyRate;

    private BigDecimal divideMoneyIncome;

    private Date registerTime;

    private Date memberTime;

    private Date examineTime;

    private String auditor;

    private Date lastLoginTime;

    private String workPlace;

    private String headUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getBelongtoPianoShop() {
        return belongtoPianoShop;
    }

    public void setBelongtoPianoShop(String belongtoPianoShop) {
        this.belongtoPianoShop = belongtoPianoShop == null ? null : belongtoPianoShop.trim();
    }

    public Integer getBelongtoPianoShopid() {
        return belongtoPianoShopid;
    }

    public void setBelongtoPianoShopid(Integer belongtoPianoShopid) {
        this.belongtoPianoShopid = belongtoPianoShopid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
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

    public BigDecimal getRecharge() {
        return recharge;
    }

    public void setRecharge(BigDecimal recharge) {
        this.recharge = recharge;
    }

    public Integer getIsDefaultTeacher() {
        return isDefaultTeacher;
    }

    public void setIsDefaultTeacher(Integer isDefaultTeacher) {
        this.isDefaultTeacher = isDefaultTeacher;
    }

    public BigDecimal getGameScore() {
        return gameScore;
    }

    public void setGameScore(BigDecimal gameScore) {
        this.gameScore = gameScore;
    }

    public String getIdcardPicture() {
        return idcardPicture;
    }

    public void setIdcardPicture(String idcardPicture) {
        this.idcardPicture = idcardPicture == null ? null : idcardPicture.trim();
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

    public BigDecimal getDivideMoneyRate() {
        return divideMoneyRate;
    }

    public void setDivideMoneyRate(BigDecimal divideMoneyRate) {
        this.divideMoneyRate = divideMoneyRate;
    }

    public BigDecimal getDivideMoneyIncome() {
        return divideMoneyIncome;
    }

    public void setDivideMoneyIncome(BigDecimal divideMoneyIncome) {
        this.divideMoneyIncome = divideMoneyIncome;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getMemberTime() {
        return memberTime;
    }

    public void setMemberTime(Date memberTime) {
        this.memberTime = memberTime;
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace == null ? null : workPlace.trim();
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }
}