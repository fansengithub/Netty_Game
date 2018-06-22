package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsAdverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmsAdverExample() {
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

        public Criteria andColumnNameIsNull() {
            addCriterion("column_name is null");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNotNull() {
            addCriterion("column_name is not null");
            return (Criteria) this;
        }

        public Criteria andColumnNameEqualTo(Integer value) {
            addCriterion("column_name =", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotEqualTo(Integer value) {
            addCriterion("column_name <>", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThan(Integer value) {
            addCriterion("column_name >", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("column_name >=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThan(Integer value) {
            addCriterion("column_name <", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThanOrEqualTo(Integer value) {
            addCriterion("column_name <=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameIn(List<Integer> values) {
            addCriterion("column_name in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotIn(List<Integer> values) {
            addCriterion("column_name not in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameBetween(Integer value1, Integer value2) {
            addCriterion("column_name between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotBetween(Integer value1, Integer value2) {
            addCriterion("column_name not between", value1, value2, "columnName");
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

        public Criteria andContantIsNull() {
            addCriterion("contant is null");
            return (Criteria) this;
        }

        public Criteria andContantIsNotNull() {
            addCriterion("contant is not null");
            return (Criteria) this;
        }

        public Criteria andContantEqualTo(String value) {
            addCriterion("contant =", value, "contant");
            return (Criteria) this;
        }

        public Criteria andContantNotEqualTo(String value) {
            addCriterion("contant <>", value, "contant");
            return (Criteria) this;
        }

        public Criteria andContantGreaterThan(String value) {
            addCriterion("contant >", value, "contant");
            return (Criteria) this;
        }

        public Criteria andContantGreaterThanOrEqualTo(String value) {
            addCriterion("contant >=", value, "contant");
            return (Criteria) this;
        }

        public Criteria andContantLessThan(String value) {
            addCriterion("contant <", value, "contant");
            return (Criteria) this;
        }

        public Criteria andContantLessThanOrEqualTo(String value) {
            addCriterion("contant <=", value, "contant");
            return (Criteria) this;
        }

        public Criteria andContantLike(String value) {
            addCriterion("contant like", value, "contant");
            return (Criteria) this;
        }

        public Criteria andContantNotLike(String value) {
            addCriterion("contant not like", value, "contant");
            return (Criteria) this;
        }

        public Criteria andContantIn(List<String> values) {
            addCriterion("contant in", values, "contant");
            return (Criteria) this;
        }

        public Criteria andContantNotIn(List<String> values) {
            addCriterion("contant not in", values, "contant");
            return (Criteria) this;
        }

        public Criteria andContantBetween(String value1, String value2) {
            addCriterion("contant between", value1, value2, "contant");
            return (Criteria) this;
        }

        public Criteria andContantNotBetween(String value1, String value2) {
            addCriterion("contant not between", value1, value2, "contant");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNull() {
            addCriterion("column_type is null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIsNotNull() {
            addCriterion("column_type is not null");
            return (Criteria) this;
        }

        public Criteria andColumnTypeEqualTo(Integer value) {
            addCriterion("column_type =", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotEqualTo(Integer value) {
            addCriterion("column_type <>", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThan(Integer value) {
            addCriterion("column_type >", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("column_type >=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThan(Integer value) {
            addCriterion("column_type <", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeLessThanOrEqualTo(Integer value) {
            addCriterion("column_type <=", value, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeIn(List<Integer> values) {
            addCriterion("column_type in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotIn(List<Integer> values) {
            addCriterion("column_type not in", values, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeBetween(Integer value1, Integer value2) {
            addCriterion("column_type between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andColumnTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("column_type not between", value1, value2, "columnType");
            return (Criteria) this;
        }

        public Criteria andFounderIsNull() {
            addCriterion("founder is null");
            return (Criteria) this;
        }

        public Criteria andFounderIsNotNull() {
            addCriterion("founder is not null");
            return (Criteria) this;
        }

        public Criteria andFounderEqualTo(String value) {
            addCriterion("founder =", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderNotEqualTo(String value) {
            addCriterion("founder <>", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderGreaterThan(String value) {
            addCriterion("founder >", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderGreaterThanOrEqualTo(String value) {
            addCriterion("founder >=", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderLessThan(String value) {
            addCriterion("founder <", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderLessThanOrEqualTo(String value) {
            addCriterion("founder <=", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderLike(String value) {
            addCriterion("founder like", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderNotLike(String value) {
            addCriterion("founder not like", value, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderIn(List<String> values) {
            addCriterion("founder in", values, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderNotIn(List<String> values) {
            addCriterion("founder not in", values, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderBetween(String value1, String value2) {
            addCriterion("founder between", value1, value2, "founder");
            return (Criteria) this;
        }

        public Criteria andFounderNotBetween(String value1, String value2) {
            addCriterion("founder not between", value1, value2, "founder");
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

        public Criteria andTextContentIsNull() {
            addCriterion("text_content is null");
            return (Criteria) this;
        }

        public Criteria andTextContentIsNotNull() {
            addCriterion("text_content is not null");
            return (Criteria) this;
        }

        public Criteria andTextContentEqualTo(String value) {
            addCriterion("text_content =", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotEqualTo(String value) {
            addCriterion("text_content <>", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentGreaterThan(String value) {
            addCriterion("text_content >", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentGreaterThanOrEqualTo(String value) {
            addCriterion("text_content >=", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentLessThan(String value) {
            addCriterion("text_content <", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentLessThanOrEqualTo(String value) {
            addCriterion("text_content <=", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentLike(String value) {
            addCriterion("text_content like", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotLike(String value) {
            addCriterion("text_content not like", value, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentIn(List<String> values) {
            addCriterion("text_content in", values, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotIn(List<String> values) {
            addCriterion("text_content not in", values, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentBetween(String value1, String value2) {
            addCriterion("text_content between", value1, value2, "textContent");
            return (Criteria) this;
        }

        public Criteria andTextContentNotBetween(String value1, String value2) {
            addCriterion("text_content not between", value1, value2, "textContent");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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