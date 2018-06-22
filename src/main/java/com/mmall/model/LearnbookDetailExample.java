package com.mmall.model;

import java.util.ArrayList;
import java.util.List;

public class LearnbookDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LearnbookDetailExample() {
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

        public Criteria andLearnbookIdIsNull() {
            addCriterion("learnBook_id is null");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdIsNotNull() {
            addCriterion("learnBook_id is not null");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdEqualTo(Integer value) {
            addCriterion("learnBook_id =", value, "learnbookId");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdNotEqualTo(Integer value) {
            addCriterion("learnBook_id <>", value, "learnbookId");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdGreaterThan(Integer value) {
            addCriterion("learnBook_id >", value, "learnbookId");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("learnBook_id >=", value, "learnbookId");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdLessThan(Integer value) {
            addCriterion("learnBook_id <", value, "learnbookId");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdLessThanOrEqualTo(Integer value) {
            addCriterion("learnBook_id <=", value, "learnbookId");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdIn(List<Integer> values) {
            addCriterion("learnBook_id in", values, "learnbookId");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdNotIn(List<Integer> values) {
            addCriterion("learnBook_id not in", values, "learnbookId");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdBetween(Integer value1, Integer value2) {
            addCriterion("learnBook_id between", value1, value2, "learnbookId");
            return (Criteria) this;
        }

        public Criteria andLearnbookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("learnBook_id not between", value1, value2, "learnbookId");
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

        public Criteria andPianoshopRoleIsNull() {
            addCriterion("pianoshop_role is null");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleIsNotNull() {
            addCriterion("pianoshop_role is not null");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleEqualTo(String value) {
            addCriterion("pianoshop_role =", value, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleNotEqualTo(String value) {
            addCriterion("pianoshop_role <>", value, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleGreaterThan(String value) {
            addCriterion("pianoshop_role >", value, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleGreaterThanOrEqualTo(String value) {
            addCriterion("pianoshop_role >=", value, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleLessThan(String value) {
            addCriterion("pianoshop_role <", value, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleLessThanOrEqualTo(String value) {
            addCriterion("pianoshop_role <=", value, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleLike(String value) {
            addCriterion("pianoshop_role like", value, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleNotLike(String value) {
            addCriterion("pianoshop_role not like", value, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleIn(List<String> values) {
            addCriterion("pianoshop_role in", values, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleNotIn(List<String> values) {
            addCriterion("pianoshop_role not in", values, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleBetween(String value1, String value2) {
            addCriterion("pianoshop_role between", value1, value2, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andPianoshopRoleNotBetween(String value1, String value2) {
            addCriterion("pianoshop_role not between", value1, value2, "pianoshopRole");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andCoverPictureIsNull() {
            addCriterion("cover_picture is null");
            return (Criteria) this;
        }

        public Criteria andCoverPictureIsNotNull() {
            addCriterion("cover_picture is not null");
            return (Criteria) this;
        }

        public Criteria andCoverPictureEqualTo(String value) {
            addCriterion("cover_picture =", value, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureNotEqualTo(String value) {
            addCriterion("cover_picture <>", value, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureGreaterThan(String value) {
            addCriterion("cover_picture >", value, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureGreaterThanOrEqualTo(String value) {
            addCriterion("cover_picture >=", value, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureLessThan(String value) {
            addCriterion("cover_picture <", value, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureLessThanOrEqualTo(String value) {
            addCriterion("cover_picture <=", value, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureLike(String value) {
            addCriterion("cover_picture like", value, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureNotLike(String value) {
            addCriterion("cover_picture not like", value, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureIn(List<String> values) {
            addCriterion("cover_picture in", values, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureNotIn(List<String> values) {
            addCriterion("cover_picture not in", values, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureBetween(String value1, String value2) {
            addCriterion("cover_picture between", value1, value2, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andCoverPictureNotBetween(String value1, String value2) {
            addCriterion("cover_picture not between", value1, value2, "coverPicture");
            return (Criteria) this;
        }

        public Criteria andOpernNumIsNull() {
            addCriterion("opern_num is null");
            return (Criteria) this;
        }

        public Criteria andOpernNumIsNotNull() {
            addCriterion("opern_num is not null");
            return (Criteria) this;
        }

        public Criteria andOpernNumEqualTo(Integer value) {
            addCriterion("opern_num =", value, "opernNum");
            return (Criteria) this;
        }

        public Criteria andOpernNumNotEqualTo(Integer value) {
            addCriterion("opern_num <>", value, "opernNum");
            return (Criteria) this;
        }

        public Criteria andOpernNumGreaterThan(Integer value) {
            addCriterion("opern_num >", value, "opernNum");
            return (Criteria) this;
        }

        public Criteria andOpernNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("opern_num >=", value, "opernNum");
            return (Criteria) this;
        }

        public Criteria andOpernNumLessThan(Integer value) {
            addCriterion("opern_num <", value, "opernNum");
            return (Criteria) this;
        }

        public Criteria andOpernNumLessThanOrEqualTo(Integer value) {
            addCriterion("opern_num <=", value, "opernNum");
            return (Criteria) this;
        }

        public Criteria andOpernNumIn(List<Integer> values) {
            addCriterion("opern_num in", values, "opernNum");
            return (Criteria) this;
        }

        public Criteria andOpernNumNotIn(List<Integer> values) {
            addCriterion("opern_num not in", values, "opernNum");
            return (Criteria) this;
        }

        public Criteria andOpernNumBetween(Integer value1, Integer value2) {
            addCriterion("opern_num between", value1, value2, "opernNum");
            return (Criteria) this;
        }

        public Criteria andOpernNumNotBetween(Integer value1, Integer value2) {
            addCriterion("opern_num not between", value1, value2, "opernNum");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNull() {
            addCriterion("is_recommend is null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNotNull() {
            addCriterion("is_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendEqualTo(Integer value) {
            addCriterion("is_recommend =", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotEqualTo(Integer value) {
            addCriterion("is_recommend <>", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThan(Integer value) {
            addCriterion("is_recommend >", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_recommend >=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThan(Integer value) {
            addCriterion("is_recommend <", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThanOrEqualTo(Integer value) {
            addCriterion("is_recommend <=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIn(List<Integer> values) {
            addCriterion("is_recommend in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotIn(List<Integer> values) {
            addCriterion("is_recommend not in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendBetween(Integer value1, Integer value2) {
            addCriterion("is_recommend between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotBetween(Integer value1, Integer value2) {
            addCriterion("is_recommend not between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsAnthorIsNull() {
            addCriterion("is_anthor is null");
            return (Criteria) this;
        }

        public Criteria andIsAnthorIsNotNull() {
            addCriterion("is_anthor is not null");
            return (Criteria) this;
        }

        public Criteria andIsAnthorEqualTo(Integer value) {
            addCriterion("is_anthor =", value, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andIsAnthorNotEqualTo(Integer value) {
            addCriterion("is_anthor <>", value, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andIsAnthorGreaterThan(Integer value) {
            addCriterion("is_anthor >", value, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andIsAnthorGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_anthor >=", value, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andIsAnthorLessThan(Integer value) {
            addCriterion("is_anthor <", value, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andIsAnthorLessThanOrEqualTo(Integer value) {
            addCriterion("is_anthor <=", value, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andIsAnthorIn(List<Integer> values) {
            addCriterion("is_anthor in", values, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andIsAnthorNotIn(List<Integer> values) {
            addCriterion("is_anthor not in", values, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andIsAnthorBetween(Integer value1, Integer value2) {
            addCriterion("is_anthor between", value1, value2, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andIsAnthorNotBetween(Integer value1, Integer value2) {
            addCriterion("is_anthor not between", value1, value2, "isAnthor");
            return (Criteria) this;
        }

        public Criteria andUsePermissionIsNull() {
            addCriterion("use_permission is null");
            return (Criteria) this;
        }

        public Criteria andUsePermissionIsNotNull() {
            addCriterion("use_permission is not null");
            return (Criteria) this;
        }

        public Criteria andUsePermissionEqualTo(String value) {
            addCriterion("use_permission =", value, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionNotEqualTo(String value) {
            addCriterion("use_permission <>", value, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionGreaterThan(String value) {
            addCriterion("use_permission >", value, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionGreaterThanOrEqualTo(String value) {
            addCriterion("use_permission >=", value, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionLessThan(String value) {
            addCriterion("use_permission <", value, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionLessThanOrEqualTo(String value) {
            addCriterion("use_permission <=", value, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionLike(String value) {
            addCriterion("use_permission like", value, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionNotLike(String value) {
            addCriterion("use_permission not like", value, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionIn(List<String> values) {
            addCriterion("use_permission in", values, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionNotIn(List<String> values) {
            addCriterion("use_permission not in", values, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionBetween(String value1, String value2) {
            addCriterion("use_permission between", value1, value2, "usePermission");
            return (Criteria) this;
        }

        public Criteria andUsePermissionNotBetween(String value1, String value2) {
            addCriterion("use_permission not between", value1, value2, "usePermission");
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