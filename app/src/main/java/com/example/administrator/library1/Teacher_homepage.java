package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Teacher_homepage extends AppCompatActivity {
    private List<Book> bookList=new ArrayList<>();
    private List<String> bookname=new ArrayList<>();
    TextView account,name,ID;
    Button refer,alter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_homepage);

        account=findViewById(R.id.tea_home_acc_id);
        name=findViewById(R.id.tea_home_name_id);
        ID=findViewById(R.id.tea_home_ID_id);
        refer=findViewById(R.id.tea_home_refer_id);
        alter=findViewById(R.id.tea_home_alter_id);
        listView=findViewById(R.id.tea_home_list_id);
        Intent intent=getIntent();
        String data=intent.getStringExtra("data");
        final MyApplication mAppInstance=new MyApplication();
        String revMsg=mAppInstance.SendMessageToServer(data);
        String[] sep =revMsg.split(":");
        final Teacher mteacher=new Teacher(sep[0],sep[1],sep[2],sep[3],sep[4],Integer.parseInt(sep[5]));
        account.setText(sep[0]);
        name.setText(sep[2]);
        ID.setText(sep[3]);
        mteacher.setBookAmount(Integer.parseInt(sep[6]));
        for(int i=0;i<Integer.parseInt(sep[6]);++i)
        {
            bookname.add(sep[7+i]);
        }
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(Teacher_homepage.this,android.R.layout.simple_list_item_1,bookname);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ret="40:"+String.valueOf(i)+":"+String.valueOf(mteacher.getId());
                String apply=mAppInstance.SendMessageToServer(ret);
                if(apply.equals("success"))
                {
                    Toast.makeText(Teacher_homepage.this,"还书成功",Toast.LENGTH_SHORT);
                }
                else
                {
                    Toast.makeText(Teacher_homepage.this,"还书失败",Toast.LENGTH_SHORT);
                }
            }
        });
        //List<Book> bookList=new ArrayList<>();
        /*for(int i=0;i<Integer.parseInt(sep[]);++i)
        {
            String sear_book="41"+sep[7+i];
            String bookMsg=mAppInstance.SendMessageToServer(sear_book);
            String[] book=bookMsg.split(":");
            Book mbook=new Book(book[0],book[1],book[2],book[3],book[4],Integer.parseInt(sep[5]));
            bookList.add(mbook);
        }*/
    }
}
