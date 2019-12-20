package spring.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UUserMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UUserMemberExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNull() {
            addCriterion("pass_word is null");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNotNull() {
            addCriterion("pass_word is not null");
            return (Criteria) this;
        }

        public Criteria andPassWordEqualTo(String value) {
            addCriterion("pass_word =", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotEqualTo(String value) {
            addCriterion("pass_word <>", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThan(String value) {
            addCriterion("pass_word >", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThanOrEqualTo(String value) {
            addCriterion("pass_word >=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThan(String value) {
            addCriterion("pass_word <", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThanOrEqualTo(String value) {
            addCriterion("pass_word <=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLike(String value) {
            addCriterion("pass_word like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotLike(String value) {
            addCriterion("pass_word not like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordIn(List<String> values) {
            addCriterion("pass_word in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotIn(List<String> values) {
            addCriterion("pass_word not in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordBetween(String value1, String value2) {
            addCriterion("pass_word between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotBetween(String value1, String value2) {
            addCriterion("pass_word not between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andYuanBaoIsNull() {
            addCriterion("yuan_bao is null");
            return (Criteria) this;
        }

        public Criteria andYuanBaoIsNotNull() {
            addCriterion("yuan_bao is not null");
            return (Criteria) this;
        }

        public Criteria andYuanBaoEqualTo(BigDecimal value) {
            addCriterion("yuan_bao =", value, "yuanBao");
            return (Criteria) this;
        }

        public Criteria andYuanBaoNotEqualTo(BigDecimal value) {
            addCriterion("yuan_bao <>", value, "yuanBao");
            return (Criteria) this;
        }

        public Criteria andYuanBaoGreaterThan(BigDecimal value) {
            addCriterion("yuan_bao >", value, "yuanBao");
            return (Criteria) this;
        }

        public Criteria andYuanBaoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("yuan_bao >=", value, "yuanBao");
            return (Criteria) this;
        }

        public Criteria andYuanBaoLessThan(BigDecimal value) {
            addCriterion("yuan_bao <", value, "yuanBao");
            return (Criteria) this;
        }

        public Criteria andYuanBaoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("yuan_bao <=", value, "yuanBao");
            return (Criteria) this;
        }

        public Criteria andYuanBaoIn(List<BigDecimal> values) {
            addCriterion("yuan_bao in", values, "yuanBao");
            return (Criteria) this;
        }

        public Criteria andYuanBaoNotIn(List<BigDecimal> values) {
            addCriterion("yuan_bao not in", values, "yuanBao");
            return (Criteria) this;
        }

        public Criteria andYuanBaoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yuan_bao between", value1, value2, "yuanBao");
            return (Criteria) this;
        }

        public Criteria andYuanBaoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yuan_bao not between", value1, value2, "yuanBao");
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

        public Criteria andGoldIsNull() {
            addCriterion("gold is null");
            return (Criteria) this;
        }

        public Criteria andGoldIsNotNull() {
            addCriterion("gold is not null");
            return (Criteria) this;
        }

        public Criteria andGoldEqualTo(BigDecimal value) {
            addCriterion("gold =", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotEqualTo(BigDecimal value) {
            addCriterion("gold <>", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThan(BigDecimal value) {
            addCriterion("gold >", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gold >=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThan(BigDecimal value) {
            addCriterion("gold <", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gold <=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldIn(List<BigDecimal> values) {
            addCriterion("gold in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotIn(List<BigDecimal> values) {
            addCriterion("gold not in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gold between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gold not between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andTGoldIsNull() {
            addCriterion("t_gold is null");
            return (Criteria) this;
        }

        public Criteria andTGoldIsNotNull() {
            addCriterion("t_gold is not null");
            return (Criteria) this;
        }

        public Criteria andTGoldEqualTo(BigDecimal value) {
            addCriterion("t_gold =", value, "tGold");
            return (Criteria) this;
        }

        public Criteria andTGoldNotEqualTo(BigDecimal value) {
            addCriterion("t_gold <>", value, "tGold");
            return (Criteria) this;
        }

        public Criteria andTGoldGreaterThan(BigDecimal value) {
            addCriterion("t_gold >", value, "tGold");
            return (Criteria) this;
        }

        public Criteria andTGoldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("t_gold >=", value, "tGold");
            return (Criteria) this;
        }

        public Criteria andTGoldLessThan(BigDecimal value) {
            addCriterion("t_gold <", value, "tGold");
            return (Criteria) this;
        }

        public Criteria andTGoldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("t_gold <=", value, "tGold");
            return (Criteria) this;
        }

        public Criteria andTGoldIn(List<BigDecimal> values) {
            addCriterion("t_gold in", values, "tGold");
            return (Criteria) this;
        }

        public Criteria andTGoldNotIn(List<BigDecimal> values) {
            addCriterion("t_gold not in", values, "tGold");
            return (Criteria) this;
        }

        public Criteria andTGoldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("t_gold between", value1, value2, "tGold");
            return (Criteria) this;
        }

        public Criteria andTGoldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("t_gold not between", value1, value2, "tGold");
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

        public Criteria andTTypeIsNull() {
            addCriterion("t_type is null");
            return (Criteria) this;
        }

        public Criteria andTTypeIsNotNull() {
            addCriterion("t_type is not null");
            return (Criteria) this;
        }

        public Criteria andTTypeEqualTo(Integer value) {
            addCriterion("t_type =", value, "tType");
            return (Criteria) this;
        }

        public Criteria andTTypeNotEqualTo(Integer value) {
            addCriterion("t_type <>", value, "tType");
            return (Criteria) this;
        }

        public Criteria andTTypeGreaterThan(Integer value) {
            addCriterion("t_type >", value, "tType");
            return (Criteria) this;
        }

        public Criteria andTTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_type >=", value, "tType");
            return (Criteria) this;
        }

        public Criteria andTTypeLessThan(Integer value) {
            addCriterion("t_type <", value, "tType");
            return (Criteria) this;
        }

        public Criteria andTTypeLessThanOrEqualTo(Integer value) {
            addCriterion("t_type <=", value, "tType");
            return (Criteria) this;
        }

        public Criteria andTTypeIn(List<Integer> values) {
            addCriterion("t_type in", values, "tType");
            return (Criteria) this;
        }

        public Criteria andTTypeNotIn(List<Integer> values) {
            addCriterion("t_type not in", values, "tType");
            return (Criteria) this;
        }

        public Criteria andTTypeBetween(Integer value1, Integer value2) {
            addCriterion("t_type between", value1, value2, "tType");
            return (Criteria) this;
        }

        public Criteria andTTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("t_type not between", value1, value2, "tType");
            return (Criteria) this;
        }

        public Criteria andWTypeIsNull() {
            addCriterion("w_type is null");
            return (Criteria) this;
        }

        public Criteria andWTypeIsNotNull() {
            addCriterion("w_type is not null");
            return (Criteria) this;
        }

        public Criteria andWTypeEqualTo(Integer value) {
            addCriterion("w_type =", value, "wType");
            return (Criteria) this;
        }

        public Criteria andWTypeNotEqualTo(Integer value) {
            addCriterion("w_type <>", value, "wType");
            return (Criteria) this;
        }

        public Criteria andWTypeGreaterThan(Integer value) {
            addCriterion("w_type >", value, "wType");
            return (Criteria) this;
        }

        public Criteria andWTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_type >=", value, "wType");
            return (Criteria) this;
        }

        public Criteria andWTypeLessThan(Integer value) {
            addCriterion("w_type <", value, "wType");
            return (Criteria) this;
        }

        public Criteria andWTypeLessThanOrEqualTo(Integer value) {
            addCriterion("w_type <=", value, "wType");
            return (Criteria) this;
        }

        public Criteria andWTypeIn(List<Integer> values) {
            addCriterion("w_type in", values, "wType");
            return (Criteria) this;
        }

        public Criteria andWTypeNotIn(List<Integer> values) {
            addCriterion("w_type not in", values, "wType");
            return (Criteria) this;
        }

        public Criteria andWTypeBetween(Integer value1, Integer value2) {
            addCriterion("w_type between", value1, value2, "wType");
            return (Criteria) this;
        }

        public Criteria andWTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("w_type not between", value1, value2, "wType");
            return (Criteria) this;
        }

        public Criteria andGTypeIsNull() {
            addCriterion("g_type is null");
            return (Criteria) this;
        }

        public Criteria andGTypeIsNotNull() {
            addCriterion("g_type is not null");
            return (Criteria) this;
        }

        public Criteria andGTypeEqualTo(Integer value) {
            addCriterion("g_type =", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeNotEqualTo(Integer value) {
            addCriterion("g_type <>", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeGreaterThan(Integer value) {
            addCriterion("g_type >", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("g_type >=", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeLessThan(Integer value) {
            addCriterion("g_type <", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeLessThanOrEqualTo(Integer value) {
            addCriterion("g_type <=", value, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeIn(List<Integer> values) {
            addCriterion("g_type in", values, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeNotIn(List<Integer> values) {
            addCriterion("g_type not in", values, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeBetween(Integer value1, Integer value2) {
            addCriterion("g_type between", value1, value2, "gType");
            return (Criteria) this;
        }

        public Criteria andGTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("g_type not between", value1, value2, "gType");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNull() {
            addCriterion("c_type is null");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNotNull() {
            addCriterion("c_type is not null");
            return (Criteria) this;
        }

        public Criteria andCTypeEqualTo(Integer value) {
            addCriterion("c_type =", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotEqualTo(Integer value) {
            addCriterion("c_type <>", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThan(Integer value) {
            addCriterion("c_type >", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_type >=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThan(Integer value) {
            addCriterion("c_type <", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThanOrEqualTo(Integer value) {
            addCriterion("c_type <=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeIn(List<Integer> values) {
            addCriterion("c_type in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotIn(List<Integer> values) {
            addCriterion("c_type not in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeBetween(Integer value1, Integer value2) {
            addCriterion("c_type between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("c_type not between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andLTypeIsNull() {
            addCriterion("l_type is null");
            return (Criteria) this;
        }

        public Criteria andLTypeIsNotNull() {
            addCriterion("l_type is not null");
            return (Criteria) this;
        }

        public Criteria andLTypeEqualTo(Integer value) {
            addCriterion("l_type =", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeNotEqualTo(Integer value) {
            addCriterion("l_type <>", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeGreaterThan(Integer value) {
            addCriterion("l_type >", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("l_type >=", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeLessThan(Integer value) {
            addCriterion("l_type <", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeLessThanOrEqualTo(Integer value) {
            addCriterion("l_type <=", value, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeIn(List<Integer> values) {
            addCriterion("l_type in", values, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeNotIn(List<Integer> values) {
            addCriterion("l_type not in", values, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeBetween(Integer value1, Integer value2) {
            addCriterion("l_type between", value1, value2, "lType");
            return (Criteria) this;
        }

        public Criteria andLTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("l_type not between", value1, value2, "lType");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andButtonIsNull() {
            addCriterion("button is null");
            return (Criteria) this;
        }

        public Criteria andButtonIsNotNull() {
            addCriterion("button is not null");
            return (Criteria) this;
        }

        public Criteria andButtonEqualTo(Integer value) {
            addCriterion("button =", value, "button");
            return (Criteria) this;
        }

        public Criteria andButtonNotEqualTo(Integer value) {
            addCriterion("button <>", value, "button");
            return (Criteria) this;
        }

        public Criteria andButtonGreaterThan(Integer value) {
            addCriterion("button >", value, "button");
            return (Criteria) this;
        }

        public Criteria andButtonGreaterThanOrEqualTo(Integer value) {
            addCriterion("button >=", value, "button");
            return (Criteria) this;
        }

        public Criteria andButtonLessThan(Integer value) {
            addCriterion("button <", value, "button");
            return (Criteria) this;
        }

        public Criteria andButtonLessThanOrEqualTo(Integer value) {
            addCriterion("button <=", value, "button");
            return (Criteria) this;
        }

        public Criteria andButtonIn(List<Integer> values) {
            addCriterion("button in", values, "button");
            return (Criteria) this;
        }

        public Criteria andButtonNotIn(List<Integer> values) {
            addCriterion("button not in", values, "button");
            return (Criteria) this;
        }

        public Criteria andButtonBetween(Integer value1, Integer value2) {
            addCriterion("button between", value1, value2, "button");
            return (Criteria) this;
        }

        public Criteria andButtonNotBetween(Integer value1, Integer value2) {
            addCriterion("button not between", value1, value2, "button");
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