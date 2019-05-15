package com.bm.model;

import java.util.ArrayList;
import java.util.List;

public class TBookExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBookExample() {
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

        public Criteria andBookNumberIsNull() {
            addCriterion("book_number is null");
            return (Criteria) this;
        }

        public Criteria andBookNumberIsNotNull() {
            addCriterion("book_number is not null");
            return (Criteria) this;
        }

        public Criteria andBookNumberEqualTo(String value) {
            addCriterion("book_number =", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberNotEqualTo(String value) {
            addCriterion("book_number <>", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberGreaterThan(String value) {
            addCriterion("book_number >", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberGreaterThanOrEqualTo(String value) {
            addCriterion("book_number >=", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberLessThan(String value) {
            addCriterion("book_number <", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberLessThanOrEqualTo(String value) {
            addCriterion("book_number <=", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberLike(String value) {
            addCriterion("book_number like", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberNotLike(String value) {
            addCriterion("book_number not like", value, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberIn(List<String> values) {
            addCriterion("book_number in", values, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberNotIn(List<String> values) {
            addCriterion("book_number not in", values, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberBetween(String value1, String value2) {
            addCriterion("book_number between", value1, value2, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNumberNotBetween(String value1, String value2) {
            addCriterion("book_number not between", value1, value2, "bookNumber");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNull() {
            addCriterion("book_author is null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIsNotNull() {
            addCriterion("book_author is not null");
            return (Criteria) this;
        }

        public Criteria andBookAuthorEqualTo(String value) {
            addCriterion("book_author =", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotEqualTo(String value) {
            addCriterion("book_author <>", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThan(String value) {
            addCriterion("book_author >", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("book_author >=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThan(String value) {
            addCriterion("book_author <", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLessThanOrEqualTo(String value) {
            addCriterion("book_author <=", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorLike(String value) {
            addCriterion("book_author like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotLike(String value) {
            addCriterion("book_author not like", value, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorIn(List<String> values) {
            addCriterion("book_author in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotIn(List<String> values) {
            addCriterion("book_author not in", values, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorBetween(String value1, String value2) {
            addCriterion("book_author between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookAuthorNotBetween(String value1, String value2) {
            addCriterion("book_author not between", value1, value2, "bookAuthor");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNull() {
            addCriterion("\"book_ press\" is null");
            return (Criteria) this;
        }

        public Criteria andBookPressIsNotNull() {
            addCriterion("\"book_ press\" is not null");
            return (Criteria) this;
        }

        public Criteria andBookPressEqualTo(String value) {
            addCriterion("\"book_ press\" =", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotEqualTo(String value) {
            addCriterion("\"book_ press\" <>", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThan(String value) {
            addCriterion("\"book_ press\" >", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressGreaterThanOrEqualTo(String value) {
            addCriterion("\"book_ press\" >=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThan(String value) {
            addCriterion("\"book_ press\" <", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLessThanOrEqualTo(String value) {
            addCriterion("\"book_ press\" <=", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressLike(String value) {
            addCriterion("\"book_ press\" like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotLike(String value) {
            addCriterion("\"book_ press\" not like", value, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressIn(List<String> values) {
            addCriterion("\"book_ press\" in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotIn(List<String> values) {
            addCriterion("\"book_ press\" not in", values, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressBetween(String value1, String value2) {
            addCriterion("\"book_ press\" between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookPressNotBetween(String value1, String value2) {
            addCriterion("\"book_ press\" not between", value1, value2, "bookPress");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeIsNull() {
            addCriterion("book_createtime is null");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeIsNotNull() {
            addCriterion("book_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeEqualTo(String value) {
            addCriterion("book_createtime =", value, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeNotEqualTo(String value) {
            addCriterion("book_createtime <>", value, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeGreaterThan(String value) {
            addCriterion("book_createtime >", value, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("book_createtime >=", value, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeLessThan(String value) {
            addCriterion("book_createtime <", value, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("book_createtime <=", value, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeLike(String value) {
            addCriterion("book_createtime like", value, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeNotLike(String value) {
            addCriterion("book_createtime not like", value, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeIn(List<String> values) {
            addCriterion("book_createtime in", values, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeNotIn(List<String> values) {
            addCriterion("book_createtime not in", values, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeBetween(String value1, String value2) {
            addCriterion("book_createtime between", value1, value2, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookCreatetimeNotBetween(String value1, String value2) {
            addCriterion("book_createtime not between", value1, value2, "bookCreatetime");
            return (Criteria) this;
        }

        public Criteria andBookSummaryIsNull() {
            addCriterion("\"book_ summary\" is null");
            return (Criteria) this;
        }

        public Criteria andBookSummaryIsNotNull() {
            addCriterion("\"book_ summary\" is not null");
            return (Criteria) this;
        }

        public Criteria andBookSummaryEqualTo(String value) {
            addCriterion("\"book_ summary\" =", value, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryNotEqualTo(String value) {
            addCriterion("\"book_ summary\" <>", value, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryGreaterThan(String value) {
            addCriterion("\"book_ summary\" >", value, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("\"book_ summary\" >=", value, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryLessThan(String value) {
            addCriterion("\"book_ summary\" <", value, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryLessThanOrEqualTo(String value) {
            addCriterion("\"book_ summary\" <=", value, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryLike(String value) {
            addCriterion("\"book_ summary\" like", value, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryNotLike(String value) {
            addCriterion("\"book_ summary\" not like", value, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryIn(List<String> values) {
            addCriterion("\"book_ summary\" in", values, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryNotIn(List<String> values) {
            addCriterion("\"book_ summary\" not in", values, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryBetween(String value1, String value2) {
            addCriterion("\"book_ summary\" between", value1, value2, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookSummaryNotBetween(String value1, String value2) {
            addCriterion("\"book_ summary\" not between", value1, value2, "bookSummary");
            return (Criteria) this;
        }

        public Criteria andBookRemarkIsNull() {
            addCriterion("book_remark is null");
            return (Criteria) this;
        }

        public Criteria andBookRemarkIsNotNull() {
            addCriterion("book_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBookRemarkEqualTo(String value) {
            addCriterion("book_remark =", value, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkNotEqualTo(String value) {
            addCriterion("book_remark <>", value, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkGreaterThan(String value) {
            addCriterion("book_remark >", value, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("book_remark >=", value, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkLessThan(String value) {
            addCriterion("book_remark <", value, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkLessThanOrEqualTo(String value) {
            addCriterion("book_remark <=", value, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkLike(String value) {
            addCriterion("book_remark like", value, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkNotLike(String value) {
            addCriterion("book_remark not like", value, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkIn(List<String> values) {
            addCriterion("book_remark in", values, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkNotIn(List<String> values) {
            addCriterion("book_remark not in", values, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkBetween(String value1, String value2) {
            addCriterion("book_remark between", value1, value2, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andBookRemarkNotBetween(String value1, String value2) {
            addCriterion("book_remark not between", value1, value2, "bookRemark");
            return (Criteria) this;
        }

        public Criteria andEbookIsNull() {
            addCriterion("ebook is null");
            return (Criteria) this;
        }

        public Criteria andEbookIsNotNull() {
            addCriterion("ebook is not null");
            return (Criteria) this;
        }

        public Criteria andEbookEqualTo(String value) {
            addCriterion("ebook =", value, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookNotEqualTo(String value) {
            addCriterion("ebook <>", value, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookGreaterThan(String value) {
            addCriterion("ebook >", value, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookGreaterThanOrEqualTo(String value) {
            addCriterion("ebook >=", value, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookLessThan(String value) {
            addCriterion("ebook <", value, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookLessThanOrEqualTo(String value) {
            addCriterion("ebook <=", value, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookLike(String value) {
            addCriterion("ebook like", value, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookNotLike(String value) {
            addCriterion("ebook not like", value, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookIn(List<String> values) {
            addCriterion("ebook in", values, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookNotIn(List<String> values) {
            addCriterion("ebook not in", values, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookBetween(String value1, String value2) {
            addCriterion("ebook between", value1, value2, "ebook");
            return (Criteria) this;
        }

        public Criteria andEbookNotBetween(String value1, String value2) {
            addCriterion("ebook not between", value1, value2, "ebook");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNull() {
            addCriterion("sort_id is null");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNotNull() {
            addCriterion("sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andSortIdEqualTo(Integer value) {
            addCriterion("sort_id =", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotEqualTo(Integer value) {
            addCriterion("sort_id <>", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThan(Integer value) {
            addCriterion("sort_id >", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_id >=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThan(Integer value) {
            addCriterion("sort_id <", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThanOrEqualTo(Integer value) {
            addCriterion("sort_id <=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdIn(List<Integer> values) {
            addCriterion("sort_id in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotIn(List<Integer> values) {
            addCriterion("sort_id not in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdBetween(Integer value1, Integer value2) {
            addCriterion("sort_id between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_id not between", value1, value2, "sortId");
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