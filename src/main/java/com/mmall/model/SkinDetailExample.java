package com.mmall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SkinDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkinDetailExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andPrice1IsNull() {
            addCriterion("price_1 is null");
            return (Criteria) this;
        }

        public Criteria andPrice1IsNotNull() {
            addCriterion("price_1 is not null");
            return (Criteria) this;
        }

        public Criteria andPrice1EqualTo(Long value) {
            addCriterion("price_1 =", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotEqualTo(Long value) {
            addCriterion("price_1 <>", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1GreaterThan(Long value) {
            addCriterion("price_1 >", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1GreaterThanOrEqualTo(Long value) {
            addCriterion("price_1 >=", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1LessThan(Long value) {
            addCriterion("price_1 <", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1LessThanOrEqualTo(Long value) {
            addCriterion("price_1 <=", value, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1In(List<Long> values) {
            addCriterion("price_1 in", values, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotIn(List<Long> values) {
            addCriterion("price_1 not in", values, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1Between(Long value1, Long value2) {
            addCriterion("price_1 between", value1, value2, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice1NotBetween(Long value1, Long value2) {
            addCriterion("price_1 not between", value1, value2, "price1");
            return (Criteria) this;
        }

        public Criteria andPrice2IsNull() {
            addCriterion("price_2 is null");
            return (Criteria) this;
        }

        public Criteria andPrice2IsNotNull() {
            addCriterion("price_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPrice2EqualTo(Long value) {
            addCriterion("price_2 =", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2NotEqualTo(Long value) {
            addCriterion("price_2 <>", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2GreaterThan(Long value) {
            addCriterion("price_2 >", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2GreaterThanOrEqualTo(Long value) {
            addCriterion("price_2 >=", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2LessThan(Long value) {
            addCriterion("price_2 <", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2LessThanOrEqualTo(Long value) {
            addCriterion("price_2 <=", value, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2In(List<Long> values) {
            addCriterion("price_2 in", values, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2NotIn(List<Long> values) {
            addCriterion("price_2 not in", values, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2Between(Long value1, Long value2) {
            addCriterion("price_2 between", value1, value2, "price2");
            return (Criteria) this;
        }

        public Criteria andPrice2NotBetween(Long value1, Long value2) {
            addCriterion("price_2 not between", value1, value2, "price2");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceIsNull() {
            addCriterion("price_choice is null");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceIsNotNull() {
            addCriterion("price_choice is not null");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceEqualTo(Integer value) {
            addCriterion("price_choice =", value, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceNotEqualTo(Integer value) {
            addCriterion("price_choice <>", value, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceGreaterThan(Integer value) {
            addCriterion("price_choice >", value, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price_choice >=", value, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceLessThan(Integer value) {
            addCriterion("price_choice <", value, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceLessThanOrEqualTo(Integer value) {
            addCriterion("price_choice <=", value, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceIn(List<Integer> values) {
            addCriterion("price_choice in", values, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceNotIn(List<Integer> values) {
            addCriterion("price_choice not in", values, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceBetween(Integer value1, Integer value2) {
            addCriterion("price_choice between", value1, value2, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andPriceChoiceNotBetween(Integer value1, Integer value2) {
            addCriterion("price_choice not between", value1, value2, "priceChoice");
            return (Criteria) this;
        }

        public Criteria andDiscount1IsNull() {
            addCriterion("discount_1 is null");
            return (Criteria) this;
        }

        public Criteria andDiscount1IsNotNull() {
            addCriterion("discount_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount1EqualTo(Long value) {
            addCriterion("discount_1 =", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1NotEqualTo(Long value) {
            addCriterion("discount_1 <>", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1GreaterThan(Long value) {
            addCriterion("discount_1 >", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1GreaterThanOrEqualTo(Long value) {
            addCriterion("discount_1 >=", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1LessThan(Long value) {
            addCriterion("discount_1 <", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1LessThanOrEqualTo(Long value) {
            addCriterion("discount_1 <=", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1In(List<Long> values) {
            addCriterion("discount_1 in", values, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1NotIn(List<Long> values) {
            addCriterion("discount_1 not in", values, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1Between(Long value1, Long value2) {
            addCriterion("discount_1 between", value1, value2, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1NotBetween(Long value1, Long value2) {
            addCriterion("discount_1 not between", value1, value2, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount2IsNull() {
            addCriterion("discount_2 is null");
            return (Criteria) this;
        }

        public Criteria andDiscount2IsNotNull() {
            addCriterion("discount_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount2EqualTo(Long value) {
            addCriterion("discount_2 =", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2NotEqualTo(Long value) {
            addCriterion("discount_2 <>", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2GreaterThan(Long value) {
            addCriterion("discount_2 >", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2GreaterThanOrEqualTo(Long value) {
            addCriterion("discount_2 >=", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2LessThan(Long value) {
            addCriterion("discount_2 <", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2LessThanOrEqualTo(Long value) {
            addCriterion("discount_2 <=", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2In(List<Long> values) {
            addCriterion("discount_2 in", values, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2NotIn(List<Long> values) {
            addCriterion("discount_2 not in", values, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2Between(Long value1, Long value2) {
            addCriterion("discount_2 between", value1, value2, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2NotBetween(Long value1, Long value2) {
            addCriterion("discount_2 not between", value1, value2, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceIsNull() {
            addCriterion("discount_choice is null");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceIsNotNull() {
            addCriterion("discount_choice is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceEqualTo(Integer value) {
            addCriterion("discount_choice =", value, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceNotEqualTo(Integer value) {
            addCriterion("discount_choice <>", value, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceGreaterThan(Integer value) {
            addCriterion("discount_choice >", value, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount_choice >=", value, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceLessThan(Integer value) {
            addCriterion("discount_choice <", value, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceLessThanOrEqualTo(Integer value) {
            addCriterion("discount_choice <=", value, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceIn(List<Integer> values) {
            addCriterion("discount_choice in", values, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceNotIn(List<Integer> values) {
            addCriterion("discount_choice not in", values, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceBetween(Integer value1, Integer value2) {
            addCriterion("discount_choice between", value1, value2, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountChoiceNotBetween(Integer value1, Integer value2) {
            addCriterion("discount_choice not between", value1, value2, "discountChoice");
            return (Criteria) this;
        }

        public Criteria andDiscountUseIsNull() {
            addCriterion("discount_use is null");
            return (Criteria) this;
        }

        public Criteria andDiscountUseIsNotNull() {
            addCriterion("discount_use is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountUseEqualTo(Integer value) {
            addCriterion("discount_use =", value, "discountUse");
            return (Criteria) this;
        }

        public Criteria andDiscountUseNotEqualTo(Integer value) {
            addCriterion("discount_use <>", value, "discountUse");
            return (Criteria) this;
        }

        public Criteria andDiscountUseGreaterThan(Integer value) {
            addCriterion("discount_use >", value, "discountUse");
            return (Criteria) this;
        }

        public Criteria andDiscountUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount_use >=", value, "discountUse");
            return (Criteria) this;
        }

        public Criteria andDiscountUseLessThan(Integer value) {
            addCriterion("discount_use <", value, "discountUse");
            return (Criteria) this;
        }

        public Criteria andDiscountUseLessThanOrEqualTo(Integer value) {
            addCriterion("discount_use <=", value, "discountUse");
            return (Criteria) this;
        }

        public Criteria andDiscountUseIn(List<Integer> values) {
            addCriterion("discount_use in", values, "discountUse");
            return (Criteria) this;
        }

        public Criteria andDiscountUseNotIn(List<Integer> values) {
            addCriterion("discount_use not in", values, "discountUse");
            return (Criteria) this;
        }

        public Criteria andDiscountUseBetween(Integer value1, Integer value2) {
            addCriterion("discount_use between", value1, value2, "discountUse");
            return (Criteria) this;
        }

        public Criteria andDiscountUseNotBetween(Integer value1, Integer value2) {
            addCriterion("discount_use not between", value1, value2, "discountUse");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNull() {
            addCriterion("purchase_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNotNull() {
            addCriterion("purchase_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeEqualTo(Integer value) {
            addCriterion("purchase_time =", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotEqualTo(Integer value) {
            addCriterion("purchase_time <>", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThan(Integer value) {
            addCriterion("purchase_time >", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_time >=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThan(Integer value) {
            addCriterion("purchase_time <", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_time <=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIn(List<Integer> values) {
            addCriterion("purchase_time in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotIn(List<Integer> values) {
            addCriterion("purchase_time not in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeBetween(Integer value1, Integer value2) {
            addCriterion("purchase_time between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_time not between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeIsNull() {
            addCriterion("last_buy_time is null");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeIsNotNull() {
            addCriterion("last_buy_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeEqualTo(Date value) {
            addCriterion("last_buy_time =", value, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeNotEqualTo(Date value) {
            addCriterion("last_buy_time <>", value, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeGreaterThan(Date value) {
            addCriterion("last_buy_time >", value, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_buy_time >=", value, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeLessThan(Date value) {
            addCriterion("last_buy_time <", value, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_buy_time <=", value, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeIn(List<Date> values) {
            addCriterion("last_buy_time in", values, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeNotIn(List<Date> values) {
            addCriterion("last_buy_time not in", values, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeBetween(Date value1, Date value2) {
            addCriterion("last_buy_time between", value1, value2, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andLastBuyTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_buy_time not between", value1, value2, "lastBuyTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andOffShelfTimeIsNull() {
            addCriterion("off_shelf_time is null");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeIsNotNull() {
            addCriterion("off_shelf_time is not null");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeEqualTo(Date value) {
            addCriterion("off_shelf_time =", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeNotEqualTo(Date value) {
            addCriterion("off_shelf_time <>", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeGreaterThan(Date value) {
            addCriterion("off_shelf_time >", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("off_shelf_time >=", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeLessThan(Date value) {
            addCriterion("off_shelf_time <", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeLessThanOrEqualTo(Date value) {
            addCriterion("off_shelf_time <=", value, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeIn(List<Date> values) {
            addCriterion("off_shelf_time in", values, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeNotIn(List<Date> values) {
            addCriterion("off_shelf_time not in", values, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeBetween(Date value1, Date value2) {
            addCriterion("off_shelf_time between", value1, value2, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOffShelfTimeNotBetween(Date value1, Date value2) {
            addCriterion("off_shelf_time not between", value1, value2, "offShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeIsNull() {
            addCriterion("on_shelf_time is null");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeIsNotNull() {
            addCriterion("on_shelf_time is not null");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeEqualTo(Date value) {
            addCriterion("on_shelf_time =", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeNotEqualTo(Date value) {
            addCriterion("on_shelf_time <>", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeGreaterThan(Date value) {
            addCriterion("on_shelf_time >", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("on_shelf_time >=", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeLessThan(Date value) {
            addCriterion("on_shelf_time <", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeLessThanOrEqualTo(Date value) {
            addCriterion("on_shelf_time <=", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeIn(List<Date> values) {
            addCriterion("on_shelf_time in", values, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeNotIn(List<Date> values) {
            addCriterion("on_shelf_time not in", values, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeBetween(Date value1, Date value2) {
            addCriterion("on_shelf_time between", value1, value2, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeNotBetween(Date value1, Date value2) {
            addCriterion("on_shelf_time not between", value1, value2, "onShelfTime");
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

        public Criteria andSkinPictureIsNull() {
            addCriterion("skin_picture is null");
            return (Criteria) this;
        }

        public Criteria andSkinPictureIsNotNull() {
            addCriterion("skin_picture is not null");
            return (Criteria) this;
        }

        public Criteria andSkinPictureEqualTo(String value) {
            addCriterion("skin_picture =", value, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureNotEqualTo(String value) {
            addCriterion("skin_picture <>", value, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureGreaterThan(String value) {
            addCriterion("skin_picture >", value, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureGreaterThanOrEqualTo(String value) {
            addCriterion("skin_picture >=", value, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureLessThan(String value) {
            addCriterion("skin_picture <", value, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureLessThanOrEqualTo(String value) {
            addCriterion("skin_picture <=", value, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureLike(String value) {
            addCriterion("skin_picture like", value, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureNotLike(String value) {
            addCriterion("skin_picture not like", value, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureIn(List<String> values) {
            addCriterion("skin_picture in", values, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureNotIn(List<String> values) {
            addCriterion("skin_picture not in", values, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureBetween(String value1, String value2) {
            addCriterion("skin_picture between", value1, value2, "skinPicture");
            return (Criteria) this;
        }

        public Criteria andSkinPictureNotBetween(String value1, String value2) {
            addCriterion("skin_picture not between", value1, value2, "skinPicture");
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