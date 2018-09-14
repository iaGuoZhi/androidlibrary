package com.example.administrator.library1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class staff_input extends AppCompatActivity {
    private EditText Name,Writer,Page,Price,Time,Amount;
    String name,writer,page,price,time,amount;
    Button commit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_input);
        Name=findViewById(R.id.book_name_id);
        Writer=findViewById(R.id.book_writer_id);
        Page=findViewById(R.id.book_page_id);
        Price=findViewById(R.id.book_price_id);
        Time=findViewById(R.id.book_time_id);
        Amount=findViewById(R.id.book_amount_id);
        commit=findViewById(R.id.book_commit_id);

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=Name.getText().toString();
                writer=Writer.getText().toString();
                page=Page.getText().toString();
                price=Price.getText().toString();
                time=Time.getText().toString();
                amount=Amount.getText().toString();
                if(name.equals("")||writer.equals("")||page.equals("")||price.equals("")||time.equals("")||amount.equals(""))
                {
                    Toast.makeText(staff_input.this,"输入不能为空",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Book book=new Book(name,writer,page,price,time,Integer.parseInt(amount));
                    book.save();
                    Intent intent=new Intent(staff_input.this,Staff_homepage.class);
                    startActivity(intent);
                }
            }
        });
    }

}
