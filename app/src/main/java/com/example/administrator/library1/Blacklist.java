package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Blacklist extends AppCompatActivity {

    private ListView listView;
    private List<Student> studentList = new ArrayList<>();
    private List<String> list_st = new ArrayList<>();
    int year, day, length;
    public static int borrow_day = -1;
    String black="";
    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blacklist);

        listView = findViewById(R.id.blacklist_list_id);

        studentList = LitePal.findAll(Student.class);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        day = calendar.get(Calendar.DAY_OF_YEAR);

        for (int i = 0; i < studentList.size(); ++i) {
            black += ("姓名:" + studentList.get(i).getName() + "   " + "逾期未还书籍:");
            for (int j = 0; j < studentList.get(i).getBookAmount(); ++j) {
                length = year * 365 + day - studentList.get(i).getBookyear(j) * 365 - studentList.get(i).getBookyear(j);
                if (length > borrow_day) {
                    flag = true;
                    black += LitePal.find(Book.class,studentList.get(i).getBookList(j)).getName();
                    black += " ";
                }
            }
                if (flag == true) {
                    list_st.add(black);
                    black = "";
                    flag = false;
                }
                else black = "";
                    }
        ArrayAdapter adapter=new ArrayAdapter<String>(Blacklist.this,android.R.layout.simple_list_item_1,list_st);
        listView.setAdapter(adapter);
    }
    @Override
    protected void onPause() {
        Intent intent=new Intent(Blacklist.this,MainActivity.class);
        startActivity(intent);
        super.onPause();
    }
}
