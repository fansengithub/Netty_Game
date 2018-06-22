package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CountRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CountRecordExample() {
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

        public Criteria andCountTimeIsNull() {
            addCriterion("count_time is null");
            return (Criteria) this;
        }

        public Criteria andCountTimeIsNotNull() {
            addCriterion("count_time is not null");
            return (Criteria) this;
        }

        public Criteria andCountTimeEqualTo(String value) {
            addCriterion("count_time =", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotEqualTo(String value) {
            addCriterion("count_time <>", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeGreaterThan(String value) {
            addCriterion("count_time >", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeGreaterThanOrEqualTo(String value) {
            addCriterion("count_time >=", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeLessThan(String value) {
            addCriterion("count_time <", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeLessThanOrEqualTo(String value) {
            addCriterion("count_time <=", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeLike(String value) {
            addCriterion("count_time like", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotLike(String value) {
            addCriterion("count_time not like", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeIn(List<String> values) {
            addCriterion("count_time in", values, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotIn(List<String> values) {
            addCriterion("count_time not in", values, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeBetween(String value1, String value2) {
            addCriterion("count_time between", value1, value2, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotBetween(String value1, String value2) {
            addCriterion("count_time not between", value1, value2, "countTime");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedIsNull() {
            addCriterion("counter_speed is null");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedIsNotNull() {
            addCriterion("counter_speed is not null");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedEqualTo(String value) {
            addCriterion("counter_speed =", value, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedNotEqualTo(String value) {
            addCriterion("counter_speed <>", value, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedGreaterThan(String value) {
            addCriterion("counter_speed >", value, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("counter_speed >=", value, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedLessThan(String value) {
            addCriterion("counter_speed <", value, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedLessThanOrEqualTo(String value) {
            addCriterion("counter_speed <=", value, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedLike(String value) {
            addCriterion("counter_speed like", value, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedNotLike(String value) {
            addCriterion("counter_speed not like", value, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedIn(List<String> values) {
            addCriterion("counter_speed in", values, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedNotIn(List<String> values) {
            addCriterion("counter_speed not in", values, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedBetween(String value1, String value2) {
            addCriterion("counter_speed between", value1, value2, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterSpeedNotBetween(String value1, String value2) {
            addCriterion("counter_speed not between", value1, value2, "counterSpeed");
            return (Criteria) this;
        }

        public Criteria andCounterCountIsNull() {
            addCriterion("counter_count is null");
            return (Criteria) this;
        }

        public Criteria andCounterCountIsNotNull() {
            addCriterion("counter_count is not null");
            return (Criteria) this;
        }

        public Criteria andCounterCountEqualTo(Integer value) {
            addCriterion("counter_count =", value, "counterCount");
            return (Criteria) this;
        }

        public Criteria andCounterCountNotEqualTo(Integer value) {
            addCriterion("counter_count <>", value, "counterCount");
            return (Criteria) this;
        }

        public Criteria andCounterCountGreaterThan(Integer value) {
            addCriterion("counter_count >", value, "counterCount");
            return (Criteria) this;
        }

        public Criteria andCounterCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("counter_count >=", value, "counterCount");
            return (Criteria) this;
        }

        public Criteria andCounterCountLessThan(Integer value) {
            addCriterion("counter_count <", value, "counterCount");
            return (Criteria) this;
        }

        public Criteria andCounterCountLessThanOrEqualTo(Integer value) {
            addCriterion("counter_count <=", value, "counterCount");
            return (Criteria) this;
        }

        public Criteria andCounterCountIn(List<Integer> values) {
            addCriterion("counter_count in", values, "counterCount");
            return (Criteria) this;
        }

        public Criteria andCounterCountNotIn(List<Integer> values) {
            addCriterion("counter_count not in", values, "counterCount");
            return (Criteria) this;
        }

        public Criteria andCounterCountBetween(Integer value1, Integer value2) {
            addCriterion("counter_count between", value1, value2, "counterCount");
            return (Criteria) this;
        }

        public Criteria andCounterCountNotBetween(Integer value1, Integer value2) {
            addCriterion("counter_count not between", value1, value2, "counterCount");
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