package com.mmall.model;

public class OperaExplainPicture {
    private Integer id;

    private Integer operaId;

    private String explainPicture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperaId() {
        return operaId;
    }

    public void setOperaId(Integer operaId) {
        this.operaId = operaId;
    }

    public String getExplainPicture() {
        return explainPicture;
    }

    public void setExplainPicture(String explainPicture) {
        this.explainPicture = explainPicture == null ? null : explainPicture.trim();
    }
}