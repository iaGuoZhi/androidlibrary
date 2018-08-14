package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.LitePal;

public class Staff_homepage extends AppCompatActivity {
    private int staff_id;
    Staff staff;
    private TextView textView_name;
    private Button button_add,button_cut,button_change_intro,button_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_homepage);
        textView_name=(TextView)findViewById(R.id.sta_home_infor_id);
        button_add=(Button)findViewById(R.id.sta_input_book_id);
        button_cut=(Button)findViewById(R.id.sta_output_book_id);
        button_change_intro=(Button)findViewById(R.id.sta_change_intro_id);
        button_news=(Button)findViewById(R.id.sta_add_news_Id);
        Intent intent=getIntent();
        staff_id=intent.getIntExtra("extra_data",1);
        staff= LitePal.find(Staff.class,staff_id);
        textView_name.setText("员工编号: "+staff.getId()+"     "+"姓名: "+staff.getName());

    }
}
