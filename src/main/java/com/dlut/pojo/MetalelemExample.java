package com.dlut.pojo;

import java.util.ArrayList;
import java.util.List;

public class MetalelemExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public MetalelemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metalelem
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table metalelem
     *
     * @mbggenerated
     */
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

        public Criteria andTimestampIsNull() {
            addCriterion("timeStamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timeStamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(String value) {
            addCriterion("timeStamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(String value) {
            addCriterion("timeStamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(String value) {
            addCriterion("timeStamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("timeStamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(String value) {
            addCriterion("timeStamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(String value) {
            addCriterion("timeStamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLike(String value) {
            addCriterion("timeStamp like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotLike(String value) {
            addCriterion("timeStamp not like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<String> values) {
            addCriterion("timeStamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<String> values) {
            addCriterion("timeStamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(String value1, String value2) {
            addCriterion("timeStamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(String value1, String value2) {
            addCriterion("timeStamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andElem1IsNull() {
            addCriterion("elem1 is null");
            return (Criteria) this;
        }

        public Criteria andElem1IsNotNull() {
            addCriterion("elem1 is not null");
            return (Criteria) this;
        }

        public Criteria andElem1EqualTo(Float value) {
            addCriterion("elem1 =", value, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem1NotEqualTo(Float value) {
            addCriterion("elem1 <>", value, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem1GreaterThan(Float value) {
            addCriterion("elem1 >", value, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem1GreaterThanOrEqualTo(Float value) {
            addCriterion("elem1 >=", value, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem1LessThan(Float value) {
            addCriterion("elem1 <", value, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem1LessThanOrEqualTo(Float value) {
            addCriterion("elem1 <=", value, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem1In(List<Float> values) {
            addCriterion("elem1 in", values, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem1NotIn(List<Float> values) {
            addCriterion("elem1 not in", values, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem1Between(Float value1, Float value2) {
            addCriterion("elem1 between", value1, value2, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem1NotBetween(Float value1, Float value2) {
            addCriterion("elem1 not between", value1, value2, "elem1");
            return (Criteria) this;
        }

        public Criteria andElem2IsNull() {
            addCriterion("elem2 is null");
            return (Criteria) this;
        }

        public Criteria andElem2IsNotNull() {
            addCriterion("elem2 is not null");
            return (Criteria) this;
        }

        public Criteria andElem2EqualTo(Float value) {
            addCriterion("elem2 =", value, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem2NotEqualTo(Float value) {
            addCriterion("elem2 <>", value, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem2GreaterThan(Float value) {
            addCriterion("elem2 >", value, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem2GreaterThanOrEqualTo(Float value) {
            addCriterion("elem2 >=", value, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem2LessThan(Float value) {
            addCriterion("elem2 <", value, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem2LessThanOrEqualTo(Float value) {
            addCriterion("elem2 <=", value, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem2In(List<Float> values) {
            addCriterion("elem2 in", values, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem2NotIn(List<Float> values) {
            addCriterion("elem2 not in", values, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem2Between(Float value1, Float value2) {
            addCriterion("elem2 between", value1, value2, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem2NotBetween(Float value1, Float value2) {
            addCriterion("elem2 not between", value1, value2, "elem2");
            return (Criteria) this;
        }

        public Criteria andElem3IsNull() {
            addCriterion("elem3 is null");
            return (Criteria) this;
        }

        public Criteria andElem3IsNotNull() {
            addCriterion("elem3 is not null");
            return (Criteria) this;
        }

        public Criteria andElem3EqualTo(Float value) {
            addCriterion("elem3 =", value, "elem3");
            return (Criteria) this;
        }

        public Criteria andElem3NotEqualTo(Float value) {
            addCriterion("elem3 <>", value, "elem3");
            return (Criteria) this;
        }

        public Criteria andElem3GreaterThan(Float value) {
            addCriterion("elem3 >", value, "elem3");
            return (Criteria) this;
        }

        public Criteria andElem3GreaterThanOrEqualTo(Float value) {
            addCriterion("elem3 >=", value, "elem3");
            return (Criteria) this;
        }

        public Criteria andElem3LessThan(Float value) {
            addCriterion("elem3 <", value, "elem3");
            return (Criteria) this;
        }

        public Criteria andElem3LessThanOrEqualTo(Float value) {
            addCriterion("elem3 <=", value, "elem3");
            return (Criteria) this;
        }

        public Criteria andElem3In(List<Float> values) {
            addCriterion("elem3 in", values, "elem3");
            return (Criteria) this;
        }

        public Criteria andElem3NotIn(List<Float> values) {
            addCriterion("elem3 not in", values, "elem3");
            return (Criteria) this;
        }

        public Criteria andElem3Between(Float value1, Float value2) {
            addCriterion("elem3 between", value1, value2, "elem3");
            return (Criteria) this;
        }

        public Criteria andElem3NotBetween(Float value1, Float value2) {
            addCriterion("elem3 not between", value1, value2, "elem3");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table metalelem
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table metalelem
     *
     * @mbggenerated
     */
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