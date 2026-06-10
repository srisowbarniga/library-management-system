package com.library.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrow_records")
public class IssueBook {

    @Id
    private Long borrow_id;

    private Long book_id;
    private Long member_id;
    private String issue_date;
    private String return_date;

    public IssueBook() {
    }

    public Long getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(Long borrow_id) {
        this.borrow_id = borrow_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
}