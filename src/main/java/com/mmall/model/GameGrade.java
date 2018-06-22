package com.mmall.model;

import java.util.Date;

public class GameGrade {
    private Integer id;

    private String gradeName;

    private Integer minScore;

    private Integer maxScore;

    private String gradeRemarks;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public String getGradeRemarks() {
        return gradeRemarks;
    }

    public void setGradeRemarks(String gradeRemarks) {
        this.gradeRemarks = gradeRemarks == null ? null : gradeRemarks.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}