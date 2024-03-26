package com.dlut.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataExample() {
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

        public Criteria andDataIdIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(Integer value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(Integer value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(Integer value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(Integer value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(Integer value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<Integer> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<Integer> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(Integer value1, Integer value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(Integer value1, Integer value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataNameIsNull() {
            addCriterion("data_name is null");
            return (Criteria) this;
        }

        public Criteria andDataNameIsNotNull() {
            addCriterion("data_name is not null");
            return (Criteria) this;
        }

        public Criteria andDataNameEqualTo(String value) {
            addCriterion("data_name =", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotEqualTo(String value) {
            addCriterion("data_name <>", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameGreaterThan(String value) {
            addCriterion("data_name >", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameGreaterThanOrEqualTo(String value) {
            addCriterion("data_name >=", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameLessThan(String value) {
            addCriterion("data_name <", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameLessThanOrEqualTo(String value) {
            addCriterion("data_name <=", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameLike(String value) {
            addCriterion("data_name like", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotLike(String value) {
            addCriterion("data_name not like", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameIn(List<String> values) {
            addCriterion("data_name in", values, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotIn(List<String> values) {
            addCriterion("data_name not in", values, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameBetween(String value1, String value2) {
            addCriterion("data_name between", value1, value2, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotBetween(String value1, String value2) {
            addCriterion("data_name not between", value1, value2, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataFilenameIsNull() {
            addCriterion("data_fileName is null");
            return (Criteria) this;
        }

        public Criteria andDataFilenameIsNotNull() {
            addCriterion("data_fileName is not null");
            return (Criteria) this;
        }

        public Criteria andDataFilenameEqualTo(String value) {
            addCriterion("data_fileName =", value, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameNotEqualTo(String value) {
            addCriterion("data_fileName <>", value, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameGreaterThan(String value) {
            addCriterion("data_fileName >", value, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("data_fileName >=", value, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameLessThan(String value) {
            addCriterion("data_fileName <", value, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameLessThanOrEqualTo(String value) {
            addCriterion("data_fileName <=", value, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameLike(String value) {
            addCriterion("data_fileName like", value, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameNotLike(String value) {
            addCriterion("data_fileName not like", value, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameIn(List<String> values) {
            addCriterion("data_fileName in", values, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameNotIn(List<String> values) {
            addCriterion("data_fileName not in", values, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameBetween(String value1, String value2) {
            addCriterion("data_fileName between", value1, value2, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataFilenameNotBetween(String value1, String value2) {
            addCriterion("data_fileName not between", value1, value2, "dataFilename");
            return (Criteria) this;
        }

        public Criteria andDataCityIsNull() {
            addCriterion("data_city is null");
            return (Criteria) this;
        }

        public Criteria andDataCityIsNotNull() {
            addCriterion("data_city is not null");
            return (Criteria) this;
        }

        public Criteria andDataCityEqualTo(String value) {
            addCriterion("data_city =", value, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityNotEqualTo(String value) {
            addCriterion("data_city <>", value, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityGreaterThan(String value) {
            addCriterion("data_city >", value, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityGreaterThanOrEqualTo(String value) {
            addCriterion("data_city >=", value, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityLessThan(String value) {
            addCriterion("data_city <", value, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityLessThanOrEqualTo(String value) {
            addCriterion("data_city <=", value, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityLike(String value) {
            addCriterion("data_city like", value, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityNotLike(String value) {
            addCriterion("data_city not like", value, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityIn(List<String> values) {
            addCriterion("data_city in", values, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityNotIn(List<String> values) {
            addCriterion("data_city not in", values, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityBetween(String value1, String value2) {
            addCriterion("data_city between", value1, value2, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataCityNotBetween(String value1, String value2) {
            addCriterion("data_city not between", value1, value2, "dataCity");
            return (Criteria) this;
        }

        public Criteria andDataDescribeIsNull() {
            addCriterion("data_describe is null");
            return (Criteria) this;
        }

        public Criteria andDataDescribeIsNotNull() {
            addCriterion("data_describe is not null");
            return (Criteria) this;
        }

        public Criteria andDataDescribeEqualTo(String value) {
            addCriterion("data_describe =", value, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeNotEqualTo(String value) {
            addCriterion("data_describe <>", value, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeGreaterThan(String value) {
            addCriterion("data_describe >", value, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("data_describe >=", value, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeLessThan(String value) {
            addCriterion("data_describe <", value, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeLessThanOrEqualTo(String value) {
            addCriterion("data_describe <=", value, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeLike(String value) {
            addCriterion("data_describe like", value, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeNotLike(String value) {
            addCriterion("data_describe not like", value, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeIn(List<String> values) {
            addCriterion("data_describe in", values, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeNotIn(List<String> values) {
            addCriterion("data_describe not in", values, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeBetween(String value1, String value2) {
            addCriterion("data_describe between", value1, value2, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataDescribeNotBetween(String value1, String value2) {
            addCriterion("data_describe not between", value1, value2, "dataDescribe");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeIsNull() {
            addCriterion("data_createTime is null");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeIsNotNull() {
            addCriterion("data_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeEqualTo(Date value) {
            addCriterion("data_createTime =", value, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeNotEqualTo(Date value) {
            addCriterion("data_createTime <>", value, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeGreaterThan(Date value) {
            addCriterion("data_createTime >", value, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("data_createTime >=", value, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeLessThan(Date value) {
            addCriterion("data_createTime <", value, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("data_createTime <=", value, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeIn(List<Date> values) {
            addCriterion("data_createTime in", values, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeNotIn(List<Date> values) {
            addCriterion("data_createTime not in", values, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeBetween(Date value1, Date value2) {
            addCriterion("data_createTime between", value1, value2, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("data_createTime not between", value1, value2, "dataCreatetime");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserIsNull() {
            addCriterion("data_createUser is null");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserIsNotNull() {
            addCriterion("data_createUser is not null");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserEqualTo(String value) {
            addCriterion("data_createUser =", value, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserNotEqualTo(String value) {
            addCriterion("data_createUser <>", value, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserGreaterThan(String value) {
            addCriterion("data_createUser >", value, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("data_createUser >=", value, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserLessThan(String value) {
            addCriterion("data_createUser <", value, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserLessThanOrEqualTo(String value) {
            addCriterion("data_createUser <=", value, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserLike(String value) {
            addCriterion("data_createUser like", value, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserNotLike(String value) {
            addCriterion("data_createUser not like", value, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserIn(List<String> values) {
            addCriterion("data_createUser in", values, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserNotIn(List<String> values) {
            addCriterion("data_createUser not in", values, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserBetween(String value1, String value2) {
            addCriterion("data_createUser between", value1, value2, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andDataCreateuserNotBetween(String value1, String value2) {
            addCriterion("data_createUser not between", value1, value2, "dataCreateuser");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
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