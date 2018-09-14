package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class Login_staff extends AppCompatActivity {

    private EditText staff_editAccount,staff_editPassword;
    private CheckBox staff_checkBox;
    private Button staff_button_commit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_staff);
        staff_editAccount=findViewById(R.id.accountStaff_id);
        staff_editPassword=findViewById(R.id.passwordStaff_id);
        staff_checkBox=findViewById(R.id.rememberPassStaff_id);
        staff_button_commit=findViewById(R.id.commitStaff_id);
        Simple simple=LitePal.find(Simple.class,3);
        staff_editAccount.setText(simple.getAccount());
        staff_editPassword.setText(simple.getPassword());

        staff_button_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                  //在这里之前已经出错
                List<Staff> staffs_account = LitePal.findAll(Staff.class);
                boolean is_account_available = false;
                String st_account = staff_editAccount.getText().toString();
                String st_password = staff_editPassword.getText().toString();
                for (int i = 0; i < staffs_account.size(); ++i) {
                    if (st_account.equals(staffs_account.get(i).getAccount())) {  //get（i）这里的查询是从0开始的，即是get（0）查询的是id为1的员工
                        is_account_available = true;
                        if (st_password.equals(staffs_account.get(i).getPassword())) {
                            if(staff_checkBox.isChecked())
                            {
                                Simple simple= LitePal.find(Simple.class,3);
                                simple.setAccount(staff_editAccount.getText().toString());
                                simple.setPassword(staff_editPassword.getText().toString());
                                simple.save();
                            }
                            else
                            {
                                Simple simple1=LitePal.find(Simple.class,3);
                                simple1.setAccount("");
                                simple1.setPassword("");
                                simple1.save();
                            }
                            Intent intent = new Intent(Login_staff.this, Staff_homepage.class);
                            intent.putExtra("extra_data", i+1);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Login_staff.this, "密码错误", Toast.LENGTH_SHORT).show();
                            break;                           //记住密码还没有用上
                        }
                    }
                }
                if (is_account_available == false) {
                    Toast.makeText(Login_staff.this, "账号不存在", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
