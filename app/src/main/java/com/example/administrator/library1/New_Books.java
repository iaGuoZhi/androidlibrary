package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class New_Books extends AppCompatActivity {

    ListView listView;
    List<Book> bookList=new ArrayList<>();
    List<String> books=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__books);

        listView=findViewById(R.id.books_new_list_id);
        bookList= LitePal.findAll(Book.class);
        if(bookList.size()>8)
        {
            for(int i=0;i<8;++i)
            {
                books.add("书名:"+bookList.get(bookList.size()-i-1).getName()+"    "+"作者:"+bookList.get(bookList.size()-i-1).getWriter());
            }
        }
        else
        {
            for(int i=bookList.size()-1;i>=0;--i)
            {
                books.add("书名:"+bookList.get(i).getName()+"    "+"作者:"+bookList.get(i).getWriter());
            }
        }
        ArrayAdapter adapter=new ArrayAdapter<String>(New_Books.this,android.R.layout.simple_list_item_1,books);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        Intent intent=new Intent(New_Books.this,MainActivity.class);
        startActivity(intent);
        super.onPause();
    }
}
