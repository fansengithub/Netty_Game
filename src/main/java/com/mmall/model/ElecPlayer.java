package com.mmall.model;

import lombok.ToString;

import java.util.Date;

@ToString
public class ElecPlayer {
    private Integer id;

    private Integer playerId;

    private String name;

    private String nickname;

    private Integer isQiyong;

    private Integer isLookallmusic;

    private Integer age;

    private Integer sex;

    private String brithday;

    private String phone;

    private String password;

    private Integer roleType;

    private Date createTime;

    private Integer score;

    private Integer xiongzhang;

    private String rank;

    private String province;

    private String city;

    private String area;

    private String address;

    private String wxOpenid;

    private String wxUnionid;

    private String wxHead;

    private String qqOpenid;

    private String qqUnionid;

    private String qqHead;

    private String sinaOpenid;

    private String sinaUnionid;

    private String sinaHead;

    private String headurl;

    private Integer iscomplete;

    private String type;

    private String refereeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getIsQiyong() {
        return isQiyong;
    }

    public void setIsQiyong(Integer isQiyong) {
        this.isQiyong = isQiyong;
    }

    public Integer getIsLookallmusic() {
        return isLookallmusic;
    }

    public void setIsLookallmusic(Integer isLookallmusic) {
        this.isLookallmusic = isLookallmusic;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday == null ? null : brithday.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getXiongzhang() {
        return xiongzhang;
    }

    public void setXiongzhang(Integer xiongzhang) {
        this.xiongzhang = xiongzhang;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid == null ? null : wxOpenid.trim();
    }

    public String getWxUnionid() {
        return wxUnionid;
    }

    public void setWxUnionid(String wxUnionid) {
        this.wxUnionid = wxUnionid == null ? null : wxUnionid.trim();
    }

    public String getWxHead() {
        return wxHead;
    }

    public void setWxHead(String wxHead) {
        this.wxHead = wxHead == null ? null : wxHead.trim();
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid == null ? null : qqOpenid.trim();
    }

    public String getQqUnionid() {
        return qqUnionid;
    }

    public void setQqUnionid(String qqUnionid) {
        this.qqUnionid = qqUnionid == null ? null : qqUnionid.trim();
    }

    public String getQqHead() {
        return qqHead;
    }

    public void setQqHead(String qqHead) {
        this.qqHead = qqHead == null ? null : qqHead.trim();
    }

    public String getSinaOpenid() {
        return sinaOpenid;
    }

    public void setSinaOpenid(String sinaOpenid) {
        this.sinaOpenid = sinaOpenid == null ? null : sinaOpenid.trim();
    }

    public String getSinaUnionid() {
        return sinaUnionid;
    }

    public void setSinaUnionid(String sinaUnionid) {
        this.sinaUnionid = sinaUnionid == null ? null : sinaUnionid.trim();
    }

    public String getSinaHead() {
        return sinaHead;
    }

    public void setSinaHead(String sinaHead) {
        this.sinaHead = sinaHead == null ? null : sinaHead.trim();
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl == null ? null : headurl.trim();
    }

    public Integer getIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(Integer iscomplete) {
        this.iscomplete = iscomplete;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(String refereeId) {
        this.refereeId = refereeId == null ? null : refereeId.trim();
    }
}