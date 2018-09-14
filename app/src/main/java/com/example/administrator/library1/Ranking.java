package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class Ranking extends AppCompatActivity {

    ListView listView1,listView2;
    List<Student> students=new ArrayList<>();
    List<Book> books=new ArrayList<>();
    List<String> stu=new ArrayList<>();
    List<String> bo=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        listView1=findViewById(R.id.rank_list1_id);
        listView2=findViewById(R.id.rank_list2_id);

        students= LitePal.findAll(Student.class);
        books=LitePal.findAll(Book.class);

        if(students.size()>5)
        {
            for(int i=0;i<5;++i)
            {
                for(int j=students.size()-1;j>0;--j)
                {
                    if(students.get(j).getBookAmount()>students.get(j-1).getBookAmount())
                    {
                        Student student_temp;
                        student_temp=students.get(j);
                        students.set(j,students.get(j-1));
                        students.set(j-1,student_temp);
                    }
                }
            }
            for(int i=0;i<5;++i)
            {
                stu.add("学生:"+students.get(i).getName()+"    "+"借阅量:"+String.valueOf(students.get(i).getBookAmount()));
            }
        }
        else
        {
            for(int i=0;i<students.size()-1;++i)
            {
                for(int j=i+1;j<students.size();++j)
                {
                    if(students.get(i).getBookAmount()<students.get(j).getBookAmount())
                    {
                        Student student_temp;
                        student_temp=students.get(i);
                        students.set(i,students.get(j));
                        students.set(j,student_temp);
                    }
                }
            }
            for(int i=0;i<students.size();++i)
            {
                stu.add("姓名:"+students.get(i).getName()+"    "+"借阅量:"+String.valueOf(students.get(i).getBookAmount()));
            }
        }
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(Ranking.this,android.R.layout.simple_list_item_1,stu);
        listView1.setAdapter(adapter1);

        if(books.size()>5)
        {
            for(int i=0;i<5;++i)
            {
                for(int j=books.size()-1;j>0;--j)
                {
                    if(books.get(j).getAmount()-books.get(j).getIn_shelf()>books.get(j-1).getAmount()-books.get(j-1).getIn_shelf())
                    {
                        Book book_temp;
                        book_temp=books.get(j);
                        books.set(j,books.get(j-1));
                        books.set(j-1,book_temp);
                    }
                }
            }
            for(int i=0;i<5;++i)
            {
                bo.add("书名:"+books.get(i).getName()+"    "+"被借阅量:"+String.valueOf(books.get(i).getAmount()-books.get(i).getIn_shelf()));
            }
        }
        else
        {
            for(int i=0;i<books.size()-1;++i)
            {
                for(int j=i+1;j<books.size();++j)
                {
                    if(books.get(i).getAmount()-books.get(i).getIn_shelf()<books.get(j).getAmount()-books.get(i).getIn_shelf())
                    {
                        Book book_temp;
                        book_temp=books.get(i);
                        books.set(i,books.get(j));
                        books.set(j,book_temp);
                    }
                }
            }
            for(int i=0;i<books.size();++i)
            {
                bo.add("书名:"+books.get(i).getName()+"    "+"被借阅量:"+String.valueOf(books.get(i).getAmount()-books.get(i).getIn_shelf()));
            }
        }
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(Ranking.this,android.R.layout.simple_list_item_1,bo);
        listView2.setAdapter(adapter2);
    }

    @Override
    protected void onPause() {
        Intent intent=new Intent(Ranking.this,MainActivity.class);
        startActivity(intent);
        super.onPause();
    }
}
