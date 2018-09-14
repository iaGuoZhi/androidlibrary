package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Login_student extends AppCompatActivity {

    private EditText editAccount,editPassword;
    private CheckBox checkBox;
    private Button button_commit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);
        editAccount=findViewById(R.id.accountStudent_id);
        editPassword=findViewById(R.id.passwordStudent_id);
        checkBox=findViewById(R.id.rememberPassStudent_id);
        button_commit=findViewById(R.id.commitStudent_id);

        //自动登录功能
        final Simple simple=LitePal.find(Simple.class,1);
        editAccount.setText(simple.getAccount());
        editPassword.setText(simple.getPassword());

        button_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                  //在这里之前已经出错
                List<Student> students_account= LitePal.findAll(Student.class);
                boolean is_account_available=false;
                String st_account,st_password;
                st_account=editAccount.getText().toString();
                st_password=editPassword.getText().toString();
                for(int i=0;i<students_account.size();++i)
                {
                    if(st_account.equals(students_account.get(i).getAccount()))
                    {
                        is_account_available=true;
                        if(st_password.equals(students_account.get(i).getPassword()))
                        {
                            if(checkBox.isChecked())
                            {
                                Simple simple= LitePal.find(Simple.class,1);
                                simple.setAccount(editAccount.getText().toString());
                                simple.setPassword(editPassword.getText().toString());
                                simple.save();
                            }
                            else
                            {
                                Simple simple1=LitePal.find(Simple.class,1);
                                simple1.setAccount("");
                                simple1.setPassword("");
                                simple1.save();
                            }
                            Intent intent=new Intent(Login_student.this,Student_homepage.class);
                            intent.putExtra("extra_data",i+1);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(Login_student.this,"密码错误",Toast.LENGTH_SHORT).show();
                            break;                           //记住密码还没有用上
                        }
                    }
                }
                if(is_account_available==false)
                {
                    Toast.makeText(Login_student.this,"账号不存在",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
