package com.zifang.charpter2.v2_1_5_user_define_view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.zifang.myapplication.R;

public class CustomViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_view);
        LinearLayout drawView = (LinearLayout) findViewById(R.id.root);
        DrawView drawView1 = new DrawView(this);
        drawView1.setMinimumHeight(500);
        drawView1.setMinimumWidth(300);
        drawView.addView(drawView1);
    }


}
