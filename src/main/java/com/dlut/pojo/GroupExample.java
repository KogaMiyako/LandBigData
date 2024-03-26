package com.dlut.pojo;

import java.util.ArrayList;
import java.util.List;

public class GroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupExample() {
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

        public Criteria andGourpIdIsNull() {
            addCriterion("gourp_id is null");
            return (Criteria) this;
        }

        public Criteria andGourpIdIsNotNull() {
            addCriterion("gourp_id is not null");
            return (Criteria) this;
        }

        public Criteria andGourpIdEqualTo(Integer value) {
            addCriterion("gourp_id =", value, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGourpIdNotEqualTo(Integer value) {
            addCriterion("gourp_id <>", value, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGourpIdGreaterThan(Integer value) {
            addCriterion("gourp_id >", value, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGourpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gourp_id >=", value, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGourpIdLessThan(Integer value) {
            addCriterion("gourp_id <", value, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGourpIdLessThanOrEqualTo(Integer value) {
            addCriterion("gourp_id <=", value, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGourpIdIn(List<Integer> values) {
            addCriterion("gourp_id in", values, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGourpIdNotIn(List<Integer> values) {
            addCriterion("gourp_id not in", values, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGourpIdBetween(Integer value1, Integer value2) {
            addCriterion("gourp_id between", value1, value2, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGourpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gourp_id not between", value1, value2, "gourpId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameIsNull() {
            addCriterion("group_leaderName is null");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameIsNotNull() {
            addCriterion("group_leaderName is not null");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameEqualTo(String value) {
            addCriterion("group_leaderName =", value, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameNotEqualTo(String value) {
            addCriterion("group_leaderName <>", value, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameGreaterThan(String value) {
            addCriterion("group_leaderName >", value, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameGreaterThanOrEqualTo(String value) {
            addCriterion("group_leaderName >=", value, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameLessThan(String value) {
            addCriterion("group_leaderName <", value, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameLessThanOrEqualTo(String value) {
            addCriterion("group_leaderName <=", value, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameLike(String value) {
            addCriterion("group_leaderName like", value, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameNotLike(String value) {
            addCriterion("group_leaderName not like", value, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameIn(List<String> values) {
            addCriterion("group_leaderName in", values, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameNotIn(List<String> values) {
            addCriterion("group_leaderName not in", values, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameBetween(String value1, String value2) {
            addCriterion("group_leaderName between", value1, value2, "groupLeadername");
            return (Criteria) this;
        }

        public Criteria andGroupLeadernameNotBetween(String value1, String value2) {
            addCriterion("group_leaderName not between", value1, value2, "groupLeadername");
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