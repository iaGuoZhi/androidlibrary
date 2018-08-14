package com.example.administrator.library1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Introduction extends AppCompatActivity {
    private TextView intr_textview_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        SharedPreferences pref=getSharedPreferences("introduce",MODE_PRIVATE);
        intr_textview_id=findViewById(R.id.intr_introduce_id);
        intr_textview_id.setText(pref.getString("introduction",""));

    }
}
