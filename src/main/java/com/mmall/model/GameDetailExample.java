package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameDetailExample() {
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

        public Criteria andPirceIsNull() {
            addCriterion("pirce is null");
            return (Criteria) this;
        }

        public Criteria andPirceIsNotNull() {
            addCriterion("pirce is not null");
            return (Criteria) this;
        }

        public Criteria andPirceEqualTo(Long value) {
            addCriterion("pirce =", value, "pirce");
            return (Criteria) this;
        }

        public Criteria andPirceNotEqualTo(Long value) {
            addCriterion("pirce <>", value, "pirce");
            return (Criteria) this;
        }

        public Criteria andPirceGreaterThan(Long value) {
            addCriterion("pirce >", value, "pirce");
            return (Criteria) this;
        }

        public Criteria andPirceGreaterThanOrEqualTo(Long value) {
            addCriterion("pirce >=", value, "pirce");
            return (Criteria) this;
        }

        public Criteria andPirceLessThan(Long value) {
            addCriterion("pirce <", value, "pirce");
            return (Criteria) this;
        }

        public Criteria andPirceLessThanOrEqualTo(Long value) {
            addCriterion("pirce <=", value, "pirce");
            return (Criteria) this;
        }

        public Criteria andPirceIn(List<Long> values) {
            addCriterion("pirce in", values, "pirce");
            return (Criteria) this;
        }

        public Criteria andPirceNotIn(List<Long> values) {
            addCriterion("pirce not in", values, "pirce");
            return (Criteria) this;
        }

        public Criteria andPirceBetween(Long value1, Long value2) {
            addCriterion("pirce between", value1, value2, "pirce");
            return (Criteria) this;
        }

        public Criteria andPirceNotBetween(Long value1, Long value2) {
            addCriterion("pirce not between", value1, value2, "pirce");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Long value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Long value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Long value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Long value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Long value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Long value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Long> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Long> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Long value1, Long value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Long value1, Long value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDicountUseIsNull() {
            addCriterion("dicount_use is null");
            return (Criteria) this;
        }

        public Criteria andDicountUseIsNotNull() {
            addCriterion("dicount_use is not null");
            return (Criteria) this;
        }

        public Criteria andDicountUseEqualTo(Integer value) {
            addCriterion("dicount_use =", value, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andDicountUseNotEqualTo(Integer value) {
            addCriterion("dicount_use <>", value, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andDicountUseGreaterThan(Integer value) {
            addCriterion("dicount_use >", value, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andDicountUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("dicount_use >=", value, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andDicountUseLessThan(Integer value) {
            addCriterion("dicount_use <", value, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andDicountUseLessThanOrEqualTo(Integer value) {
            addCriterion("dicount_use <=", value, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andDicountUseIn(List<Integer> values) {
            addCriterion("dicount_use in", values, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andDicountUseNotIn(List<Integer> values) {
            addCriterion("dicount_use not in", values, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andDicountUseBetween(Integer value1, Integer value2) {
            addCriterion("dicount_use between", value1, value2, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andDicountUseNotBetween(Integer value1, Integer value2) {
            addCriterion("dicount_use not between", value1, value2, "dicountUse");
            return (Criteria) this;
        }

        public Criteria andFreeCountIsNull() {
            addCriterion("free_count is null");
            return (Criteria) this;
        }

        public Criteria andFreeCountIsNotNull() {
            addCriterion("free_count is not null");
            return (Criteria) this;
        }

        public Criteria andFreeCountEqualTo(Integer value) {
            addCriterion("free_count =", value, "freeCount");
            return (Criteria) this;
        }

        public Criteria andFreeCountNotEqualTo(Integer value) {
            addCriterion("free_count <>", value, "freeCount");
            return (Criteria) this;
        }

        public Criteria andFreeCountGreaterThan(Integer value) {
            addCriterion("free_count >", value, "freeCount");
            return (Criteria) this;
        }

        public Criteria andFreeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_count >=", value, "freeCount");
            return (Criteria) this;
        }

        public Criteria andFreeCountLessThan(Integer value) {
            addCriterion("free_count <", value, "freeCount");
            return (Criteria) this;
        }

        public Criteria andFreeCountLessThanOrEqualTo(Integer value) {
            addCriterion("free_count <=", value, "freeCount");
            return (Criteria) this;
        }

        public Criteria andFreeCountIn(List<Integer> values) {
            addCriterion("free_count in", values, "freeCount");
            return (Criteria) this;
        }

        public Criteria andFreeCountNotIn(List<Integer> values) {
            addCriterion("free_count not in", values, "freeCount");
            return (Criteria) this;
        }

        public Criteria andFreeCountBetween(Integer value1, Integer value2) {
            addCriterion("free_count between", value1, value2, "freeCount");
            return (Criteria) this;
        }

        public Criteria andFreeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("free_count not between", value1, value2, "freeCount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPlayCountIsNull() {
            addCriterion("play_count is null");
            return (Criteria) this;
        }

        public Criteria andPlayCountIsNotNull() {
            addCriterion("play_count is not null");
            return (Criteria) this;
        }

        public Criteria andPlayCountEqualTo(Integer value) {
            addCriterion("play_count =", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotEqualTo(Integer value) {
            addCriterion("play_count <>", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountGreaterThan(Integer value) {
            addCriterion("play_count >", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("play_count >=", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountLessThan(Integer value) {
            addCriterion("play_count <", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountLessThanOrEqualTo(Integer value) {
            addCriterion("play_count <=", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountIn(List<Integer> values) {
            addCriterion("play_count in", values, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotIn(List<Integer> values) {
            addCriterion("play_count not in", values, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountBetween(Integer value1, Integer value2) {
            addCriterion("play_count between", value1, value2, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotBetween(Integer value1, Integer value2) {
            addCriterion("play_count not between", value1, value2, "playCount");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeIsNull() {
            addCriterion("last_play_time is null");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeIsNotNull() {
            addCriterion("last_play_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeEqualTo(Date value) {
            addCriterion("last_play_time =", value, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeNotEqualTo(Date value) {
            addCriterion("last_play_time <>", value, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeGreaterThan(Date value) {
            addCriterion("last_play_time >", value, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_play_time >=", value, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeLessThan(Date value) {
            addCriterion("last_play_time <", value, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_play_time <=", value, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeIn(List<Date> values) {
            addCriterion("last_play_time in", values, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeNotIn(List<Date> values) {
            addCriterion("last_play_time not in", values, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeBetween(Date value1, Date value2) {
            addCriterion("last_play_time between", value1, value2, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andLastPlayTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_play_time not between", value1, value2, "lastPlayTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeIsNull() {
            addCriterion("on_shelf_time is null");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeIsNotNull() {
            addCriterion("on_shelf_time is not null");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeEqualTo(Date value) {
            addCriterion("on_shelf_time =", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeNotEqualTo(Date value) {
            addCriterion("on_shelf_time <>", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeGreaterThan(Date value) {
            addCriterion("on_shelf_time >", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("on_shelf_time >=", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeLessThan(Date value) {
            addCriterion("on_shelf_time <", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeLessThanOrEqualTo(Date value) {
            addCriterion("on_shelf_time <=", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeIn(List<Date> values) {
            addCriterion("on_shelf_time in", values, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeNotIn(List<Date> values) {
            addCriterion("on_shelf_time not in", values, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeBetween(Date value1, Date value2) {
            addCriterion("on_shelf_time between", value1, value2, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeNotBetween(Date value1, Date value2) {
            addCriterion("on_shelf_time not between", value1, value2, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeIsNull() {
            addCriterion("off_shelf_time is null");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeIsNotNull() {
            addCriterion("off_shelf_time is not null");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeEqualTo(Date value) {
            addCriterion("off_shelf_time =", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeNotEqualTo(Date value) {
            addCriterion("off_shelf_time <>", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeGreaterThan(Date value) {
            addCriterion("off_shelf_time >", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("off_shelf_time >=", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeLessThan(Date value) {
            addCriterion("off_shelf_time <", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeLessThanOrEqualTo(Date value) {
            addCriterion("off_shelf_time <=", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeIn(List<Date> values) {
            addCriterion("off_shelf_time in", values, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeNotIn(List<Date> values) {
            addCriterion("off_shelf_time not in", values, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeBetween(Date value1, Date value2) {
            addCriterion("off_shelf_time between", value1, value2, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeNotBetween(Date value1, Date value2) {
            addCriterion("off_shelf_time not between", value1, value2, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andFounderIsNull() {
            addCriterion("founder is null");
            return (Criteria) this;
        }

        public Criteria andFounderIsNotNull() {
            addCriterion("founder is not null");
            return (Criteria) this;
        }

        public Criteria andFounderEqualTo(String value) {
            addCriterion("founder =", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderNotEqualTo(String value) {
            addCriterion("founder <>", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderGreaterThan(String value) {
            addCriterion("founder >", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderGreaterThanOrEqualTo(String value) {
            addCriterion("founder >=", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderLessThan(String value) {
            addCriterion("founder <", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderLessThanOrEqualTo(String value) {
            addCriterion("founder <=", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderLike(String value) {
            addCriterion("founder like", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderNotLike(String value) {
            addCriterion("founder not like", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderIn(List<String> values) {
            addCriterion("founder in", values, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderNotIn(List<String> values) {
            addCriterion("founder not in", values, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderBetween(String value1, String value2) {
            addCriterion("founder between", value1, value2, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderNotBetween(String value1, String value2) {
            addCriterion("founder not between", value1, value2, "founder");
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