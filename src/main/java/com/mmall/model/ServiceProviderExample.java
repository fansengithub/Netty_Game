package com.mmall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceProviderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceProviderExample() {
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

        public Criteria andProviderIdIsNull() {
            addCriterion("provider_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNotNull() {
            addCriterion("provider_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderIdEqualTo(Integer value) {
            addCriterion("provider_id =", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotEqualTo(Integer value) {
            addCriterion("provider_id <>", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThan(Integer value) {
            addCriterion("provider_id >", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("provider_id >=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThan(Integer value) {
            addCriterion("provider_id <", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThanOrEqualTo(Integer value) {
            addCriterion("provider_id <=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIn(List<Integer> values) {
            addCriterion("provider_id in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotIn(List<Integer> values) {
            addCriterion("provider_id not in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdBetween(Integer value1, Integer value2) {
            addCriterion("provider_id between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("provider_id not between", value1, value2, "providerId");
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

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andIsDisableIsNull() {
            addCriterion("is_disable is null");
            return (Criteria) this;
        }

        public Criteria andIsDisableIsNotNull() {
            addCriterion("is_disable is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisableEqualTo(Integer value) {
            addCriterion("is_disable =", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableNotEqualTo(Integer value) {
            addCriterion("is_disable <>", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableGreaterThan(Integer value) {
            addCriterion("is_disable >", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_disable >=", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableLessThan(Integer value) {
            addCriterion("is_disable <", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableLessThanOrEqualTo(Integer value) {
            addCriterion("is_disable <=", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableIn(List<Integer> values) {
            addCriterion("is_disable in", values, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableNotIn(List<Integer> values) {
            addCriterion("is_disable not in", values, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableBetween(Integer value1, Integer value2) {
            addCriterion("is_disable between", value1, value2, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableNotBetween(Integer value1, Integer value2) {
            addCriterion("is_disable not between", value1, value2, "isDisable");
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

        public Criteria andOrganiztionNumIsNull() {
            addCriterion("organiztion_num is null");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumIsNotNull() {
            addCriterion("organiztion_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumEqualTo(Integer value) {
            addCriterion("organiztion_num =", value, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumNotEqualTo(Integer value) {
            addCriterion("organiztion_num <>", value, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumGreaterThan(Integer value) {
            addCriterion("organiztion_num >", value, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("organiztion_num >=", value, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumLessThan(Integer value) {
            addCriterion("organiztion_num <", value, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumLessThanOrEqualTo(Integer value) {
            addCriterion("organiztion_num <=", value, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumIn(List<Integer> values) {
            addCriterion("organiztion_num in", values, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumNotIn(List<Integer> values) {
            addCriterion("organiztion_num not in", values, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumBetween(Integer value1, Integer value2) {
            addCriterion("organiztion_num between", value1, value2, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andOrganiztionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("organiztion_num not between", value1, value2, "organiztionNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumIsNull() {
            addCriterion("piano_shop_num is null");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumIsNotNull() {
            addCriterion("piano_shop_num is not null");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumEqualTo(Integer value) {
            addCriterion("piano_shop_num =", value, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumNotEqualTo(Integer value) {
            addCriterion("piano_shop_num <>", value, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumGreaterThan(Integer value) {
            addCriterion("piano_shop_num >", value, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("piano_shop_num >=", value, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumLessThan(Integer value) {
            addCriterion("piano_shop_num <", value, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumLessThanOrEqualTo(Integer value) {
            addCriterion("piano_shop_num <=", value, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumIn(List<Integer> values) {
            addCriterion("piano_shop_num in", values, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumNotIn(List<Integer> values) {
            addCriterion("piano_shop_num not in", values, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumBetween(Integer value1, Integer value2) {
            addCriterion("piano_shop_num between", value1, value2, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andPianoShopNumNotBetween(Integer value1, Integer value2) {
            addCriterion("piano_shop_num not between", value1, value2, "pianoShopNum");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNull() {
            addCriterion("boss_name is null");
            return (Criteria) this;
        }

        public Criteria andBossNameIsNotNull() {
            addCriterion("boss_name is not null");
            return (Criteria) this;
        }

        public Criteria andBossNameEqualTo(String value) {
            addCriterion("boss_name =", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotEqualTo(String value) {
            addCriterion("boss_name <>", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThan(String value) {
            addCriterion("boss_name >", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameGreaterThanOrEqualTo(String value) {
            addCriterion("boss_name >=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThan(String value) {
            addCriterion("boss_name <", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLessThanOrEqualTo(String value) {
            addCriterion("boss_name <=", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameLike(String value) {
            addCriterion("boss_name like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotLike(String value) {
            addCriterion("boss_name not like", value, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameIn(List<String> values) {
            addCriterion("boss_name in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotIn(List<String> values) {
            addCriterion("boss_name not in", values, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameBetween(String value1, String value2) {
            addCriterion("boss_name between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossNameNotBetween(String value1, String value2) {
            addCriterion("boss_name not between", value1, value2, "bossName");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneIsNull() {
            addCriterion("boss_telephone is null");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneIsNotNull() {
            addCriterion("boss_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneEqualTo(String value) {
            addCriterion("boss_telephone =", value, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneNotEqualTo(String value) {
            addCriterion("boss_telephone <>", value, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneGreaterThan(String value) {
            addCriterion("boss_telephone >", value, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("boss_telephone >=", value, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneLessThan(String value) {
            addCriterion("boss_telephone <", value, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneLessThanOrEqualTo(String value) {
            addCriterion("boss_telephone <=", value, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneLike(String value) {
            addCriterion("boss_telephone like", value, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneNotLike(String value) {
            addCriterion("boss_telephone not like", value, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneIn(List<String> values) {
            addCriterion("boss_telephone in", values, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneNotIn(List<String> values) {
            addCriterion("boss_telephone not in", values, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneBetween(String value1, String value2) {
            addCriterion("boss_telephone between", value1, value2, "bossTelephone");
            return (Criteria) this;
        }

        public Criteria andBossTelephoneNotBetween(String value1, String value2) {
            addCriterion("boss_telephone not between", value1, value2, "bossTelephone");
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

        public Criteria andFengmianPictureIsNull() {
            addCriterion("fengmian_picture is null");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureIsNotNull() {
            addCriterion("fengmian_picture is not null");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureEqualTo(String value) {
            addCriterion("fengmian_picture =", value, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureNotEqualTo(String value) {
            addCriterion("fengmian_picture <>", value, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureGreaterThan(String value) {
            addCriterion("fengmian_picture >", value, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureGreaterThanOrEqualTo(String value) {
            addCriterion("fengmian_picture >=", value, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureLessThan(String value) {
            addCriterion("fengmian_picture <", value, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureLessThanOrEqualTo(String value) {
            addCriterion("fengmian_picture <=", value, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureLike(String value) {
            addCriterion("fengmian_picture like", value, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureNotLike(String value) {
            addCriterion("fengmian_picture not like", value, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureIn(List<String> values) {
            addCriterion("fengmian_picture in", values, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureNotIn(List<String> values) {
            addCriterion("fengmian_picture not in", values, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureBetween(String value1, String value2) {
            addCriterion("fengmian_picture between", value1, value2, "fengmianPicture");
            return (Criteria) this;
        }

        public Criteria andFengmianPictureNotBetween(String value1, String value2) {
            addCriterion("fengmian_picture not between", value1, value2, "fengmianPicture");
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

        public Criteria andBusinessLicensePictureIsNull() {
            addCriterion("business_license_picture is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureIsNotNull() {
            addCriterion("business_license_picture is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureEqualTo(String value) {
            addCriterion("business_license_picture =", value, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureNotEqualTo(String value) {
            addCriterion("business_license_picture <>", value, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureGreaterThan(String value) {
            addCriterion("business_license_picture >", value, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_picture >=", value, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureLessThan(String value) {
            addCriterion("business_license_picture <", value, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureLessThanOrEqualTo(String value) {
            addCriterion("business_license_picture <=", value, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureLike(String value) {
            addCriterion("business_license_picture like", value, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureNotLike(String value) {
            addCriterion("business_license_picture not like", value, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureIn(List<String> values) {
            addCriterion("business_license_picture in", values, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureNotIn(List<String> values) {
            addCriterion("business_license_picture not in", values, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureBetween(String value1, String value2) {
            addCriterion("business_license_picture between", value1, value2, "businessLicensePicture");
            return (Criteria) this;
        }

        public Criteria andBusinessLicensePictureNotBetween(String value1, String value2) {
            addCriterion("business_license_picture not between", value1, value2, "businessLicensePicture");
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

        public Criteria andMemeberTimeIsNull() {
            addCriterion("memeber_time is null");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeIsNotNull() {
            addCriterion("memeber_time is not null");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeEqualTo(Date value) {
            addCriterion("memeber_time =", value, "memeberTime");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeNotEqualTo(Date value) {
            addCriterion("memeber_time <>", value, "memeberTime");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeGreaterThan(Date value) {
            addCriterion("memeber_time >", value, "memeberTime");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("memeber_time >=", value, "memeberTime");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeLessThan(Date value) {
            addCriterion("memeber_time <", value, "memeberTime");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeLessThanOrEqualTo(Date value) {
            addCriterion("memeber_time <=", value, "memeberTime");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeIn(List<Date> values) {
            addCriterion("memeber_time in", values, "memeberTime");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeNotIn(List<Date> values) {
            addCriterion("memeber_time not in", values, "memeberTime");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeBetween(Date value1, Date value2) {
            addCriterion("memeber_time between", value1, value2, "memeberTime");
            return (Criteria) this;
        }

        public Criteria andMemeberTimeNotBetween(Date value1, Date value2) {
            addCriterion("memeber_time not between", value1, value2, "memeberTime");
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