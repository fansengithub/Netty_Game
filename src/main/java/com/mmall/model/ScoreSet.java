package com.mmall.model;

public class ScoreSet {
    private Integer id;

    private String title;

    private String score;

    private String baseex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getBaseex() {
        return baseex;
    }

    public void setBaseex(String baseex) {
        this.baseex = baseex == null ? null : baseex.trim();
    }
}