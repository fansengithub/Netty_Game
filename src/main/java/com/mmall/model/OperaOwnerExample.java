package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperaOwnerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperaOwnerExample() {
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

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(Integer value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(Integer value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(Integer value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(Integer value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<Integer> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<Integer> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeIsNull() {
            addCriterion("expiry_time is null");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeIsNotNull() {
            addCriterion("expiry_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeEqualTo(Date value) {
            addCriterion("expiry_time =", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeNotEqualTo(Date value) {
            addCriterion("expiry_time <>", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeGreaterThan(Date value) {
            addCriterion("expiry_time >", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expiry_time >=", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeLessThan(Date value) {
            addCriterion("expiry_time <", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeLessThanOrEqualTo(Date value) {
            addCriterion("expiry_time <=", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeIn(List<Date> values) {
            addCriterion("expiry_time in", values, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeNotIn(List<Date> values) {
            addCriterion("expiry_time not in", values, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeBetween(Date value1, Date value2) {
            addCriterion("expiry_time between", value1, value2, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeNotBetween(Date value1, Date value2) {
            addCriterion("expiry_time not between", value1, value2, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIsNull() {
            addCriterion("classify_id is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIsNotNull() {
            addCriterion("classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyIdEqualTo(Integer value) {
            addCriterion("classify_id =", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotEqualTo(Integer value) {
            addCriterion("classify_id <>", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdGreaterThan(Integer value) {
            addCriterion("classify_id >", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("classify_id >=", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdLessThan(Integer value) {
            addCriterion("classify_id <", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdLessThanOrEqualTo(Integer value) {
            addCriterion("classify_id <=", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIn(List<Integer> values) {
            addCriterion("classify_id in", values, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotIn(List<Integer> values) {
            addCriterion("classify_id not in", values, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdBetween(Integer value1, Integer value2) {
            addCriterion("classify_id between", value1, value2, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("classify_id not between", value1, value2, "classifyId");
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