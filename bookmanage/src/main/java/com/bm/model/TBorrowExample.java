package com.bm.model;

import java.util.ArrayList;
import java.util.List;

public class TBorrowExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBorrowExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBorrowDateIsNull() {
            addCriterion("borrow_date is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDateIsNotNull() {
            addCriterion("borrow_date is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDateEqualTo(String value) {
            addCriterion("borrow_date =", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotEqualTo(String value) {
            addCriterion("borrow_date <>", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateGreaterThan(String value) {
            addCriterion("borrow_date >", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_date >=", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateLessThan(String value) {
            addCriterion("borrow_date <", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateLessThanOrEqualTo(String value) {
            addCriterion("borrow_date <=", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateLike(String value) {
            addCriterion("borrow_date like", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotLike(String value) {
            addCriterion("borrow_date not like", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateIn(List<String> values) {
            addCriterion("borrow_date in", values, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotIn(List<String> values) {
            addCriterion("borrow_date not in", values, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateBetween(String value1, String value2) {
            addCriterion("borrow_date between", value1, value2, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotBetween(String value1, String value2) {
            addCriterion("borrow_date not between", value1, value2, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateIsNull() {
            addCriterion("also_date is null");
            return (Criteria) this;
        }

        public Criteria andAlsoDateIsNotNull() {
            addCriterion("also_date is not null");
            return (Criteria) this;
        }

        public Criteria andAlsoDateEqualTo(String value) {
            addCriterion("also_date =", value, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateNotEqualTo(String value) {
            addCriterion("also_date <>", value, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateGreaterThan(String value) {
            addCriterion("also_date >", value, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateGreaterThanOrEqualTo(String value) {
            addCriterion("also_date >=", value, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateLessThan(String value) {
            addCriterion("also_date <", value, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateLessThanOrEqualTo(String value) {
            addCriterion("also_date <=", value, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateLike(String value) {
            addCriterion("also_date like", value, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateNotLike(String value) {
            addCriterion("also_date not like", value, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateIn(List<String> values) {
            addCriterion("also_date in", values, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateNotIn(List<String> values) {
            addCriterion("also_date not in", values, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateBetween(String value1, String value2) {
            addCriterion("also_date between", value1, value2, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andAlsoDateNotBetween(String value1, String value2) {
            addCriterion("also_date not between", value1, value2, "alsoDate");
            return (Criteria) this;
        }

        public Criteria andIsAlsoIsNull() {
            addCriterion("is_also is null");
            return (Criteria) this;
        }

        public Criteria andIsAlsoIsNotNull() {
            addCriterion("is_also is not null");
            return (Criteria) this;
        }

        public Criteria andIsAlsoEqualTo(Integer value) {
            addCriterion("is_also =", value, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsAlsoNotEqualTo(Integer value) {
            addCriterion("is_also <>", value, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsAlsoGreaterThan(Integer value) {
            addCriterion("is_also >", value, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsAlsoGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_also >=", value, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsAlsoLessThan(Integer value) {
            addCriterion("is_also <", value, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsAlsoLessThanOrEqualTo(Integer value) {
            addCriterion("is_also <=", value, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsAlsoIn(List<Integer> values) {
            addCriterion("is_also in", values, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsAlsoNotIn(List<Integer> values) {
            addCriterion("is_also not in", values, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsAlsoBetween(Integer value1, Integer value2) {
            addCriterion("is_also between", value1, value2, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsAlsoNotBetween(Integer value1, Integer value2) {
            addCriterion("is_also not between", value1, value2, "isAlso");
            return (Criteria) this;
        }

        public Criteria andIsContinueIsNull() {
            addCriterion("is_continue is null");
            return (Criteria) this;
        }

        public Criteria andIsContinueIsNotNull() {
            addCriterion("is_continue is not null");
            return (Criteria) this;
        }

        public Criteria andIsContinueEqualTo(Integer value) {
            addCriterion("is_continue =", value, "isContinue");
            return (Criteria) this;
        }

        public Criteria andIsContinueNotEqualTo(Integer value) {
            addCriterion("is_continue <>", value, "isContinue");
            return (Criteria) this;
        }

        public Criteria andIsContinueGreaterThan(Integer value) {
            addCriterion("is_continue >", value, "isContinue");
            return (Criteria) this;
        }

        public Criteria andIsContinueGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_continue >=", value, "isContinue");
            return (Criteria) this;
        }

        public Criteria andIsContinueLessThan(Integer value) {
            addCriterion("is_continue <", value, "isContinue");
            return (Criteria) this;
        }

        public Criteria andIsContinueLessThanOrEqualTo(Integer value) {
            addCriterion("is_continue <=", value, "isContinue");
            return (Criteria) this;
        }

        public Criteria andIsContinueIn(List<Integer> values) {
            addCriterion("is_continue in", values, "isContinue");
            return (Criteria) this;
        }

        public Criteria andIsContinueNotIn(List<Integer> values) {
            addCriterion("is_continue not in", values, "isContinue");
            return (Criteria) this;
        }

        public Criteria andIsContinueBetween(Integer value1, Integer value2) {
            addCriterion("is_continue between", value1, value2, "isContinue");
            return (Criteria) this;
        }

        public Criteria andIsContinueNotBetween(Integer value1, Integer value2) {
            addCriterion("is_continue not between", value1, value2, "isContinue");
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