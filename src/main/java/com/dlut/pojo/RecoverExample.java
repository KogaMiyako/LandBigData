package com.dlut.pojo;

import java.util.ArrayList;
import java.util.List;

public class RecoverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecoverExample() {
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

        public Criteria andRecoverIdIsNull() {
            addCriterion("recover_id is null");
            return (Criteria) this;
        }

        public Criteria andRecoverIdIsNotNull() {
            addCriterion("recover_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverIdEqualTo(Integer value) {
            addCriterion("recover_id =", value, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverIdNotEqualTo(Integer value) {
            addCriterion("recover_id <>", value, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverIdGreaterThan(Integer value) {
            addCriterion("recover_id >", value, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recover_id >=", value, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverIdLessThan(Integer value) {
            addCriterion("recover_id <", value, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverIdLessThanOrEqualTo(Integer value) {
            addCriterion("recover_id <=", value, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverIdIn(List<Integer> values) {
            addCriterion("recover_id in", values, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverIdNotIn(List<Integer> values) {
            addCriterion("recover_id not in", values, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverIdBetween(Integer value1, Integer value2) {
            addCriterion("recover_id between", value1, value2, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recover_id not between", value1, value2, "recoverId");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeIsNull() {
            addCriterion("recover_describe is null");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeIsNotNull() {
            addCriterion("recover_describe is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeEqualTo(String value) {
            addCriterion("recover_describe =", value, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeNotEqualTo(String value) {
            addCriterion("recover_describe <>", value, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeGreaterThan(String value) {
            addCriterion("recover_describe >", value, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("recover_describe >=", value, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeLessThan(String value) {
            addCriterion("recover_describe <", value, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeLessThanOrEqualTo(String value) {
            addCriterion("recover_describe <=", value, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeLike(String value) {
            addCriterion("recover_describe like", value, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeNotLike(String value) {
            addCriterion("recover_describe not like", value, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeIn(List<String> values) {
            addCriterion("recover_describe in", values, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeNotIn(List<String> values) {
            addCriterion("recover_describe not in", values, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeBetween(String value1, String value2) {
            addCriterion("recover_describe between", value1, value2, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverDescribeNotBetween(String value1, String value2) {
            addCriterion("recover_describe not between", value1, value2, "recoverDescribe");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdIsNull() {
            addCriterion("recover_metal_id is null");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdIsNotNull() {
            addCriterion("recover_metal_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdEqualTo(Integer value) {
            addCriterion("recover_metal_id =", value, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdNotEqualTo(Integer value) {
            addCriterion("recover_metal_id <>", value, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdGreaterThan(Integer value) {
            addCriterion("recover_metal_id >", value, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recover_metal_id >=", value, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdLessThan(Integer value) {
            addCriterion("recover_metal_id <", value, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdLessThanOrEqualTo(Integer value) {
            addCriterion("recover_metal_id <=", value, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdIn(List<Integer> values) {
            addCriterion("recover_metal_id in", values, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdNotIn(List<Integer> values) {
            addCriterion("recover_metal_id not in", values, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdBetween(Integer value1, Integer value2) {
            addCriterion("recover_metal_id between", value1, value2, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recover_metal_id not between", value1, value2, "recoverMetalId");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameIsNull() {
            addCriterion("recover_metal_name is null");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameIsNotNull() {
            addCriterion("recover_metal_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameEqualTo(String value) {
            addCriterion("recover_metal_name =", value, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameNotEqualTo(String value) {
            addCriterion("recover_metal_name <>", value, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameGreaterThan(String value) {
            addCriterion("recover_metal_name >", value, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameGreaterThanOrEqualTo(String value) {
            addCriterion("recover_metal_name >=", value, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameLessThan(String value) {
            addCriterion("recover_metal_name <", value, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameLessThanOrEqualTo(String value) {
            addCriterion("recover_metal_name <=", value, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameLike(String value) {
            addCriterion("recover_metal_name like", value, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameNotLike(String value) {
            addCriterion("recover_metal_name not like", value, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameIn(List<String> values) {
            addCriterion("recover_metal_name in", values, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameNotIn(List<String> values) {
            addCriterion("recover_metal_name not in", values, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameBetween(String value1, String value2) {
            addCriterion("recover_metal_name between", value1, value2, "recoverMetalName");
            return (Criteria) this;
        }

        public Criteria andRecoverMetalNameNotBetween(String value1, String value2) {
            addCriterion("recover_metal_name not between", value1, value2, "recoverMetalName");
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