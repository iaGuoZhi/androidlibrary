package com.example.administrator.library1;

import org.litepal.crud.LitePalSupport;

public class Simple extends LitePalSupport {
    private String account,password;
    public Simple(String account,String password)
    {
        this.account=account;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
