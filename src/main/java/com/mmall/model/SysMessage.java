package com.mmall.model;

import java.util.Date;

public class SysMessage {
    private Integer id;

    private String content;

    private Integer messageType;

    private Integer objectId;

    private String messageObject;

    private Date sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getMessageObject() {
        return messageObject;
    }

    public void setMessageObject(String messageObject) {
        this.messageObject = messageObject == null ? null : messageObject.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}