package com.ibm.dw.bookkeeping.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "TABLE_ACCOUNT")
@XmlRootElement
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COL_ID")
    @Expose
    private int id;

    @ManyToOne
    @JoinColumn(name = "COL_PERSON")
    @Expose
    private Person person;

    @Column(name = "COL_AMOUNT")
    @Expose
    private BigDecimal amount;

    @Column(name = "COL_DATE")
    @Expose
    private Date date;

    @ManyToOne
    @JoinColumn(name = "COL_CATEGORY")
    @Expose
    private Category category;

    @Column(name = "COL_COMMENT")
    @Expose
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
