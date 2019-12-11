package spring.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PGoodsExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andPmsTypeIsNull() {
            addCriterion("pms_type is null");
            return (Criteria) this;
        }

        public Criteria andPmsTypeIsNotNull() {
            addCriterion("pms_type is not null");
            return (Criteria) this;
        }

        public Criteria andPmsTypeEqualTo(Long value) {
            addCriterion("pms_type =", value, "pmsType");
            return (Criteria) this;
        }

        public Criteria andPmsTypeNotEqualTo(Long value) {
            addCriterion("pms_type <>", value, "pmsType");
            return (Criteria) this;
        }

        public Criteria andPmsTypeGreaterThan(Long value) {
            addCriterion("pms_type >", value, "pmsType");
            return (Criteria) this;
        }

        public Criteria andPmsTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("pms_type >=", value, "pmsType");
            return (Criteria) this;
        }

        public Criteria andPmsTypeLessThan(Long value) {
            addCriterion("pms_type <", value, "pmsType");
            return (Criteria) this;
        }

        public Criteria andPmsTypeLessThanOrEqualTo(Long value) {
            addCriterion("pms_type <=", value, "pmsType");
            return (Criteria) this;
        }

        public Criteria andPmsTypeIn(List<Long> values) {
            addCriterion("pms_type in", values, "pmsType");
            return (Criteria) this;
        }

        public Criteria andPmsTypeNotIn(List<Long> values) {
            addCriterion("pms_type not in", values, "pmsType");
            return (Criteria) this;
        }

        public Criteria andPmsTypeBetween(Long value1, Long value2) {
            addCriterion("pms_type between", value1, value2, "pmsType");
            return (Criteria) this;
        }

        public Criteria andPmsTypeNotBetween(Long value1, Long value2) {
            addCriterion("pms_type not between", value1, value2, "pmsType");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandIsNull() {
            addCriterion("goods_brand is null");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandIsNotNull() {
            addCriterion("goods_brand is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandEqualTo(String value) {
            addCriterion("goods_brand =", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotEqualTo(String value) {
            addCriterion("goods_brand <>", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandGreaterThan(String value) {
            addCriterion("goods_brand >", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandGreaterThanOrEqualTo(String value) {
            addCriterion("goods_brand >=", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandLessThan(String value) {
            addCriterion("goods_brand <", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandLessThanOrEqualTo(String value) {
            addCriterion("goods_brand <=", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandLike(String value) {
            addCriterion("goods_brand like", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotLike(String value) {
            addCriterion("goods_brand not like", value, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandIn(List<String> values) {
            addCriterion("goods_brand in", values, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotIn(List<String> values) {
            addCriterion("goods_brand not in", values, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandBetween(String value1, String value2) {
            addCriterion("goods_brand between", value1, value2, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsBrandNotBetween(String value1, String value2) {
            addCriterion("goods_brand not between", value1, value2, "goodsBrand");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionIsNull() {
            addCriterion("goods_condition is null");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionIsNotNull() {
            addCriterion("goods_condition is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionEqualTo(Integer value) {
            addCriterion("goods_condition =", value, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionNotEqualTo(Integer value) {
            addCriterion("goods_condition <>", value, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionGreaterThan(Integer value) {
            addCriterion("goods_condition >", value, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_condition >=", value, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionLessThan(Integer value) {
            addCriterion("goods_condition <", value, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionLessThanOrEqualTo(Integer value) {
            addCriterion("goods_condition <=", value, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionIn(List<Integer> values) {
            addCriterion("goods_condition in", values, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionNotIn(List<Integer> values) {
            addCriterion("goods_condition not in", values, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionBetween(Integer value1, Integer value2) {
            addCriterion("goods_condition between", value1, value2, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsConditionNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_condition not between", value1, value2, "goodsCondition");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNull() {
            addCriterion("goods_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNotNull() {
            addCriterion("goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberEqualTo(Integer value) {
            addCriterion("goods_number =", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotEqualTo(Integer value) {
            addCriterion("goods_number <>", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThan(Integer value) {
            addCriterion("goods_number >", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_number >=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThan(Integer value) {
            addCriterion("goods_number <", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("goods_number <=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIn(List<Integer> values) {
            addCriterion("goods_number in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotIn(List<Integer> values) {
            addCriterion("goods_number not in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("goods_number between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_number not between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andFreshUsedIsNull() {
            addCriterion("fresh_used is null");
            return (Criteria) this;
        }

        public Criteria andFreshUsedIsNotNull() {
            addCriterion("fresh_used is not null");
            return (Criteria) this;
        }

        public Criteria andFreshUsedEqualTo(Integer value) {
            addCriterion("fresh_used =", value, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andFreshUsedNotEqualTo(Integer value) {
            addCriterion("fresh_used <>", value, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andFreshUsedGreaterThan(Integer value) {
            addCriterion("fresh_used >", value, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andFreshUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("fresh_used >=", value, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andFreshUsedLessThan(Integer value) {
            addCriterion("fresh_used <", value, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andFreshUsedLessThanOrEqualTo(Integer value) {
            addCriterion("fresh_used <=", value, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andFreshUsedIn(List<Integer> values) {
            addCriterion("fresh_used in", values, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andFreshUsedNotIn(List<Integer> values) {
            addCriterion("fresh_used not in", values, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andFreshUsedBetween(Integer value1, Integer value2) {
            addCriterion("fresh_used between", value1, value2, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andFreshUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("fresh_used not between", value1, value2, "freshUsed");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Long value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Long value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Long value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Long value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Long value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Long value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Long> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Long> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Long value1, Long value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Long value1, Long value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("discount_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(BigDecimal value) {
            addCriterion("discount_price =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(BigDecimal value) {
            addCriterion("discount_price <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(BigDecimal value) {
            addCriterion("discount_price >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(BigDecimal value) {
            addCriterion("discount_price <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<BigDecimal> values) {
            addCriterion("discount_price in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<BigDecimal> values) {
            addCriterion("discount_price not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price not between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountIsNull() {
            addCriterion("treasure_discount is null");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountIsNotNull() {
            addCriterion("treasure_discount is not null");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountEqualTo(Long value) {
            addCriterion("treasure_discount =", value, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountNotEqualTo(Long value) {
            addCriterion("treasure_discount <>", value, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountGreaterThan(Long value) {
            addCriterion("treasure_discount >", value, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountGreaterThanOrEqualTo(Long value) {
            addCriterion("treasure_discount >=", value, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountLessThan(Long value) {
            addCriterion("treasure_discount <", value, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountLessThanOrEqualTo(Long value) {
            addCriterion("treasure_discount <=", value, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountIn(List<Long> values) {
            addCriterion("treasure_discount in", values, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountNotIn(List<Long> values) {
            addCriterion("treasure_discount not in", values, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountBetween(Long value1, Long value2) {
            addCriterion("treasure_discount between", value1, value2, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountNotBetween(Long value1, Long value2) {
            addCriterion("treasure_discount not between", value1, value2, "treasureDiscount");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceIsNull() {
            addCriterion("treasure_discount_price is null");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceIsNotNull() {
            addCriterion("treasure_discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceEqualTo(BigDecimal value) {
            addCriterion("treasure_discount_price =", value, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceNotEqualTo(BigDecimal value) {
            addCriterion("treasure_discount_price <>", value, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceGreaterThan(BigDecimal value) {
            addCriterion("treasure_discount_price >", value, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("treasure_discount_price >=", value, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceLessThan(BigDecimal value) {
            addCriterion("treasure_discount_price <", value, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("treasure_discount_price <=", value, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceIn(List<BigDecimal> values) {
            addCriterion("treasure_discount_price in", values, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceNotIn(List<BigDecimal> values) {
            addCriterion("treasure_discount_price not in", values, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treasure_discount_price between", value1, value2, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andTreasureDiscountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("treasure_discount_price not between", value1, value2, "treasureDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andExpressIsNull() {
            addCriterion("express is null");
            return (Criteria) this;
        }

        public Criteria andExpressIsNotNull() {
            addCriterion("express is not null");
            return (Criteria) this;
        }

        public Criteria andExpressEqualTo(Integer value) {
            addCriterion("express =", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotEqualTo(Integer value) {
            addCriterion("express <>", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressGreaterThan(Integer value) {
            addCriterion("express >", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressGreaterThanOrEqualTo(Integer value) {
            addCriterion("express >=", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressLessThan(Integer value) {
            addCriterion("express <", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressLessThanOrEqualTo(Integer value) {
            addCriterion("express <=", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressIn(List<Integer> values) {
            addCriterion("express in", values, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotIn(List<Integer> values) {
            addCriterion("express not in", values, "express");
            return (Criteria) this;
        }

        public Criteria andExpressBetween(Integer value1, Integer value2) {
            addCriterion("express between", value1, value2, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotBetween(Integer value1, Integer value2) {
            addCriterion("express not between", value1, value2, "express");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNull() {
            addCriterion("express_id is null");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNotNull() {
            addCriterion("express_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpressIdEqualTo(Long value) {
            addCriterion("express_id =", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotEqualTo(Long value) {
            addCriterion("express_id <>", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThan(Long value) {
            addCriterion("express_id >", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            addCriterion("express_id >=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThan(Long value) {
            addCriterion("express_id <", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThanOrEqualTo(Long value) {
            addCriterion("express_id <=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdIn(List<Long> values) {
            addCriterion("express_id in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotIn(List<Long> values) {
            addCriterion("express_id not in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdBetween(Long value1, Long value2) {
            addCriterion("express_id between", value1, value2, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotBetween(Long value1, Long value2) {
            addCriterion("express_id not between", value1, value2, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNull() {
            addCriterion("express_name is null");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNotNull() {
            addCriterion("express_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNameEqualTo(String value) {
            addCriterion("express_name =", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            addCriterion("express_name <>", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThan(String value) {
            addCriterion("express_name >", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            addCriterion("express_name >=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThan(String value) {
            addCriterion("express_name <", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            addCriterion("express_name <=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLike(String value) {
            addCriterion("express_name like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotLike(String value) {
            addCriterion("express_name not like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameIn(List<String> values) {
            addCriterion("express_name in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            addCriterion("express_name not in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            addCriterion("express_name between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            addCriterion("express_name not between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceIsNull() {
            addCriterion("goods_service is null");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceIsNotNull() {
            addCriterion("goods_service is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceEqualTo(String value) {
            addCriterion("goods_service =", value, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceNotEqualTo(String value) {
            addCriterion("goods_service <>", value, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceGreaterThan(String value) {
            addCriterion("goods_service >", value, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceGreaterThanOrEqualTo(String value) {
            addCriterion("goods_service >=", value, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceLessThan(String value) {
            addCriterion("goods_service <", value, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceLessThanOrEqualTo(String value) {
            addCriterion("goods_service <=", value, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceLike(String value) {
            addCriterion("goods_service like", value, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceNotLike(String value) {
            addCriterion("goods_service not like", value, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceIn(List<String> values) {
            addCriterion("goods_service in", values, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceNotIn(List<String> values) {
            addCriterion("goods_service not in", values, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceBetween(String value1, String value2) {
            addCriterion("goods_service between", value1, value2, "goodsService");
            return (Criteria) this;
        }

        public Criteria andGoodsServiceNotBetween(String value1, String value2) {
            addCriterion("goods_service not between", value1, value2, "goodsService");
            return (Criteria) this;
        }

        public Criteria andContentDetailsIsNull() {
            addCriterion("content_details is null");
            return (Criteria) this;
        }

        public Criteria andContentDetailsIsNotNull() {
            addCriterion("content_details is not null");
            return (Criteria) this;
        }

        public Criteria andContentDetailsEqualTo(String value) {
            addCriterion("content_details =", value, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsNotEqualTo(String value) {
            addCriterion("content_details <>", value, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsGreaterThan(String value) {
            addCriterion("content_details >", value, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("content_details >=", value, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsLessThan(String value) {
            addCriterion("content_details <", value, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsLessThanOrEqualTo(String value) {
            addCriterion("content_details <=", value, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsLike(String value) {
            addCriterion("content_details like", value, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsNotLike(String value) {
            addCriterion("content_details not like", value, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsIn(List<String> values) {
            addCriterion("content_details in", values, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsNotIn(List<String> values) {
            addCriterion("content_details not in", values, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsBetween(String value1, String value2) {
            addCriterion("content_details between", value1, value2, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andContentDetailsNotBetween(String value1, String value2) {
            addCriterion("content_details not between", value1, value2, "contentDetails");
            return (Criteria) this;
        }

        public Criteria andMasterGraphIsNull() {
            addCriterion("master_graph is null");
            return (Criteria) this;
        }

        public Criteria andMasterGraphIsNotNull() {
            addCriterion("master_graph is not null");
            return (Criteria) this;
        }

        public Criteria andMasterGraphEqualTo(String value) {
            addCriterion("master_graph =", value, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphNotEqualTo(String value) {
            addCriterion("master_graph <>", value, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphGreaterThan(String value) {
            addCriterion("master_graph >", value, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphGreaterThanOrEqualTo(String value) {
            addCriterion("master_graph >=", value, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphLessThan(String value) {
            addCriterion("master_graph <", value, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphLessThanOrEqualTo(String value) {
            addCriterion("master_graph <=", value, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphLike(String value) {
            addCriterion("master_graph like", value, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphNotLike(String value) {
            addCriterion("master_graph not like", value, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphIn(List<String> values) {
            addCriterion("master_graph in", values, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphNotIn(List<String> values) {
            addCriterion("master_graph not in", values, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphBetween(String value1, String value2) {
            addCriterion("master_graph between", value1, value2, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andMasterGraphNotBetween(String value1, String value2) {
            addCriterion("master_graph not between", value1, value2, "masterGraph");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureIsNull() {
            addCriterion("goods_picture is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureIsNotNull() {
            addCriterion("goods_picture is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureEqualTo(String value) {
            addCriterion("goods_picture =", value, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureNotEqualTo(String value) {
            addCriterion("goods_picture <>", value, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureGreaterThan(String value) {
            addCriterion("goods_picture >", value, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureGreaterThanOrEqualTo(String value) {
            addCriterion("goods_picture >=", value, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureLessThan(String value) {
            addCriterion("goods_picture <", value, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureLessThanOrEqualTo(String value) {
            addCriterion("goods_picture <=", value, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureLike(String value) {
            addCriterion("goods_picture like", value, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureNotLike(String value) {
            addCriterion("goods_picture not like", value, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureIn(List<String> values) {
            addCriterion("goods_picture in", values, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureNotIn(List<String> values) {
            addCriterion("goods_picture not in", values, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureBetween(String value1, String value2) {
            addCriterion("goods_picture between", value1, value2, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureNotBetween(String value1, String value2) {
            addCriterion("goods_picture not between", value1, value2, "goodsPicture");
            return (Criteria) this;
        }

        public Criteria andGoodsStateIsNull() {
            addCriterion("goods_state is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStateIsNotNull() {
            addCriterion("goods_state is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStateEqualTo(Integer value) {
            addCriterion("goods_state =", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateNotEqualTo(Integer value) {
            addCriterion("goods_state <>", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateGreaterThan(Integer value) {
            addCriterion("goods_state >", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_state >=", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateLessThan(Integer value) {
            addCriterion("goods_state <", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateLessThanOrEqualTo(Integer value) {
            addCriterion("goods_state <=", value, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateIn(List<Integer> values) {
            addCriterion("goods_state in", values, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateNotIn(List<Integer> values) {
            addCriterion("goods_state not in", values, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateBetween(Integer value1, Integer value2) {
            addCriterion("goods_state between", value1, value2, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsStateNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_state not between", value1, value2, "goodsState");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(Integer value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(Integer value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(Integer value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(Integer value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<Integer> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<Integer> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(Integer value1, Integer value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeIsNull() {
            addCriterion("goods_num_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeIsNotNull() {
            addCriterion("goods_num_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeEqualTo(Integer value) {
            addCriterion("goods_num_type =", value, "goodsNumType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeNotEqualTo(Integer value) {
            addCriterion("goods_num_type <>", value, "goodsNumType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeGreaterThan(Integer value) {
            addCriterion("goods_num_type >", value, "goodsNumType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_num_type >=", value, "goodsNumType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeLessThan(Integer value) {
            addCriterion("goods_num_type <", value, "goodsNumType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_num_type <=", value, "goodsNumType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeIn(List<Integer> values) {
            addCriterion("goods_num_type in", values, "goodsNumType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeNotIn(List<Integer> values) {
            addCriterion("goods_num_type not in", values, "goodsNumType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeBetween(Integer value1, Integer value2) {
            addCriterion("goods_num_type between", value1, value2, "goodsNumType");
            return (Criteria) this;
        }

        public Criteria andGoodsNumTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_num_type not between", value1, value2, "goodsNumType");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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