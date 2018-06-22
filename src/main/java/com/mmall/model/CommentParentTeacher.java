package com.mmall.model;

import java.util.Date;

public class CommentParentTeacher {
    private Integer id;

    private String pianoShop;

    private Integer parentsId;

    private String parents;

    private Integer studentId;

    private String student;

    private Integer teacherId;

    private String teacher;

    private String comment;

    private Date commentTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPianoShop() {
        return pianoShop;
    }

    public void setPianoShop(String pianoShop) {
        this.pianoShop = pianoShop == null ? null : pianoShop.trim();
    }

    public Integer getParentsId() {
        return parentsId;
    }

    public void setParentsId(Integer parentsId) {
        this.parentsId = parentsId;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents == null ? null : parents.trim();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student == null ? null : student.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}