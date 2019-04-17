package com.bm.model;

public class AdminBook {
    private Integer id;

    private String addTime;

    private Integer bookId;

    private Integer addNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(Integer addNumber) {
        this.addNumber = addNumber;
    }
}