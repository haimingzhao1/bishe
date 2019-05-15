package com.bm.model;

public class TBorrow {

    private Integer id;

    private Integer userId;

    private Integer bookId;

    private String borrowDate;

    private String alsoDate;

    private Integer isAlso;

    private Integer isContinue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate == null ? null : borrowDate.trim();
    }

    public String getAlsoDate() {
        return alsoDate;
    }

    public void setAlsoDate(String alsoDate) {
        this.alsoDate = alsoDate == null ? null : alsoDate.trim();
    }

    public Integer getIsAlso() {
        return isAlso;
    }

    public void setIsAlso(Integer isAlso) {
        this.isAlso = isAlso;
    }

    public Integer getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(Integer isContinue) {
        this.isContinue = isContinue;
    }
}