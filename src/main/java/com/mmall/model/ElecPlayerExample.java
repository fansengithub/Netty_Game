package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ElecPlayerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ElecPlayerExample() {
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

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andIsQiyongIsNull() {
            addCriterion("is_qiyong is null");
            return (Criteria) this;
        }

        public Criteria andIsQiyongIsNotNull() {
            addCriterion("is_qiyong is not null");
            return (Criteria) this;
        }

        public Criteria andIsQiyongEqualTo(Integer value) {
            addCriterion("is_qiyong =", value, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsQiyongNotEqualTo(Integer value) {
            addCriterion("is_qiyong <>", value, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsQiyongGreaterThan(Integer value) {
            addCriterion("is_qiyong >", value, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsQiyongGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_qiyong >=", value, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsQiyongLessThan(Integer value) {
            addCriterion("is_qiyong <", value, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsQiyongLessThanOrEqualTo(Integer value) {
            addCriterion("is_qiyong <=", value, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsQiyongIn(List<Integer> values) {
            addCriterion("is_qiyong in", values, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsQiyongNotIn(List<Integer> values) {
            addCriterion("is_qiyong not in", values, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsQiyongBetween(Integer value1, Integer value2) {
            addCriterion("is_qiyong between", value1, value2, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsQiyongNotBetween(Integer value1, Integer value2) {
            addCriterion("is_qiyong not between", value1, value2, "isQiyong");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicIsNull() {
            addCriterion("is_lookallMusic is null");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicIsNotNull() {
            addCriterion("is_lookallMusic is not null");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicEqualTo(Integer value) {
            addCriterion("is_lookallMusic =", value, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicNotEqualTo(Integer value) {
            addCriterion("is_lookallMusic <>", value, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicGreaterThan(Integer value) {
            addCriterion("is_lookallMusic >", value, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_lookallMusic >=", value, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicLessThan(Integer value) {
            addCriterion("is_lookallMusic <", value, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicLessThanOrEqualTo(Integer value) {
            addCriterion("is_lookallMusic <=", value, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicIn(List<Integer> values) {
            addCriterion("is_lookallMusic in", values, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicNotIn(List<Integer> values) {
            addCriterion("is_lookallMusic not in", values, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicBetween(Integer value1, Integer value2) {
            addCriterion("is_lookallMusic between", value1, value2, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andIsLookallmusicNotBetween(Integer value1, Integer value2) {
            addCriterion("is_lookallMusic not between", value1, value2, "isLookallmusic");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBrithdayIsNull() {
            addCriterion("brithday is null");
            return (Criteria) this;
        }

        public Criteria andBrithdayIsNotNull() {
            addCriterion("brithday is not null");
            return (Criteria) this;
        }

        public Criteria andBrithdayEqualTo(String value) {
            addCriterion("brithday =", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotEqualTo(String value) {
            addCriterion("brithday <>", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayGreaterThan(String value) {
            addCriterion("brithday >", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayGreaterThanOrEqualTo(String value) {
            addCriterion("brithday >=", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayLessThan(String value) {
            addCriterion("brithday <", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayLessThanOrEqualTo(String value) {
            addCriterion("brithday <=", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayLike(String value) {
            addCriterion("brithday like", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotLike(String value) {
            addCriterion("brithday not like", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayIn(List<String> values) {
            addCriterion("brithday in", values, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotIn(List<String> values) {
            addCriterion("brithday not in", values, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayBetween(String value1, String value2) {
            addCriterion("brithday between", value1, value2, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotBetween(String value1, String value2) {
            addCriterion("brithday not between", value1, value2, "brithday");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNull() {
            addCriterion("role_type is null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNotNull() {
            addCriterion("role_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeEqualTo(Integer value) {
            addCriterion("role_type =", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotEqualTo(Integer value) {
            addCriterion("role_type <>", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThan(Integer value) {
            addCriterion("role_type >", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_type >=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThan(Integer value) {
            addCriterion("role_type <", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("role_type <=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIn(List<Integer> values) {
            addCriterion("role_type in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotIn(List<Integer> values) {
            addCriterion("role_type not in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeBetween(Integer value1, Integer value2) {
            addCriterion("role_type between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("role_type not between", value1, value2, "roleType");
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andXiongzhangIsNull() {
            addCriterion("xiongzhang is null");
            return (Criteria) this;
        }

        public Criteria andXiongzhangIsNotNull() {
            addCriterion("xiongzhang is not null");
            return (Criteria) this;
        }

        public Criteria andXiongzhangEqualTo(Integer value) {
            addCriterion("xiongzhang =", value, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andXiongzhangNotEqualTo(Integer value) {
            addCriterion("xiongzhang <>", value, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andXiongzhangGreaterThan(Integer value) {
            addCriterion("xiongzhang >", value, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andXiongzhangGreaterThanOrEqualTo(Integer value) {
            addCriterion("xiongzhang >=", value, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andXiongzhangLessThan(Integer value) {
            addCriterion("xiongzhang <", value, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andXiongzhangLessThanOrEqualTo(Integer value) {
            addCriterion("xiongzhang <=", value, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andXiongzhangIn(List<Integer> values) {
            addCriterion("xiongzhang in", values, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andXiongzhangNotIn(List<Integer> values) {
            addCriterion("xiongzhang not in", values, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andXiongzhangBetween(Integer value1, Integer value2) {
            addCriterion("xiongzhang between", value1, value2, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andXiongzhangNotBetween(Integer value1, Integer value2) {
            addCriterion("xiongzhang not between", value1, value2, "xiongzhang");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(String value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(String value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(String value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(String value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(String value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(String value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLike(String value) {
            addCriterion("rank like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotLike(String value) {
            addCriterion("rank not like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<String> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<String> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(String value1, String value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(String value1, String value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andWxOpenidIsNull() {
            addCriterion("wx_openid is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIsNotNull() {
            addCriterion("wx_openid is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenidEqualTo(String value) {
            addCriterion("wx_openid =", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotEqualTo(String value) {
            addCriterion("wx_openid <>", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThan(String value) {
            addCriterion("wx_openid >", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_openid >=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThan(String value) {
            addCriterion("wx_openid <", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLessThanOrEqualTo(String value) {
            addCriterion("wx_openid <=", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidLike(String value) {
            addCriterion("wx_openid like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotLike(String value) {
            addCriterion("wx_openid not like", value, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidIn(List<String> values) {
            addCriterion("wx_openid in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotIn(List<String> values) {
            addCriterion("wx_openid not in", values, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidBetween(String value1, String value2) {
            addCriterion("wx_openid between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxOpenidNotBetween(String value1, String value2) {
            addCriterion("wx_openid not between", value1, value2, "wxOpenid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidIsNull() {
            addCriterion("wx_unionid is null");
            return (Criteria) this;
        }

        public Criteria andWxUnionidIsNotNull() {
            addCriterion("wx_unionid is not null");
            return (Criteria) this;
        }

        public Criteria andWxUnionidEqualTo(String value) {
            addCriterion("wx_unionid =", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotEqualTo(String value) {
            addCriterion("wx_unionid <>", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidGreaterThan(String value) {
            addCriterion("wx_unionid >", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_unionid >=", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidLessThan(String value) {
            addCriterion("wx_unionid <", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidLessThanOrEqualTo(String value) {
            addCriterion("wx_unionid <=", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidLike(String value) {
            addCriterion("wx_unionid like", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotLike(String value) {
            addCriterion("wx_unionid not like", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidIn(List<String> values) {
            addCriterion("wx_unionid in", values, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotIn(List<String> values) {
            addCriterion("wx_unionid not in", values, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidBetween(String value1, String value2) {
            addCriterion("wx_unionid between", value1, value2, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotBetween(String value1, String value2) {
            addCriterion("wx_unionid not between", value1, value2, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxHeadIsNull() {
            addCriterion("wx_head is null");
            return (Criteria) this;
        }

        public Criteria andWxHeadIsNotNull() {
            addCriterion("wx_head is not null");
            return (Criteria) this;
        }

        public Criteria andWxHeadEqualTo(String value) {
            addCriterion("wx_head =", value, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadNotEqualTo(String value) {
            addCriterion("wx_head <>", value, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadGreaterThan(String value) {
            addCriterion("wx_head >", value, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadGreaterThanOrEqualTo(String value) {
            addCriterion("wx_head >=", value, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadLessThan(String value) {
            addCriterion("wx_head <", value, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadLessThanOrEqualTo(String value) {
            addCriterion("wx_head <=", value, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadLike(String value) {
            addCriterion("wx_head like", value, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadNotLike(String value) {
            addCriterion("wx_head not like", value, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadIn(List<String> values) {
            addCriterion("wx_head in", values, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadNotIn(List<String> values) {
            addCriterion("wx_head not in", values, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadBetween(String value1, String value2) {
            addCriterion("wx_head between", value1, value2, "wxHead");
            return (Criteria) this;
        }

        public Criteria andWxHeadNotBetween(String value1, String value2) {
            addCriterion("wx_head not between", value1, value2, "wxHead");
            return (Criteria) this;
        }

        public Criteria andQqOpenidIsNull() {
            addCriterion("qq_openid is null");
            return (Criteria) this;
        }

        public Criteria andQqOpenidIsNotNull() {
            addCriterion("qq_openid is not null");
            return (Criteria) this;
        }

        public Criteria andQqOpenidEqualTo(String value) {
            addCriterion("qq_openid =", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotEqualTo(String value) {
            addCriterion("qq_openid <>", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidGreaterThan(String value) {
            addCriterion("qq_openid >", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("qq_openid >=", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidLessThan(String value) {
            addCriterion("qq_openid <", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidLessThanOrEqualTo(String value) {
            addCriterion("qq_openid <=", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidLike(String value) {
            addCriterion("qq_openid like", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotLike(String value) {
            addCriterion("qq_openid not like", value, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidIn(List<String> values) {
            addCriterion("qq_openid in", values, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotIn(List<String> values) {
            addCriterion("qq_openid not in", values, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidBetween(String value1, String value2) {
            addCriterion("qq_openid between", value1, value2, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqOpenidNotBetween(String value1, String value2) {
            addCriterion("qq_openid not between", value1, value2, "qqOpenid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidIsNull() {
            addCriterion("qq_unionid is null");
            return (Criteria) this;
        }

        public Criteria andQqUnionidIsNotNull() {
            addCriterion("qq_unionid is not null");
            return (Criteria) this;
        }

        public Criteria andQqUnionidEqualTo(String value) {
            addCriterion("qq_unionid =", value, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidNotEqualTo(String value) {
            addCriterion("qq_unionid <>", value, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidGreaterThan(String value) {
            addCriterion("qq_unionid >", value, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("qq_unionid >=", value, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidLessThan(String value) {
            addCriterion("qq_unionid <", value, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidLessThanOrEqualTo(String value) {
            addCriterion("qq_unionid <=", value, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidLike(String value) {
            addCriterion("qq_unionid like", value, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidNotLike(String value) {
            addCriterion("qq_unionid not like", value, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidIn(List<String> values) {
            addCriterion("qq_unionid in", values, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidNotIn(List<String> values) {
            addCriterion("qq_unionid not in", values, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidBetween(String value1, String value2) {
            addCriterion("qq_unionid between", value1, value2, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqUnionidNotBetween(String value1, String value2) {
            addCriterion("qq_unionid not between", value1, value2, "qqUnionid");
            return (Criteria) this;
        }

        public Criteria andQqHeadIsNull() {
            addCriterion("qq_head is null");
            return (Criteria) this;
        }

        public Criteria andQqHeadIsNotNull() {
            addCriterion("qq_head is not null");
            return (Criteria) this;
        }

        public Criteria andQqHeadEqualTo(String value) {
            addCriterion("qq_head =", value, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadNotEqualTo(String value) {
            addCriterion("qq_head <>", value, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadGreaterThan(String value) {
            addCriterion("qq_head >", value, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadGreaterThanOrEqualTo(String value) {
            addCriterion("qq_head >=", value, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadLessThan(String value) {
            addCriterion("qq_head <", value, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadLessThanOrEqualTo(String value) {
            addCriterion("qq_head <=", value, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadLike(String value) {
            addCriterion("qq_head like", value, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadNotLike(String value) {
            addCriterion("qq_head not like", value, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadIn(List<String> values) {
            addCriterion("qq_head in", values, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadNotIn(List<String> values) {
            addCriterion("qq_head not in", values, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadBetween(String value1, String value2) {
            addCriterion("qq_head between", value1, value2, "qqHead");
            return (Criteria) this;
        }

        public Criteria andQqHeadNotBetween(String value1, String value2) {
            addCriterion("qq_head not between", value1, value2, "qqHead");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidIsNull() {
            addCriterion("sina_openid is null");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidIsNotNull() {
            addCriterion("sina_openid is not null");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidEqualTo(String value) {
            addCriterion("sina_openid =", value, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidNotEqualTo(String value) {
            addCriterion("sina_openid <>", value, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidGreaterThan(String value) {
            addCriterion("sina_openid >", value, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("sina_openid >=", value, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidLessThan(String value) {
            addCriterion("sina_openid <", value, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidLessThanOrEqualTo(String value) {
            addCriterion("sina_openid <=", value, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidLike(String value) {
            addCriterion("sina_openid like", value, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidNotLike(String value) {
            addCriterion("sina_openid not like", value, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidIn(List<String> values) {
            addCriterion("sina_openid in", values, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidNotIn(List<String> values) {
            addCriterion("sina_openid not in", values, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidBetween(String value1, String value2) {
            addCriterion("sina_openid between", value1, value2, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaOpenidNotBetween(String value1, String value2) {
            addCriterion("sina_openid not between", value1, value2, "sinaOpenid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidIsNull() {
            addCriterion("sina_unionid is null");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidIsNotNull() {
            addCriterion("sina_unionid is not null");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidEqualTo(String value) {
            addCriterion("sina_unionid =", value, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidNotEqualTo(String value) {
            addCriterion("sina_unionid <>", value, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidGreaterThan(String value) {
            addCriterion("sina_unionid >", value, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("sina_unionid >=", value, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidLessThan(String value) {
            addCriterion("sina_unionid <", value, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidLessThanOrEqualTo(String value) {
            addCriterion("sina_unionid <=", value, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidLike(String value) {
            addCriterion("sina_unionid like", value, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidNotLike(String value) {
            addCriterion("sina_unionid not like", value, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidIn(List<String> values) {
            addCriterion("sina_unionid in", values, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidNotIn(List<String> values) {
            addCriterion("sina_unionid not in", values, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidBetween(String value1, String value2) {
            addCriterion("sina_unionid between", value1, value2, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaUnionidNotBetween(String value1, String value2) {
            addCriterion("sina_unionid not between", value1, value2, "sinaUnionid");
            return (Criteria) this;
        }

        public Criteria andSinaHeadIsNull() {
            addCriterion("sina_head is null");
            return (Criteria) this;
        }

        public Criteria andSinaHeadIsNotNull() {
            addCriterion("sina_head is not null");
            return (Criteria) this;
        }

        public Criteria andSinaHeadEqualTo(String value) {
            addCriterion("sina_head =", value, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadNotEqualTo(String value) {
            addCriterion("sina_head <>", value, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadGreaterThan(String value) {
            addCriterion("sina_head >", value, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadGreaterThanOrEqualTo(String value) {
            addCriterion("sina_head >=", value, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadLessThan(String value) {
            addCriterion("sina_head <", value, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadLessThanOrEqualTo(String value) {
            addCriterion("sina_head <=", value, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadLike(String value) {
            addCriterion("sina_head like", value, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadNotLike(String value) {
            addCriterion("sina_head not like", value, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadIn(List<String> values) {
            addCriterion("sina_head in", values, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadNotIn(List<String> values) {
            addCriterion("sina_head not in", values, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadBetween(String value1, String value2) {
            addCriterion("sina_head between", value1, value2, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andSinaHeadNotBetween(String value1, String value2) {
            addCriterion("sina_head not between", value1, value2, "sinaHead");
            return (Criteria) this;
        }

        public Criteria andHeadurlIsNull() {
            addCriterion("headurl is null");
            return (Criteria) this;
        }

        public Criteria andHeadurlIsNotNull() {
            addCriterion("headurl is not null");
            return (Criteria) this;
        }

        public Criteria andHeadurlEqualTo(String value) {
            addCriterion("headurl =", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlNotEqualTo(String value) {
            addCriterion("headurl <>", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlGreaterThan(String value) {
            addCriterion("headurl >", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlGreaterThanOrEqualTo(String value) {
            addCriterion("headurl >=", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlLessThan(String value) {
            addCriterion("headurl <", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlLessThanOrEqualTo(String value) {
            addCriterion("headurl <=", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlLike(String value) {
            addCriterion("headurl like", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlNotLike(String value) {
            addCriterion("headurl not like", value, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlIn(List<String> values) {
            addCriterion("headurl in", values, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlNotIn(List<String> values) {
            addCriterion("headurl not in", values, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlBetween(String value1, String value2) {
            addCriterion("headurl between", value1, value2, "headurl");
            return (Criteria) this;
        }

        public Criteria andHeadurlNotBetween(String value1, String value2) {
            addCriterion("headurl not between", value1, value2, "headurl");
            return (Criteria) this;
        }

        public Criteria andIscompleteIsNull() {
            addCriterion("isComplete is null");
            return (Criteria) this;
        }

        public Criteria andIscompleteIsNotNull() {
            addCriterion("isComplete is not null");
            return (Criteria) this;
        }

        public Criteria andIscompleteEqualTo(Integer value) {
            addCriterion("isComplete =", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteNotEqualTo(Integer value) {
            addCriterion("isComplete <>", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteGreaterThan(Integer value) {
            addCriterion("isComplete >", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isComplete >=", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteLessThan(Integer value) {
            addCriterion("isComplete <", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteLessThanOrEqualTo(Integer value) {
            addCriterion("isComplete <=", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteIn(List<Integer> values) {
            addCriterion("isComplete in", values, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteNotIn(List<Integer> values) {
            addCriterion("isComplete not in", values, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteBetween(Integer value1, Integer value2) {
            addCriterion("isComplete between", value1, value2, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isComplete not between", value1, value2, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andRefereeIdIsNull() {
            addCriterion("referee_id is null");
            return (Criteria) this;
        }

        public Criteria andRefereeIdIsNotNull() {
            addCriterion("referee_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeIdEqualTo(String value) {
            addCriterion("referee_id =", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdNotEqualTo(String value) {
            addCriterion("referee_id <>", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdGreaterThan(String value) {
            addCriterion("referee_id >", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdGreaterThanOrEqualTo(String value) {
            addCriterion("referee_id >=", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdLessThan(String value) {
            addCriterion("referee_id <", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdLessThanOrEqualTo(String value) {
            addCriterion("referee_id <=", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdLike(String value) {
            addCriterion("referee_id like", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdNotLike(String value) {
            addCriterion("referee_id not like", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdIn(List<String> values) {
            addCriterion("referee_id in", values, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdNotIn(List<String> values) {
            addCriterion("referee_id not in", values, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdBetween(String value1, String value2) {
            addCriterion("referee_id between", value1, value2, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdNotBetween(String value1, String value2) {
            addCriterion("referee_id not between", value1, value2, "refereeId");
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