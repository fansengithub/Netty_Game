package com.mmall.model;

import java.util.ArrayList;
import java.util.List;

public class RechargePackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RechargePackageExample() {
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

        public Criteria andRechargeMonryIsNull() {
            addCriterion("recharge_monry is null");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryIsNotNull() {
            addCriterion("recharge_monry is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryEqualTo(Long value) {
            addCriterion("recharge_monry =", value, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryNotEqualTo(Long value) {
            addCriterion("recharge_monry <>", value, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryGreaterThan(Long value) {
            addCriterion("recharge_monry >", value, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryGreaterThanOrEqualTo(Long value) {
            addCriterion("recharge_monry >=", value, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryLessThan(Long value) {
            addCriterion("recharge_monry <", value, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryLessThanOrEqualTo(Long value) {
            addCriterion("recharge_monry <=", value, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryIn(List<Long> values) {
            addCriterion("recharge_monry in", values, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryNotIn(List<Long> values) {
            addCriterion("recharge_monry not in", values, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryBetween(Long value1, Long value2) {
            addCriterion("recharge_monry between", value1, value2, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeMonryNotBetween(Long value1, Long value2) {
            addCriterion("recharge_monry not between", value1, value2, "rechargeMonry");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectIsNull() {
            addCriterion("recharge_object is null");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectIsNotNull() {
            addCriterion("recharge_object is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectEqualTo(Long value) {
            addCriterion("recharge_object =", value, "rechargeObject");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectNotEqualTo(Long value) {
            addCriterion("recharge_object <>", value, "rechargeObject");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectGreaterThan(Long value) {
            addCriterion("recharge_object >", value, "rechargeObject");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectGreaterThanOrEqualTo(Long value) {
            addCriterion("recharge_object >=", value, "rechargeObject");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectLessThan(Long value) {
            addCriterion("recharge_object <", value, "rechargeObject");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectLessThanOrEqualTo(Long value) {
            addCriterion("recharge_object <=", value, "rechargeObject");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectIn(List<Long> values) {
            addCriterion("recharge_object in", values, "rechargeObject");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectNotIn(List<Long> values) {
            addCriterion("recharge_object not in", values, "rechargeObject");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectBetween(Long value1, Long value2) {
            addCriterion("recharge_object between", value1, value2, "rechargeObject");
            return (Criteria) this;
        }

        public Criteria andRechargeObjectNotBetween(Long value1, Long value2) {
            addCriterion("recharge_object not between", value1, value2, "rechargeObject");
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