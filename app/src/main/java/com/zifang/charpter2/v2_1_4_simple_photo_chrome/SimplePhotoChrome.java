package com.zifang.charpter2.v2_1_4_simple_photo_chrome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zifang.myapplication.R;

import java.util.Date;

public class SimplePhotoChrome extends Activity {
    private int currentColor;
    int[] images = new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c
    };
    int currentImg = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout main = (LinearLayout) findViewById(R.id.main);
        final ImageView image = new ImageView(this);
        main.addView(image);
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(images[++currentImg % images.length]);
            }
        });
    }

    public void clickHander(View souruce) {
        TextView textView = findViewById(R.id.show);
        textView.setText("hellow-w" + new Date());
    }
}
