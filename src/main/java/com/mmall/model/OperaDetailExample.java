package com.mmall.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperaDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperaDetailExample() {
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

        public Criteria andLearnbookNameIsNull() {
            addCriterion("learnBook_name is null");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameIsNotNull() {
            addCriterion("learnBook_name is not null");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameEqualTo(String value) {
            addCriterion("learnBook_name =", value, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameNotEqualTo(String value) {
            addCriterion("learnBook_name <>", value, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameGreaterThan(String value) {
            addCriterion("learnBook_name >", value, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameGreaterThanOrEqualTo(String value) {
            addCriterion("learnBook_name >=", value, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameLessThan(String value) {
            addCriterion("learnBook_name <", value, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameLessThanOrEqualTo(String value) {
            addCriterion("learnBook_name <=", value, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameLike(String value) {
            addCriterion("learnBook_name like", value, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameNotLike(String value) {
            addCriterion("learnBook_name not like", value, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameIn(List<String> values) {
            addCriterion("learnBook_name in", values, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameNotIn(List<String> values) {
            addCriterion("learnBook_name not in", values, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameBetween(String value1, String value2) {
            addCriterion("learnBook_name between", value1, value2, "learnbookName");
            return (Criteria) this;
        }

        public Criteria andLearnbookNameNotBetween(String value1, String value2) {
            addCriterion("learnBook_name not between", value1, value2, "learnbookName");
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

        public Criteria andStyleIsNull() {
            addCriterion("style is null");
            return (Criteria) this;
        }

        public Criteria andStyleIsNotNull() {
            addCriterion("style is not null");
            return (Criteria) this;
        }

        public Criteria andStyleEqualTo(String value) {
            addCriterion("style =", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotEqualTo(String value) {
            addCriterion("style <>", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThan(String value) {
            addCriterion("style >", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThanOrEqualTo(String value) {
            addCriterion("style >=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThan(String value) {
            addCriterion("style <", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThanOrEqualTo(String value) {
            addCriterion("style <=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLike(String value) {
            addCriterion("style like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotLike(String value) {
            addCriterion("style not like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleIn(List<String> values) {
            addCriterion("style in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotIn(List<String> values) {
            addCriterion("style not in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleBetween(String value1, String value2) {
            addCriterion("style between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotBetween(String value1, String value2) {
            addCriterion("style not between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andApplyStageIsNull() {
            addCriterion("apply_stage is null");
            return (Criteria) this;
        }

        public Criteria andApplyStageIsNotNull() {
            addCriterion("apply_stage is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStageEqualTo(String value) {
            addCriterion("apply_stage =", value, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageNotEqualTo(String value) {
            addCriterion("apply_stage <>", value, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageGreaterThan(String value) {
            addCriterion("apply_stage >", value, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageGreaterThanOrEqualTo(String value) {
            addCriterion("apply_stage >=", value, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageLessThan(String value) {
            addCriterion("apply_stage <", value, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageLessThanOrEqualTo(String value) {
            addCriterion("apply_stage <=", value, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageLike(String value) {
            addCriterion("apply_stage like", value, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageNotLike(String value) {
            addCriterion("apply_stage not like", value, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageIn(List<String> values) {
            addCriterion("apply_stage in", values, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageNotIn(List<String> values) {
            addCriterion("apply_stage not in", values, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageBetween(String value1, String value2) {
            addCriterion("apply_stage between", value1, value2, "applyStage");
            return (Criteria) this;
        }

        public Criteria andApplyStageNotBetween(String value1, String value2) {
            addCriterion("apply_stage not between", value1, value2, "applyStage");
            return (Criteria) this;
        }

        public Criteria andOperaNameIsNull() {
            addCriterion("opera_name is null");
            return (Criteria) this;
        }

        public Criteria andOperaNameIsNotNull() {
            addCriterion("opera_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperaNameEqualTo(String value) {
            addCriterion("opera_name =", value, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameNotEqualTo(String value) {
            addCriterion("opera_name <>", value, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameGreaterThan(String value) {
            addCriterion("opera_name >", value, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameGreaterThanOrEqualTo(String value) {
            addCriterion("opera_name >=", value, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameLessThan(String value) {
            addCriterion("opera_name <", value, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameLessThanOrEqualTo(String value) {
            addCriterion("opera_name <=", value, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameLike(String value) {
            addCriterion("opera_name like", value, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameNotLike(String value) {
            addCriterion("opera_name not like", value, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameIn(List<String> values) {
            addCriterion("opera_name in", values, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameNotIn(List<String> values) {
            addCriterion("opera_name not in", values, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameBetween(String value1, String value2) {
            addCriterion("opera_name between", value1, value2, "operaName");
            return (Criteria) this;
        }

        public Criteria andOperaNameNotBetween(String value1, String value2) {
            addCriterion("opera_name not between", value1, value2, "operaName");
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

        public Criteria andIsGetScoreIsNull() {
            addCriterion("is_get_score is null");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreIsNotNull() {
            addCriterion("is_get_score is not null");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreEqualTo(Integer value) {
            addCriterion("is_get_score =", value, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreNotEqualTo(Integer value) {
            addCriterion("is_get_score <>", value, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreGreaterThan(Integer value) {
            addCriterion("is_get_score >", value, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_get_score >=", value, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreLessThan(Integer value) {
            addCriterion("is_get_score <", value, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreLessThanOrEqualTo(Integer value) {
            addCriterion("is_get_score <=", value, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreIn(List<Integer> values) {
            addCriterion("is_get_score in", values, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreNotIn(List<Integer> values) {
            addCriterion("is_get_score not in", values, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreBetween(Integer value1, Integer value2) {
            addCriterion("is_get_score between", value1, value2, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsGetScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("is_get_score not between", value1, value2, "isGetScore");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNull() {
            addCriterion("is_open is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNotNull() {
            addCriterion("is_open is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenEqualTo(Integer value) {
            addCriterion("is_open =", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotEqualTo(Integer value) {
            addCriterion("is_open <>", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThan(Integer value) {
            addCriterion("is_open >", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_open >=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThan(Integer value) {
            addCriterion("is_open <", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThanOrEqualTo(Integer value) {
            addCriterion("is_open <=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenIn(List<Integer> values) {
            addCriterion("is_open in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotIn(List<Integer> values) {
            addCriterion("is_open not in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenBetween(Integer value1, Integer value2) {
            addCriterion("is_open between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotBetween(Integer value1, Integer value2) {
            addCriterion("is_open not between", value1, value2, "isOpen");
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

        public Criteria andDownlaodAmountIsNull() {
            addCriterion("downlaod_amount is null");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountIsNotNull() {
            addCriterion("downlaod_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountEqualTo(Integer value) {
            addCriterion("downlaod_amount =", value, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountNotEqualTo(Integer value) {
            addCriterion("downlaod_amount <>", value, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountGreaterThan(Integer value) {
            addCriterion("downlaod_amount >", value, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("downlaod_amount >=", value, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountLessThan(Integer value) {
            addCriterion("downlaod_amount <", value, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountLessThanOrEqualTo(Integer value) {
            addCriterion("downlaod_amount <=", value, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountIn(List<Integer> values) {
            addCriterion("downlaod_amount in", values, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountNotIn(List<Integer> values) {
            addCriterion("downlaod_amount not in", values, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountBetween(Integer value1, Integer value2) {
            addCriterion("downlaod_amount between", value1, value2, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andDownlaodAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("downlaod_amount not between", value1, value2, "downlaodAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountIsNull() {
            addCriterion("saled_amount is null");
            return (Criteria) this;
        }

        public Criteria andSaledAmountIsNotNull() {
            addCriterion("saled_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSaledAmountEqualTo(Integer value) {
            addCriterion("saled_amount =", value, "saledAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountNotEqualTo(Integer value) {
            addCriterion("saled_amount <>", value, "saledAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountGreaterThan(Integer value) {
            addCriterion("saled_amount >", value, "saledAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("saled_amount >=", value, "saledAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountLessThan(Integer value) {
            addCriterion("saled_amount <", value, "saledAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountLessThanOrEqualTo(Integer value) {
            addCriterion("saled_amount <=", value, "saledAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountIn(List<Integer> values) {
            addCriterion("saled_amount in", values, "saledAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountNotIn(List<Integer> values) {
            addCriterion("saled_amount not in", values, "saledAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountBetween(Integer value1, Integer value2) {
            addCriterion("saled_amount between", value1, value2, "saledAmount");
            return (Criteria) this;
        }

        public Criteria andSaledAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("saled_amount not between", value1, value2, "saledAmount");
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

        public Criteria andIsUsedIsNull() {
            addCriterion("is_used is null");
            return (Criteria) this;
        }

        public Criteria andIsUsedIsNotNull() {
            addCriterion("is_used is not null");
            return (Criteria) this;
        }

        public Criteria andIsUsedEqualTo(Integer value) {
            addCriterion("is_used =", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotEqualTo(Integer value) {
            addCriterion("is_used <>", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThan(Integer value) {
            addCriterion("is_used >", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_used >=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThan(Integer value) {
            addCriterion("is_used <", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedLessThanOrEqualTo(Integer value) {
            addCriterion("is_used <=", value, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedIn(List<Integer> values) {
            addCriterion("is_used in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotIn(List<Integer> values) {
            addCriterion("is_used not in", values, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedBetween(Integer value1, Integer value2) {
            addCriterion("is_used between", value1, value2, "isUsed");
            return (Criteria) this;
        }

        public Criteria andIsUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_used not between", value1, value2, "isUsed");
            return (Criteria) this;
        }

        public Criteria andExplainPriceIsNull() {
            addCriterion("explain_price is null");
            return (Criteria) this;
        }

        public Criteria andExplainPriceIsNotNull() {
            addCriterion("explain_price is not null");
            return (Criteria) this;
        }

        public Criteria andExplainPriceEqualTo(BigDecimal value) {
            addCriterion("explain_price =", value, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andExplainPriceNotEqualTo(BigDecimal value) {
            addCriterion("explain_price <>", value, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andExplainPriceGreaterThan(BigDecimal value) {
            addCriterion("explain_price >", value, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andExplainPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("explain_price >=", value, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andExplainPriceLessThan(BigDecimal value) {
            addCriterion("explain_price <", value, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andExplainPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("explain_price <=", value, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andExplainPriceIn(List<BigDecimal> values) {
            addCriterion("explain_price in", values, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andExplainPriceNotIn(List<BigDecimal> values) {
            addCriterion("explain_price not in", values, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andExplainPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("explain_price between", value1, value2, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andExplainPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("explain_price not between", value1, value2, "explainPrice");
            return (Criteria) this;
        }

        public Criteria andPriceUsedIsNull() {
            addCriterion("price_used is null");
            return (Criteria) this;
        }

        public Criteria andPriceUsedIsNotNull() {
            addCriterion("price_used is not null");
            return (Criteria) this;
        }

        public Criteria andPriceUsedEqualTo(Integer value) {
            addCriterion("price_used =", value, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andPriceUsedNotEqualTo(Integer value) {
            addCriterion("price_used <>", value, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andPriceUsedGreaterThan(Integer value) {
            addCriterion("price_used >", value, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andPriceUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("price_used >=", value, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andPriceUsedLessThan(Integer value) {
            addCriterion("price_used <", value, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andPriceUsedLessThanOrEqualTo(Integer value) {
            addCriterion("price_used <=", value, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andPriceUsedIn(List<Integer> values) {
            addCriterion("price_used in", values, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andPriceUsedNotIn(List<Integer> values) {
            addCriterion("price_used not in", values, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andPriceUsedBetween(Integer value1, Integer value2) {
            addCriterion("price_used between", value1, value2, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andPriceUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("price_used not between", value1, value2, "priceUsed");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualTo(Integer value) {
            addCriterion("difficulty =", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(Integer value) {
            addCriterion("difficulty <>", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThan(Integer value) {
            addCriterion("difficulty >", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(Integer value) {
            addCriterion("difficulty >=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(Integer value) {
            addCriterion("difficulty <", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(Integer value) {
            addCriterion("difficulty <=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyIn(List<Integer> values) {
            addCriterion("difficulty in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<Integer> values) {
            addCriterion("difficulty not in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(Integer value1, Integer value2) {
            addCriterion("difficulty between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(Integer value1, Integer value2) {
            addCriterion("difficulty not between", value1, value2, "difficulty");
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

        public Criteria andExplainPictureIsNull() {
            addCriterion("explain_picture is null");
            return (Criteria) this;
        }

        public Criteria andExplainPictureIsNotNull() {
            addCriterion("explain_picture is not null");
            return (Criteria) this;
        }

        public Criteria andExplainPictureEqualTo(String value) {
            addCriterion("explain_picture =", value, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureNotEqualTo(String value) {
            addCriterion("explain_picture <>", value, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureGreaterThan(String value) {
            addCriterion("explain_picture >", value, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureGreaterThanOrEqualTo(String value) {
            addCriterion("explain_picture >=", value, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureLessThan(String value) {
            addCriterion("explain_picture <", value, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureLessThanOrEqualTo(String value) {
            addCriterion("explain_picture <=", value, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureLike(String value) {
            addCriterion("explain_picture like", value, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureNotLike(String value) {
            addCriterion("explain_picture not like", value, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureIn(List<String> values) {
            addCriterion("explain_picture in", values, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureNotIn(List<String> values) {
            addCriterion("explain_picture not in", values, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureBetween(String value1, String value2) {
            addCriterion("explain_picture between", value1, value2, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainPictureNotBetween(String value1, String value2) {
            addCriterion("explain_picture not between", value1, value2, "explainPicture");
            return (Criteria) this;
        }

        public Criteria andExplainVideoIsNull() {
            addCriterion("explain_video is null");
            return (Criteria) this;
        }

        public Criteria andExplainVideoIsNotNull() {
            addCriterion("explain_video is not null");
            return (Criteria) this;
        }

        public Criteria andExplainVideoEqualTo(String value) {
            addCriterion("explain_video =", value, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoNotEqualTo(String value) {
            addCriterion("explain_video <>", value, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoGreaterThan(String value) {
            addCriterion("explain_video >", value, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoGreaterThanOrEqualTo(String value) {
            addCriterion("explain_video >=", value, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoLessThan(String value) {
            addCriterion("explain_video <", value, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoLessThanOrEqualTo(String value) {
            addCriterion("explain_video <=", value, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoLike(String value) {
            addCriterion("explain_video like", value, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoNotLike(String value) {
            addCriterion("explain_video not like", value, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoIn(List<String> values) {
            addCriterion("explain_video in", values, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoNotIn(List<String> values) {
            addCriterion("explain_video not in", values, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoBetween(String value1, String value2) {
            addCriterion("explain_video between", value1, value2, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andExplainVideoNotBetween(String value1, String value2) {
            addCriterion("explain_video not between", value1, value2, "explainVideo");
            return (Criteria) this;
        }

        public Criteria andMusicScoreIsNull() {
            addCriterion("music_score is null");
            return (Criteria) this;
        }

        public Criteria andMusicScoreIsNotNull() {
            addCriterion("music_score is not null");
            return (Criteria) this;
        }

        public Criteria andMusicScoreEqualTo(String value) {
            addCriterion("music_score =", value, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreNotEqualTo(String value) {
            addCriterion("music_score <>", value, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreGreaterThan(String value) {
            addCriterion("music_score >", value, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreGreaterThanOrEqualTo(String value) {
            addCriterion("music_score >=", value, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreLessThan(String value) {
            addCriterion("music_score <", value, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreLessThanOrEqualTo(String value) {
            addCriterion("music_score <=", value, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreLike(String value) {
            addCriterion("music_score like", value, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreNotLike(String value) {
            addCriterion("music_score not like", value, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreIn(List<String> values) {
            addCriterion("music_score in", values, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreNotIn(List<String> values) {
            addCriterion("music_score not in", values, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreBetween(String value1, String value2) {
            addCriterion("music_score between", value1, value2, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicScoreNotBetween(String value1, String value2) {
            addCriterion("music_score not between", value1, value2, "musicScore");
            return (Criteria) this;
        }

        public Criteria andMusicIsNull() {
            addCriterion("music is null");
            return (Criteria) this;
        }

        public Criteria andMusicIsNotNull() {
            addCriterion("music is not null");
            return (Criteria) this;
        }

        public Criteria andMusicEqualTo(String value) {
            addCriterion("music =", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotEqualTo(String value) {
            addCriterion("music <>", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicGreaterThan(String value) {
            addCriterion("music >", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicGreaterThanOrEqualTo(String value) {
            addCriterion("music >=", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicLessThan(String value) {
            addCriterion("music <", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicLessThanOrEqualTo(String value) {
            addCriterion("music <=", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicLike(String value) {
            addCriterion("music like", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotLike(String value) {
            addCriterion("music not like", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicIn(List<String> values) {
            addCriterion("music in", values, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotIn(List<String> values) {
            addCriterion("music not in", values, "music");
            return (Criteria) this;
        }

        public Criteria andMusicBetween(String value1, String value2) {
            addCriterion("music between", value1, value2, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotBetween(String value1, String value2) {
            addCriterion("music not between", value1, value2, "music");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiIsNull() {
            addCriterion("music_score_midi is null");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiIsNotNull() {
            addCriterion("music_score_midi is not null");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiEqualTo(String value) {
            addCriterion("music_score_midi =", value, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiNotEqualTo(String value) {
            addCriterion("music_score_midi <>", value, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiGreaterThan(String value) {
            addCriterion("music_score_midi >", value, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiGreaterThanOrEqualTo(String value) {
            addCriterion("music_score_midi >=", value, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiLessThan(String value) {
            addCriterion("music_score_midi <", value, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiLessThanOrEqualTo(String value) {
            addCriterion("music_score_midi <=", value, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiLike(String value) {
            addCriterion("music_score_midi like", value, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiNotLike(String value) {
            addCriterion("music_score_midi not like", value, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiIn(List<String> values) {
            addCriterion("music_score_midi in", values, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiNotIn(List<String> values) {
            addCriterion("music_score_midi not in", values, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiBetween(String value1, String value2) {
            addCriterion("music_score_midi between", value1, value2, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andMusicScoreMidiNotBetween(String value1, String value2) {
            addCriterion("music_score_midi not between", value1, value2, "musicScoreMidi");
            return (Criteria) this;
        }

        public Criteria andProfileIsNull() {
            addCriterion("profile is null");
            return (Criteria) this;
        }

        public Criteria andProfileIsNotNull() {
            addCriterion("profile is not null");
            return (Criteria) this;
        }

        public Criteria andProfileEqualTo(String value) {
            addCriterion("profile =", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotEqualTo(String value) {
            addCriterion("profile <>", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThan(String value) {
            addCriterion("profile >", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileGreaterThanOrEqualTo(String value) {
            addCriterion("profile >=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThan(String value) {
            addCriterion("profile <", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLessThanOrEqualTo(String value) {
            addCriterion("profile <=", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileLike(String value) {
            addCriterion("profile like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotLike(String value) {
            addCriterion("profile not like", value, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileIn(List<String> values) {
            addCriterion("profile in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotIn(List<String> values) {
            addCriterion("profile not in", values, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileBetween(String value1, String value2) {
            addCriterion("profile between", value1, value2, "profile");
            return (Criteria) this;
        }

        public Criteria andProfileNotBetween(String value1, String value2) {
            addCriterion("profile not between", value1, value2, "profile");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNull() {
            addCriterion("edit_time is null");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNotNull() {
            addCriterion("edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andEditTimeEqualTo(Date value) {
            addCriterion("edit_time =", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotEqualTo(Date value) {
            addCriterion("edit_time <>", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThan(Date value) {
            addCriterion("edit_time >", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("edit_time >=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThan(Date value) {
            addCriterion("edit_time <", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThanOrEqualTo(Date value) {
            addCriterion("edit_time <=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIn(List<Date> values) {
            addCriterion("edit_time in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotIn(List<Date> values) {
            addCriterion("edit_time not in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeBetween(Date value1, Date value2) {
            addCriterion("edit_time between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotBetween(Date value1, Date value2) {
            addCriterion("edit_time not between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdIsNull() {
            addCriterion("classfiy_id is null");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdIsNotNull() {
            addCriterion("classfiy_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdEqualTo(Integer value) {
            addCriterion("classfiy_id =", value, "classfiyId");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdNotEqualTo(Integer value) {
            addCriterion("classfiy_id <>", value, "classfiyId");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdGreaterThan(Integer value) {
            addCriterion("classfiy_id >", value, "classfiyId");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("classfiy_id >=", value, "classfiyId");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdLessThan(Integer value) {
            addCriterion("classfiy_id <", value, "classfiyId");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdLessThanOrEqualTo(Integer value) {
            addCriterion("classfiy_id <=", value, "classfiyId");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdIn(List<Integer> values) {
            addCriterion("classfiy_id in", values, "classfiyId");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdNotIn(List<Integer> values) {
            addCriterion("classfiy_id not in", values, "classfiyId");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdBetween(Integer value1, Integer value2) {
            addCriterion("classfiy_id between", value1, value2, "classfiyId");
            return (Criteria) this;
        }

        public Criteria andClassfiyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("classfiy_id not between", value1, value2, "classfiyId");
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