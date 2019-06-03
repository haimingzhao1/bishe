package com.bm.model;

public class TLeaveMsg {
    private Integer id;
    private String total;
    private String content;
    private TStudent student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TStudent getStudent() {
        return student;
    }

    public void setStudent(TStudent student) {
        this.student = student;
    }
}
