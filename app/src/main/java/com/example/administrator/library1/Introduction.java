package com.example.administrator.library1;

import android.content.Intent;
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
        //SharedPreferences pref=getSharedPreferences("introduce",MODE_PRIVATE);
        intr_textview_id=findViewById(R.id.intr_introduce_id);
        intr_textview_id.setText("上海交通大学图书馆(Shanghai jiaotong university library)是国际图联(IFLA)成员馆，" +"\n"+
                "在交通、材料、机电、能源、信息、管理及农业等学科领域形成馆藏文献特色。\n" +
                "\n" +
                "上海交通大学图书馆创建于1896年，同年建成一个图书室，1919年建成独立的图书馆大楼。1990年，" +
                        "为适应学校办学规模的迅速发展，在闵行校区兴建了包玉刚图书馆，于1992年10月建成。2005年，学校整体战略开始向闵行校区转移" +
                        "，遂计划在闵行校区兴建新馆。2014年12月李政道图书馆成为上海交通大学的新地标。\n" +
                "\n" +
                "截止到2015年底，上海交通大学主要有新图书馆(主图书馆)、包玉刚图书馆 、包兆龙图书馆 、钱学森图书馆 、" +
                        "李政道图书馆和上海交通大学医学院图书馆 等场馆，总面积约为6.63万平米，阅览座位约6324席。馆藏纸质文献367万册，" +
                        "期刊7500余种，电子期刊5.55万种，电子图书281.07万种，学位论文322.12万种，电子数据库399个，此外，多媒体资源馆藏总量达4.59万种、" +
                        "15.5TB。支持通过网络24×7的馆藏目录、电子文献、馆际互借、参考咨询、文献征订、新书刊报道等服务");


    }

    @Override
    protected void onPause() {
        Intent intent=new Intent(Introduction.this,MainActivity.class);
        startActivity(intent);
        super.onPause();
    }
}
