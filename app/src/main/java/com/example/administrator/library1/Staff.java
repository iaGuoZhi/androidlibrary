package com.example.administrator.library1;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

public class Staff extends LitePalSupport {
    private int id;
    private String account,password,name,staff_number,mail_box;
    int age;
    public Staff(String account,String password,String name,String staff_number,String mail_box,int age)
    {
        this.account=account;
        this.age=age;
        this.staff_number=staff_number;
        this.mail_box=mail_box;
        this.password=password;
        this.name=name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public int getAge() {
        return age;
    }
    public String getStaff_number() {
        return staff_number;
    }
    public String getMail_box() {
        return mail_box;
    }
    public String getAccount() {
        return account;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public void setMail_box(String mail_box) {
        this.mail_box = mail_box;
    }
    public void setStaff_number(String staff_number) {
        this.staff_number = staff_number;
    }
}
