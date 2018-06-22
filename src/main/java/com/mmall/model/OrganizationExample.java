package com.mmall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrganizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrganizationExample() {
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

        public Criteria andOrganizeIdIsNull() {
            addCriterion("organize_id is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdIsNotNull() {
            addCriterion("organize_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdEqualTo(Integer value) {
            addCriterion("organize_id =", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotEqualTo(Integer value) {
            addCriterion("organize_id <>", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdGreaterThan(Integer value) {
            addCriterion("organize_id >", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("organize_id >=", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdLessThan(Integer value) {
            addCriterion("organize_id <", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("organize_id <=", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdIn(List<Integer> values) {
            addCriterion("organize_id in", values, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotIn(List<Integer> values) {
            addCriterion("organize_id not in", values, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdBetween(Integer value1, Integer value2) {
            addCriterion("organize_id between", value1, value2, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("organize_id not between", value1, value2, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameIsNull() {
            addCriterion("organize_name is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameIsNotNull() {
            addCriterion("organize_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameEqualTo(String value) {
            addCriterion("organize_name =", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotEqualTo(String value) {
            addCriterion("organize_name <>", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameGreaterThan(String value) {
            addCriterion("organize_name >", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("organize_name >=", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameLessThan(String value) {
            addCriterion("organize_name <", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameLessThanOrEqualTo(String value) {
            addCriterion("organize_name <=", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameLike(String value) {
            addCriterion("organize_name like", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotLike(String value) {
            addCriterion("organize_name not like", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameIn(List<String> values) {
            addCriterion("organize_name in", values, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotIn(List<String> values) {
            addCriterion("organize_name not in", values, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameBetween(String value1, String value2) {
            addCriterion("organize_name between", value1, value2, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotBetween(String value1, String value2) {
            addCriterion("organize_name not between", value1, value2, "organizeName");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdIsNull() {
            addCriterion("serviceProvider_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdIsNotNull() {
            addCriterion("serviceProvider_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdEqualTo(Integer value) {
            addCriterion("serviceProvider_id =", value, "serviceproviderId");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdNotEqualTo(Integer value) {
            addCriterion("serviceProvider_id <>", value, "serviceproviderId");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdGreaterThan(Integer value) {
            addCriterion("serviceProvider_id >", value, "serviceproviderId");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("serviceProvider_id >=", value, "serviceproviderId");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdLessThan(Integer value) {
            addCriterion("serviceProvider_id <", value, "serviceproviderId");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdLessThanOrEqualTo(Integer value) {
            addCriterion("serviceProvider_id <=", value, "serviceproviderId");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdIn(List<Integer> values) {
            addCriterion("serviceProvider_id in", values, "serviceproviderId");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdNotIn(List<Integer> values) {
            addCriterion("serviceProvider_id not in", values, "serviceproviderId");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdBetween(Integer value1, Integer value2) {
            addCriterion("serviceProvider_id between", value1, value2, "serviceproviderId");
            return (Criteria) this;
        }

        public Criteria andServiceproviderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("serviceProvider_id not between", value1, value2, "serviceproviderId");
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

        public Criteria andDisableIsNull() {
            addCriterion("disable is null");
            return (Criteria) this;
        }

        public Criteria andDisableIsNotNull() {
            addCriterion("disable is not null");
            return (Criteria) this;
        }

        public Criteria andDisableEqualTo(Integer value) {
            addCriterion("disable =", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableNotEqualTo(Integer value) {
            addCriterion("disable <>", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableGreaterThan(Integer value) {
            addCriterion("disable >", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableGreaterThanOrEqualTo(Integer value) {
            addCriterion("disable >=", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableLessThan(Integer value) {
            addCriterion("disable <", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableLessThanOrEqualTo(Integer value) {
            addCriterion("disable <=", value, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableIn(List<Integer> values) {
            addCriterion("disable in", values, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableNotIn(List<Integer> values) {
            addCriterion("disable not in", values, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableBetween(Integer value1, Integer value2) {
            addCriterion("disable between", value1, value2, "disable");
            return (Criteria) this;
        }

        public Criteria andDisableNotBetween(Integer value1, Integer value2) {
            addCriterion("disable not between", value1, value2, "disable");
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

        public Criteria andMemberNumIsNull() {
            addCriterion("member_num is null");
            return (Criteria) this;
        }

        public Criteria andMemberNumIsNotNull() {
            addCriterion("member_num is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNumEqualTo(Integer value) {
            addCriterion("member_num =", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumNotEqualTo(Integer value) {
            addCriterion("member_num <>", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumGreaterThan(Integer value) {
            addCriterion("member_num >", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_num >=", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumLessThan(Integer value) {
            addCriterion("member_num <", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumLessThanOrEqualTo(Integer value) {
            addCriterion("member_num <=", value, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumIn(List<Integer> values) {
            addCriterion("member_num in", values, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumNotIn(List<Integer> values) {
            addCriterion("member_num not in", values, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumBetween(Integer value1, Integer value2) {
            addCriterion("member_num between", value1, value2, "memberNum");
            return (Criteria) this;
        }

        public Criteria andMemberNumNotBetween(Integer value1, Integer value2) {
            addCriterion("member_num not between", value1, value2, "memberNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumIsNull() {
            addCriterion("learnBook_num is null");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumIsNotNull() {
            addCriterion("learnBook_num is not null");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumEqualTo(Integer value) {
            addCriterion("learnBook_num =", value, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumNotEqualTo(Integer value) {
            addCriterion("learnBook_num <>", value, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumGreaterThan(Integer value) {
            addCriterion("learnBook_num >", value, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("learnBook_num >=", value, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumLessThan(Integer value) {
            addCriterion("learnBook_num <", value, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumLessThanOrEqualTo(Integer value) {
            addCriterion("learnBook_num <=", value, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumIn(List<Integer> values) {
            addCriterion("learnBook_num in", values, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumNotIn(List<Integer> values) {
            addCriterion("learnBook_num not in", values, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumBetween(Integer value1, Integer value2) {
            addCriterion("learnBook_num between", value1, value2, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andLearnbookNumNotBetween(Integer value1, Integer value2) {
            addCriterion("learnBook_num not between", value1, value2, "learnbookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumIsNull() {
            addCriterion("operaBook_num is null");
            return (Criteria) this;
        }

        public Criteria andOperabookNumIsNotNull() {
            addCriterion("operaBook_num is not null");
            return (Criteria) this;
        }

        public Criteria andOperabookNumEqualTo(Integer value) {
            addCriterion("operaBook_num =", value, "operabookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumNotEqualTo(Integer value) {
            addCriterion("operaBook_num <>", value, "operabookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumGreaterThan(Integer value) {
            addCriterion("operaBook_num >", value, "operabookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("operaBook_num >=", value, "operabookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumLessThan(Integer value) {
            addCriterion("operaBook_num <", value, "operabookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumLessThanOrEqualTo(Integer value) {
            addCriterion("operaBook_num <=", value, "operabookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumIn(List<Integer> values) {
            addCriterion("operaBook_num in", values, "operabookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumNotIn(List<Integer> values) {
            addCriterion("operaBook_num not in", values, "operabookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumBetween(Integer value1, Integer value2) {
            addCriterion("operaBook_num between", value1, value2, "operabookNum");
            return (Criteria) this;
        }

        public Criteria andOperabookNumNotBetween(Integer value1, Integer value2) {
            addCriterion("operaBook_num not between", value1, value2, "operabookNum");
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

        public Criteria andBoosTelephoneIsNull() {
            addCriterion("boos_telephone is null");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneIsNotNull() {
            addCriterion("boos_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneEqualTo(String value) {
            addCriterion("boos_telephone =", value, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneNotEqualTo(String value) {
            addCriterion("boos_telephone <>", value, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneGreaterThan(String value) {
            addCriterion("boos_telephone >", value, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("boos_telephone >=", value, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneLessThan(String value) {
            addCriterion("boos_telephone <", value, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneLessThanOrEqualTo(String value) {
            addCriterion("boos_telephone <=", value, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneLike(String value) {
            addCriterion("boos_telephone like", value, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneNotLike(String value) {
            addCriterion("boos_telephone not like", value, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneIn(List<String> values) {
            addCriterion("boos_telephone in", values, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneNotIn(List<String> values) {
            addCriterion("boos_telephone not in", values, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneBetween(String value1, String value2) {
            addCriterion("boos_telephone between", value1, value2, "boosTelephone");
            return (Criteria) this;
        }

        public Criteria andBoosTelephoneNotBetween(String value1, String value2) {
            addCriterion("boos_telephone not between", value1, value2, "boosTelephone");
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

        public Criteria andDetailAddressIsNull() {
            addCriterion("detail_address is null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIsNotNull() {
            addCriterion("detail_address is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAddressEqualTo(String value) {
            addCriterion("detail_address =", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotEqualTo(String value) {
            addCriterion("detail_address <>", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThan(String value) {
            addCriterion("detail_address >", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detail_address >=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThan(String value) {
            addCriterion("detail_address <", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLessThanOrEqualTo(String value) {
            addCriterion("detail_address <=", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressLike(String value) {
            addCriterion("detail_address like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotLike(String value) {
            addCriterion("detail_address not like", value, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressIn(List<String> values) {
            addCriterion("detail_address in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotIn(List<String> values) {
            addCriterion("detail_address not in", values, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressBetween(String value1, String value2) {
            addCriterion("detail_address between", value1, value2, "detailAddress");
            return (Criteria) this;
        }

        public Criteria andDetailAddressNotBetween(String value1, String value2) {
            addCriterion("detail_address not between", value1, value2, "detailAddress");
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
            addCriterion("IDCard_picture is null");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureIsNotNull() {
            addCriterion("IDCard_picture is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureEqualTo(String value) {
            addCriterion("IDCard_picture =", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureNotEqualTo(String value) {
            addCriterion("IDCard_picture <>", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureGreaterThan(String value) {
            addCriterion("IDCard_picture >", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureGreaterThanOrEqualTo(String value) {
            addCriterion("IDCard_picture >=", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureLessThan(String value) {
            addCriterion("IDCard_picture <", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureLessThanOrEqualTo(String value) {
            addCriterion("IDCard_picture <=", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureLike(String value) {
            addCriterion("IDCard_picture like", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureNotLike(String value) {
            addCriterion("IDCard_picture not like", value, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureIn(List<String> values) {
            addCriterion("IDCard_picture in", values, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureNotIn(List<String> values) {
            addCriterion("IDCard_picture not in", values, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureBetween(String value1, String value2) {
            addCriterion("IDCard_picture between", value1, value2, "idcardPicture");
            return (Criteria) this;
        }

        public Criteria andIdcardPictureNotBetween(String value1, String value2) {
            addCriterion("IDCard_picture not between", value1, value2, "idcardPicture");
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

        public Criteria andOrganizeTypeIsNull() {
            addCriterion("organize_type is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeIsNotNull() {
            addCriterion("organize_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeEqualTo(String value) {
            addCriterion("organize_type =", value, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeNotEqualTo(String value) {
            addCriterion("organize_type <>", value, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeGreaterThan(String value) {
            addCriterion("organize_type >", value, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("organize_type >=", value, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeLessThan(String value) {
            addCriterion("organize_type <", value, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeLessThanOrEqualTo(String value) {
            addCriterion("organize_type <=", value, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeLike(String value) {
            addCriterion("organize_type like", value, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeNotLike(String value) {
            addCriterion("organize_type not like", value, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeIn(List<String> values) {
            addCriterion("organize_type in", values, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeNotIn(List<String> values) {
            addCriterion("organize_type not in", values, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeBetween(String value1, String value2) {
            addCriterion("organize_type between", value1, value2, "organizeType");
            return (Criteria) this;
        }

        public Criteria andOrganizeTypeNotBetween(String value1, String value2) {
            addCriterion("organize_type not between", value1, value2, "organizeType");
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

        public Criteria andLogOutIsNull() {
            addCriterion("log_out is null");
            return (Criteria) this;
        }

        public Criteria andLogOutIsNotNull() {
            addCriterion("log_out is not null");
            return (Criteria) this;
        }

        public Criteria andLogOutEqualTo(Integer value) {
            addCriterion("log_out =", value, "logOut");
            return (Criteria) this;
        }

        public Criteria andLogOutNotEqualTo(Integer value) {
            addCriterion("log_out <>", value, "logOut");
            return (Criteria) this;
        }

        public Criteria andLogOutGreaterThan(Integer value) {
            addCriterion("log_out >", value, "logOut");
            return (Criteria) this;
        }

        public Criteria andLogOutGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_out >=", value, "logOut");
            return (Criteria) this;
        }

        public Criteria andLogOutLessThan(Integer value) {
            addCriterion("log_out <", value, "logOut");
            return (Criteria) this;
        }

        public Criteria andLogOutLessThanOrEqualTo(Integer value) {
            addCriterion("log_out <=", value, "logOut");
            return (Criteria) this;
        }

        public Criteria andLogOutIn(List<Integer> values) {
            addCriterion("log_out in", values, "logOut");
            return (Criteria) this;
        }

        public Criteria andLogOutNotIn(List<Integer> values) {
            addCriterion("log_out not in", values, "logOut");
            return (Criteria) this;
        }

        public Criteria andLogOutBetween(Integer value1, Integer value2) {
            addCriterion("log_out between", value1, value2, "logOut");
            return (Criteria) this;
        }

        public Criteria andLogOutNotBetween(Integer value1, Integer value2) {
            addCriterion("log_out not between", value1, value2, "logOut");
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

        public Criteria andConsumpMoneyIsNull() {
            addCriterion("consump_money is null");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyIsNotNull() {
            addCriterion("consump_money is not null");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyEqualTo(BigDecimal value) {
            addCriterion("consump_money =", value, "consumpMoney");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyNotEqualTo(BigDecimal value) {
            addCriterion("consump_money <>", value, "consumpMoney");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyGreaterThan(BigDecimal value) {
            addCriterion("consump_money >", value, "consumpMoney");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consump_money >=", value, "consumpMoney");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyLessThan(BigDecimal value) {
            addCriterion("consump_money <", value, "consumpMoney");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consump_money <=", value, "consumpMoney");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyIn(List<BigDecimal> values) {
            addCriterion("consump_money in", values, "consumpMoney");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyNotIn(List<BigDecimal> values) {
            addCriterion("consump_money not in", values, "consumpMoney");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consump_money between", value1, value2, "consumpMoney");
            return (Criteria) this;
        }

        public Criteria andConsumpMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consump_money not between", value1, value2, "consumpMoney");
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

        public Criteria andRechargeMoneyEqualTo(BigDecimal value) {
            addCriterion("recharge_money =", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("recharge_money <>", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyGreaterThan(BigDecimal value) {
            addCriterion("recharge_money >", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_money >=", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyLessThan(BigDecimal value) {
            addCriterion("recharge_money <", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_money <=", value, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyIn(List<BigDecimal> values) {
            addCriterion("recharge_money in", values, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("recharge_money not in", values, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_money between", value1, value2, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andRechargeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_money not between", value1, value2, "rechargeMoney");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeIsNull() {
            addCriterion("organize_scope is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeIsNotNull() {
            addCriterion("organize_scope is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeEqualTo(String value) {
            addCriterion("organize_scope =", value, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeNotEqualTo(String value) {
            addCriterion("organize_scope <>", value, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeGreaterThan(String value) {
            addCriterion("organize_scope >", value, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeGreaterThanOrEqualTo(String value) {
            addCriterion("organize_scope >=", value, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeLessThan(String value) {
            addCriterion("organize_scope <", value, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeLessThanOrEqualTo(String value) {
            addCriterion("organize_scope <=", value, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeLike(String value) {
            addCriterion("organize_scope like", value, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeNotLike(String value) {
            addCriterion("organize_scope not like", value, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeIn(List<String> values) {
            addCriterion("organize_scope in", values, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeNotIn(List<String> values) {
            addCriterion("organize_scope not in", values, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeBetween(String value1, String value2) {
            addCriterion("organize_scope between", value1, value2, "organizeScope");
            return (Criteria) this;
        }

        public Criteria andOrganizeScopeNotBetween(String value1, String value2) {
            addCriterion("organize_scope not between", value1, value2, "organizeScope");
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