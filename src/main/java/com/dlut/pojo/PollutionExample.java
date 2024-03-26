package com.dlut.pojo;

import java.util.ArrayList;
import java.util.List;

public class PollutionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PollutionExample() {
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

        public Criteria andPollutionIdIsNull() {
            addCriterion("pollution_id is null");
            return (Criteria) this;
        }

        public Criteria andPollutionIdIsNotNull() {
            addCriterion("pollution_id is not null");
            return (Criteria) this;
        }

        public Criteria andPollutionIdEqualTo(Integer value) {
            addCriterion("pollution_id =", value, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionIdNotEqualTo(Integer value) {
            addCriterion("pollution_id <>", value, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionIdGreaterThan(Integer value) {
            addCriterion("pollution_id >", value, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pollution_id >=", value, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionIdLessThan(Integer value) {
            addCriterion("pollution_id <", value, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionIdLessThanOrEqualTo(Integer value) {
            addCriterion("pollution_id <=", value, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionIdIn(List<Integer> values) {
            addCriterion("pollution_id in", values, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionIdNotIn(List<Integer> values) {
            addCriterion("pollution_id not in", values, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionIdBetween(Integer value1, Integer value2) {
            addCriterion("pollution_id between", value1, value2, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pollution_id not between", value1, value2, "pollutionId");
            return (Criteria) this;
        }

        public Criteria andPollutionNameIsNull() {
            addCriterion("pollution_name is null");
            return (Criteria) this;
        }

        public Criteria andPollutionNameIsNotNull() {
            addCriterion("pollution_name is not null");
            return (Criteria) this;
        }

        public Criteria andPollutionNameEqualTo(String value) {
            addCriterion("pollution_name =", value, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameNotEqualTo(String value) {
            addCriterion("pollution_name <>", value, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameGreaterThan(String value) {
            addCriterion("pollution_name >", value, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameGreaterThanOrEqualTo(String value) {
            addCriterion("pollution_name >=", value, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameLessThan(String value) {
            addCriterion("pollution_name <", value, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameLessThanOrEqualTo(String value) {
            addCriterion("pollution_name <=", value, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameLike(String value) {
            addCriterion("pollution_name like", value, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameNotLike(String value) {
            addCriterion("pollution_name not like", value, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameIn(List<String> values) {
            addCriterion("pollution_name in", values, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameNotIn(List<String> values) {
            addCriterion("pollution_name not in", values, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameBetween(String value1, String value2) {
            addCriterion("pollution_name between", value1, value2, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionNameNotBetween(String value1, String value2) {
            addCriterion("pollution_name not between", value1, value2, "pollutionName");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeIsNull() {
            addCriterion("pollution_describe is null");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeIsNotNull() {
            addCriterion("pollution_describe is not null");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeEqualTo(String value) {
            addCriterion("pollution_describe =", value, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeNotEqualTo(String value) {
            addCriterion("pollution_describe <>", value, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeGreaterThan(String value) {
            addCriterion("pollution_describe >", value, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("pollution_describe >=", value, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeLessThan(String value) {
            addCriterion("pollution_describe <", value, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeLessThanOrEqualTo(String value) {
            addCriterion("pollution_describe <=", value, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeLike(String value) {
            addCriterion("pollution_describe like", value, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeNotLike(String value) {
            addCriterion("pollution_describe not like", value, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeIn(List<String> values) {
            addCriterion("pollution_describe in", values, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeNotIn(List<String> values) {
            addCriterion("pollution_describe not in", values, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeBetween(String value1, String value2) {
            addCriterion("pollution_describe between", value1, value2, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andPollutionDescribeNotBetween(String value1, String value2) {
            addCriterion("pollution_describe not between", value1, value2, "pollutionDescribe");
            return (Criteria) this;
        }

        public Criteria andCrIsNull() {
            addCriterion("Cr is null");
            return (Criteria) this;
        }

        public Criteria andCrIsNotNull() {
            addCriterion("Cr is not null");
            return (Criteria) this;
        }

        public Criteria andCrEqualTo(Integer value) {
            addCriterion("Cr =", value, "cr");
            return (Criteria) this;
        }

        public Criteria andCrNotEqualTo(Integer value) {
            addCriterion("Cr <>", value, "cr");
            return (Criteria) this;
        }

        public Criteria andCrGreaterThan(Integer value) {
            addCriterion("Cr >", value, "cr");
            return (Criteria) this;
        }

        public Criteria andCrGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cr >=", value, "cr");
            return (Criteria) this;
        }

        public Criteria andCrLessThan(Integer value) {
            addCriterion("Cr <", value, "cr");
            return (Criteria) this;
        }

        public Criteria andCrLessThanOrEqualTo(Integer value) {
            addCriterion("Cr <=", value, "cr");
            return (Criteria) this;
        }

        public Criteria andCrIn(List<Integer> values) {
            addCriterion("Cr in", values, "cr");
            return (Criteria) this;
        }

        public Criteria andCrNotIn(List<Integer> values) {
            addCriterion("Cr not in", values, "cr");
            return (Criteria) this;
        }

        public Criteria andCrBetween(Integer value1, Integer value2) {
            addCriterion("Cr between", value1, value2, "cr");
            return (Criteria) this;
        }

        public Criteria andCrNotBetween(Integer value1, Integer value2) {
            addCriterion("Cr not between", value1, value2, "cr");
            return (Criteria) this;
        }

        public Criteria andNiIsNull() {
            addCriterion("Ni is null");
            return (Criteria) this;
        }

        public Criteria andNiIsNotNull() {
            addCriterion("Ni is not null");
            return (Criteria) this;
        }

        public Criteria andNiEqualTo(Integer value) {
            addCriterion("Ni =", value, "ni");
            return (Criteria) this;
        }

        public Criteria andNiNotEqualTo(Integer value) {
            addCriterion("Ni <>", value, "ni");
            return (Criteria) this;
        }

        public Criteria andNiGreaterThan(Integer value) {
            addCriterion("Ni >", value, "ni");
            return (Criteria) this;
        }

        public Criteria andNiGreaterThanOrEqualTo(Integer value) {
            addCriterion("Ni >=", value, "ni");
            return (Criteria) this;
        }

        public Criteria andNiLessThan(Integer value) {
            addCriterion("Ni <", value, "ni");
            return (Criteria) this;
        }

        public Criteria andNiLessThanOrEqualTo(Integer value) {
            addCriterion("Ni <=", value, "ni");
            return (Criteria) this;
        }

        public Criteria andNiIn(List<Integer> values) {
            addCriterion("Ni in", values, "ni");
            return (Criteria) this;
        }

        public Criteria andNiNotIn(List<Integer> values) {
            addCriterion("Ni not in", values, "ni");
            return (Criteria) this;
        }

        public Criteria andNiBetween(Integer value1, Integer value2) {
            addCriterion("Ni between", value1, value2, "ni");
            return (Criteria) this;
        }

        public Criteria andNiNotBetween(Integer value1, Integer value2) {
            addCriterion("Ni not between", value1, value2, "ni");
            return (Criteria) this;
        }

        public Criteria andCuIsNull() {
            addCriterion("Cu is null");
            return (Criteria) this;
        }

        public Criteria andCuIsNotNull() {
            addCriterion("Cu is not null");
            return (Criteria) this;
        }

        public Criteria andCuEqualTo(Integer value) {
            addCriterion("Cu =", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotEqualTo(Integer value) {
            addCriterion("Cu <>", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuGreaterThan(Integer value) {
            addCriterion("Cu >", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cu >=", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuLessThan(Integer value) {
            addCriterion("Cu <", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuLessThanOrEqualTo(Integer value) {
            addCriterion("Cu <=", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuIn(List<Integer> values) {
            addCriterion("Cu in", values, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotIn(List<Integer> values) {
            addCriterion("Cu not in", values, "cu");
            return (Criteria) this;
        }

        public Criteria andCuBetween(Integer value1, Integer value2) {
            addCriterion("Cu between", value1, value2, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotBetween(Integer value1, Integer value2) {
            addCriterion("Cu not between", value1, value2, "cu");
            return (Criteria) this;
        }

        public Criteria andZnIsNull() {
            addCriterion("Zn is null");
            return (Criteria) this;
        }

        public Criteria andZnIsNotNull() {
            addCriterion("Zn is not null");
            return (Criteria) this;
        }

        public Criteria andZnEqualTo(Integer value) {
            addCriterion("Zn =", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotEqualTo(Integer value) {
            addCriterion("Zn <>", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnGreaterThan(Integer value) {
            addCriterion("Zn >", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnGreaterThanOrEqualTo(Integer value) {
            addCriterion("Zn >=", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnLessThan(Integer value) {
            addCriterion("Zn <", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnLessThanOrEqualTo(Integer value) {
            addCriterion("Zn <=", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnIn(List<Integer> values) {
            addCriterion("Zn in", values, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotIn(List<Integer> values) {
            addCriterion("Zn not in", values, "zn");
            return (Criteria) this;
        }

        public Criteria andZnBetween(Integer value1, Integer value2) {
            addCriterion("Zn between", value1, value2, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotBetween(Integer value1, Integer value2) {
            addCriterion("Zn not between", value1, value2, "zn");
            return (Criteria) this;
        }

        public Criteria andAsIsNull() {
            addCriterion("As_ is null");
            return (Criteria) this;
        }

        public Criteria andAsIsNotNull() {
            addCriterion("As_ is not null");
            return (Criteria) this;
        }

        public Criteria andAsEqualTo(Integer value) {
            addCriterion("As_ =", value, "as");
            return (Criteria) this;
        }

        public Criteria andAsNotEqualTo(Integer value) {
            addCriterion("As_ <>", value, "as");
            return (Criteria) this;
        }

        public Criteria andAsGreaterThan(Integer value) {
            addCriterion("As_ >", value, "as");
            return (Criteria) this;
        }

        public Criteria andAsGreaterThanOrEqualTo(Integer value) {
            addCriterion("As_ >=", value, "as");
            return (Criteria) this;
        }

        public Criteria andAsLessThan(Integer value) {
            addCriterion("As_ <", value, "as");
            return (Criteria) this;
        }

        public Criteria andAsLessThanOrEqualTo(Integer value) {
            addCriterion("As_ <=", value, "as");
            return (Criteria) this;
        }

        public Criteria andAsIn(List<Integer> values) {
            addCriterion("As_ in", values, "as");
            return (Criteria) this;
        }

        public Criteria andAsNotIn(List<Integer> values) {
            addCriterion("As_ not in", values, "as");
            return (Criteria) this;
        }

        public Criteria andAsBetween(Integer value1, Integer value2) {
            addCriterion("As_ between", value1, value2, "as");
            return (Criteria) this;
        }

        public Criteria andAsNotBetween(Integer value1, Integer value2) {
            addCriterion("As_ not between", value1, value2, "as");
            return (Criteria) this;
        }

        public Criteria andCdIsNull() {
            addCriterion("Cd is null");
            return (Criteria) this;
        }

        public Criteria andCdIsNotNull() {
            addCriterion("Cd is not null");
            return (Criteria) this;
        }

        public Criteria andCdEqualTo(Integer value) {
            addCriterion("Cd =", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdNotEqualTo(Integer value) {
            addCriterion("Cd <>", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdGreaterThan(Integer value) {
            addCriterion("Cd >", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Cd >=", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdLessThan(Integer value) {
            addCriterion("Cd <", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdLessThanOrEqualTo(Integer value) {
            addCriterion("Cd <=", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdIn(List<Integer> values) {
            addCriterion("Cd in", values, "cd");
            return (Criteria) this;
        }

        public Criteria andCdNotIn(List<Integer> values) {
            addCriterion("Cd not in", values, "cd");
            return (Criteria) this;
        }

        public Criteria andCdBetween(Integer value1, Integer value2) {
            addCriterion("Cd between", value1, value2, "cd");
            return (Criteria) this;
        }

        public Criteria andCdNotBetween(Integer value1, Integer value2) {
            addCriterion("Cd not between", value1, value2, "cd");
            return (Criteria) this;
        }

        public Criteria andHgIsNull() {
            addCriterion("Hg is null");
            return (Criteria) this;
        }

        public Criteria andHgIsNotNull() {
            addCriterion("Hg is not null");
            return (Criteria) this;
        }

        public Criteria andHgEqualTo(Integer value) {
            addCriterion("Hg =", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgNotEqualTo(Integer value) {
            addCriterion("Hg <>", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgGreaterThan(Integer value) {
            addCriterion("Hg >", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgGreaterThanOrEqualTo(Integer value) {
            addCriterion("Hg >=", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgLessThan(Integer value) {
            addCriterion("Hg <", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgLessThanOrEqualTo(Integer value) {
            addCriterion("Hg <=", value, "hg");
            return (Criteria) this;
        }

        public Criteria andHgIn(List<Integer> values) {
            addCriterion("Hg in", values, "hg");
            return (Criteria) this;
        }

        public Criteria andHgNotIn(List<Integer> values) {
            addCriterion("Hg not in", values, "hg");
            return (Criteria) this;
        }

        public Criteria andHgBetween(Integer value1, Integer value2) {
            addCriterion("Hg between", value1, value2, "hg");
            return (Criteria) this;
        }

        public Criteria andHgNotBetween(Integer value1, Integer value2) {
            addCriterion("Hg not between", value1, value2, "hg");
            return (Criteria) this;
        }

        public Criteria andPbIsNull() {
            addCriterion("Pb is null");
            return (Criteria) this;
        }

        public Criteria andPbIsNotNull() {
            addCriterion("Pb is not null");
            return (Criteria) this;
        }

        public Criteria andPbEqualTo(Integer value) {
            addCriterion("Pb =", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotEqualTo(Integer value) {
            addCriterion("Pb <>", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbGreaterThan(Integer value) {
            addCriterion("Pb >", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbGreaterThanOrEqualTo(Integer value) {
            addCriterion("Pb >=", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbLessThan(Integer value) {
            addCriterion("Pb <", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbLessThanOrEqualTo(Integer value) {
            addCriterion("Pb <=", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbIn(List<Integer> values) {
            addCriterion("Pb in", values, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotIn(List<Integer> values) {
            addCriterion("Pb not in", values, "pb");
            return (Criteria) this;
        }

        public Criteria andPbBetween(Integer value1, Integer value2) {
            addCriterion("Pb between", value1, value2, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotBetween(Integer value1, Integer value2) {
            addCriterion("Pb not between", value1, value2, "pb");
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