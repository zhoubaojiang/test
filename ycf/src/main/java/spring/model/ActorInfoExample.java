package spring.model;

import java.util.ArrayList;
import java.util.List;

public class ActorInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActorInfoExample() {
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

        public Criteria andActorIdIsNull() {
            addCriterion("actor_id is null");
            return (Criteria) this;
        }

        public Criteria andActorIdIsNotNull() {
            addCriterion("actor_id is not null");
            return (Criteria) this;
        }

        public Criteria andActorIdEqualTo(Integer value) {
            addCriterion("actor_id =", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdNotEqualTo(Integer value) {
            addCriterion("actor_id <>", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdGreaterThan(Integer value) {
            addCriterion("actor_id >", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("actor_id >=", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdLessThan(Integer value) {
            addCriterion("actor_id <", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdLessThanOrEqualTo(Integer value) {
            addCriterion("actor_id <=", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdIn(List<Integer> values) {
            addCriterion("actor_id in", values, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdNotIn(List<Integer> values) {
            addCriterion("actor_id not in", values, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdBetween(Integer value1, Integer value2) {
            addCriterion("actor_id between", value1, value2, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("actor_id not between", value1, value2, "actorId");
            return (Criteria) this;
        }

        public Criteria andFirstNameIsNull() {
            addCriterion("first_name is null");
            return (Criteria) this;
        }

        public Criteria andFirstNameIsNotNull() {
            addCriterion("first_name is not null");
            return (Criteria) this;
        }

        public Criteria andFirstNameEqualTo(Integer value) {
            addCriterion("first_name =", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotEqualTo(Integer value) {
            addCriterion("first_name <>", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameGreaterThan(Integer value) {
            addCriterion("first_name >", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_name >=", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameLessThan(Integer value) {
            addCriterion("first_name <", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameLessThanOrEqualTo(Integer value) {
            addCriterion("first_name <=", value, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameIn(List<Integer> values) {
            addCriterion("first_name in", values, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotIn(List<Integer> values) {
            addCriterion("first_name not in", values, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameBetween(Integer value1, Integer value2) {
            addCriterion("first_name between", value1, value2, "firstName");
            return (Criteria) this;
        }

        public Criteria andFirstNameNotBetween(Integer value1, Integer value2) {
            addCriterion("first_name not between", value1, value2, "firstName");
            return (Criteria) this;
        }

        public Criteria andLastNameIsNull() {
            addCriterion("last_name is null");
            return (Criteria) this;
        }

        public Criteria andLastNameIsNotNull() {
            addCriterion("last_name is not null");
            return (Criteria) this;
        }

        public Criteria andLastNameEqualTo(Integer value) {
            addCriterion("last_name =", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotEqualTo(Integer value) {
            addCriterion("last_name <>", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameGreaterThan(Integer value) {
            addCriterion("last_name >", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_name >=", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameLessThan(Integer value) {
            addCriterion("last_name <", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameLessThanOrEqualTo(Integer value) {
            addCriterion("last_name <=", value, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameIn(List<Integer> values) {
            addCriterion("last_name in", values, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotIn(List<Integer> values) {
            addCriterion("last_name not in", values, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameBetween(Integer value1, Integer value2) {
            addCriterion("last_name between", value1, value2, "lastName");
            return (Criteria) this;
        }

        public Criteria andLastNameNotBetween(Integer value1, Integer value2) {
            addCriterion("last_name not between", value1, value2, "lastName");
            return (Criteria) this;
        }

        public Criteria andFilmInfoIsNull() {
            addCriterion("film_info is null");
            return (Criteria) this;
        }

        public Criteria andFilmInfoIsNotNull() {
            addCriterion("film_info is not null");
            return (Criteria) this;
        }

        public Criteria andFilmInfoEqualTo(Integer value) {
            addCriterion("film_info =", value, "filmInfo");
            return (Criteria) this;
        }

        public Criteria andFilmInfoNotEqualTo(Integer value) {
            addCriterion("film_info <>", value, "filmInfo");
            return (Criteria) this;
        }

        public Criteria andFilmInfoGreaterThan(Integer value) {
            addCriterion("film_info >", value, "filmInfo");
            return (Criteria) this;
        }

        public Criteria andFilmInfoGreaterThanOrEqualTo(Integer value) {
            addCriterion("film_info >=", value, "filmInfo");
            return (Criteria) this;
        }

        public Criteria andFilmInfoLessThan(Integer value) {
            addCriterion("film_info <", value, "filmInfo");
            return (Criteria) this;
        }

        public Criteria andFilmInfoLessThanOrEqualTo(Integer value) {
            addCriterion("film_info <=", value, "filmInfo");
            return (Criteria) this;
        }

        public Criteria andFilmInfoIn(List<Integer> values) {
            addCriterion("film_info in", values, "filmInfo");
            return (Criteria) this;
        }

        public Criteria andFilmInfoNotIn(List<Integer> values) {
            addCriterion("film_info not in", values, "filmInfo");
            return (Criteria) this;
        }

        public Criteria andFilmInfoBetween(Integer value1, Integer value2) {
            addCriterion("film_info between", value1, value2, "filmInfo");
            return (Criteria) this;
        }

        public Criteria andFilmInfoNotBetween(Integer value1, Integer value2) {
            addCriterion("film_info not between", value1, value2, "filmInfo");
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