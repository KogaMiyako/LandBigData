package com.dlut.pojo;

import java.util.ArrayList;
import java.util.List;

public class RuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RuleExample() {
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

        public Criteria andRuleIdIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(Integer value) {
            addCriterion("rule_id =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(Integer value) {
            addCriterion("rule_id <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(Integer value) {
            addCriterion("rule_id >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_id >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(Integer value) {
            addCriterion("rule_id <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("rule_id <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<Integer> values) {
            addCriterion("rule_id in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<Integer> values) {
            addCriterion("rule_id not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(Integer value1, Integer value2) {
            addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_id not between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleNumIsNull() {
            addCriterion("rule_num is null");
            return (Criteria) this;
        }

        public Criteria andRuleNumIsNotNull() {
            addCriterion("rule_num is not null");
            return (Criteria) this;
        }

        public Criteria andRuleNumEqualTo(Integer value) {
            addCriterion("rule_num =", value, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleNumNotEqualTo(Integer value) {
            addCriterion("rule_num <>", value, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleNumGreaterThan(Integer value) {
            addCriterion("rule_num >", value, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_num >=", value, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleNumLessThan(Integer value) {
            addCriterion("rule_num <", value, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleNumLessThanOrEqualTo(Integer value) {
            addCriterion("rule_num <=", value, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleNumIn(List<Integer> values) {
            addCriterion("rule_num in", values, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleNumNotIn(List<Integer> values) {
            addCriterion("rule_num not in", values, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleNumBetween(Integer value1, Integer value2) {
            addCriterion("rule_num between", value1, value2, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_num not between", value1, value2, "ruleNum");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeIsNull() {
            addCriterion("rule_describe is null");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeIsNotNull() {
            addCriterion("rule_describe is not null");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeEqualTo(String value) {
            addCriterion("rule_describe =", value, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeNotEqualTo(String value) {
            addCriterion("rule_describe <>", value, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeGreaterThan(String value) {
            addCriterion("rule_describe >", value, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_describe >=", value, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeLessThan(String value) {
            addCriterion("rule_describe <", value, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeLessThanOrEqualTo(String value) {
            addCriterion("rule_describe <=", value, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeLike(String value) {
            addCriterion("rule_describe like", value, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeNotLike(String value) {
            addCriterion("rule_describe not like", value, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeIn(List<String> values) {
            addCriterion("rule_describe in", values, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeNotIn(List<String> values) {
            addCriterion("rule_describe not in", values, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeBetween(String value1, String value2) {
            addCriterion("rule_describe between", value1, value2, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleDescribeNotBetween(String value1, String value2) {
            addCriterion("rule_describe not between", value1, value2, "ruleDescribe");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIsNull() {
            addCriterion("rule_type is null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIsNotNull() {
            addCriterion("rule_type is not null");
            return (Criteria) this;
        }

        public Criteria andRuleTypeEqualTo(Integer value) {
            addCriterion("rule_type =", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotEqualTo(Integer value) {
            addCriterion("rule_type <>", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThan(Integer value) {
            addCriterion("rule_type >", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_type >=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThan(Integer value) {
            addCriterion("rule_type <", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("rule_type <=", value, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeIn(List<Integer> values) {
            addCriterion("rule_type in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotIn(List<Integer> values) {
            addCriterion("rule_type not in", values, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeBetween(Integer value1, Integer value2) {
            addCriterion("rule_type between", value1, value2, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRuleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_type not between", value1, value2, "ruleType");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelIsNull() {
            addCriterion("rule_pH_level is null");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelIsNotNull() {
            addCriterion("rule_pH_level is not null");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelEqualTo(Integer value) {
            addCriterion("rule_pH_level =", value, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelNotEqualTo(Integer value) {
            addCriterion("rule_pH_level <>", value, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelGreaterThan(Integer value) {
            addCriterion("rule_pH_level >", value, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_pH_level >=", value, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelLessThan(Integer value) {
            addCriterion("rule_pH_level <", value, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelLessThanOrEqualTo(Integer value) {
            addCriterion("rule_pH_level <=", value, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelIn(List<Integer> values) {
            addCriterion("rule_pH_level in", values, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelNotIn(List<Integer> values) {
            addCriterion("rule_pH_level not in", values, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelBetween(Integer value1, Integer value2) {
            addCriterion("rule_pH_level between", value1, value2, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRulePhLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_pH_level not between", value1, value2, "rulePhLevel");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeIsNull() {
            addCriterion("rule_crop_type is null");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeIsNotNull() {
            addCriterion("rule_crop_type is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeEqualTo(Integer value) {
            addCriterion("rule_crop_type =", value, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeNotEqualTo(Integer value) {
            addCriterion("rule_crop_type <>", value, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeGreaterThan(Integer value) {
            addCriterion("rule_crop_type >", value, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_crop_type >=", value, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeLessThan(Integer value) {
            addCriterion("rule_crop_type <", value, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeLessThanOrEqualTo(Integer value) {
            addCriterion("rule_crop_type <=", value, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeIn(List<Integer> values) {
            addCriterion("rule_crop_type in", values, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeNotIn(List<Integer> values) {
            addCriterion("rule_crop_type not in", values, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeBetween(Integer value1, Integer value2) {
            addCriterion("rule_crop_type between", value1, value2, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCropTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_crop_type not between", value1, value2, "ruleCropType");
            return (Criteria) this;
        }

        public Criteria andRuleCrIsNull() {
            addCriterion("rule_Cr is null");
            return (Criteria) this;
        }

        public Criteria andRuleCrIsNotNull() {
            addCriterion("rule_Cr is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCrEqualTo(Float value) {
            addCriterion("rule_Cr =", value, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleCrNotEqualTo(Float value) {
            addCriterion("rule_Cr <>", value, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleCrGreaterThan(Float value) {
            addCriterion("rule_Cr >", value, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleCrGreaterThanOrEqualTo(Float value) {
            addCriterion("rule_Cr >=", value, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleCrLessThan(Float value) {
            addCriterion("rule_Cr <", value, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleCrLessThanOrEqualTo(Float value) {
            addCriterion("rule_Cr <=", value, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleCrIn(List<Float> values) {
            addCriterion("rule_Cr in", values, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleCrNotIn(List<Float> values) {
            addCriterion("rule_Cr not in", values, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleCrBetween(Float value1, Float value2) {
            addCriterion("rule_Cr between", value1, value2, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleCrNotBetween(Float value1, Float value2) {
            addCriterion("rule_Cr not between", value1, value2, "ruleCr");
            return (Criteria) this;
        }

        public Criteria andRuleNiIsNull() {
            addCriterion("rule_Ni is null");
            return (Criteria) this;
        }

        public Criteria andRuleNiIsNotNull() {
            addCriterion("rule_Ni is not null");
            return (Criteria) this;
        }

        public Criteria andRuleNiEqualTo(Float value) {
            addCriterion("rule_Ni =", value, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleNiNotEqualTo(Float value) {
            addCriterion("rule_Ni <>", value, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleNiGreaterThan(Float value) {
            addCriterion("rule_Ni >", value, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleNiGreaterThanOrEqualTo(Float value) {
            addCriterion("rule_Ni >=", value, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleNiLessThan(Float value) {
            addCriterion("rule_Ni <", value, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleNiLessThanOrEqualTo(Float value) {
            addCriterion("rule_Ni <=", value, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleNiIn(List<Float> values) {
            addCriterion("rule_Ni in", values, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleNiNotIn(List<Float> values) {
            addCriterion("rule_Ni not in", values, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleNiBetween(Float value1, Float value2) {
            addCriterion("rule_Ni between", value1, value2, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleNiNotBetween(Float value1, Float value2) {
            addCriterion("rule_Ni not between", value1, value2, "ruleNi");
            return (Criteria) this;
        }

        public Criteria andRuleCuIsNull() {
            addCriterion("rule_Cu is null");
            return (Criteria) this;
        }

        public Criteria andRuleCuIsNotNull() {
            addCriterion("rule_Cu is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCuEqualTo(Float value) {
            addCriterion("rule_Cu =", value, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleCuNotEqualTo(Float value) {
            addCriterion("rule_Cu <>", value, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleCuGreaterThan(Float value) {
            addCriterion("rule_Cu >", value, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleCuGreaterThanOrEqualTo(Float value) {
            addCriterion("rule_Cu >=", value, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleCuLessThan(Float value) {
            addCriterion("rule_Cu <", value, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleCuLessThanOrEqualTo(Float value) {
            addCriterion("rule_Cu <=", value, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleCuIn(List<Float> values) {
            addCriterion("rule_Cu in", values, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleCuNotIn(List<Float> values) {
            addCriterion("rule_Cu not in", values, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleCuBetween(Float value1, Float value2) {
            addCriterion("rule_Cu between", value1, value2, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleCuNotBetween(Float value1, Float value2) {
            addCriterion("rule_Cu not between", value1, value2, "ruleCu");
            return (Criteria) this;
        }

        public Criteria andRuleZnIsNull() {
            addCriterion("rule_Zn is null");
            return (Criteria) this;
        }

        public Criteria andRuleZnIsNotNull() {
            addCriterion("rule_Zn is not null");
            return (Criteria) this;
        }

        public Criteria andRuleZnEqualTo(Float value) {
            addCriterion("rule_Zn =", value, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleZnNotEqualTo(Float value) {
            addCriterion("rule_Zn <>", value, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleZnGreaterThan(Float value) {
            addCriterion("rule_Zn >", value, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleZnGreaterThanOrEqualTo(Float value) {
            addCriterion("rule_Zn >=", value, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleZnLessThan(Float value) {
            addCriterion("rule_Zn <", value, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleZnLessThanOrEqualTo(Float value) {
            addCriterion("rule_Zn <=", value, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleZnIn(List<Float> values) {
            addCriterion("rule_Zn in", values, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleZnNotIn(List<Float> values) {
            addCriterion("rule_Zn not in", values, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleZnBetween(Float value1, Float value2) {
            addCriterion("rule_Zn between", value1, value2, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleZnNotBetween(Float value1, Float value2) {
            addCriterion("rule_Zn not between", value1, value2, "ruleZn");
            return (Criteria) this;
        }

        public Criteria andRuleAsIsNull() {
            addCriterion("rule_As is null");
            return (Criteria) this;
        }

        public Criteria andRuleAsIsNotNull() {
            addCriterion("rule_As is not null");
            return (Criteria) this;
        }

        public Criteria andRuleAsEqualTo(Float value) {
            addCriterion("rule_As =", value, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleAsNotEqualTo(Float value) {
            addCriterion("rule_As <>", value, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleAsGreaterThan(Float value) {
            addCriterion("rule_As >", value, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleAsGreaterThanOrEqualTo(Float value) {
            addCriterion("rule_As >=", value, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleAsLessThan(Float value) {
            addCriterion("rule_As <", value, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleAsLessThanOrEqualTo(Float value) {
            addCriterion("rule_As <=", value, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleAsIn(List<Float> values) {
            addCriterion("rule_As in", values, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleAsNotIn(List<Float> values) {
            addCriterion("rule_As not in", values, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleAsBetween(Float value1, Float value2) {
            addCriterion("rule_As between", value1, value2, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleAsNotBetween(Float value1, Float value2) {
            addCriterion("rule_As not between", value1, value2, "ruleAs");
            return (Criteria) this;
        }

        public Criteria andRuleCdIsNull() {
            addCriterion("rule_Cd is null");
            return (Criteria) this;
        }

        public Criteria andRuleCdIsNotNull() {
            addCriterion("rule_Cd is not null");
            return (Criteria) this;
        }

        public Criteria andRuleCdEqualTo(Float value) {
            addCriterion("rule_Cd =", value, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleCdNotEqualTo(Float value) {
            addCriterion("rule_Cd <>", value, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleCdGreaterThan(Float value) {
            addCriterion("rule_Cd >", value, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleCdGreaterThanOrEqualTo(Float value) {
            addCriterion("rule_Cd >=", value, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleCdLessThan(Float value) {
            addCriterion("rule_Cd <", value, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleCdLessThanOrEqualTo(Float value) {
            addCriterion("rule_Cd <=", value, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleCdIn(List<Float> values) {
            addCriterion("rule_Cd in", values, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleCdNotIn(List<Float> values) {
            addCriterion("rule_Cd not in", values, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleCdBetween(Float value1, Float value2) {
            addCriterion("rule_Cd between", value1, value2, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleCdNotBetween(Float value1, Float value2) {
            addCriterion("rule_Cd not between", value1, value2, "ruleCd");
            return (Criteria) this;
        }

        public Criteria andRuleHgIsNull() {
            addCriterion("rule_Hg is null");
            return (Criteria) this;
        }

        public Criteria andRuleHgIsNotNull() {
            addCriterion("rule_Hg is not null");
            return (Criteria) this;
        }

        public Criteria andRuleHgEqualTo(Float value) {
            addCriterion("rule_Hg =", value, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRuleHgNotEqualTo(Float value) {
            addCriterion("rule_Hg <>", value, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRuleHgGreaterThan(Float value) {
            addCriterion("rule_Hg >", value, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRuleHgGreaterThanOrEqualTo(Float value) {
            addCriterion("rule_Hg >=", value, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRuleHgLessThan(Float value) {
            addCriterion("rule_Hg <", value, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRuleHgLessThanOrEqualTo(Float value) {
            addCriterion("rule_Hg <=", value, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRuleHgIn(List<Float> values) {
            addCriterion("rule_Hg in", values, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRuleHgNotIn(List<Float> values) {
            addCriterion("rule_Hg not in", values, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRuleHgBetween(Float value1, Float value2) {
            addCriterion("rule_Hg between", value1, value2, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRuleHgNotBetween(Float value1, Float value2) {
            addCriterion("rule_Hg not between", value1, value2, "ruleHg");
            return (Criteria) this;
        }

        public Criteria andRulePbIsNull() {
            addCriterion("rule_Pb is null");
            return (Criteria) this;
        }

        public Criteria andRulePbIsNotNull() {
            addCriterion("rule_Pb is not null");
            return (Criteria) this;
        }

        public Criteria andRulePbEqualTo(Float value) {
            addCriterion("rule_Pb =", value, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRulePbNotEqualTo(Float value) {
            addCriterion("rule_Pb <>", value, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRulePbGreaterThan(Float value) {
            addCriterion("rule_Pb >", value, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRulePbGreaterThanOrEqualTo(Float value) {
            addCriterion("rule_Pb >=", value, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRulePbLessThan(Float value) {
            addCriterion("rule_Pb <", value, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRulePbLessThanOrEqualTo(Float value) {
            addCriterion("rule_Pb <=", value, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRulePbIn(List<Float> values) {
            addCriterion("rule_Pb in", values, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRulePbNotIn(List<Float> values) {
            addCriterion("rule_Pb not in", values, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRulePbBetween(Float value1, Float value2) {
            addCriterion("rule_Pb between", value1, value2, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRulePbNotBetween(Float value1, Float value2) {
            addCriterion("rule_Pb not between", value1, value2, "rulePb");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdIsNull() {
            addCriterion("rule_laws_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdIsNotNull() {
            addCriterion("rule_laws_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdEqualTo(Integer value) {
            addCriterion("rule_laws_id =", value, "ruleLawsId");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdNotEqualTo(Integer value) {
            addCriterion("rule_laws_id <>", value, "ruleLawsId");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdGreaterThan(Integer value) {
            addCriterion("rule_laws_id >", value, "ruleLawsId");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_laws_id >=", value, "ruleLawsId");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdLessThan(Integer value) {
            addCriterion("rule_laws_id <", value, "ruleLawsId");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdLessThanOrEqualTo(Integer value) {
            addCriterion("rule_laws_id <=", value, "ruleLawsId");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdIn(List<Integer> values) {
            addCriterion("rule_laws_id in", values, "ruleLawsId");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdNotIn(List<Integer> values) {
            addCriterion("rule_laws_id not in", values, "ruleLawsId");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdBetween(Integer value1, Integer value2) {
            addCriterion("rule_laws_id between", value1, value2, "ruleLawsId");
            return (Criteria) this;
        }

        public Criteria andRuleLawsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_laws_id not between", value1, value2, "ruleLawsId");
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