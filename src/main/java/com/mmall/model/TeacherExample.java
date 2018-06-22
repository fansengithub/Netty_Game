package com.mmall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("work_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("work_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("work_type like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("work_type not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("work_type not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopIsNull() {
            addCriterion("belongto_piano_shop is null");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopIsNotNull() {
            addCriterion("belongto_piano_shop is not null");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopEqualTo(String value) {
            addCriterion("belongto_piano_shop =", value, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopNotEqualTo(String value) {
            addCriterion("belongto_piano_shop <>", value, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopGreaterThan(String value) {
            addCriterion("belongto_piano_shop >", value, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopGreaterThanOrEqualTo(String value) {
            addCriterion("belongto_piano_shop >=", value, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopLessThan(String value) {
            addCriterion("belongto_piano_shop <", value, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopLessThanOrEqualTo(String value) {
            addCriterion("belongto_piano_shop <=", value, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopLike(String value) {
            addCriterion("belongto_piano_shop like", value, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopNotLike(String value) {
            addCriterion("belongto_piano_shop not like", value, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopIn(List<String> values) {
            addCriterion("belongto_piano_shop in", values, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopNotIn(List<String> values) {
            addCriterion("belongto_piano_shop not in", values, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopBetween(String value1, String value2) {
            addCriterion("belongto_piano_shop between", value1, value2, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopNotBetween(String value1, String value2) {
            addCriterion("belongto_piano_shop not between", value1, value2, "belongtoPianoShop");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidIsNull() {
            addCriterion("belongto_piano_shopID is null");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidIsNotNull() {
            addCriterion("belongto_piano_shopID is not null");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidEqualTo(Integer value) {
            addCriterion("belongto_piano_shopID =", value, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidNotEqualTo(Integer value) {
            addCriterion("belongto_piano_shopID <>", value, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidGreaterThan(Integer value) {
            addCriterion("belongto_piano_shopID >", value, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidGreaterThanOrEqualTo(Integer value) {
            addCriterion("belongto_piano_shopID >=", value, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidLessThan(Integer value) {
            addCriterion("belongto_piano_shopID <", value, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidLessThanOrEqualTo(Integer value) {
            addCriterion("belongto_piano_shopID <=", value, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidIn(List<Integer> values) {
            addCriterion("belongto_piano_shopID in", values, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidNotIn(List<Integer> values) {
            addCriterion("belongto_piano_shopID not in", values, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidBetween(Integer value1, Integer value2) {
            addCriterion("belongto_piano_shopID between", value1, value2, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andBelongtoPianoShopidNotBetween(Integer value1, Integer value2) {
            addCriterion("belongto_piano_shopID not between", value1, value2, "belongtoPianoShopid");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andMemberLevelIsNull() {
            addCriterion("member_level is null");
            return (Criteria) this;
        }

        public Criteria andMemberLevelIsNotNull() {
            addCriterion("member_level is not null");
            return (Criteria) this;
        }

        public Criteria andMemberLevelEqualTo(Integer value) {
            addCriterion("member_level =", value, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andMemberLevelNotEqualTo(Integer value) {
            addCriterion("member_level <>", value, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andMemberLevelGreaterThan(Integer value) {
            addCriterion("member_level >", value, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andMemberLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_level >=", value, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andMemberLevelLessThan(Integer value) {
            addCriterion("member_level <", value, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andMemberLevelLessThanOrEqualTo(Integer value) {
            addCriterion("member_level <=", value, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andMemberLevelIn(List<Integer> values) {
            addCriterion("member_level in", values, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andMemberLevelNotIn(List<Integer> values) {
            addCriterion("member_level not in", values, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andMemberLevelBetween(Integer value1, Integer value2) {
            addCriterion("member_level between", value1, value2, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andMemberLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("member_level not between", value1, value2, "memberLevel");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(BigDecimal value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(BigDecimal value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(BigDecimal value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(BigDecimal value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<BigDecimal> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<BigDecimal> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRemindIsNull() {
            addCriterion("remind is null");
            return (Criteria) this;
        }

        public Criteria andRemindIsNotNull() {
            addCriterion("remind is not null");
            return (Criteria) this;
        }

        public Criteria andRemindEqualTo(Integer value) {
            addCriterion("remind =", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindNotEqualTo(Integer value) {
            addCriterion("remind <>", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindGreaterThan(Integer value) {
            addCriterion("remind >", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindGreaterThanOrEqualTo(Integer value) {
            addCriterion("remind >=", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindLessThan(Integer value) {
            addCriterion("remind <", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindLessThanOrEqualTo(Integer value) {
            addCriterion("remind <=", value, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindIn(List<Integer> values) {
            addCriterion("remind in", values, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindNotIn(List<Integer> values) {
            addCriterion("remind not in", values, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindBetween(Integer value1, Integer value2) {
            addCriterion("remind between", value1, value2, "remind");
            return (Criteria) this;
        }

        public Criteria andRemindNotBetween(Integer value1, Integer value2) {
            addCriterion("remind not between", value1, value2, "remind");
            return (Criteria) this;
        }

        public Criteria andRechargeIsNull() {
            addCriterion("recharge is null");
            return (Criteria) this;
        }

        public Criteria andRechargeIsNotNull() {
            addCriterion("recharge is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeEqualTo(BigDecimal value) {
            addCriterion("recharge =", value, "recharge");
            return (Criteria) this;
        }

        public Criteria andRechargeNotEqualTo(BigDecimal value) {
            addCriterion("recharge <>", value, "recharge");
            return (Criteria) this;
        }

        public Criteria andRechargeGreaterThan(BigDecimal value) {
            addCriterion("recharge >", value, "recharge");
            return (Criteria) this;
        }

        public Criteria andRechargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge >=", value, "recharge");
            return (Criteria) this;
        }

        public Criteria andRechargeLessThan(BigDecimal value) {
            addCriterion("recharge <", value, "recharge");
            return (Criteria) this;
        }

        public Criteria andRechargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge <=", value, "recharge");
            return (Criteria) this;
        }

        public Criteria andRechargeIn(List<BigDecimal> values) {
            addCriterion("recharge in", values, "recharge");
            return (Criteria) this;
        }

        public Criteria andRechargeNotIn(List<BigDecimal> values) {
            addCriterion("recharge not in", values, "recharge");
            return (Criteria) this;
        }

        public Criteria andRechargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge between", value1, value2, "recharge");
            return (Criteria) this;
        }

        public Criteria andRechargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge not between", value1, value2, "recharge");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherIsNull() {
            addCriterion("is_default_teacher is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherIsNotNull() {
            addCriterion("is_default_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherEqualTo(Integer value) {
            addCriterion("is_default_teacher =", value, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherNotEqualTo(Integer value) {
            addCriterion("is_default_teacher <>", value, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherGreaterThan(Integer value) {
            addCriterion("is_default_teacher >", value, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_default_teacher >=", value, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherLessThan(Integer value) {
            addCriterion("is_default_teacher <", value, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherLessThanOrEqualTo(Integer value) {
            addCriterion("is_default_teacher <=", value, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherIn(List<Integer> values) {
            addCriterion("is_default_teacher in", values, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherNotIn(List<Integer> values) {
            addCriterion("is_default_teacher not in", values, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherBetween(Integer value1, Integer value2) {
            addCriterion("is_default_teacher between", value1, value2, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andIsDefaultTeacherNotBetween(Integer value1, Integer value2) {
            addCriterion("is_default_teacher not between", value1, value2, "isDefaultTeacher");
            return (Criteria) this;
        }

        public Criteria andGameScoreIsNull() {
            addCriterion("game_score is null");
            return (Criteria) this;
        }

        public Criteria andGameScoreIsNotNull() {
            addCriterion("game_score is not null");
            return (Criteria) this;
        }

        public Criteria andGameScoreEqualTo(BigDecimal value) {
            addCriterion("game_score =", value, "gameScore");
            return (Criteria) this;
        }

        public Criteria andGameScoreNotEqualTo(BigDecimal value) {
            addCriterion("game_score <>", value, "gameScore");
            return (Criteria) this;
        }

        public Criteria andGameScoreGreaterThan(BigDecimal value) {
            addCriterion("game_score >", value, "gameScore");
            return (Criteria) this;
        }

        public Criteria andGameScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("game_score >=", value, "gameScore");
            return (Criteria) this;
        }

        public Criteria andGameScoreLessThan(BigDecimal value) {
            addCriterion("game_score <", value, "gameScore");
            return (Criteria) this;
        }

        public Criteria andGameScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("game_score <=", value, "gameScore");
            return (Criteria) this;
        }

        public Criteria andGameScoreIn(List<BigDecimal> values) {
            addCriterion("game_score in", values, "gameScore");
            return (Criteria) this;
        }

        public Criteria andGameScoreNotIn(List<BigDecimal> values) {
            addCriterion("game_score not in", values, "gameScore");
            return (Criteria) this;
        }

        public Criteria andGameScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("game_score between", value1, value2, "gameScore");
            return (Criteria) this;
        }

        public Criteria andGameScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("game_score not between", value1, value2, "gameScore");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureIsNull() {
            addCriterion("IDcard_picture is null");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureIsNotNull() {
            addCriterion("IDcard_picture is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureEqualTo(String value) {
            addCriterion("IDcard_picture =", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureNotEqualTo(String value) {
            addCriterion("IDcard_picture <>", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureGreaterThan(String value) {
            addCriterion("IDcard_picture >", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureGreaterThanOrEqualTo(String value) {
            addCriterion("IDcard_picture >=", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureLessThan(String value) {
            addCriterion("IDcard_picture <", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureLessThanOrEqualTo(String value) {
            addCriterion("IDcard_picture <=", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureLike(String value) {
            addCriterion("IDcard_picture like", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureNotLike(String value) {
            addCriterion("IDcard_picture not like", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureIn(List<String> values) {
            addCriterion("IDcard_picture in", values, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureNotIn(List<String> values) {
            addCriterion("IDcard_picture not in", values, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureBetween(String value1, String value2) {
            addCriterion("IDcard_picture between", value1, value2, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureNotBetween(String value1, String value2) {
            addCriterion("IDcard_picture not between", value1, value2, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceIsNull() {
            addCriterion("withdraw_balance is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceIsNotNull() {
            addCriterion("withdraw_balance is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceEqualTo(BigDecimal value) {
            addCriterion("withdraw_balance =", value, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceNotEqualTo(BigDecimal value) {
            addCriterion("withdraw_balance <>", value, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceGreaterThan(BigDecimal value) {
            addCriterion("withdraw_balance >", value, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_balance >=", value, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceLessThan(BigDecimal value) {
            addCriterion("withdraw_balance <", value, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_balance <=", value, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceIn(List<BigDecimal> values) {
            addCriterion("withdraw_balance in", values, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceNotIn(List<BigDecimal> values) {
            addCriterion("withdraw_balance not in", values, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_balance between", value1, value2, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_balance not between", value1, value2, "withdrawBalance");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateIsNull() {
            addCriterion("divide_money_rate is null");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateIsNotNull() {
            addCriterion("divide_money_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateEqualTo(BigDecimal value) {
            addCriterion("divide_money_rate =", value, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateNotEqualTo(BigDecimal value) {
            addCriterion("divide_money_rate <>", value, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateGreaterThan(BigDecimal value) {
            addCriterion("divide_money_rate >", value, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("divide_money_rate >=", value, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateLessThan(BigDecimal value) {
            addCriterion("divide_money_rate <", value, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("divide_money_rate <=", value, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateIn(List<BigDecimal> values) {
            addCriterion("divide_money_rate in", values, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateNotIn(List<BigDecimal> values) {
            addCriterion("divide_money_rate not in", values, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("divide_money_rate between", value1, value2, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("divide_money_rate not between", value1, value2, "divideMoneyRate");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeIsNull() {
            addCriterion("divide_money_income is null");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeIsNotNull() {
            addCriterion("divide_money_income is not null");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeEqualTo(BigDecimal value) {
            addCriterion("divide_money_income =", value, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeNotEqualTo(BigDecimal value) {
            addCriterion("divide_money_income <>", value, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeGreaterThan(BigDecimal value) {
            addCriterion("divide_money_income >", value, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("divide_money_income >=", value, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeLessThan(BigDecimal value) {
            addCriterion("divide_money_income <", value, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("divide_money_income <=", value, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeIn(List<BigDecimal> values) {
            addCriterion("divide_money_income in", values, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeNotIn(List<BigDecimal> values) {
            addCriterion("divide_money_income not in", values, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("divide_money_income between", value1, value2, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andDivideMoneyIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("divide_money_income not between", value1, value2, "divideMoneyIncome");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeIsNull() {
            addCriterion("member_time is null");
            return (Criteria) this;
        }

        public Criteria andMemberTimeIsNotNull() {
            addCriterion("member_time is not null");
            return (Criteria) this;
        }

        public Criteria andMemberTimeEqualTo(Date value) {
            addCriterion("member_time =", value, "memberTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeNotEqualTo(Date value) {
            addCriterion("member_time <>", value, "memberTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeGreaterThan(Date value) {
            addCriterion("member_time >", value, "memberTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("member_time >=", value, "memberTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeLessThan(Date value) {
            addCriterion("member_time <", value, "memberTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeLessThanOrEqualTo(Date value) {
            addCriterion("member_time <=", value, "memberTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeIn(List<Date> values) {
            addCriterion("member_time in", values, "memberTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeNotIn(List<Date> values) {
            addCriterion("member_time not in", values, "memberTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeBetween(Date value1, Date value2) {
            addCriterion("member_time between", value1, value2, "memberTime");
            return (Criteria) this;
        }

        public Criteria andMemberTimeNotBetween(Date value1, Date value2) {
            addCriterion("member_time not between", value1, value2, "memberTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeIsNull() {
            addCriterion("examine_time is null");
            return (Criteria) this;
        }

        public Criteria andExamineTimeIsNotNull() {
            addCriterion("examine_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamineTimeEqualTo(Date value) {
            addCriterion("examine_time =", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeNotEqualTo(Date value) {
            addCriterion("examine_time <>", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeGreaterThan(Date value) {
            addCriterion("examine_time >", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("examine_time >=", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeLessThan(Date value) {
            addCriterion("examine_time <", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeLessThanOrEqualTo(Date value) {
            addCriterion("examine_time <=", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeIn(List<Date> values) {
            addCriterion("examine_time in", values, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeNotIn(List<Date> values) {
            addCriterion("examine_time not in", values, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeBetween(Date value1, Date value2) {
            addCriterion("examine_time between", value1, value2, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeNotBetween(Date value1, Date value2) {
            addCriterion("examine_time not between", value1, value2, "examineTime");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("auditor like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("auditor not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNull() {
            addCriterion("work_place is null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIsNotNull() {
            addCriterion("work_place is not null");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceEqualTo(String value) {
            addCriterion("work_place =", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotEqualTo(String value) {
            addCriterion("work_place <>", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThan(String value) {
            addCriterion("work_place >", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("work_place >=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThan(String value) {
            addCriterion("work_place <", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLessThanOrEqualTo(String value) {
            addCriterion("work_place <=", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceLike(String value) {
            addCriterion("work_place like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotLike(String value) {
            addCriterion("work_place not like", value, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceIn(List<String> values) {
            addCriterion("work_place in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotIn(List<String> values) {
            addCriterion("work_place not in", values, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceBetween(String value1, String value2) {
            addCriterion("work_place between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andWorkPlaceNotBetween(String value1, String value2) {
            addCriterion("work_place not between", value1, value2, "workPlace");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNull() {
            addCriterion("head_url is null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNotNull() {
            addCriterion("head_url is not null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlEqualTo(String value) {
            addCriterion("head_url =", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotEqualTo(String value) {
            addCriterion("head_url <>", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThan(String value) {
            addCriterion("head_url >", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("head_url >=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThan(String value) {
            addCriterion("head_url <", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("head_url <=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLike(String value) {
            addCriterion("head_url like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotLike(String value) {
            addCriterion("head_url not like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIn(List<String> values) {
            addCriterion("head_url in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotIn(List<String> values) {
            addCriterion("head_url not in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlBetween(String value1, String value2) {
            addCriterion("head_url between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotBetween(String value1, String value2) {
            addCriterion("head_url not between", value1, value2, "headUrl");
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