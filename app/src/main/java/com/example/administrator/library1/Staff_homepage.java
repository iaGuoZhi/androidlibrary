package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class Staff_homepage extends AppCompatActivity {
    private int staff_id;
    Staff staff;
    private TextView textView_name;
    private Button button_add,button_return;
    private List<Book> totalbooks=new ArrayList<>();
    private List<String> booknames=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_homepage);
        textView_name = (TextView) findViewById(R.id.sta_home_infor_id);
        button_add = (Button) findViewById(R.id.sta_input_book_id);
        button_return = (Button) findViewById(R.id.sta_return_id);
        totalbooks = LitePal.findAll(Book.class);

        final Intent intent = getIntent();
        staff_id = intent.getIntExtra("extra_data", 1);
        staff = LitePal.find(Staff.class, staff_id);
        textView_name.setText("员工编号: " + staff.getId() + "     " + "姓名: " + staff.getName());

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Staff_homepage.this, staff_input.class);
                startActivity(intent1);
            }
        });

        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Staff_homepage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        for (int i = 0; i < totalbooks.size(); ++i) {
            booknames.add("名称:" + totalbooks.get(i).getName() + "  " + "作者:" + totalbooks.get(i).getWriter() + "  " + "数量:" + totalbooks.get(i).getAmount());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Staff_homepage.this, android.R.layout.simple_list_item_1, booknames);
        ListView listView = (ListView) findViewById(R.id.staff_home_list_id);
        listView.setAdapter(adapter);
    }
}
