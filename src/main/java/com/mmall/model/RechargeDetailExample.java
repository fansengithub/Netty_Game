package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RechargeDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RechargeDetailExample() {
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

        public Criteria andTradNoIsNull() {
            addCriterion("trad_no is null");
            return (Criteria) this;
        }

        public Criteria andTradNoIsNotNull() {
            addCriterion("trad_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradNoEqualTo(String value) {
            addCriterion("trad_no =", value, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoNotEqualTo(String value) {
            addCriterion("trad_no <>", value, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoGreaterThan(String value) {
            addCriterion("trad_no >", value, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoGreaterThanOrEqualTo(String value) {
            addCriterion("trad_no >=", value, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoLessThan(String value) {
            addCriterion("trad_no <", value, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoLessThanOrEqualTo(String value) {
            addCriterion("trad_no <=", value, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoLike(String value) {
            addCriterion("trad_no like", value, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoNotLike(String value) {
            addCriterion("trad_no not like", value, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoIn(List<String> values) {
            addCriterion("trad_no in", values, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoNotIn(List<String> values) {
            addCriterion("trad_no not in", values, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoBetween(String value1, String value2) {
            addCriterion("trad_no between", value1, value2, "tradNo");
            return (Criteria) this;
        }

        public Criteria andTradNoNotBetween(String value1, String value2) {
            addCriterion("trad_no not between", value1, value2, "tradNo");
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

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("role like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("role not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeIsNull() {
            addCriterion("before_recharge is null");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeIsNotNull() {
            addCriterion("before_recharge is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeEqualTo(Long value) {
            addCriterion("before_recharge =", value, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeNotEqualTo(Long value) {
            addCriterion("before_recharge <>", value, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeGreaterThan(Long value) {
            addCriterion("before_recharge >", value, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeGreaterThanOrEqualTo(Long value) {
            addCriterion("before_recharge >=", value, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeLessThan(Long value) {
            addCriterion("before_recharge <", value, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeLessThanOrEqualTo(Long value) {
            addCriterion("before_recharge <=", value, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeIn(List<Long> values) {
            addCriterion("before_recharge in", values, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeNotIn(List<Long> values) {
            addCriterion("before_recharge not in", values, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeBetween(Long value1, Long value2) {
            addCriterion("before_recharge between", value1, value2, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andBeforeRechargeNotBetween(Long value1, Long value2) {
            addCriterion("before_recharge not between", value1, value2, "beforeRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeIsNull() {
            addCriterion("after_recharge is null");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeIsNotNull() {
            addCriterion("after_recharge is not null");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeEqualTo(Long value) {
            addCriterion("after_recharge =", value, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeNotEqualTo(Long value) {
            addCriterion("after_recharge <>", value, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeGreaterThan(Long value) {
            addCriterion("after_recharge >", value, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeGreaterThanOrEqualTo(Long value) {
            addCriterion("after_recharge >=", value, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeLessThan(Long value) {
            addCriterion("after_recharge <", value, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeLessThanOrEqualTo(Long value) {
            addCriterion("after_recharge <=", value, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeIn(List<Long> values) {
            addCriterion("after_recharge in", values, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeNotIn(List<Long> values) {
            addCriterion("after_recharge not in", values, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeBetween(Long value1, Long value2) {
            addCriterion("after_recharge between", value1, value2, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andAfterRechargeNotBetween(Long value1, Long value2) {
            addCriterion("after_recharge not between", value1, value2, "afterRecharge");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyIsNull() {
            addCriterion("recharge_money is null");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyIsNotNull() {
            addCriterion("recharge_money is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyEqualTo(Long value) {
            addCriterion("recharge_money =", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyNotEqualTo(Long value) {
            addCriterion("recharge_money <>", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyGreaterThan(Long value) {
            addCriterion("recharge_money >", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyGreaterThanOrEqualTo(Long value) {
            addCriterion("recharge_money >=", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyLessThan(Long value) {
            addCriterion("recharge_money <", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyLessThanOrEqualTo(Long value) {
            addCriterion("recharge_money <=", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyIn(List<Long> values) {
            addCriterion("recharge_money in", values, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyNotIn(List<Long> values) {
            addCriterion("recharge_money not in", values, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyBetween(Long value1, Long value2) {
            addCriterion("recharge_money between", value1, value2, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyNotBetween(Long value1, Long value2) {
            addCriterion("recharge_money not between", value1, value2, "rechargeMoney");
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

        public Criteria andRechargeTypeIsNull() {
            addCriterion("recharge_type is null");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeIsNotNull() {
            addCriterion("recharge_type is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeEqualTo(Integer value) {
            addCriterion("recharge_type =", value, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeNotEqualTo(Integer value) {
            addCriterion("recharge_type <>", value, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeGreaterThan(Integer value) {
            addCriterion("recharge_type >", value, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("recharge_type >=", value, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeLessThan(Integer value) {
            addCriterion("recharge_type <", value, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("recharge_type <=", value, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeIn(List<Integer> values) {
            addCriterion("recharge_type in", values, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeNotIn(List<Integer> values) {
            addCriterion("recharge_type not in", values, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeBetween(Integer value1, Integer value2) {
            addCriterion("recharge_type between", value1, value2, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("recharge_type not between", value1, value2, "rechargeType");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeIsNull() {
            addCriterion("recharge_time is null");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeIsNotNull() {
            addCriterion("recharge_time is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeEqualTo(Date value) {
            addCriterion("recharge_time =", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeNotEqualTo(Date value) {
            addCriterion("recharge_time <>", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeGreaterThan(Date value) {
            addCriterion("recharge_time >", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recharge_time >=", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeLessThan(Date value) {
            addCriterion("recharge_time <", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeLessThanOrEqualTo(Date value) {
            addCriterion("recharge_time <=", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeIn(List<Date> values) {
            addCriterion("recharge_time in", values, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeNotIn(List<Date> values) {
            addCriterion("recharge_time not in", values, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeBetween(Date value1, Date value2) {
            addCriterion("recharge_time between", value1, value2, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeNotBetween(Date value1, Date value2) {
            addCriterion("recharge_time not between", value1, value2, "rechargeTime");
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