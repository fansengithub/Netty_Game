package com.mmall.model;

import java.util.Date;

public class CmsAdver {
    private Integer id;

    private Integer columnName;

    private String coverPicture;

    private String contant;

    private Integer columnType;

    private String founder;

    private Date createTime;

    private String textContent;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getColumnName() {
        return columnName;
    }

    public void setColumnName(Integer columnName) {
        this.columnName = columnName;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture == null ? null : coverPicture.trim();
    }

    public String getContant() {
        return contant;
    }

    public void setContant(String contant) {
        this.contant = contant == null ? null : contant.trim();
    }

    public Integer getColumnType() {
        return columnType;
    }

    public void setColumnType(Integer columnType) {
        this.columnType = columnType;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent == null ? null : textContent.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}