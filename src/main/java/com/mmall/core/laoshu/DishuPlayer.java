package com.mmall.core.laoshu;

import com.mmall.core.BaseUser;

public class DishuPlayer {

    //是否准备
    private boolean isRead;

    //打击次数
    private int count;

    //积分
    private int score;


    private BaseUser user;


    public BaseUser getUser() {
        return user;
    }

    public void setUser(BaseUser user) {
        this.user = user;
    }

    int beinum = 1 ;


    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        this.score = count * beinum;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
