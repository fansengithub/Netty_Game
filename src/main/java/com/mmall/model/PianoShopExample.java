package com.mmall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PianoShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PianoShopExample() {
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

        public Criteria andPianoShopIdIsNull() {
            addCriterion("piano_shop_id is null");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdIsNotNull() {
            addCriterion("piano_shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdEqualTo(Integer value) {
            addCriterion("piano_shop_id =", value, "pianoShopId");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdNotEqualTo(Integer value) {
            addCriterion("piano_shop_id <>", value, "pianoShopId");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdGreaterThan(Integer value) {
            addCriterion("piano_shop_id >", value, "pianoShopId");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("piano_shop_id >=", value, "pianoShopId");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdLessThan(Integer value) {
            addCriterion("piano_shop_id <", value, "pianoShopId");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("piano_shop_id <=", value, "pianoShopId");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdIn(List<Integer> values) {
            addCriterion("piano_shop_id in", values, "pianoShopId");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdNotIn(List<Integer> values) {
            addCriterion("piano_shop_id not in", values, "pianoShopId");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdBetween(Integer value1, Integer value2) {
            addCriterion("piano_shop_id between", value1, value2, "pianoShopId");
            return (Criteria) this;
        }

        public Criteria andPianoShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("piano_shop_id not between", value1, value2, "pianoShopId");
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

        public Criteria andBelongtoOrginazeIsNull() {
            addCriterion("belongto_orginaze is null");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeIsNotNull() {
            addCriterion("belongto_orginaze is not null");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeEqualTo(String value) {
            addCriterion("belongto_orginaze =", value, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeNotEqualTo(String value) {
            addCriterion("belongto_orginaze <>", value, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeGreaterThan(String value) {
            addCriterion("belongto_orginaze >", value, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeGreaterThanOrEqualTo(String value) {
            addCriterion("belongto_orginaze >=", value, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeLessThan(String value) {
            addCriterion("belongto_orginaze <", value, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeLessThanOrEqualTo(String value) {
            addCriterion("belongto_orginaze <=", value, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeLike(String value) {
            addCriterion("belongto_orginaze like", value, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeNotLike(String value) {
            addCriterion("belongto_orginaze not like", value, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeIn(List<String> values) {
            addCriterion("belongto_orginaze in", values, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeNotIn(List<String> values) {
            addCriterion("belongto_orginaze not in", values, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeBetween(String value1, String value2) {
            addCriterion("belongto_orginaze between", value1, value2, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeNotBetween(String value1, String value2) {
            addCriterion("belongto_orginaze not between", value1, value2, "belongtoOrginaze");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidIsNull() {
            addCriterion("belongto_orginazeID is null");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidIsNotNull() {
            addCriterion("belongto_orginazeID is not null");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidEqualTo(Integer value) {
            addCriterion("belongto_orginazeID =", value, "belongtoOrginazeid");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidNotEqualTo(Integer value) {
            addCriterion("belongto_orginazeID <>", value, "belongtoOrginazeid");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidGreaterThan(Integer value) {
            addCriterion("belongto_orginazeID >", value, "belongtoOrginazeid");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("belongto_orginazeID >=", value, "belongtoOrginazeid");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidLessThan(Integer value) {
            addCriterion("belongto_orginazeID <", value, "belongtoOrginazeid");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidLessThanOrEqualTo(Integer value) {
            addCriterion("belongto_orginazeID <=", value, "belongtoOrginazeid");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidIn(List<Integer> values) {
            addCriterion("belongto_orginazeID in", values, "belongtoOrginazeid");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidNotIn(List<Integer> values) {
            addCriterion("belongto_orginazeID not in", values, "belongtoOrginazeid");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidBetween(Integer value1, Integer value2) {
            addCriterion("belongto_orginazeID between", value1, value2, "belongtoOrginazeid");
            return (Criteria) this;
        }

        public Criteria andBelongtoOrginazeidNotBetween(Integer value1, Integer value2) {
            addCriterion("belongto_orginazeID not between", value1, value2, "belongtoOrginazeid");
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

        public Criteria andCreateTeacherTotalnumIsNull() {
            addCriterion("create_teacher_totalNum is null");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumIsNotNull() {
            addCriterion("create_teacher_totalNum is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumEqualTo(Integer value) {
            addCriterion("create_teacher_totalNum =", value, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumNotEqualTo(Integer value) {
            addCriterion("create_teacher_totalNum <>", value, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumGreaterThan(Integer value) {
            addCriterion("create_teacher_totalNum >", value, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_teacher_totalNum >=", value, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumLessThan(Integer value) {
            addCriterion("create_teacher_totalNum <", value, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumLessThanOrEqualTo(Integer value) {
            addCriterion("create_teacher_totalNum <=", value, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumIn(List<Integer> values) {
            addCriterion("create_teacher_totalNum in", values, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumNotIn(List<Integer> values) {
            addCriterion("create_teacher_totalNum not in", values, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumBetween(Integer value1, Integer value2) {
            addCriterion("create_teacher_totalNum between", value1, value2, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherTotalnumNotBetween(Integer value1, Integer value2) {
            addCriterion("create_teacher_totalNum not between", value1, value2, "createTeacherTotalnum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumIsNull() {
            addCriterion("now_teacherNum is null");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumIsNotNull() {
            addCriterion("now_teacherNum is not null");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumEqualTo(Integer value) {
            addCriterion("now_teacherNum =", value, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumNotEqualTo(Integer value) {
            addCriterion("now_teacherNum <>", value, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumGreaterThan(Integer value) {
            addCriterion("now_teacherNum >", value, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("now_teacherNum >=", value, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumLessThan(Integer value) {
            addCriterion("now_teacherNum <", value, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumLessThanOrEqualTo(Integer value) {
            addCriterion("now_teacherNum <=", value, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumIn(List<Integer> values) {
            addCriterion("now_teacherNum in", values, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumNotIn(List<Integer> values) {
            addCriterion("now_teacherNum not in", values, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumBetween(Integer value1, Integer value2) {
            addCriterion("now_teacherNum between", value1, value2, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andNowTeachernumNotBetween(Integer value1, Integer value2) {
            addCriterion("now_teacherNum not between", value1, value2, "nowTeachernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumIsNull() {
            addCriterion("free_teaherNum is null");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumIsNotNull() {
            addCriterion("free_teaherNum is not null");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumEqualTo(Integer value) {
            addCriterion("free_teaherNum =", value, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumNotEqualTo(Integer value) {
            addCriterion("free_teaherNum <>", value, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumGreaterThan(Integer value) {
            addCriterion("free_teaherNum >", value, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_teaherNum >=", value, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumLessThan(Integer value) {
            addCriterion("free_teaherNum <", value, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumLessThanOrEqualTo(Integer value) {
            addCriterion("free_teaherNum <=", value, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumIn(List<Integer> values) {
            addCriterion("free_teaherNum in", values, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumNotIn(List<Integer> values) {
            addCriterion("free_teaherNum not in", values, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumBetween(Integer value1, Integer value2) {
            addCriterion("free_teaherNum between", value1, value2, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andFreeTeahernumNotBetween(Integer value1, Integer value2) {
            addCriterion("free_teaherNum not between", value1, value2, "freeTeahernum");
            return (Criteria) this;
        }

        public Criteria andStudentNumIsNull() {
            addCriterion("student_num is null");
            return (Criteria) this;
        }

        public Criteria andStudentNumIsNotNull() {
            addCriterion("student_num is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNumEqualTo(Integer value) {
            addCriterion("student_num =", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotEqualTo(Integer value) {
            addCriterion("student_num <>", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumGreaterThan(Integer value) {
            addCriterion("student_num >", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_num >=", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumLessThan(Integer value) {
            addCriterion("student_num <", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumLessThanOrEqualTo(Integer value) {
            addCriterion("student_num <=", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumIn(List<Integer> values) {
            addCriterion("student_num in", values, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotIn(List<Integer> values) {
            addCriterion("student_num not in", values, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumBetween(Integer value1, Integer value2) {
            addCriterion("student_num between", value1, value2, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("student_num not between", value1, value2, "studentNum");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNull() {
            addCriterion("legal_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNotNull() {
            addCriterion("legal_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalNameEqualTo(String value) {
            addCriterion("legal_name =", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotEqualTo(String value) {
            addCriterion("legal_name <>", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThan(String value) {
            addCriterion("legal_name >", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_name >=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThan(String value) {
            addCriterion("legal_name <", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThanOrEqualTo(String value) {
            addCriterion("legal_name <=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLike(String value) {
            addCriterion("legal_name like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotLike(String value) {
            addCriterion("legal_name not like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIn(List<String> values) {
            addCriterion("legal_name in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotIn(List<String> values) {
            addCriterion("legal_name not in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameBetween(String value1, String value2) {
            addCriterion("legal_name between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotBetween(String value1, String value2) {
            addCriterion("legal_name not between", value1, value2, "legalName");
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

        public Criteria andIncomeMoneyIsNull() {
            addCriterion("income_money is null");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyIsNotNull() {
            addCriterion("income_money is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyEqualTo(BigDecimal value) {
            addCriterion("income_money =", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("income_money <>", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyGreaterThan(BigDecimal value) {
            addCriterion("income_money >", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income_money >=", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyLessThan(BigDecimal value) {
            addCriterion("income_money <", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income_money <=", value, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyIn(List<BigDecimal> values) {
            addCriterion("income_money in", values, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("income_money not in", values, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_money between", value1, value2, "incomeMoney");
            return (Criteria) this;
        }

        public Criteria andIncomeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_money not between", value1, value2, "incomeMoney");
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

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
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

        public Criteria andTransitionPictureIsNull() {
            addCriterion("transition_picture is null");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureIsNotNull() {
            addCriterion("transition_picture is not null");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureEqualTo(String value) {
            addCriterion("transition_picture =", value, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureNotEqualTo(String value) {
            addCriterion("transition_picture <>", value, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureGreaterThan(String value) {
            addCriterion("transition_picture >", value, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureGreaterThanOrEqualTo(String value) {
            addCriterion("transition_picture >=", value, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureLessThan(String value) {
            addCriterion("transition_picture <", value, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureLessThanOrEqualTo(String value) {
            addCriterion("transition_picture <=", value, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureLike(String value) {
            addCriterion("transition_picture like", value, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureNotLike(String value) {
            addCriterion("transition_picture not like", value, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureIn(List<String> values) {
            addCriterion("transition_picture in", values, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureNotIn(List<String> values) {
            addCriterion("transition_picture not in", values, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureBetween(String value1, String value2) {
            addCriterion("transition_picture between", value1, value2, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andTransitionPictureNotBetween(String value1, String value2) {
            addCriterion("transition_picture not between", value1, value2, "transitionPicture");
            return (Criteria) this;
        }

        public Criteria andRechargeNumIsNull() {
            addCriterion("recharge_num is null");
            return (Criteria) this;
        }

        public Criteria andRechargeNumIsNotNull() {
            addCriterion("recharge_num is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeNumEqualTo(BigDecimal value) {
            addCriterion("recharge_num =", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumNotEqualTo(BigDecimal value) {
            addCriterion("recharge_num <>", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumGreaterThan(BigDecimal value) {
            addCriterion("recharge_num >", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_num >=", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumLessThan(BigDecimal value) {
            addCriterion("recharge_num <", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_num <=", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumIn(List<BigDecimal> values) {
            addCriterion("recharge_num in", values, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumNotIn(List<BigDecimal> values) {
            addCriterion("recharge_num not in", values, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_num between", value1, value2, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_num not between", value1, value2, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceIsNull() {
            addCriterion("withdrawals_balance is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceIsNotNull() {
            addCriterion("withdrawals_balance is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceEqualTo(BigDecimal value) {
            addCriterion("withdrawals_balance =", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceNotEqualTo(BigDecimal value) {
            addCriterion("withdrawals_balance <>", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceGreaterThan(BigDecimal value) {
            addCriterion("withdrawals_balance >", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdrawals_balance >=", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceLessThan(BigDecimal value) {
            addCriterion("withdrawals_balance <", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdrawals_balance <=", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceIn(List<BigDecimal> values) {
            addCriterion("withdrawals_balance in", values, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceNotIn(List<BigDecimal> values) {
            addCriterion("withdrawals_balance not in", values, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdrawals_balance between", value1, value2, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdrawals_balance not between", value1, value2, "withdrawalsBalance");
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

        public Criteria andPianoShopScaleIsNull() {
            addCriterion("piano_shop_scale is null");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleIsNotNull() {
            addCriterion("piano_shop_scale is not null");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleEqualTo(String value) {
            addCriterion("piano_shop_scale =", value, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleNotEqualTo(String value) {
            addCriterion("piano_shop_scale <>", value, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleGreaterThan(String value) {
            addCriterion("piano_shop_scale >", value, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleGreaterThanOrEqualTo(String value) {
            addCriterion("piano_shop_scale >=", value, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleLessThan(String value) {
            addCriterion("piano_shop_scale <", value, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleLessThanOrEqualTo(String value) {
            addCriterion("piano_shop_scale <=", value, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleLike(String value) {
            addCriterion("piano_shop_scale like", value, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleNotLike(String value) {
            addCriterion("piano_shop_scale not like", value, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleIn(List<String> values) {
            addCriterion("piano_shop_scale in", values, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleNotIn(List<String> values) {
            addCriterion("piano_shop_scale not in", values, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleBetween(String value1, String value2) {
            addCriterion("piano_shop_scale between", value1, value2, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andPianoShopScaleNotBetween(String value1, String value2) {
            addCriterion("piano_shop_scale not between", value1, value2, "pianoShopScale");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdIsNull() {
            addCriterion("shop_scale_id is null");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdIsNotNull() {
            addCriterion("shop_scale_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdEqualTo(Integer value) {
            addCriterion("shop_scale_id =", value, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdNotEqualTo(Integer value) {
            addCriterion("shop_scale_id <>", value, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdGreaterThan(Integer value) {
            addCriterion("shop_scale_id >", value, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_scale_id >=", value, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdLessThan(Integer value) {
            addCriterion("shop_scale_id <", value, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_scale_id <=", value, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdIn(List<Integer> values) {
            addCriterion("shop_scale_id in", values, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdNotIn(List<Integer> values) {
            addCriterion("shop_scale_id not in", values, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_scale_id between", value1, value2, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andShopScaleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_scale_id not between", value1, value2, "shopScaleId");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeIsNull() {
            addCriterion("piano_shop_type is null");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeIsNotNull() {
            addCriterion("piano_shop_type is not null");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeEqualTo(String value) {
            addCriterion("piano_shop_type =", value, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeNotEqualTo(String value) {
            addCriterion("piano_shop_type <>", value, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeGreaterThan(String value) {
            addCriterion("piano_shop_type >", value, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeGreaterThanOrEqualTo(String value) {
            addCriterion("piano_shop_type >=", value, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeLessThan(String value) {
            addCriterion("piano_shop_type <", value, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeLessThanOrEqualTo(String value) {
            addCriterion("piano_shop_type <=", value, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeLike(String value) {
            addCriterion("piano_shop_type like", value, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeNotLike(String value) {
            addCriterion("piano_shop_type not like", value, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeIn(List<String> values) {
            addCriterion("piano_shop_type in", values, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeNotIn(List<String> values) {
            addCriterion("piano_shop_type not in", values, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeBetween(String value1, String value2) {
            addCriterion("piano_shop_type between", value1, value2, "pianoShopType");
            return (Criteria) this;
        }

        public Criteria andPianoShopTypeNotBetween(String value1, String value2) {
            addCriterion("piano_shop_type not between", value1, value2, "pianoShopType");
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

        public Criteria andPromoterRateIsNull() {
            addCriterion("promoter_rate is null");
            return (Criteria) this;
        }

        public Criteria andPromoterRateIsNotNull() {
            addCriterion("promoter_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterRateEqualTo(BigDecimal value) {
            addCriterion("promoter_rate =", value, "promoterRate");
            return (Criteria) this;
        }

        public Criteria andPromoterRateNotEqualTo(BigDecimal value) {
            addCriterion("promoter_rate <>", value, "promoterRate");
            return (Criteria) this;
        }

        public Criteria andPromoterRateGreaterThan(BigDecimal value) {
            addCriterion("promoter_rate >", value, "promoterRate");
            return (Criteria) this;
        }

        public Criteria andPromoterRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promoter_rate >=", value, "promoterRate");
            return (Criteria) this;
        }

        public Criteria andPromoterRateLessThan(BigDecimal value) {
            addCriterion("promoter_rate <", value, "promoterRate");
            return (Criteria) this;
        }

        public Criteria andPromoterRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promoter_rate <=", value, "promoterRate");
            return (Criteria) this;
        }

        public Criteria andPromoterRateIn(List<BigDecimal> values) {
            addCriterion("promoter_rate in", values, "promoterRate");
            return (Criteria) this;
        }

        public Criteria andPromoterRateNotIn(List<BigDecimal> values) {
            addCriterion("promoter_rate not in", values, "promoterRate");
            return (Criteria) this;
        }

        public Criteria andPromoterRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promoter_rate between", value1, value2, "promoterRate");
            return (Criteria) this;
        }

        public Criteria andPromoterRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promoter_rate not between", value1, value2, "promoterRate");
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