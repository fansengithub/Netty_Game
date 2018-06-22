package com.mmall.model;

import java.util.ArrayList;
import java.util.List;

public class WaitingMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaitingMemberExample() {
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

        public Criteria andIsPassIsNull() {
            addCriterion("is_pass is null");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNotNull() {
            addCriterion("is_pass is not null");
            return (Criteria) this;
        }

        public Criteria andIsPassEqualTo(Integer value) {
            addCriterion("is_pass =", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotEqualTo(Integer value) {
            addCriterion("is_pass <>", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThan(Integer value) {
            addCriterion("is_pass >", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pass >=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThan(Integer value) {
            addCriterion("is_pass <", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThanOrEqualTo(Integer value) {
            addCriterion("is_pass <=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassIn(List<Integer> values) {
            addCriterion("is_pass in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotIn(List<Integer> values) {
            addCriterion("is_pass not in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassBetween(Integer value1, Integer value2) {
            addCriterion("is_pass between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pass not between", value1, value2, "isPass");
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