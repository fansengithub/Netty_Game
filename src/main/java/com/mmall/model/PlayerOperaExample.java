package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerOperaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayerOperaExample() {
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

        public Criteria andPlayerIdIsNull() {
            addCriterion("player_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNotNull() {
            addCriterion("player_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdEqualTo(Integer value) {
            addCriterion("player_id =", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotEqualTo(Integer value) {
            addCriterion("player_id <>", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThan(Integer value) {
            addCriterion("player_id >", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("player_id >=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThan(Integer value) {
            addCriterion("player_id <", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThanOrEqualTo(Integer value) {
            addCriterion("player_id <=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIn(List<Integer> values) {
            addCriterion("player_id in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotIn(List<Integer> values) {
            addCriterion("player_id not in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdBetween(Integer value1, Integer value2) {
            addCriterion("player_id between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("player_id not between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andOperaIdIsNull() {
            addCriterion("opera_id is null");
            return (Criteria) this;
        }

        public Criteria andOperaIdIsNotNull() {
            addCriterion("opera_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperaIdEqualTo(Integer value) {
            addCriterion("opera_id =", value, "operaId");
            return (Criteria) this;
        }

        public Criteria andOperaIdNotEqualTo(Integer value) {
            addCriterion("opera_id <>", value, "operaId");
            return (Criteria) this;
        }

        public Criteria andOperaIdGreaterThan(Integer value) {
            addCriterion("opera_id >", value, "operaId");
            return (Criteria) this;
        }

        public Criteria andOperaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("opera_id >=", value, "operaId");
            return (Criteria) this;
        }

        public Criteria andOperaIdLessThan(Integer value) {
            addCriterion("opera_id <", value, "operaId");
            return (Criteria) this;
        }

        public Criteria andOperaIdLessThanOrEqualTo(Integer value) {
            addCriterion("opera_id <=", value, "operaId");
            return (Criteria) this;
        }

        public Criteria andOperaIdIn(List<Integer> values) {
            addCriterion("opera_id in", values, "operaId");
            return (Criteria) this;
        }

        public Criteria andOperaIdNotIn(List<Integer> values) {
            addCriterion("opera_id not in", values, "operaId");
            return (Criteria) this;
        }

        public Criteria andOperaIdBetween(Integer value1, Integer value2) {
            addCriterion("opera_id between", value1, value2, "operaId");
            return (Criteria) this;
        }

        public Criteria andOperaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("opera_id not between", value1, value2, "operaId");
            return (Criteria) this;
        }

        public Criteria andPriceIdIsNull() {
            addCriterion("price_id is null");
            return (Criteria) this;
        }

        public Criteria andPriceIdIsNotNull() {
            addCriterion("price_id is not null");
            return (Criteria) this;
        }

        public Criteria andPriceIdEqualTo(Integer value) {
            addCriterion("price_id =", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdNotEqualTo(Integer value) {
            addCriterion("price_id <>", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdGreaterThan(Integer value) {
            addCriterion("price_id >", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("price_id >=", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdLessThan(Integer value) {
            addCriterion("price_id <", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdLessThanOrEqualTo(Integer value) {
            addCriterion("price_id <=", value, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdIn(List<Integer> values) {
            addCriterion("price_id in", values, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdNotIn(List<Integer> values) {
            addCriterion("price_id not in", values, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdBetween(Integer value1, Integer value2) {
            addCriterion("price_id between", value1, value2, "priceId");
            return (Criteria) this;
        }

        public Criteria andPriceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("price_id not between", value1, value2, "priceId");
            return (Criteria) this;
        }

        public Criteria andCratetimeIsNull() {
            addCriterion("cratetime is null");
            return (Criteria) this;
        }

        public Criteria andCratetimeIsNotNull() {
            addCriterion("cratetime is not null");
            return (Criteria) this;
        }

        public Criteria andCratetimeEqualTo(Date value) {
            addCriterion("cratetime =", value, "cratetime");
            return (Criteria) this;
        }

        public Criteria andCratetimeNotEqualTo(Date value) {
            addCriterion("cratetime <>", value, "cratetime");
            return (Criteria) this;
        }

        public Criteria andCratetimeGreaterThan(Date value) {
            addCriterion("cratetime >", value, "cratetime");
            return (Criteria) this;
        }

        public Criteria andCratetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cratetime >=", value, "cratetime");
            return (Criteria) this;
        }

        public Criteria andCratetimeLessThan(Date value) {
            addCriterion("cratetime <", value, "cratetime");
            return (Criteria) this;
        }

        public Criteria andCratetimeLessThanOrEqualTo(Date value) {
            addCriterion("cratetime <=", value, "cratetime");
            return (Criteria) this;
        }

        public Criteria andCratetimeIn(List<Date> values) {
            addCriterion("cratetime in", values, "cratetime");
            return (Criteria) this;
        }

        public Criteria andCratetimeNotIn(List<Date> values) {
            addCriterion("cratetime not in", values, "cratetime");
            return (Criteria) this;
        }

        public Criteria andCratetimeBetween(Date value1, Date value2) {
            addCriterion("cratetime between", value1, value2, "cratetime");
            return (Criteria) this;
        }

        public Criteria andCratetimeNotBetween(Date value1, Date value2) {
            addCriterion("cratetime not between", value1, value2, "cratetime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIsNull() {
            addCriterion("expiretime is null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIsNotNull() {
            addCriterion("expiretime is not null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeEqualTo(Date value) {
            addCriterion("expiretime =", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotEqualTo(Date value) {
            addCriterion("expiretime <>", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThan(Date value) {
            addCriterion("expiretime >", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expiretime >=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThan(Date value) {
            addCriterion("expiretime <", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThanOrEqualTo(Date value) {
            addCriterion("expiretime <=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIn(List<Date> values) {
            addCriterion("expiretime in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotIn(List<Date> values) {
            addCriterion("expiretime not in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeBetween(Date value1, Date value2) {
            addCriterion("expiretime between", value1, value2, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotBetween(Date value1, Date value2) {
            addCriterion("expiretime not between", value1, value2, "expiretime");
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