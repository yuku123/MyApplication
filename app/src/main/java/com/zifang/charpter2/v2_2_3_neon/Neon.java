package com.zifang.charpter2.v2_2_3_neon;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.zifang.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

public class Neon extends Activity {
    private int currentColor;

    final int[] colors = new int[]{
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6
    };
    final int[] names = new int[]{
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TextView[] views = new TextView[names.length];
        @SuppressLint("HandlerLeak")
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                if(msg.what == 0x123){
                    for(int i =0;i<names.length;i++){
                        views[i].setBackgroundResource(colors[(i+currentColor)%names.length]);
                    }
                    currentColor++;
                }
                super.handleMessage(msg);
            }
        };
        setContentView(R.layout.layout_framelayout);

        for(int i=0;i<names.length;i++){
            views[i] = findViewById(names[i]);
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,200);

    }
}
