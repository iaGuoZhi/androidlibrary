package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Login_teacher extends AppCompatActivity {

    private EditText tea_acc,tea_pass;
    private CheckBox tea_rem;
    private Button tea_commit;
    private MyApplication mAppInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_teacher);
        tea_acc=findViewById(R.id.accountTeacher_id);
        tea_pass=findViewById(R.id.passwordTeacher_id);
        tea_rem=findViewById(R.id.rememberPassTeacher_id);
        tea_commit=findViewById(R.id.commitTeacher_id);
        tea_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String account,password;
                account=tea_acc.getText().toString();
                password=tea_pass.getText().toString();
                String Msg="22:"+account+":"+password;     //2代表教师，2代表注册
                String revMsg=mAppInstance.SendMessageToServer(Msg);
                if(revMsg.equals("Not set Server IP")) {
                    Toast.makeText(Login_teacher.this, "服务器IP地址未设定", Toast.LENGTH_SHORT).show();
                }
                else{
                        if (revMsg.equals("Loginfail")) {
                            Toast.makeText(Login_teacher.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Login_teacher.this,revMsg,Toast.LENGTH_SHORT).show();
                            /*Intent intent = new Intent(Login_teacher.this, Teacher_homepage.class);
                            intent.putExtra("data", Msg);
                            startActivity(intent);*/
                    /*String[] sep =revMsg.split(":");
                    Teacher mteacher=new Teacher(account,password,sep[0],sep[1],sep[2],sep[3]);
                    mteacher.setBookAmount(Integer.parseInt(sep[4]));
                    List<Book> bookList=new ArrayList<>();
                    for(int i=0;i<Integer.parseInt(sep[4]);++i)
                    {
                        String sear_book="41"+sep[5+i];
                        String bookMsg=mAppInstance.SendMessageToServer(sear_book);
                        String[] book=bookMsg.split(":");
                        Book mbook=new Book(book[0],book[1],book[2],book[3],book[4],Integer.parseInt(sep[5]));
                        bookList.add(mbook);
                    }*/
                        }
                    }
                }

        });
    }
}
