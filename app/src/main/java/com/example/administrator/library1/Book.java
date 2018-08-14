package com.example.administrator.library1;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Book extends LitePalSupport{
    int id;
    private String name;
    private String writer,page,price,time;
    private int borrow_year,borrow_month,borrow_day,recommends,frequency,amount,in_shelf;
    public Book(String name,String writer,String page,String price,String time,int amount)
    {
        this.name=name;
        this.writer=writer;
        this.page=page;
        this.price=price;
        this.time=time;
        this.amount=amount;
        borrow_day=0;borrow_month=0;borrow_year=0;recommends=0;frequency=0;
        in_shelf=amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }
    public void setIn_shelf(int in_shelf) {
        this.in_shelf = in_shelf;
    }
    public int getIn_shelf() {
        return in_shelf;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public int getFrequency() {
        return frequency;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setBorrow_day(int borrow_day) {
        this.borrow_day = borrow_day;
    }
    public void setBorrow_month(int borrow_month) {
        this.borrow_month = borrow_month;
    }
    public void setBorrow_year(int borrow_year) {
        this.borrow_year = borrow_year;
    }
    public void setPage(String page) {
        this.page = page;
    }
    public void setRecommends(int recommends) {
        this.recommends = recommends;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getName() {
        return name;
    }
    public int getBorrow_day() {
        return borrow_day;
    }
    public int getBorrow_month() {
        return borrow_month;
    }
    public int getBorrow_year() {
        return borrow_year;
    }
    public int getRecommends() {
        return recommends;
    }
    public String getPage() {
        return page;
    }
    public String getPrice() {
        return price;
    }
    public String getTime() {
        return time;
    }
    public String getWriter() {
        return writer;
    }

}
