package com.example.administrator.library1;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Book extends LitePalSupport{
    int id;
    private String name;
    private String writer,page,price,time;
    private int amount,in_shelf;
    public Book(String name,String writer,String page,String price,String time,int amount)
    {
        this.name=name;
        this.writer=writer;
        this.page=page;
        this.price=price;
        this.time=time;
        this.amount=amount;
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
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setPage(String page) {
        this.page = page;
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
