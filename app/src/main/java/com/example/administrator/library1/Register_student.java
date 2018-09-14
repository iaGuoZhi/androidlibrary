package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class Register_student extends AppCompatActivity {
    private EditText editAccount,editPassword1,editPassword2,editName,editMailbox,editAge,editStudentID;
    private Button button_commit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
        editAccount=findViewById(R.id.reg_st_acc_id);
        editPassword1=findViewById(R.id.reg_st_pass1_id);
        editPassword2=findViewById(R.id.reg_st_pass2_id);
        editName=findViewById(R.id.reg_st_name_id);
        editAge=findViewById(R.id.reg_st_age_id);
        editMailbox=findViewById(R.id.reg_st_mail_id);
        editStudentID=findViewById(R.id.reg_st_ID_id);
        button_commit=findViewById(R.id.reg_st_commit_id);
        button_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editAccount.getText().toString().equals("")||editPassword1.getText().toString().equals("")||editPassword2.getText().toString().equals("")||editName.getText().toString().equals("")||editAge.getText().toString().equals("")||editMailbox.getText().toString().equals("")||editStudentID.getText().toString().equals(""))
                {
                    Toast.makeText(Register_student.this,"注册信息不能为空",Toast.LENGTH_SHORT);
                }
                else
                {
                    if(editAccount.getText().toString().length()>=6&&editAccount.getText().toString().length()<=12)
                    {
                        List<Student> students_account= LitePal.findAll(Student.class);
                        boolean differ=true;
                        for(int i=0;i<students_account.size();++i)
                        {
                            if(editAccount.getText().toString().equals(students_account.get(i).getAccount()))
                            {
                                Toast.makeText(Register_student.this,"账号已存在",Toast.LENGTH_SHORT).show();
                                differ=false;
                            }
                        }
                        if(differ==true)
                        {
                            if(editPassword2.getText().toString().equals(editPassword1.getText().toString()))
                            {
                                int reg_age=Integer.parseInt(editAge.getText().toString());
                                Student student=new Student(editAccount.getText().toString(),editPassword1.getText().toString(),editName.getText().toString(),editStudentID.getText().toString(),editMailbox.getText().toString(),reg_age);
                                student.save();
                                Intent intent=new Intent(Register_student.this,MainActivity.class);
                                startActivity(intent);
                                //Toast.makeText(Register_student.this,"注册成功",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(Register_student.this,"两次密码不相同",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else
                    {
                        Toast.makeText(Register_student.this,"账号大小需要在6-12位数之间",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    @Override
    protected void onPause() {
        Intent intent=new Intent(Register_student.this,MainActivity.class);
        startActivity(intent);
        super.onPause();
    }
}
