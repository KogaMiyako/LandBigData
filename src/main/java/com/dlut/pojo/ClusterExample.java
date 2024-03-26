package com.dlut.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClusterExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cluster
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cluster
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cluster
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cluster
     *
     * @mbggenerated
     */
    public ClusterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cluster
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cluster
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cluster
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cluster
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cluster
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cluster
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cluster
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
     * This method corresponds to the database table cluster
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
     * This method corresponds to the database table cluster
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cluster
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
     * This class corresponds to the database table cluster
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

        public Criteria andClusterIdIsNull() {
            addCriterion("cluster_id is null");
            return (Criteria) this;
        }

        public Criteria andClusterIdIsNotNull() {
            addCriterion("cluster_id is not null");
            return (Criteria) this;
        }

        public Criteria andClusterIdEqualTo(Integer value) {
            addCriterion("cluster_id =", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotEqualTo(Integer value) {
            addCriterion("cluster_id <>", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThan(Integer value) {
            addCriterion("cluster_id >", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cluster_id >=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThan(Integer value) {
            addCriterion("cluster_id <", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThanOrEqualTo(Integer value) {
            addCriterion("cluster_id <=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdIn(List<Integer> values) {
            addCriterion("cluster_id in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotIn(List<Integer> values) {
            addCriterion("cluster_id not in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdBetween(Integer value1, Integer value2) {
            addCriterion("cluster_id between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cluster_id not between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterNameIsNull() {
            addCriterion("cluster_name is null");
            return (Criteria) this;
        }

        public Criteria andClusterNameIsNotNull() {
            addCriterion("cluster_name is not null");
            return (Criteria) this;
        }

        public Criteria andClusterNameEqualTo(String value) {
            addCriterion("cluster_name =", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameNotEqualTo(String value) {
            addCriterion("cluster_name <>", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameGreaterThan(String value) {
            addCriterion("cluster_name >", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameGreaterThanOrEqualTo(String value) {
            addCriterion("cluster_name >=", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameLessThan(String value) {
            addCriterion("cluster_name <", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameLessThanOrEqualTo(String value) {
            addCriterion("cluster_name <=", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameLike(String value) {
            addCriterion("cluster_name like", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameNotLike(String value) {
            addCriterion("cluster_name not like", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameIn(List<String> values) {
            addCriterion("cluster_name in", values, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameNotIn(List<String> values) {
            addCriterion("cluster_name not in", values, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameBetween(String value1, String value2) {
            addCriterion("cluster_name between", value1, value2, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameNotBetween(String value1, String value2) {
            addCriterion("cluster_name not between", value1, value2, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberIsNull() {
            addCriterion("cluster_node_number is null");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberIsNotNull() {
            addCriterion("cluster_node_number is not null");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberEqualTo(Integer value) {
            addCriterion("cluster_node_number =", value, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberNotEqualTo(Integer value) {
            addCriterion("cluster_node_number <>", value, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberGreaterThan(Integer value) {
            addCriterion("cluster_node_number >", value, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("cluster_node_number >=", value, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberLessThan(Integer value) {
            addCriterion("cluster_node_number <", value, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("cluster_node_number <=", value, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberIn(List<Integer> values) {
            addCriterion("cluster_node_number in", values, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberNotIn(List<Integer> values) {
            addCriterion("cluster_node_number not in", values, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberBetween(Integer value1, Integer value2) {
            addCriterion("cluster_node_number between", value1, value2, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterNodeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("cluster_node_number not between", value1, value2, "clusterNodeNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberIsNull() {
            addCriterion("cluster_master_number is null");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberIsNotNull() {
            addCriterion("cluster_master_number is not null");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberEqualTo(Integer value) {
            addCriterion("cluster_master_number =", value, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberNotEqualTo(Integer value) {
            addCriterion("cluster_master_number <>", value, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberGreaterThan(Integer value) {
            addCriterion("cluster_master_number >", value, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("cluster_master_number >=", value, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberLessThan(Integer value) {
            addCriterion("cluster_master_number <", value, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberLessThanOrEqualTo(Integer value) {
            addCriterion("cluster_master_number <=", value, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberIn(List<Integer> values) {
            addCriterion("cluster_master_number in", values, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberNotIn(List<Integer> values) {
            addCriterion("cluster_master_number not in", values, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberBetween(Integer value1, Integer value2) {
            addCriterion("cluster_master_number between", value1, value2, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterMasterNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("cluster_master_number not between", value1, value2, "clusterMasterNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberIsNull() {
            addCriterion("cluster_slave_number is null");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberIsNotNull() {
            addCriterion("cluster_slave_number is not null");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberEqualTo(Integer value) {
            addCriterion("cluster_slave_number =", value, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberNotEqualTo(Integer value) {
            addCriterion("cluster_slave_number <>", value, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberGreaterThan(Integer value) {
            addCriterion("cluster_slave_number >", value, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("cluster_slave_number >=", value, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberLessThan(Integer value) {
            addCriterion("cluster_slave_number <", value, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberLessThanOrEqualTo(Integer value) {
            addCriterion("cluster_slave_number <=", value, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberIn(List<Integer> values) {
            addCriterion("cluster_slave_number in", values, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberNotIn(List<Integer> values) {
            addCriterion("cluster_slave_number not in", values, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberBetween(Integer value1, Integer value2) {
            addCriterion("cluster_slave_number between", value1, value2, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterSlaveNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("cluster_slave_number not between", value1, value2, "clusterSlaveNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberIsNull() {
            addCriterion("cluster_storage_number is null");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberIsNotNull() {
            addCriterion("cluster_storage_number is not null");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberEqualTo(Integer value) {
            addCriterion("cluster_storage_number =", value, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberNotEqualTo(Integer value) {
            addCriterion("cluster_storage_number <>", value, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberGreaterThan(Integer value) {
            addCriterion("cluster_storage_number >", value, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("cluster_storage_number >=", value, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberLessThan(Integer value) {
            addCriterion("cluster_storage_number <", value, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberLessThanOrEqualTo(Integer value) {
            addCriterion("cluster_storage_number <=", value, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberIn(List<Integer> values) {
            addCriterion("cluster_storage_number in", values, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberNotIn(List<Integer> values) {
            addCriterion("cluster_storage_number not in", values, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberBetween(Integer value1, Integer value2) {
            addCriterion("cluster_storage_number between", value1, value2, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterStorageNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("cluster_storage_number not between", value1, value2, "clusterStorageNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberIsNull() {
            addCriterion("cluster_cpu_number is null");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberIsNotNull() {
            addCriterion("cluster_cpu_number is not null");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberEqualTo(Integer value) {
            addCriterion("cluster_cpu_number =", value, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberNotEqualTo(Integer value) {
            addCriterion("cluster_cpu_number <>", value, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberGreaterThan(Integer value) {
            addCriterion("cluster_cpu_number >", value, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("cluster_cpu_number >=", value, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberLessThan(Integer value) {
            addCriterion("cluster_cpu_number <", value, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberLessThanOrEqualTo(Integer value) {
            addCriterion("cluster_cpu_number <=", value, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberIn(List<Integer> values) {
            addCriterion("cluster_cpu_number in", values, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberNotIn(List<Integer> values) {
            addCriterion("cluster_cpu_number not in", values, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberBetween(Integer value1, Integer value2) {
            addCriterion("cluster_cpu_number between", value1, value2, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("cluster_cpu_number not between", value1, value2, "clusterCpuNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberIsNull() {
            addCriterion("cluster_cpu_kernel_number is null");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberIsNotNull() {
            addCriterion("cluster_cpu_kernel_number is not null");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberEqualTo(Integer value) {
            addCriterion("cluster_cpu_kernel_number =", value, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberNotEqualTo(Integer value) {
            addCriterion("cluster_cpu_kernel_number <>", value, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberGreaterThan(Integer value) {
            addCriterion("cluster_cpu_kernel_number >", value, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("cluster_cpu_kernel_number >=", value, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberLessThan(Integer value) {
            addCriterion("cluster_cpu_kernel_number <", value, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberLessThanOrEqualTo(Integer value) {
            addCriterion("cluster_cpu_kernel_number <=", value, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberIn(List<Integer> values) {
            addCriterion("cluster_cpu_kernel_number in", values, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberNotIn(List<Integer> values) {
            addCriterion("cluster_cpu_kernel_number not in", values, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberBetween(Integer value1, Integer value2) {
            addCriterion("cluster_cpu_kernel_number between", value1, value2, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterCpuKernelNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("cluster_cpu_kernel_number not between", value1, value2, "clusterCpuKernelNumber");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageIsNull() {
            addCriterion("cluster_total_storage is null");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageIsNotNull() {
            addCriterion("cluster_total_storage is not null");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageEqualTo(String value) {
            addCriterion("cluster_total_storage =", value, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageNotEqualTo(String value) {
            addCriterion("cluster_total_storage <>", value, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageGreaterThan(String value) {
            addCriterion("cluster_total_storage >", value, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageGreaterThanOrEqualTo(String value) {
            addCriterion("cluster_total_storage >=", value, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageLessThan(String value) {
            addCriterion("cluster_total_storage <", value, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageLessThanOrEqualTo(String value) {
            addCriterion("cluster_total_storage <=", value, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageLike(String value) {
            addCriterion("cluster_total_storage like", value, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageNotLike(String value) {
            addCriterion("cluster_total_storage not like", value, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageIn(List<String> values) {
            addCriterion("cluster_total_storage in", values, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageNotIn(List<String> values) {
            addCriterion("cluster_total_storage not in", values, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageBetween(String value1, String value2) {
            addCriterion("cluster_total_storage between", value1, value2, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalStorageNotBetween(String value1, String value2) {
            addCriterion("cluster_total_storage not between", value1, value2, "clusterTotalStorage");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryIsNull() {
            addCriterion("cluster_total_momery is null");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryIsNotNull() {
            addCriterion("cluster_total_momery is not null");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryEqualTo(String value) {
            addCriterion("cluster_total_momery =", value, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryNotEqualTo(String value) {
            addCriterion("cluster_total_momery <>", value, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryGreaterThan(String value) {
            addCriterion("cluster_total_momery >", value, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryGreaterThanOrEqualTo(String value) {
            addCriterion("cluster_total_momery >=", value, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryLessThan(String value) {
            addCriterion("cluster_total_momery <", value, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryLessThanOrEqualTo(String value) {
            addCriterion("cluster_total_momery <=", value, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryLike(String value) {
            addCriterion("cluster_total_momery like", value, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryNotLike(String value) {
            addCriterion("cluster_total_momery not like", value, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryIn(List<String> values) {
            addCriterion("cluster_total_momery in", values, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryNotIn(List<String> values) {
            addCriterion("cluster_total_momery not in", values, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryBetween(String value1, String value2) {
            addCriterion("cluster_total_momery between", value1, value2, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterTotalMomeryNotBetween(String value1, String value2) {
            addCriterion("cluster_total_momery not between", value1, value2, "clusterTotalMomery");
            return (Criteria) this;
        }

        public Criteria andClusterOsIsNull() {
            addCriterion("cluster_os is null");
            return (Criteria) this;
        }

        public Criteria andClusterOsIsNotNull() {
            addCriterion("cluster_os is not null");
            return (Criteria) this;
        }

        public Criteria andClusterOsEqualTo(String value) {
            addCriterion("cluster_os =", value, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsNotEqualTo(String value) {
            addCriterion("cluster_os <>", value, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsGreaterThan(String value) {
            addCriterion("cluster_os >", value, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsGreaterThanOrEqualTo(String value) {
            addCriterion("cluster_os >=", value, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsLessThan(String value) {
            addCriterion("cluster_os <", value, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsLessThanOrEqualTo(String value) {
            addCriterion("cluster_os <=", value, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsLike(String value) {
            addCriterion("cluster_os like", value, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsNotLike(String value) {
            addCriterion("cluster_os not like", value, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsIn(List<String> values) {
            addCriterion("cluster_os in", values, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsNotIn(List<String> values) {
            addCriterion("cluster_os not in", values, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsBetween(String value1, String value2) {
            addCriterion("cluster_os between", value1, value2, "clusterOs");
            return (Criteria) this;
        }

        public Criteria andClusterOsNotBetween(String value1, String value2) {
            addCriterion("cluster_os not between", value1, value2, "clusterOs");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cluster
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
     * This class corresponds to the database table cluster
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