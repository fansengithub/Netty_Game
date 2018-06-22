package com.mmall.model;

import java.util.ArrayList;
import java.util.List;

public class ShareProfitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareProfitExample() {
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

        public Criteria andGameProfitIsNull() {
            addCriterion("game_profit is null");
            return (Criteria) this;
        }

        public Criteria andGameProfitIsNotNull() {
            addCriterion("game_profit is not null");
            return (Criteria) this;
        }

        public Criteria andGameProfitEqualTo(Long value) {
            addCriterion("game_profit =", value, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andGameProfitNotEqualTo(Long value) {
            addCriterion("game_profit <>", value, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andGameProfitGreaterThan(Long value) {
            addCriterion("game_profit >", value, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andGameProfitGreaterThanOrEqualTo(Long value) {
            addCriterion("game_profit >=", value, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andGameProfitLessThan(Long value) {
            addCriterion("game_profit <", value, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andGameProfitLessThanOrEqualTo(Long value) {
            addCriterion("game_profit <=", value, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andGameProfitIn(List<Long> values) {
            addCriterion("game_profit in", values, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andGameProfitNotIn(List<Long> values) {
            addCriterion("game_profit not in", values, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andGameProfitBetween(Long value1, Long value2) {
            addCriterion("game_profit between", value1, value2, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andGameProfitNotBetween(Long value1, Long value2) {
            addCriterion("game_profit not between", value1, value2, "gameProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitIsNull() {
            addCriterion("learnBook_profit is null");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitIsNotNull() {
            addCriterion("learnBook_profit is not null");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitEqualTo(Long value) {
            addCriterion("learnBook_profit =", value, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitNotEqualTo(Long value) {
            addCriterion("learnBook_profit <>", value, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitGreaterThan(Long value) {
            addCriterion("learnBook_profit >", value, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitGreaterThanOrEqualTo(Long value) {
            addCriterion("learnBook_profit >=", value, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitLessThan(Long value) {
            addCriterion("learnBook_profit <", value, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitLessThanOrEqualTo(Long value) {
            addCriterion("learnBook_profit <=", value, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitIn(List<Long> values) {
            addCriterion("learnBook_profit in", values, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitNotIn(List<Long> values) {
            addCriterion("learnBook_profit not in", values, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitBetween(Long value1, Long value2) {
            addCriterion("learnBook_profit between", value1, value2, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andLearnbookProfitNotBetween(Long value1, Long value2) {
            addCriterion("learnBook_profit not between", value1, value2, "learnbookProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitIsNull() {
            addCriterion("skin_profit is null");
            return (Criteria) this;
        }

        public Criteria andSkinProfitIsNotNull() {
            addCriterion("skin_profit is not null");
            return (Criteria) this;
        }

        public Criteria andSkinProfitEqualTo(Long value) {
            addCriterion("skin_profit =", value, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitNotEqualTo(Long value) {
            addCriterion("skin_profit <>", value, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitGreaterThan(Long value) {
            addCriterion("skin_profit >", value, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitGreaterThanOrEqualTo(Long value) {
            addCriterion("skin_profit >=", value, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitLessThan(Long value) {
            addCriterion("skin_profit <", value, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitLessThanOrEqualTo(Long value) {
            addCriterion("skin_profit <=", value, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitIn(List<Long> values) {
            addCriterion("skin_profit in", values, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitNotIn(List<Long> values) {
            addCriterion("skin_profit not in", values, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitBetween(Long value1, Long value2) {
            addCriterion("skin_profit between", value1, value2, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andSkinProfitNotBetween(Long value1, Long value2) {
            addCriterion("skin_profit not between", value1, value2, "skinProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitIsNull() {
            addCriterion("create_teacher_profit is null");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitIsNotNull() {
            addCriterion("create_teacher_profit is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitEqualTo(Long value) {
            addCriterion("create_teacher_profit =", value, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitNotEqualTo(Long value) {
            addCriterion("create_teacher_profit <>", value, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitGreaterThan(Long value) {
            addCriterion("create_teacher_profit >", value, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitGreaterThanOrEqualTo(Long value) {
            addCriterion("create_teacher_profit >=", value, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitLessThan(Long value) {
            addCriterion("create_teacher_profit <", value, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitLessThanOrEqualTo(Long value) {
            addCriterion("create_teacher_profit <=", value, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitIn(List<Long> values) {
            addCriterion("create_teacher_profit in", values, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitNotIn(List<Long> values) {
            addCriterion("create_teacher_profit not in", values, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitBetween(Long value1, Long value2) {
            addCriterion("create_teacher_profit between", value1, value2, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andCreateTeacherProfitNotBetween(Long value1, Long value2) {
            addCriterion("create_teacher_profit not between", value1, value2, "createTeacherProfit");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Integer value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andOperaExplainIsNull() {
            addCriterion("opera_explain is null");
            return (Criteria) this;
        }

        public Criteria andOperaExplainIsNotNull() {
            addCriterion("opera_explain is not null");
            return (Criteria) this;
        }

        public Criteria andOperaExplainEqualTo(Long value) {
            addCriterion("opera_explain =", value, "operaExplain");
            return (Criteria) this;
        }

        public Criteria andOperaExplainNotEqualTo(Long value) {
            addCriterion("opera_explain <>", value, "operaExplain");
            return (Criteria) this;
        }

        public Criteria andOperaExplainGreaterThan(Long value) {
            addCriterion("opera_explain >", value, "operaExplain");
            return (Criteria) this;
        }

        public Criteria andOperaExplainGreaterThanOrEqualTo(Long value) {
            addCriterion("opera_explain >=", value, "operaExplain");
            return (Criteria) this;
        }

        public Criteria andOperaExplainLessThan(Long value) {
            addCriterion("opera_explain <", value, "operaExplain");
            return (Criteria) this;
        }

        public Criteria andOperaExplainLessThanOrEqualTo(Long value) {
            addCriterion("opera_explain <=", value, "operaExplain");
            return (Criteria) this;
        }

        public Criteria andOperaExplainIn(List<Long> values) {
            addCriterion("opera_explain in", values, "operaExplain");
            return (Criteria) this;
        }

        public Criteria andOperaExplainNotIn(List<Long> values) {
            addCriterion("opera_explain not in", values, "operaExplain");
            return (Criteria) this;
        }

        public Criteria andOperaExplainBetween(Long value1, Long value2) {
            addCriterion("opera_explain between", value1, value2, "operaExplain");
            return (Criteria) this;
        }

        public Criteria andOperaExplainNotBetween(Long value1, Long value2) {
            addCriterion("opera_explain not between", value1, value2, "operaExplain");
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