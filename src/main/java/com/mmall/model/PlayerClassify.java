package com.mmall.model;

public class PlayerClassify {
    private Integer id;

    private Integer playerId;

    private String classifyName;

    private Integer isDelete;

    private Integer operaCount;

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

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getOperaCount() {
        return operaCount;
    }

    public void setOperaCount(Integer operaCount) {
        this.operaCount = operaCount;
    }
}