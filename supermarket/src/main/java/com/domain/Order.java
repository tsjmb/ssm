package com.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order {
    private int id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date times;
    private int num;
    private String operator;
    private String tag;
    private double total;

    public Order(int id, Date times, int num, String operator, String tag, double total) {
        this.id = id;
        this.times = times;
        this.num = num;
        this.operator = operator;
        this.tag = tag;
        this.total = total;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", times=" + times +
                ", num=" + num +
                ", operator='" + operator + '\'' +
                ", tag='" + tag + '\'' +
                ", total=" + total +
                '}';
    }
}
