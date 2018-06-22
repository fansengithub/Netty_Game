package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeworkDatailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HomeworkDatailExample() {
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

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
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

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Integer value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Integer value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Integer value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Integer value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Integer> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Integer> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Integer value1, Integer value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStudentIsNull() {
            addCriterion("student is null");
            return (Criteria) this;
        }

        public Criteria andStudentIsNotNull() {
            addCriterion("student is not null");
            return (Criteria) this;
        }

        public Criteria andStudentEqualTo(String value) {
            addCriterion("student =", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentNotEqualTo(String value) {
            addCriterion("student <>", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentGreaterThan(String value) {
            addCriterion("student >", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentGreaterThanOrEqualTo(String value) {
            addCriterion("student >=", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentLessThan(String value) {
            addCriterion("student <", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentLessThanOrEqualTo(String value) {
            addCriterion("student <=", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentLike(String value) {
            addCriterion("student like", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentNotLike(String value) {
            addCriterion("student not like", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentIn(List<String> values) {
            addCriterion("student in", values, "student");
            return (Criteria) this;
        }

        public Criteria andStudentNotIn(List<String> values) {
            addCriterion("student not in", values, "student");
            return (Criteria) this;
        }

        public Criteria andStudentBetween(String value1, String value2) {
            addCriterion("student between", value1, value2, "student");
            return (Criteria) this;
        }

        public Criteria andStudentNotBetween(String value1, String value2) {
            addCriterion("student not between", value1, value2, "student");
            return (Criteria) this;
        }

        public Criteria andParentIsNull() {
            addCriterion("parent is null");
            return (Criteria) this;
        }

        public Criteria andParentIsNotNull() {
            addCriterion("parent is not null");
            return (Criteria) this;
        }

        public Criteria andParentEqualTo(String value) {
            addCriterion("parent =", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotEqualTo(String value) {
            addCriterion("parent <>", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThan(String value) {
            addCriterion("parent >", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThanOrEqualTo(String value) {
            addCriterion("parent >=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThan(String value) {
            addCriterion("parent <", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThanOrEqualTo(String value) {
            addCriterion("parent <=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLike(String value) {
            addCriterion("parent like", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotLike(String value) {
            addCriterion("parent not like", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentIn(List<String> values) {
            addCriterion("parent in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotIn(List<String> values) {
            addCriterion("parent not in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentBetween(String value1, String value2) {
            addCriterion("parent between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotBetween(String value1, String value2) {
            addCriterion("parent not between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailIsNull() {
            addCriterion("homework_detail is null");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailIsNotNull() {
            addCriterion("homework_detail is not null");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailEqualTo(String value) {
            addCriterion("homework_detail =", value, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailNotEqualTo(String value) {
            addCriterion("homework_detail <>", value, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailGreaterThan(String value) {
            addCriterion("homework_detail >", value, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailGreaterThanOrEqualTo(String value) {
            addCriterion("homework_detail >=", value, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailLessThan(String value) {
            addCriterion("homework_detail <", value, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailLessThanOrEqualTo(String value) {
            addCriterion("homework_detail <=", value, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailLike(String value) {
            addCriterion("homework_detail like", value, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailNotLike(String value) {
            addCriterion("homework_detail not like", value, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailIn(List<String> values) {
            addCriterion("homework_detail in", values, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailNotIn(List<String> values) {
            addCriterion("homework_detail not in", values, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailBetween(String value1, String value2) {
            addCriterion("homework_detail between", value1, value2, "homeworkDetail");
            return (Criteria) this;
        }

        public Criteria andHomeworkDetailNotBetween(String value1, String value2) {
            addCriterion("homework_detail not between", value1, value2, "homeworkDetail");
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

        public Criteria andPracticeIsNull() {
            addCriterion("practice is null");
            return (Criteria) this;
        }

        public Criteria andPracticeIsNotNull() {
            addCriterion("practice is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeEqualTo(Integer value) {
            addCriterion("practice =", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeNotEqualTo(Integer value) {
            addCriterion("practice <>", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeGreaterThan(Integer value) {
            addCriterion("practice >", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeGreaterThanOrEqualTo(Integer value) {
            addCriterion("practice >=", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeLessThan(Integer value) {
            addCriterion("practice <", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeLessThanOrEqualTo(Integer value) {
            addCriterion("practice <=", value, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeIn(List<Integer> values) {
            addCriterion("practice in", values, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeNotIn(List<Integer> values) {
            addCriterion("practice not in", values, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeBetween(Integer value1, Integer value2) {
            addCriterion("practice between", value1, value2, "practice");
            return (Criteria) this;
        }

        public Criteria andPracticeNotBetween(Integer value1, Integer value2) {
            addCriterion("practice not between", value1, value2, "practice");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeIsNull() {
            addCriterion("want_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeIsNotNull() {
            addCriterion("want_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeEqualTo(Date value) {
            addCriterion("want_finish_time =", value, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeNotEqualTo(Date value) {
            addCriterion("want_finish_time <>", value, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeGreaterThan(Date value) {
            addCriterion("want_finish_time >", value, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("want_finish_time >=", value, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeLessThan(Date value) {
            addCriterion("want_finish_time <", value, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("want_finish_time <=", value, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeIn(List<Date> values) {
            addCriterion("want_finish_time in", values, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeNotIn(List<Date> values) {
            addCriterion("want_finish_time not in", values, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeBetween(Date value1, Date value2) {
            addCriterion("want_finish_time between", value1, value2, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andWantFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("want_finish_time not between", value1, value2, "wantFinishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoIsNull() {
            addCriterion("belonto_piano is null");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoIsNotNull() {
            addCriterion("belonto_piano is not null");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoEqualTo(String value) {
            addCriterion("belonto_piano =", value, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoNotEqualTo(String value) {
            addCriterion("belonto_piano <>", value, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoGreaterThan(String value) {
            addCriterion("belonto_piano >", value, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoGreaterThanOrEqualTo(String value) {
            addCriterion("belonto_piano >=", value, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoLessThan(String value) {
            addCriterion("belonto_piano <", value, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoLessThanOrEqualTo(String value) {
            addCriterion("belonto_piano <=", value, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoLike(String value) {
            addCriterion("belonto_piano like", value, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoNotLike(String value) {
            addCriterion("belonto_piano not like", value, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoIn(List<String> values) {
            addCriterion("belonto_piano in", values, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoNotIn(List<String> values) {
            addCriterion("belonto_piano not in", values, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoBetween(String value1, String value2) {
            addCriterion("belonto_piano between", value1, value2, "belontoPiano");
            return (Criteria) this;
        }

        public Criteria andBelontoPianoNotBetween(String value1, String value2) {
            addCriterion("belonto_piano not between", value1, value2, "belontoPiano");
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