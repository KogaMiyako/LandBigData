package com.dlut.pojo;

import java.util.ArrayList;
import java.util.List;

public class LawsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LawsExample() {
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

        public Criteria andLawsIdIsNull() {
            addCriterion("laws_id is null");
            return (Criteria) this;
        }

        public Criteria andLawsIdIsNotNull() {
            addCriterion("laws_id is not null");
            return (Criteria) this;
        }

        public Criteria andLawsIdEqualTo(Integer value) {
            addCriterion("laws_id =", value, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsIdNotEqualTo(Integer value) {
            addCriterion("laws_id <>", value, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsIdGreaterThan(Integer value) {
            addCriterion("laws_id >", value, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("laws_id >=", value, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsIdLessThan(Integer value) {
            addCriterion("laws_id <", value, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsIdLessThanOrEqualTo(Integer value) {
            addCriterion("laws_id <=", value, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsIdIn(List<Integer> values) {
            addCriterion("laws_id in", values, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsIdNotIn(List<Integer> values) {
            addCriterion("laws_id not in", values, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsIdBetween(Integer value1, Integer value2) {
            addCriterion("laws_id between", value1, value2, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("laws_id not between", value1, value2, "lawsId");
            return (Criteria) this;
        }

        public Criteria andLawsNameIsNull() {
            addCriterion("laws_name is null");
            return (Criteria) this;
        }

        public Criteria andLawsNameIsNotNull() {
            addCriterion("laws_name is not null");
            return (Criteria) this;
        }

        public Criteria andLawsNameEqualTo(String value) {
            addCriterion("laws_name =", value, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameNotEqualTo(String value) {
            addCriterion("laws_name <>", value, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameGreaterThan(String value) {
            addCriterion("laws_name >", value, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameGreaterThanOrEqualTo(String value) {
            addCriterion("laws_name >=", value, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameLessThan(String value) {
            addCriterion("laws_name <", value, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameLessThanOrEqualTo(String value) {
            addCriterion("laws_name <=", value, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameLike(String value) {
            addCriterion("laws_name like", value, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameNotLike(String value) {
            addCriterion("laws_name not like", value, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameIn(List<String> values) {
            addCriterion("laws_name in", values, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameNotIn(List<String> values) {
            addCriterion("laws_name not in", values, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameBetween(String value1, String value2) {
            addCriterion("laws_name between", value1, value2, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsNameNotBetween(String value1, String value2) {
            addCriterion("laws_name not between", value1, value2, "lawsName");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeIsNull() {
            addCriterion("laws_describe is null");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeIsNotNull() {
            addCriterion("laws_describe is not null");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeEqualTo(String value) {
            addCriterion("laws_describe =", value, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeNotEqualTo(String value) {
            addCriterion("laws_describe <>", value, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeGreaterThan(String value) {
            addCriterion("laws_describe >", value, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("laws_describe >=", value, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeLessThan(String value) {
            addCriterion("laws_describe <", value, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeLessThanOrEqualTo(String value) {
            addCriterion("laws_describe <=", value, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeLike(String value) {
            addCriterion("laws_describe like", value, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeNotLike(String value) {
            addCriterion("laws_describe not like", value, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeIn(List<String> values) {
            addCriterion("laws_describe in", values, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeNotIn(List<String> values) {
            addCriterion("laws_describe not in", values, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeBetween(String value1, String value2) {
            addCriterion("laws_describe between", value1, value2, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsDescribeNotBetween(String value1, String value2) {
            addCriterion("laws_describe not between", value1, value2, "lawsDescribe");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathIsNull() {
            addCriterion("laws_filePath is null");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathIsNotNull() {
            addCriterion("laws_filePath is not null");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathEqualTo(String value) {
            addCriterion("laws_filePath =", value, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathNotEqualTo(String value) {
            addCriterion("laws_filePath <>", value, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathGreaterThan(String value) {
            addCriterion("laws_filePath >", value, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("laws_filePath >=", value, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathLessThan(String value) {
            addCriterion("laws_filePath <", value, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathLessThanOrEqualTo(String value) {
            addCriterion("laws_filePath <=", value, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathLike(String value) {
            addCriterion("laws_filePath like", value, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathNotLike(String value) {
            addCriterion("laws_filePath not like", value, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathIn(List<String> values) {
            addCriterion("laws_filePath in", values, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathNotIn(List<String> values) {
            addCriterion("laws_filePath not in", values, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathBetween(String value1, String value2) {
            addCriterion("laws_filePath between", value1, value2, "lawsFilepath");
            return (Criteria) this;
        }

        public Criteria andLawsFilepathNotBetween(String value1, String value2) {
            addCriterion("laws_filePath not between", value1, value2, "lawsFilepath");
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