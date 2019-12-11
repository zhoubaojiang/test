package spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MPermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MPermissionExample() {
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

        public Criteria andPermissionIdIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(Long value) {
            addCriterion("permission_id =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(Long value) {
            addCriterion("permission_id <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(Long value) {
            addCriterion("permission_id >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("permission_id >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(Long value) {
            addCriterion("permission_id <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(Long value) {
            addCriterion("permission_id <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<Long> values) {
            addCriterion("permission_id in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<Long> values) {
            addCriterion("permission_id not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(Long value1, Long value2) {
            addCriterion("permission_id between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(Long value1, Long value2) {
            addCriterion("permission_id not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNull() {
            addCriterion("permission_name is null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIsNotNull() {
            addCriterion("permission_name is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionNameEqualTo(String value) {
            addCriterion("permission_name =", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotEqualTo(String value) {
            addCriterion("permission_name <>", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThan(String value) {
            addCriterion("permission_name >", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameGreaterThanOrEqualTo(String value) {
            addCriterion("permission_name >=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThan(String value) {
            addCriterion("permission_name <", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLessThanOrEqualTo(String value) {
            addCriterion("permission_name <=", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameLike(String value) {
            addCriterion("permission_name like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotLike(String value) {
            addCriterion("permission_name not like", value, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameIn(List<String> values) {
            addCriterion("permission_name in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotIn(List<String> values) {
            addCriterion("permission_name not in", values, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameBetween(String value1, String value2) {
            addCriterion("permission_name between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionNameNotBetween(String value1, String value2) {
            addCriterion("permission_name not between", value1, value2, "permissionName");
            return (Criteria) this;
        }

        public Criteria andPermissionDescIsNull() {
            addCriterion("permission_desc is null");
            return (Criteria) this;
        }

        public Criteria andPermissionDescIsNotNull() {
            addCriterion("permission_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionDescEqualTo(String value) {
            addCriterion("permission_desc =", value, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescNotEqualTo(String value) {
            addCriterion("permission_desc <>", value, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescGreaterThan(String value) {
            addCriterion("permission_desc >", value, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescGreaterThanOrEqualTo(String value) {
            addCriterion("permission_desc >=", value, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescLessThan(String value) {
            addCriterion("permission_desc <", value, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescLessThanOrEqualTo(String value) {
            addCriterion("permission_desc <=", value, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescLike(String value) {
            addCriterion("permission_desc like", value, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescNotLike(String value) {
            addCriterion("permission_desc not like", value, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescIn(List<String> values) {
            addCriterion("permission_desc in", values, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescNotIn(List<String> values) {
            addCriterion("permission_desc not in", values, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescBetween(String value1, String value2) {
            addCriterion("permission_desc between", value1, value2, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionDescNotBetween(String value1, String value2) {
            addCriterion("permission_desc not between", value1, value2, "permissionDesc");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyIsNull() {
            addCriterion("permission_key is null");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyIsNotNull() {
            addCriterion("permission_key is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyEqualTo(String value) {
            addCriterion("permission_key =", value, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyNotEqualTo(String value) {
            addCriterion("permission_key <>", value, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyGreaterThan(String value) {
            addCriterion("permission_key >", value, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("permission_key >=", value, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyLessThan(String value) {
            addCriterion("permission_key <", value, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyLessThanOrEqualTo(String value) {
            addCriterion("permission_key <=", value, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyLike(String value) {
            addCriterion("permission_key like", value, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyNotLike(String value) {
            addCriterion("permission_key not like", value, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyIn(List<String> values) {
            addCriterion("permission_key in", values, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyNotIn(List<String> values) {
            addCriterion("permission_key not in", values, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyBetween(String value1, String value2) {
            addCriterion("permission_key between", value1, value2, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionKeyNotBetween(String value1, String value2) {
            addCriterion("permission_key not between", value1, value2, "permissionKey");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlIsNull() {
            addCriterion("permission_url is null");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlIsNotNull() {
            addCriterion("permission_url is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlEqualTo(String value) {
            addCriterion("permission_url =", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlNotEqualTo(String value) {
            addCriterion("permission_url <>", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlGreaterThan(String value) {
            addCriterion("permission_url >", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("permission_url >=", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlLessThan(String value) {
            addCriterion("permission_url <", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlLessThanOrEqualTo(String value) {
            addCriterion("permission_url <=", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlLike(String value) {
            addCriterion("permission_url like", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlNotLike(String value) {
            addCriterion("permission_url not like", value, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlIn(List<String> values) {
            addCriterion("permission_url in", values, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlNotIn(List<String> values) {
            addCriterion("permission_url not in", values, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlBetween(String value1, String value2) {
            addCriterion("permission_url between", value1, value2, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionUrlNotBetween(String value1, String value2) {
            addCriterion("permission_url not between", value1, value2, "permissionUrl");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIsNull() {
            addCriterion("permission_type is null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIsNotNull() {
            addCriterion("permission_type is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeEqualTo(Integer value) {
            addCriterion("permission_type =", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotEqualTo(Integer value) {
            addCriterion("permission_type <>", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeGreaterThan(Integer value) {
            addCriterion("permission_type >", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_type >=", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeLessThan(Integer value) {
            addCriterion("permission_type <", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("permission_type <=", value, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIn(List<Integer> values) {
            addCriterion("permission_type in", values, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotIn(List<Integer> values) {
            addCriterion("permission_type not in", values, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeBetween(Integer value1, Integer value2) {
            addCriterion("permission_type between", value1, value2, "permissionType");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_type not between", value1, value2, "permissionType");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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