package com.mmall.model;

import java.math.BigDecimal;
import java.util.Date;

public class Organization {
    private Integer id;

    private Integer organizeId;

    private String organizeName;

    private Integer serviceproviderId;

    private String contacts;

    private Integer disable;

    private String telephone;

    private Integer pianoShopNum;

    private Integer memberNum;

    private Integer learnbookNum;

    private Integer operabookNum;

    private String bossName;

    private String boosTelephone;

    private BigDecimal income;

    private String area;

    private String detailAddress;

    private Integer remind;

    private String fengmianPicture;

    private String idcardPicture;

    private BigDecimal withdrawBalance;

    private BigDecimal balance;

    private Date registerTime;

    private Date memberTime;

    private Date examineTime;

    private String auditor;

    private String organizeType;

    private BigDecimal divideMoneyRate;

    private Date lastLoginTime;

    private String businessLicensePicture;

    private Integer logOut;

    private String headUrl;

    private BigDecimal consumpMoney;

    private BigDecimal rechargeMoney;

    private String organizeScope;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Integer organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName == null ? null : organizeName.trim();
    }

    public Integer getServiceproviderId() {
        return serviceproviderId;
    }

    public void setServiceproviderId(Integer serviceproviderId) {
        this.serviceproviderId = serviceproviderId;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getPianoShopNum() {
        return pianoShopNum;
    }

    public void setPianoShopNum(Integer pianoShopNum) {
        this.pianoShopNum = pianoShopNum;
    }

    public Integer getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Integer memberNum) {
        this.memberNum = memberNum;
    }

    public Integer getLearnbookNum() {
        return learnbookNum;
    }

    public void setLearnbookNum(Integer learnbookNum) {
        this.learnbookNum = learnbookNum;
    }

    public Integer getOperabookNum() {
        return operabookNum;
    }

    public void setOperabookNum(Integer operabookNum) {
        this.operabookNum = operabookNum;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName == null ? null : bossName.trim();
    }

    public String getBoosTelephone() {
        return boosTelephone;
    }

    public void setBoosTelephone(String boosTelephone) {
        this.boosTelephone = boosTelephone == null ? null : boosTelephone.trim();
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

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public Integer getRemind() {
        return remind;
    }

    public void setRemind(Integer remind) {
        this.remind = remind;
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

    public BigDecimal getWithdrawBalance() {
        return withdrawBalance;
    }

    public void setWithdrawBalance(BigDecimal withdrawBalance) {
        this.withdrawBalance = withdrawBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public String getOrganizeType() {
        return organizeType;
    }

    public void setOrganizeType(String organizeType) {
        this.organizeType = organizeType == null ? null : organizeType.trim();
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

    public String getBusinessLicensePicture() {
        return businessLicensePicture;
    }

    public void setBusinessLicensePicture(String businessLicensePicture) {
        this.businessLicensePicture = businessLicensePicture == null ? null : businessLicensePicture.trim();
    }

    public Integer getLogOut() {
        return logOut;
    }

    public void setLogOut(Integer logOut) {
        this.logOut = logOut;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public BigDecimal getConsumpMoney() {
        return consumpMoney;
    }

    public void setConsumpMoney(BigDecimal consumpMoney) {
        this.consumpMoney = consumpMoney;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public String getOrganizeScope() {
        return organizeScope;
    }

    public void setOrganizeScope(String organizeScope) {
        this.organizeScope = organizeScope == null ? null : organizeScope.trim();
    }
}