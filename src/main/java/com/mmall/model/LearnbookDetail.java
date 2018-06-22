package com.mmall.model;

public class LearnbookDetail {
    private Integer id;

    private Integer learnbookId;

    private String name;

    private String pianoshopRole;

    private String summary;

    private String author;

    private String coverPicture;

    private Integer opernNum;

    private Integer isRecommend;

    private Integer isAnthor;

    private String usePermission;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPianoshopRole() {
        return pianoshopRole;
    }

    public void setPianoshopRole(String pianoshopRole) {
        this.pianoshopRole = pianoshopRole == null ? null : pianoshopRole.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture == null ? null : coverPicture.trim();
    }

    public Integer getOpernNum() {
        return opernNum;
    }

    public void setOpernNum(Integer opernNum) {
        this.opernNum = opernNum;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getIsAnthor() {
        return isAnthor;
    }

    public void setIsAnthor(Integer isAnthor) {
        this.isAnthor = isAnthor;
    }

    public String getUsePermission() {
        return usePermission;
    }

    public void setUsePermission(String usePermission) {
        this.usePermission = usePermission == null ? null : usePermission.trim();
    }
}