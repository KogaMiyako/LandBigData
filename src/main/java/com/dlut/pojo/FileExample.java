package com.dlut.pojo;

import java.util.ArrayList;
import java.util.List;

public class FileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileExample() {
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

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(Integer value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(Integer value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(Integer value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(Integer value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(Integer value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<Integer> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<Integer> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(Integer value1, Integer value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeIsNull() {
            addCriterion("file_discribe is null");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeIsNotNull() {
            addCriterion("file_discribe is not null");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeEqualTo(String value) {
            addCriterion("file_discribe =", value, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeNotEqualTo(String value) {
            addCriterion("file_discribe <>", value, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeGreaterThan(String value) {
            addCriterion("file_discribe >", value, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeGreaterThanOrEqualTo(String value) {
            addCriterion("file_discribe >=", value, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeLessThan(String value) {
            addCriterion("file_discribe <", value, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeLessThanOrEqualTo(String value) {
            addCriterion("file_discribe <=", value, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeLike(String value) {
            addCriterion("file_discribe like", value, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeNotLike(String value) {
            addCriterion("file_discribe not like", value, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeIn(List<String> values) {
            addCriterion("file_discribe in", values, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeNotIn(List<String> values) {
            addCriterion("file_discribe not in", values, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeBetween(String value1, String value2) {
            addCriterion("file_discribe between", value1, value2, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDiscribeNotBetween(String value1, String value2) {
            addCriterion("file_discribe not between", value1, value2, "fileDiscribe");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryIsNull() {
            addCriterion("file_directory is null");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryIsNotNull() {
            addCriterion("file_directory is not null");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryEqualTo(String value) {
            addCriterion("file_directory =", value, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryNotEqualTo(String value) {
            addCriterion("file_directory <>", value, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryGreaterThan(String value) {
            addCriterion("file_directory >", value, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryGreaterThanOrEqualTo(String value) {
            addCriterion("file_directory >=", value, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryLessThan(String value) {
            addCriterion("file_directory <", value, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryLessThanOrEqualTo(String value) {
            addCriterion("file_directory <=", value, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryLike(String value) {
            addCriterion("file_directory like", value, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryNotLike(String value) {
            addCriterion("file_directory not like", value, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryIn(List<String> values) {
            addCriterion("file_directory in", values, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryNotIn(List<String> values) {
            addCriterion("file_directory not in", values, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryBetween(String value1, String value2) {
            addCriterion("file_directory between", value1, value2, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileDirectoryNotBetween(String value1, String value2) {
            addCriterion("file_directory not between", value1, value2, "fileDirectory");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathIsNull() {
            addCriterion("file_complete_path is null");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathIsNotNull() {
            addCriterion("file_complete_path is not null");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathEqualTo(String value) {
            addCriterion("file_complete_path =", value, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathNotEqualTo(String value) {
            addCriterion("file_complete_path <>", value, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathGreaterThan(String value) {
            addCriterion("file_complete_path >", value, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_complete_path >=", value, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathLessThan(String value) {
            addCriterion("file_complete_path <", value, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathLessThanOrEqualTo(String value) {
            addCriterion("file_complete_path <=", value, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathLike(String value) {
            addCriterion("file_complete_path like", value, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathNotLike(String value) {
            addCriterion("file_complete_path not like", value, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathIn(List<String> values) {
            addCriterion("file_complete_path in", values, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathNotIn(List<String> values) {
            addCriterion("file_complete_path not in", values, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathBetween(String value1, String value2) {
            addCriterion("file_complete_path between", value1, value2, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileCompletePathNotBetween(String value1, String value2) {
            addCriterion("file_complete_path not between", value1, value2, "fileCompletePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathIsNull() {
            addCriterion("file_relative_path is null");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathIsNotNull() {
            addCriterion("file_relative_path is not null");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathEqualTo(String value) {
            addCriterion("file_relative_path =", value, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathNotEqualTo(String value) {
            addCriterion("file_relative_path <>", value, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathGreaterThan(String value) {
            addCriterion("file_relative_path >", value, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_relative_path >=", value, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathLessThan(String value) {
            addCriterion("file_relative_path <", value, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathLessThanOrEqualTo(String value) {
            addCriterion("file_relative_path <=", value, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathLike(String value) {
            addCriterion("file_relative_path like", value, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathNotLike(String value) {
            addCriterion("file_relative_path not like", value, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathIn(List<String> values) {
            addCriterion("file_relative_path in", values, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathNotIn(List<String> values) {
            addCriterion("file_relative_path not in", values, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathBetween(String value1, String value2) {
            addCriterion("file_relative_path between", value1, value2, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileRelativePathNotBetween(String value1, String value2) {
            addCriterion("file_relative_path not between", value1, value2, "fileRelativePath");
            return (Criteria) this;
        }

        public Criteria andFileAuthorIsNull() {
            addCriterion("file_author is null");
            return (Criteria) this;
        }

        public Criteria andFileAuthorIsNotNull() {
            addCriterion("file_author is not null");
            return (Criteria) this;
        }

        public Criteria andFileAuthorEqualTo(String value) {
            addCriterion("file_author =", value, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorNotEqualTo(String value) {
            addCriterion("file_author <>", value, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorGreaterThan(String value) {
            addCriterion("file_author >", value, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("file_author >=", value, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorLessThan(String value) {
            addCriterion("file_author <", value, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorLessThanOrEqualTo(String value) {
            addCriterion("file_author <=", value, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorLike(String value) {
            addCriterion("file_author like", value, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorNotLike(String value) {
            addCriterion("file_author not like", value, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorIn(List<String> values) {
            addCriterion("file_author in", values, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorNotIn(List<String> values) {
            addCriterion("file_author not in", values, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorBetween(String value1, String value2) {
            addCriterion("file_author between", value1, value2, "fileAuthor");
            return (Criteria) this;
        }

        public Criteria andFileAuthorNotBetween(String value1, String value2) {
            addCriterion("file_author not between", value1, value2, "fileAuthor");
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