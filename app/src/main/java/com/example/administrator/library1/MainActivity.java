package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity {

    private Button button_introduce,button_information,button_ranking,button_newBooks,button_register_student,button_register_teacher,button_blacklist;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.student_id:
                Intent intent_student=new Intent(MainActivity.this,Login_student.class);
                startActivity(intent_student);
                break;
            case R.id.teacher_id:
                Intent intent_teacher=new Intent(MainActivity.this,Login_teacher.class);
                startActivity(intent_teacher);
                break;
            case R.id.staff_id:
                Intent intent_staff=new Intent(MainActivity.this,Login_staff.class);
                startActivity(intent_staff);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_introduce=findViewById(R.id.introduce_id);
        button_register_student=findViewById(R.id.registerStudent_id);
        button_register_teacher=findViewById(R.id.registerTeacher_id);
        button_blacklist=findViewById(R.id.blacklist_id);
        button_information=findViewById(R.id.news_id);
        button_introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Introduction.class);
                startActivity(intent);
                finish();
            }
        });
        button_register_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Register_student.class);
                startActivity(intent);
                finish();
            }
        });
        button_register_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Register_teacher.class);
                startActivity(intent);
                finish();
            }
        });
        button_blacklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
                Book book=new Book("He changed China","jiang","278","23.8","2002/2/12",2);
                book.save();
            }
        });
    }
}
