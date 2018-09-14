package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.media.CamcorderProfile.get;//
//应该是书的数据没有存进去。

public class Student_homepage extends AppCompatActivity {
    private int book_id[]=new int[10];
    Student student_local;
    private List<String> bookList=new ArrayList<>();
    private Book book_in_search,book_in_delete;
    int student_id;
    boolean key=false;
    private TextView text_student_infor,text_book_infor;
    private Button search,borrow;
    private EditText search_content;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homepage);

        for(int i=0;i<10;++i)
        {
            book_id[i]=0;
        }

        linearLayout=(LinearLayout)findViewById(R.id.stu_linear_id);
        text_student_infor=(TextView)findViewById(R.id.stu_home_infor_id);
        search_content=(EditText) findViewById(R.id.stu_home_ser_content_id);
        text_book_infor=(TextView)findViewById(R.id.stu_home_book_id);
        borrow=(Button)findViewById(R.id.stu_home_borrow_id);
        search=(Button)findViewById(R.id.stu_home_ser_id);                     //注册控件

        Intent intent=getIntent();                                             //获得上一个活动的数据
        student_id=intent.getIntExtra("extra_data",1);
        student_local=LitePal.find(Student.class,student_id);
        text_student_infor.setText("学号："+student_local.getStudent_ID()+"     "+"姓名："+student_local.getName());

        for(int i=0;i<student_local.getBookAmount();++i)
        {
            bookList.add(LitePal.find(Book.class,student_local.getBookList(i)).getName());
            book_id[i]=student_local.getBookList(i);
        }

        final ListView listView=(ListView) findViewById(R.id.st_home_list_id);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(Student_homepage.this,android.R.layout.simple_list_item_1,bookList);
        listView.setAdapter(adapter);                                      //制作listview滚动

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String string = bookList.get(i);
                Toast.makeText(Student_homepage.this, string+"归还成功", Toast.LENGTH_SHORT).show();
                bookList.remove(i);
                for (int key = i; key < student_local.getBookAmount() - 1; ++key) {
                    book_id[key] = book_id[key + 1];
                }
                student_local.setBookAmount(student_local.getBookAmount() - 1);
                student_local.setBookList(book_id);
                student_local.save();
                //List<Book> books = LitePal.where("name like ?", string).find(Book.class);
                book_in_delete=LitePal.find(Book.class,book_id[i]);
                int current_book = book_in_delete.getIn_shelf();
                book_in_delete.setIn_shelf(current_book + 1);
                book_in_delete.save();

                listView.setAdapter(adapter);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sear_book_name;
                sear_book_name=search_content.getText().toString();
                List<Book> books=LitePal.where("name like ?",sear_book_name).find(Book.class);
                if(books.size()>0) {
                    book_in_search = books.get(0);
                    text_book_infor.setText("书名:" + book_in_search.getName() + "     " + "作者:" + book_in_search.getWriter());
                    linearLayout.setVisibility(View.VISIBLE);
                    key=true;
                }
            }
        });
        borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (book_in_search.getIn_shelf() > 0&&key==true) {
                    key=false;
                    if (student_local.getBookAmount() < 10) {
                        book_in_search.setIn_shelf(book_in_search.getIn_shelf() - 1);
                        book_in_search.save();
                        book_id[student_local.getBookAmount()] = book_in_search.getId();
                        bookList.add(book_in_search.getName());

                        Calendar calendar=Calendar.getInstance();
                        int year=calendar.get(Calendar.YEAR);
                        int day=calendar.get(Calendar.DAY_OF_YEAR);                               //获得当前的时间

                        student_local.setBookList(student_local.getBookAmount(),book_in_search.getId());
                        student_local.setBookyear(student_local.getBookAmount(),year);
                        student_local.setBookday(student_local.getBookAmount(),day);
                        student_local.setBookAmount(student_local.getBookAmount()+1);
                        student_local.save();
                        listView.setAdapter(adapter);
                        Toast.makeText(Student_homepage.this, "借书成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Student_homepage.this, "借书数目已达到上限，请还书后再借", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Student_homepage.this, "该书已经全部被借出", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
