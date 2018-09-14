package com.example.administrator.library1;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.List;

public class Student extends LitePalSupport{
    private int id;
    private String account,name,password,student_ID,mailBox;
    private int age,bookAmount;
    private int bookList[]=new int[10];
    private int bookyear[]=new int[10];
    private int bookday[]=new int[10];

    public Student(String account, String password, String name, String student_ID, String mailBox, int age)
    {
        this.account=account;
        this.password=password;
        this.name=name;
        this.student_ID=student_ID;
        this.mailBox=mailBox;
        this.age=age;
        bookAmount=0;
        for(int i=0;i<10;++i)
        {
            bookList[i]=0;
            bookyear[i]=0;
            bookday[i]=0;
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
    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
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
    public String getStudent_ID() {
        return student_ID;
    }
    public String getMailBox() {
        return mailBox;
    }
    public void setBookList(int[] bookList) {
        this.bookList = bookList;
    }
    public void setBookList(int number,int book_id)
    {
        this.bookList[number]=book_id;
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
    public int getBookyear(int number){return bookyear[number];}
    public int getBookday(int number){return bookday[number];}
    public void setBookyear(int number,int year){this.bookyear[number]=year;}
    public void setBookday(int number,int day){this.bookday[number]=day;}

}
