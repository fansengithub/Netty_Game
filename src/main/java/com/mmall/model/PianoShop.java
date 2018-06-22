package com.mmall.model;

import java.math.BigDecimal;
import java.util.Date;

public class PianoShop {
    private Integer id;

    private Integer pianoShopId;

    private String name;

    private String contacts;

    private String belongtoOrginaze;

    private Integer belongtoOrginazeid;

    private String telephone;

    private Integer createTeacherTotalnum;

    private Integer nowTeachernum;

    private Integer freeTeahernum;

    private Integer studentNum;

    private String legalName;

    private String bossTelephone;

    private BigDecimal incomeMoney;

    private BigDecimal consumpMoney;

    private String area;

    private String address;

    private Integer remind;

    private Integer state;

    private Integer integral;

    private String fengmianPicture;

    private String idcardPicture;

    private String businessLicensePicture;

    private String transitionPicture;

    private BigDecimal rechargeNum;

    private BigDecimal withdrawalsBalance;

    private Date registerTime;

    private Date memeberTime;

    private Date examineTime;

    private String auditor;

    private Date lastLoginTime;

    private String pianoShopScale;

    private Integer shopScaleId;

    private String pianoShopType;

    private BigDecimal divideMoneyRate;

    private BigDecimal promoterRate;

    private Integer logOut;

    private BigDecimal balance;

    private String headUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPianoShopId() {
        return pianoShopId;
    }

    public void setPianoShopId(Integer pianoShopId) {
        this.pianoShopId = pianoShopId;
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

    public String getBelongtoOrginaze() {
        return belongtoOrginaze;
    }

    public void setBelongtoOrginaze(String belongtoOrginaze) {
        this.belongtoOrginaze = belongtoOrginaze == null ? null : belongtoOrginaze.trim();
    }

    public Integer getBelongtoOrginazeid() {
        return belongtoOrginazeid;
    }

    public void setBelongtoOrginazeid(Integer belongtoOrginazeid) {
        this.belongtoOrginazeid = belongtoOrginazeid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getCreateTeacherTotalnum() {
        return createTeacherTotalnum;
    }

    public void setCreateTeacherTotalnum(Integer createTeacherTotalnum) {
        this.createTeacherTotalnum = createTeacherTotalnum;
    }

    public Integer getNowTeachernum() {
        return nowTeachernum;
    }

    public void setNowTeachernum(Integer nowTeachernum) {
        this.nowTeachernum = nowTeachernum;
    }

    public Integer getFreeTeahernum() {
        return freeTeahernum;
    }

    public void setFreeTeahernum(Integer freeTeahernum) {
        this.freeTeahernum = freeTeahernum;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    public String getBossTelephone() {
        return bossTelephone;
    }

    public void setBossTelephone(String bossTelephone) {
        this.bossTelephone = bossTelephone == null ? null : bossTelephone.trim();
    }

    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public BigDecimal getConsumpMoney() {
        return consumpMoney;
    }

    public void setConsumpMoney(BigDecimal consumpMoney) {
        this.consumpMoney = consumpMoney;
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

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
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

    public String getTransitionPicture() {
        return transitionPicture;
    }

    public void setTransitionPicture(String transitionPicture) {
        this.transitionPicture = transitionPicture == null ? null : transitionPicture.trim();
    }

    public BigDecimal getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(BigDecimal rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    public BigDecimal getWithdrawalsBalance() {
        return withdrawalsBalance;
    }

    public void setWithdrawalsBalance(BigDecimal withdrawalsBalance) {
        this.withdrawalsBalance = withdrawalsBalance;
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

    public String getPianoShopScale() {
        return pianoShopScale;
    }

    public void setPianoShopScale(String pianoShopScale) {
        this.pianoShopScale = pianoShopScale == null ? null : pianoShopScale.trim();
    }

    public Integer getShopScaleId() {
        return shopScaleId;
    }

    public void setShopScaleId(Integer shopScaleId) {
        this.shopScaleId = shopScaleId;
    }

    public String getPianoShopType() {
        return pianoShopType;
    }

    public void setPianoShopType(String pianoShopType) {
        this.pianoShopType = pianoShopType == null ? null : pianoShopType.trim();
    }

    public BigDecimal getDivideMoneyRate() {
        return divideMoneyRate;
    }

    public void setDivideMoneyRate(BigDecimal divideMoneyRate) {
        this.divideMoneyRate = divideMoneyRate;
    }

    public BigDecimal getPromoterRate() {
        return promoterRate;
    }

    public void setPromoterRate(BigDecimal promoterRate) {
        this.promoterRate = promoterRate;
    }

    public Integer getLogOut() {
        return logOut;
    }

    public void setLogOut(Integer logOut) {
        this.logOut = logOut;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }
}