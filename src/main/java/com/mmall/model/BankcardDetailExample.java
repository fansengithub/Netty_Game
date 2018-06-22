package com.mmall.model;

import java.util.ArrayList;
import java.util.List;

public class BankcardDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankcardDetailExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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

        public Criteria andRolerIsNull() {
            addCriterion("roler is null");
            return (Criteria) this;
        }

        public Criteria andRolerIsNotNull() {
            addCriterion("roler is not null");
            return (Criteria) this;
        }

        public Criteria andRolerEqualTo(String value) {
            addCriterion("roler =", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerNotEqualTo(String value) {
            addCriterion("roler <>", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerGreaterThan(String value) {
            addCriterion("roler >", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerGreaterThanOrEqualTo(String value) {
            addCriterion("roler >=", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerLessThan(String value) {
            addCriterion("roler <", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerLessThanOrEqualTo(String value) {
            addCriterion("roler <=", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerLike(String value) {
            addCriterion("roler like", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerNotLike(String value) {
            addCriterion("roler not like", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerIn(List<String> values) {
            addCriterion("roler in", values, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerNotIn(List<String> values) {
            addCriterion("roler not in", values, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerBetween(String value1, String value2) {
            addCriterion("roler between", value1, value2, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerNotBetween(String value1, String value2) {
            addCriterion("roler not between", value1, value2, "roler");
            return (Criteria) this;
        }

        public Criteria andOpeanBankIsNull() {
            addCriterion("opean_bank is null");
            return (Criteria) this;
        }

        public Criteria andOpeanBankIsNotNull() {
            addCriterion("opean_bank is not null");
            return (Criteria) this;
        }

        public Criteria andOpeanBankEqualTo(String value) {
            addCriterion("opean_bank =", value, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankNotEqualTo(String value) {
            addCriterion("opean_bank <>", value, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankGreaterThan(String value) {
            addCriterion("opean_bank >", value, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankGreaterThanOrEqualTo(String value) {
            addCriterion("opean_bank >=", value, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankLessThan(String value) {
            addCriterion("opean_bank <", value, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankLessThanOrEqualTo(String value) {
            addCriterion("opean_bank <=", value, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankLike(String value) {
            addCriterion("opean_bank like", value, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankNotLike(String value) {
            addCriterion("opean_bank not like", value, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankIn(List<String> values) {
            addCriterion("opean_bank in", values, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankNotIn(List<String> values) {
            addCriterion("opean_bank not in", values, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankBetween(String value1, String value2) {
            addCriterion("opean_bank between", value1, value2, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andOpeanBankNotBetween(String value1, String value2) {
            addCriterion("opean_bank not between", value1, value2, "opeanBank");
            return (Criteria) this;
        }

        public Criteria andHolderNameIsNull() {
            addCriterion("holder_name is null");
            return (Criteria) this;
        }

        public Criteria andHolderNameIsNotNull() {
            addCriterion("holder_name is not null");
            return (Criteria) this;
        }

        public Criteria andHolderNameEqualTo(String value) {
            addCriterion("holder_name =", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameNotEqualTo(String value) {
            addCriterion("holder_name <>", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameGreaterThan(String value) {
            addCriterion("holder_name >", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameGreaterThanOrEqualTo(String value) {
            addCriterion("holder_name >=", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameLessThan(String value) {
            addCriterion("holder_name <", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameLessThanOrEqualTo(String value) {
            addCriterion("holder_name <=", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameLike(String value) {
            addCriterion("holder_name like", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameNotLike(String value) {
            addCriterion("holder_name not like", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameIn(List<String> values) {
            addCriterion("holder_name in", values, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameNotIn(List<String> values) {
            addCriterion("holder_name not in", values, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameBetween(String value1, String value2) {
            addCriterion("holder_name between", value1, value2, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameNotBetween(String value1, String value2) {
            addCriterion("holder_name not between", value1, value2, "holderName");
            return (Criteria) this;
        }

        public Criteria andBankcardNumIsNull() {
            addCriterion("bankCard_num is null");
            return (Criteria) this;
        }

        public Criteria andBankcardNumIsNotNull() {
            addCriterion("bankCard_num is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardNumEqualTo(String value) {
            addCriterion("bankCard_num =", value, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumNotEqualTo(String value) {
            addCriterion("bankCard_num <>", value, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumGreaterThan(String value) {
            addCriterion("bankCard_num >", value, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumGreaterThanOrEqualTo(String value) {
            addCriterion("bankCard_num >=", value, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumLessThan(String value) {
            addCriterion("bankCard_num <", value, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumLessThanOrEqualTo(String value) {
            addCriterion("bankCard_num <=", value, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumLike(String value) {
            addCriterion("bankCard_num like", value, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumNotLike(String value) {
            addCriterion("bankCard_num not like", value, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumIn(List<String> values) {
            addCriterion("bankCard_num in", values, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumNotIn(List<String> values) {
            addCriterion("bankCard_num not in", values, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumBetween(String value1, String value2) {
            addCriterion("bankCard_num between", value1, value2, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andBankcardNumNotBetween(String value1, String value2) {
            addCriterion("bankCard_num not between", value1, value2, "bankcardNum");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Integer value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Integer value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Integer value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Integer value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Integer value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Integer> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Integer> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Integer value1, Integer value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeIsNull() {
            addCriterion("bankCard_type is null");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeIsNotNull() {
            addCriterion("bankCard_type is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeEqualTo(String value) {
            addCriterion("bankCard_type =", value, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeNotEqualTo(String value) {
            addCriterion("bankCard_type <>", value, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeGreaterThan(String value) {
            addCriterion("bankCard_type >", value, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bankCard_type >=", value, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeLessThan(String value) {
            addCriterion("bankCard_type <", value, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeLessThanOrEqualTo(String value) {
            addCriterion("bankCard_type <=", value, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeLike(String value) {
            addCriterion("bankCard_type like", value, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeNotLike(String value) {
            addCriterion("bankCard_type not like", value, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeIn(List<String> values) {
            addCriterion("bankCard_type in", values, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeNotIn(List<String> values) {
            addCriterion("bankCard_type not in", values, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeBetween(String value1, String value2) {
            addCriterion("bankCard_type between", value1, value2, "bankcardType");
            return (Criteria) this;
        }

        public Criteria andBankcardTypeNotBetween(String value1, String value2) {
            addCriterion("bankCard_type not between", value1, value2, "bankcardType");
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