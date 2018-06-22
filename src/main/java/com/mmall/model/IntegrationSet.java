package com.mmall.model;

public class IntegrationSet {
    private Integer id;

    private Integer typeId;

    private String content;

    private Long value;

    private Long topValues;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getTopValues() {
        return topValues;
    }

    public void setTopValues(Long topValues) {
        this.topValues = topValues;
    }
}