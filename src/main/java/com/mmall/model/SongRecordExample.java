package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SongRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SongRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNull() {
            addCriterion("user_role is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNotNull() {
            addCriterion("user_role is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleEqualTo(String value) {
            addCriterion("user_role =", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotEqualTo(String value) {
            addCriterion("user_role <>", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThan(String value) {
            addCriterion("user_role >", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThanOrEqualTo(String value) {
            addCriterion("user_role >=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThan(String value) {
            addCriterion("user_role <", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThanOrEqualTo(String value) {
            addCriterion("user_role <=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLike(String value) {
            addCriterion("user_role like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotLike(String value) {
            addCriterion("user_role not like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleIn(List<String> values) {
            addCriterion("user_role in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotIn(List<String> values) {
            addCriterion("user_role not in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleBetween(String value1, String value2) {
            addCriterion("user_role between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotBetween(String value1, String value2) {
            addCriterion("user_role not between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserNickIsNull() {
            addCriterion("user_nick is null");
            return (Criteria) this;
        }

        public Criteria andUserNickIsNotNull() {
            addCriterion("user_nick is not null");
            return (Criteria) this;
        }

        public Criteria andUserNickEqualTo(String value) {
            addCriterion("user_nick =", value, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickNotEqualTo(String value) {
            addCriterion("user_nick <>", value, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickGreaterThan(String value) {
            addCriterion("user_nick >", value, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickGreaterThanOrEqualTo(String value) {
            addCriterion("user_nick >=", value, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickLessThan(String value) {
            addCriterion("user_nick <", value, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickLessThanOrEqualTo(String value) {
            addCriterion("user_nick <=", value, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickLike(String value) {
            addCriterion("user_nick like", value, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickNotLike(String value) {
            addCriterion("user_nick not like", value, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickIn(List<String> values) {
            addCriterion("user_nick in", values, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickNotIn(List<String> values) {
            addCriterion("user_nick not in", values, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickBetween(String value1, String value2) {
            addCriterion("user_nick between", value1, value2, "userNick");
            return (Criteria) this;
        }

        public Criteria andUserNickNotBetween(String value1, String value2) {
            addCriterion("user_nick not between", value1, value2, "userNick");
            return (Criteria) this;
        }

        public Criteria andPianoShopIsNull() {
            addCriterion("piano_shop is null");
            return (Criteria) this;
        }

        public Criteria andPianoShopIsNotNull() {
            addCriterion("piano_shop is not null");
            return (Criteria) this;
        }

        public Criteria andPianoShopEqualTo(String value) {
            addCriterion("piano_shop =", value, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopNotEqualTo(String value) {
            addCriterion("piano_shop <>", value, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopGreaterThan(String value) {
            addCriterion("piano_shop >", value, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopGreaterThanOrEqualTo(String value) {
            addCriterion("piano_shop >=", value, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopLessThan(String value) {
            addCriterion("piano_shop <", value, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopLessThanOrEqualTo(String value) {
            addCriterion("piano_shop <=", value, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopLike(String value) {
            addCriterion("piano_shop like", value, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopNotLike(String value) {
            addCriterion("piano_shop not like", value, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopIn(List<String> values) {
            addCriterion("piano_shop in", values, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopNotIn(List<String> values) {
            addCriterion("piano_shop not in", values, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopBetween(String value1, String value2) {
            addCriterion("piano_shop between", value1, value2, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andPianoShopNotBetween(String value1, String value2) {
            addCriterion("piano_shop not between", value1, value2, "pianoShop");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNull() {
            addCriterion("teacher is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIsNotNull() {
            addCriterion("teacher is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEqualTo(String value) {
            addCriterion("teacher =", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotEqualTo(String value) {
            addCriterion("teacher <>", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThan(String value) {
            addCriterion("teacher >", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("teacher >=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThan(String value) {
            addCriterion("teacher <", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLessThanOrEqualTo(String value) {
            addCriterion("teacher <=", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherLike(String value) {
            addCriterion("teacher like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotLike(String value) {
            addCriterion("teacher not like", value, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherIn(List<String> values) {
            addCriterion("teacher in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotIn(List<String> values) {
            addCriterion("teacher not in", values, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherBetween(String value1, String value2) {
            addCriterion("teacher between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andTeacherNotBetween(String value1, String value2) {
            addCriterion("teacher not between", value1, value2, "teacher");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Integer value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Integer value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Integer> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andSongIdIsNull() {
            addCriterion("song_id is null");
            return (Criteria) this;
        }

        public Criteria andSongIdIsNotNull() {
            addCriterion("song_id is not null");
            return (Criteria) this;
        }

        public Criteria andSongIdEqualTo(Integer value) {
            addCriterion("song_id =", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotEqualTo(Integer value) {
            addCriterion("song_id <>", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdGreaterThan(Integer value) {
            addCriterion("song_id >", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("song_id >=", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdLessThan(Integer value) {
            addCriterion("song_id <", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdLessThanOrEqualTo(Integer value) {
            addCriterion("song_id <=", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdIn(List<Integer> values) {
            addCriterion("song_id in", values, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotIn(List<Integer> values) {
            addCriterion("song_id not in", values, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdBetween(Integer value1, Integer value2) {
            addCriterion("song_id between", value1, value2, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotBetween(Integer value1, Integer value2) {
            addCriterion("song_id not between", value1, value2, "songId");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualTo(Integer value) {
            addCriterion("difficulty =", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(Integer value) {
            addCriterion("difficulty <>", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThan(Integer value) {
            addCriterion("difficulty >", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(Integer value) {
            addCriterion("difficulty >=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(Integer value) {
            addCriterion("difficulty <", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(Integer value) {
            addCriterion("difficulty <=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyIn(List<Integer> values) {
            addCriterion("difficulty in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<Integer> values) {
            addCriterion("difficulty not in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(Integer value1, Integer value2) {
            addCriterion("difficulty between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(Integer value1, Integer value2) {
            addCriterion("difficulty not between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andPlayspeedIsNull() {
            addCriterion("playspeed is null");
            return (Criteria) this;
        }

        public Criteria andPlayspeedIsNotNull() {
            addCriterion("playspeed is not null");
            return (Criteria) this;
        }

        public Criteria andPlayspeedEqualTo(Integer value) {
            addCriterion("playspeed =", value, "playspeed");
            return (Criteria) this;
        }

        public Criteria andPlayspeedNotEqualTo(Integer value) {
            addCriterion("playspeed <>", value, "playspeed");
            return (Criteria) this;
        }

        public Criteria andPlayspeedGreaterThan(Integer value) {
            addCriterion("playspeed >", value, "playspeed");
            return (Criteria) this;
        }

        public Criteria andPlayspeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("playspeed >=", value, "playspeed");
            return (Criteria) this;
        }

        public Criteria andPlayspeedLessThan(Integer value) {
            addCriterion("playspeed <", value, "playspeed");
            return (Criteria) this;
        }

        public Criteria andPlayspeedLessThanOrEqualTo(Integer value) {
            addCriterion("playspeed <=", value, "playspeed");
            return (Criteria) this;
        }

        public Criteria andPlayspeedIn(List<Integer> values) {
            addCriterion("playspeed in", values, "playspeed");
            return (Criteria) this;
        }

        public Criteria andPlayspeedNotIn(List<Integer> values) {
            addCriterion("playspeed not in", values, "playspeed");
            return (Criteria) this;
        }

        public Criteria andPlayspeedBetween(Integer value1, Integer value2) {
            addCriterion("playspeed between", value1, value2, "playspeed");
            return (Criteria) this;
        }

        public Criteria andPlayspeedNotBetween(Integer value1, Integer value2) {
            addCriterion("playspeed not between", value1, value2, "playspeed");
            return (Criteria) this;
        }

        public Criteria andSuccessIsNull() {
            addCriterion("success is null");
            return (Criteria) this;
        }

        public Criteria andSuccessIsNotNull() {
            addCriterion("success is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessEqualTo(Integer value) {
            addCriterion("success =", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotEqualTo(Integer value) {
            addCriterion("success <>", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessGreaterThan(Integer value) {
            addCriterion("success >", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("success >=", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessLessThan(Integer value) {
            addCriterion("success <", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessLessThanOrEqualTo(Integer value) {
            addCriterion("success <=", value, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessIn(List<Integer> values) {
            addCriterion("success in", values, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotIn(List<Integer> values) {
            addCriterion("success not in", values, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessBetween(Integer value1, Integer value2) {
            addCriterion("success between", value1, value2, "success");
            return (Criteria) this;
        }

        public Criteria andSuccessNotBetween(Integer value1, Integer value2) {
            addCriterion("success not between", value1, value2, "success");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Integer value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Integer value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Integer value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Integer value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Integer value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Integer> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Integer> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Integer value1, Integer value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("times not between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andFirstParamIsNull() {
            addCriterion("first_param is null");
            return (Criteria) this;
        }

        public Criteria andFirstParamIsNotNull() {
            addCriterion("first_param is not null");
            return (Criteria) this;
        }

        public Criteria andFirstParamEqualTo(Integer value) {
            addCriterion("first_param =", value, "firstParam");
            return (Criteria) this;
        }

        public Criteria andFirstParamNotEqualTo(Integer value) {
            addCriterion("first_param <>", value, "firstParam");
            return (Criteria) this;
        }

        public Criteria andFirstParamGreaterThan(Integer value) {
            addCriterion("first_param >", value, "firstParam");
            return (Criteria) this;
        }

        public Criteria andFirstParamGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_param >=", value, "firstParam");
            return (Criteria) this;
        }

        public Criteria andFirstParamLessThan(Integer value) {
            addCriterion("first_param <", value, "firstParam");
            return (Criteria) this;
        }

        public Criteria andFirstParamLessThanOrEqualTo(Integer value) {
            addCriterion("first_param <=", value, "firstParam");
            return (Criteria) this;
        }

        public Criteria andFirstParamIn(List<Integer> values) {
            addCriterion("first_param in", values, "firstParam");
            return (Criteria) this;
        }

        public Criteria andFirstParamNotIn(List<Integer> values) {
            addCriterion("first_param not in", values, "firstParam");
            return (Criteria) this;
        }

        public Criteria andFirstParamBetween(Integer value1, Integer value2) {
            addCriterion("first_param between", value1, value2, "firstParam");
            return (Criteria) this;
        }

        public Criteria andFirstParamNotBetween(Integer value1, Integer value2) {
            addCriterion("first_param not between", value1, value2, "firstParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamIsNull() {
            addCriterion("second_param is null");
            return (Criteria) this;
        }

        public Criteria andSecondParamIsNotNull() {
            addCriterion("second_param is not null");
            return (Criteria) this;
        }

        public Criteria andSecondParamEqualTo(Double value) {
            addCriterion("second_param =", value, "secondParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamNotEqualTo(Double value) {
            addCriterion("second_param <>", value, "secondParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamGreaterThan(Double value) {
            addCriterion("second_param >", value, "secondParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamGreaterThanOrEqualTo(Double value) {
            addCriterion("second_param >=", value, "secondParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamLessThan(Double value) {
            addCriterion("second_param <", value, "secondParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamLessThanOrEqualTo(Double value) {
            addCriterion("second_param <=", value, "secondParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamIn(List<Double> values) {
            addCriterion("second_param in", values, "secondParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamNotIn(List<Double> values) {
            addCriterion("second_param not in", values, "secondParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamBetween(Double value1, Double value2) {
            addCriterion("second_param between", value1, value2, "secondParam");
            return (Criteria) this;
        }

        public Criteria andSecondParamNotBetween(Double value1, Double value2) {
            addCriterion("second_param not between", value1, value2, "secondParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamIsNull() {
            addCriterion("third_param is null");
            return (Criteria) this;
        }

        public Criteria andThirdParamIsNotNull() {
            addCriterion("third_param is not null");
            return (Criteria) this;
        }

        public Criteria andThirdParamEqualTo(Integer value) {
            addCriterion("third_param =", value, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamNotEqualTo(Integer value) {
            addCriterion("third_param <>", value, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamGreaterThan(Integer value) {
            addCriterion("third_param >", value, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamGreaterThanOrEqualTo(Integer value) {
            addCriterion("third_param >=", value, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamLessThan(Integer value) {
            addCriterion("third_param <", value, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamLessThanOrEqualTo(Integer value) {
            addCriterion("third_param <=", value, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamIn(List<Integer> values) {
            addCriterion("third_param in", values, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamNotIn(List<Integer> values) {
            addCriterion("third_param not in", values, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamBetween(Integer value1, Integer value2) {
            addCriterion("third_param between", value1, value2, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andThirdParamNotBetween(Integer value1, Integer value2) {
            addCriterion("third_param not between", value1, value2, "thirdParam");
            return (Criteria) this;
        }

        public Criteria andComboIsNull() {
            addCriterion("combo is null");
            return (Criteria) this;
        }

        public Criteria andComboIsNotNull() {
            addCriterion("combo is not null");
            return (Criteria) this;
        }

        public Criteria andComboEqualTo(Integer value) {
            addCriterion("combo =", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboNotEqualTo(Integer value) {
            addCriterion("combo <>", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboGreaterThan(Integer value) {
            addCriterion("combo >", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboGreaterThanOrEqualTo(Integer value) {
            addCriterion("combo >=", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboLessThan(Integer value) {
            addCriterion("combo <", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboLessThanOrEqualTo(Integer value) {
            addCriterion("combo <=", value, "combo");
            return (Criteria) this;
        }

        public Criteria andComboIn(List<Integer> values) {
            addCriterion("combo in", values, "combo");
            return (Criteria) this;
        }

        public Criteria andComboNotIn(List<Integer> values) {
            addCriterion("combo not in", values, "combo");
            return (Criteria) this;
        }

        public Criteria andComboBetween(Integer value1, Integer value2) {
            addCriterion("combo between", value1, value2, "combo");
            return (Criteria) this;
        }

        public Criteria andComboNotBetween(Integer value1, Integer value2) {
            addCriterion("combo not between", value1, value2, "combo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}