package com.example.administrator.library1;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends LitePalSupport{
    private int id;
    private String account,name,password,teacher_ID,mailBox;
    private int bookAmount,age;
    private int bookList[]=new int[10];
    public Teacher(String account, String password, String name, String teacher_ID, String mailBox, int age)
    {
        this.account=account;
        this.password=password;
        this.name=name;
        this.teacher_ID=teacher_ID;
        this.mailBox=mailBox;
        this.age=age;
        bookAmount=0;
        for(int i=0;i<10;++i)
        {
            bookList[i]=0;
        }
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }
    public void setTeacher_ID(String teacher_ID) {
        this.teacher_ID = teacher_ID;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getAccount() {
        return account;
    }
    public String getPassword() {
        return password;
    }
    public String getTeacher_ID() {
        return teacher_ID;
    }
    public String getMailBox() {
        return mailBox;
    }
    public void setBookList(int[] bookList) {
        this.bookList = bookList;
    }
    public void setBookList(int ammount,int book_id)
    {
        this.bookList[ammount]=book_id;
    }
    public int[] getBookList() {
        return bookList;
    }
    public int getBookAmount() {
        return bookAmount;
    }
    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }
    public int getBookList(int number)
    {
        return bookList[number];
    }

}

