package com.mmall.model;

public class WaitingMember {
    private Integer id;

    private String name;

    private String contacts;

    private String telephone;

    private String boosTelephone;

    private String area;

    private String address;

    private String idcardPicture;

    private String businessLicensePicture;

    private Integer isPass;

    private String bossName;

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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getBoosTelephone() {
        return boosTelephone;
    }

    public void setBoosTelephone(String boosTelephone) {
        this.boosTelephone = boosTelephone == null ? null : boosTelephone.trim();
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

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName == null ? null : bossName.trim();
    }
}