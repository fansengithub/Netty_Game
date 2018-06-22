package com.mmall.model;

public class BankcardDetail {
    private Integer id;

    private Integer userId;

    private String userName;

    private Integer roleType;

    private String roler;

    private String opeanBank;

    private String holderName;

    private String bankcardNum;

    private Integer isDefault;

    private String bankcardType;

    private String telephone;

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

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getRoler() {
        return roler;
    }

    public void setRoler(String roler) {
        this.roler = roler == null ? null : roler.trim();
    }

    public String getOpeanBank() {
        return opeanBank;
    }

    public void setOpeanBank(String opeanBank) {
        this.opeanBank = opeanBank == null ? null : opeanBank.trim();
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName == null ? null : holderName.trim();
    }

    public String getBankcardNum() {
        return bankcardNum;
    }

    public void setBankcardNum(String bankcardNum) {
        this.bankcardNum = bankcardNum == null ? null : bankcardNum.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getBankcardType() {
        return bankcardType;
    }

    public void setBankcardType(String bankcardType) {
        this.bankcardType = bankcardType == null ? null : bankcardType.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }
}