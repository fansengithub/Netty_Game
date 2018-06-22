package com.mmall.model;

import java.util.Date;

public class HomeworkDatail {
    private Integer id;

    private Integer teacherId;

    private String teacherName;

    private Integer operaId;

    private Integer stuId;

    private String student;

    private String parent;

    private String homeworkDetail;

    private Integer state;

    private Integer practice;

    private Date sendTime;

    private Date wantFinishTime;

    private Date finishTime;

    private String belontoPiano;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public Integer getOperaId() {
        return operaId;
    }

    public void setOperaId(Integer operaId) {
        this.operaId = operaId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student == null ? null : student.trim();
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent == null ? null : parent.trim();
    }

    public String getHomeworkDetail() {
        return homeworkDetail;
    }

    public void setHomeworkDetail(String homeworkDetail) {
        this.homeworkDetail = homeworkDetail == null ? null : homeworkDetail.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPractice() {
        return practice;
    }

    public void setPractice(Integer practice) {
        this.practice = practice;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getWantFinishTime() {
        return wantFinishTime;
    }

    public void setWantFinishTime(Date wantFinishTime) {
        this.wantFinishTime = wantFinishTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getBelontoPiano() {
        return belontoPiano;
    }

    public void setBelontoPiano(String belontoPiano) {
        this.belontoPiano = belontoPiano == null ? null : belontoPiano.trim();
    }
}