package com.mmall.model;

import java.math.BigDecimal;
import java.util.Date;

public class OperaDetail {
    private Integer id;

    private Integer learnbookId;

    private String learnbookName;

    private String pianoshopRole;

    private String style;

    private String applyStage;

    private String operaName;

    private String author;

    private Integer isGetScore;

    private Integer isOpen;

    private Date createTime;

    private Integer downlaodAmount;

    private Integer saledAmount;

    private BigDecimal income;

    private Integer isUsed;

    private BigDecimal explainPrice;

    private Integer priceUsed;

    private Integer difficulty;

    private String coverPicture;

    private String explainPicture;

    private String explainVideo;

    private String musicScore;

    private String music;

    private String musicScoreMidi;

    private String profile;

    private Date editTime;

    private Integer classfiyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLearnbookId() {
        return learnbookId;
    }

    public void setLearnbookId(Integer learnbookId) {
        this.learnbookId = learnbookId;
    }

    public String getLearnbookName() {
        return learnbookName;
    }

    public void setLearnbookName(String learnbookName) {
        this.learnbookName = learnbookName == null ? null : learnbookName.trim();
    }

    public String getPianoshopRole() {
        return pianoshopRole;
    }

    public void setPianoshopRole(String pianoshopRole) {
        this.pianoshopRole = pianoshopRole == null ? null : pianoshopRole.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getApplyStage() {
        return applyStage;
    }

    public void setApplyStage(String applyStage) {
        this.applyStage = applyStage == null ? null : applyStage.trim();
    }

    public String getOperaName() {
        return operaName;
    }

    public void setOperaName(String operaName) {
        this.operaName = operaName == null ? null : operaName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getIsGetScore() {
        return isGetScore;
    }

    public void setIsGetScore(Integer isGetScore) {
        this.isGetScore = isGetScore;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDownlaodAmount() {
        return downlaodAmount;
    }

    public void setDownlaodAmount(Integer downlaodAmount) {
        this.downlaodAmount = downlaodAmount;
    }

    public Integer getSaledAmount() {
        return saledAmount;
    }

    public void setSaledAmount(Integer saledAmount) {
        this.saledAmount = saledAmount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    public BigDecimal getExplainPrice() {
        return explainPrice;
    }

    public void setExplainPrice(BigDecimal explainPrice) {
        this.explainPrice = explainPrice;
    }

    public Integer getPriceUsed() {
        return priceUsed;
    }

    public void setPriceUsed(Integer priceUsed) {
        this.priceUsed = priceUsed;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture == null ? null : coverPicture.trim();
    }

    public String getExplainPicture() {
        return explainPicture;
    }

    public void setExplainPicture(String explainPicture) {
        this.explainPicture = explainPicture == null ? null : explainPicture.trim();
    }

    public String getExplainVideo() {
        return explainVideo;
    }

    public void setExplainVideo(String explainVideo) {
        this.explainVideo = explainVideo == null ? null : explainVideo.trim();
    }

    public String getMusicScore() {
        return musicScore;
    }

    public void setMusicScore(String musicScore) {
        this.musicScore = musicScore == null ? null : musicScore.trim();
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music == null ? null : music.trim();
    }

    public String getMusicScoreMidi() {
        return musicScoreMidi;
    }

    public void setMusicScoreMidi(String musicScoreMidi) {
        this.musicScoreMidi = musicScoreMidi == null ? null : musicScoreMidi.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Integer getClassfiyId() {
        return classfiyId;
    }

    public void setClassfiyId(Integer classfiyId) {
        this.classfiyId = classfiyId;
    }
}