package spring.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MRecoveryGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MRecoveryGoodsExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("member_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("member_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("member_name =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("member_name <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("member_name >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_name >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("member_name <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("member_name <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("member_name like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("member_name not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("member_name in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("member_name not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("member_name between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("member_name not between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNull() {
            addCriterion("order_state is null");
            return (Criteria) this;
        }

        public Criteria andOrderStateIsNotNull() {
            addCriterion("order_state is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStateEqualTo(Integer value) {
            addCriterion("order_state =", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotEqualTo(Integer value) {
            addCriterion("order_state <>", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThan(Integer value) {
            addCriterion("order_state >", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_state >=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThan(Integer value) {
            addCriterion("order_state <", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateLessThanOrEqualTo(Integer value) {
            addCriterion("order_state <=", value, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateIn(List<Integer> values) {
            addCriterion("order_state in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotIn(List<Integer> values) {
            addCriterion("order_state not in", values, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateBetween(Integer value1, Integer value2) {
            addCriterion("order_state between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andOrderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("order_state not between", value1, value2, "orderState");
            return (Criteria) this;
        }

        public Criteria andZPicIsNull() {
            addCriterion("z_pic is null");
            return (Criteria) this;
        }

        public Criteria andZPicIsNotNull() {
            addCriterion("z_pic is not null");
            return (Criteria) this;
        }

        public Criteria andZPicEqualTo(String value) {
            addCriterion("z_pic =", value, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicNotEqualTo(String value) {
            addCriterion("z_pic <>", value, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicGreaterThan(String value) {
            addCriterion("z_pic >", value, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicGreaterThanOrEqualTo(String value) {
            addCriterion("z_pic >=", value, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicLessThan(String value) {
            addCriterion("z_pic <", value, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicLessThanOrEqualTo(String value) {
            addCriterion("z_pic <=", value, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicLike(String value) {
            addCriterion("z_pic like", value, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicNotLike(String value) {
            addCriterion("z_pic not like", value, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicIn(List<String> values) {
            addCriterion("z_pic in", values, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicNotIn(List<String> values) {
            addCriterion("z_pic not in", values, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicBetween(String value1, String value2) {
            addCriterion("z_pic between", value1, value2, "zPic");
            return (Criteria) this;
        }

        public Criteria andZPicNotBetween(String value1, String value2) {
            addCriterion("z_pic not between", value1, value2, "zPic");
            return (Criteria) this;
        }

        public Criteria andXPicIsNull() {
            addCriterion("x_pic is null");
            return (Criteria) this;
        }

        public Criteria andXPicIsNotNull() {
            addCriterion("x_pic is not null");
            return (Criteria) this;
        }

        public Criteria andXPicEqualTo(String value) {
            addCriterion("x_pic =", value, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicNotEqualTo(String value) {
            addCriterion("x_pic <>", value, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicGreaterThan(String value) {
            addCriterion("x_pic >", value, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicGreaterThanOrEqualTo(String value) {
            addCriterion("x_pic >=", value, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicLessThan(String value) {
            addCriterion("x_pic <", value, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicLessThanOrEqualTo(String value) {
            addCriterion("x_pic <=", value, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicLike(String value) {
            addCriterion("x_pic like", value, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicNotLike(String value) {
            addCriterion("x_pic not like", value, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicIn(List<String> values) {
            addCriterion("x_pic in", values, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicNotIn(List<String> values) {
            addCriterion("x_pic not in", values, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicBetween(String value1, String value2) {
            addCriterion("x_pic between", value1, value2, "xPic");
            return (Criteria) this;
        }

        public Criteria andXPicNotBetween(String value1, String value2) {
            addCriterion("x_pic not between", value1, value2, "xPic");
            return (Criteria) this;
        }

        public Criteria andPPicIsNull() {
            addCriterion("p_pic is null");
            return (Criteria) this;
        }

        public Criteria andPPicIsNotNull() {
            addCriterion("p_pic is not null");
            return (Criteria) this;
        }

        public Criteria andPPicEqualTo(String value) {
            addCriterion("p_pic =", value, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicNotEqualTo(String value) {
            addCriterion("p_pic <>", value, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicGreaterThan(String value) {
            addCriterion("p_pic >", value, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicGreaterThanOrEqualTo(String value) {
            addCriterion("p_pic >=", value, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicLessThan(String value) {
            addCriterion("p_pic <", value, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicLessThanOrEqualTo(String value) {
            addCriterion("p_pic <=", value, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicLike(String value) {
            addCriterion("p_pic like", value, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicNotLike(String value) {
            addCriterion("p_pic not like", value, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicIn(List<String> values) {
            addCriterion("p_pic in", values, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicNotIn(List<String> values) {
            addCriterion("p_pic not in", values, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicBetween(String value1, String value2) {
            addCriterion("p_pic between", value1, value2, "pPic");
            return (Criteria) this;
        }

        public Criteria andPPicNotBetween(String value1, String value2) {
            addCriterion("p_pic not between", value1, value2, "pPic");
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

        public Criteria andYouPriceIsNull() {
            addCriterion("you_price is null");
            return (Criteria) this;
        }

        public Criteria andYouPriceIsNotNull() {
            addCriterion("you_price is not null");
            return (Criteria) this;
        }

        public Criteria andYouPriceEqualTo(BigDecimal value) {
            addCriterion("you_price =", value, "youPrice");
            return (Criteria) this;
        }

        public Criteria andYouPriceNotEqualTo(BigDecimal value) {
            addCriterion("you_price <>", value, "youPrice");
            return (Criteria) this;
        }

        public Criteria andYouPriceGreaterThan(BigDecimal value) {
            addCriterion("you_price >", value, "youPrice");
            return (Criteria) this;
        }

        public Criteria andYouPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("you_price >=", value, "youPrice");
            return (Criteria) this;
        }

        public Criteria andYouPriceLessThan(BigDecimal value) {
            addCriterion("you_price <", value, "youPrice");
            return (Criteria) this;
        }

        public Criteria andYouPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("you_price <=", value, "youPrice");
            return (Criteria) this;
        }

        public Criteria andYouPriceIn(List<BigDecimal> values) {
            addCriterion("you_price in", values, "youPrice");
            return (Criteria) this;
        }

        public Criteria andYouPriceNotIn(List<BigDecimal> values) {
            addCriterion("you_price not in", values, "youPrice");
            return (Criteria) this;
        }

        public Criteria andYouPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("you_price between", value1, value2, "youPrice");
            return (Criteria) this;
        }

        public Criteria andYouPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("you_price not between", value1, value2, "youPrice");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksIsNull() {
            addCriterion("de_remarks is null");
            return (Criteria) this;
        }

        public Criteria andDeRemarksIsNotNull() {
            addCriterion("de_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andDeRemarksEqualTo(String value) {
            addCriterion("de_remarks =", value, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksNotEqualTo(String value) {
            addCriterion("de_remarks <>", value, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksGreaterThan(String value) {
            addCriterion("de_remarks >", value, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("de_remarks >=", value, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksLessThan(String value) {
            addCriterion("de_remarks <", value, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksLessThanOrEqualTo(String value) {
            addCriterion("de_remarks <=", value, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksLike(String value) {
            addCriterion("de_remarks like", value, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksNotLike(String value) {
            addCriterion("de_remarks not like", value, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksIn(List<String> values) {
            addCriterion("de_remarks in", values, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksNotIn(List<String> values) {
            addCriterion("de_remarks not in", values, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksBetween(String value1, String value2) {
            addCriterion("de_remarks between", value1, value2, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andDeRemarksNotBetween(String value1, String value2) {
            addCriterion("de_remarks not between", value1, value2, "deRemarks");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedIsNull() {
            addCriterion("m_fresh_used is null");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedIsNotNull() {
            addCriterion("m_fresh_used is not null");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedEqualTo(Integer value) {
            addCriterion("m_fresh_used =", value, "mFreshUsed");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedNotEqualTo(Integer value) {
            addCriterion("m_fresh_used <>", value, "mFreshUsed");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedGreaterThan(Integer value) {
            addCriterion("m_fresh_used >", value, "mFreshUsed");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_fresh_used >=", value, "mFreshUsed");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedLessThan(Integer value) {
            addCriterion("m_fresh_used <", value, "mFreshUsed");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedLessThanOrEqualTo(Integer value) {
            addCriterion("m_fresh_used <=", value, "mFreshUsed");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedIn(List<Integer> values) {
            addCriterion("m_fresh_used in", values, "mFreshUsed");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedNotIn(List<Integer> values) {
            addCriterion("m_fresh_used not in", values, "mFreshUsed");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedBetween(Integer value1, Integer value2) {
            addCriterion("m_fresh_used between", value1, value2, "mFreshUsed");
            return (Criteria) this;
        }

        public Criteria andMFreshUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("m_fresh_used not between", value1, value2, "mFreshUsed");
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