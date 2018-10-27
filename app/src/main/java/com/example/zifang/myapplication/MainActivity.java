package com.example.zifang.myapplication;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int[] images = new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c
    };
    int currentImg = 0;
    private int currentColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //ex_2_BallGoesByFinger();
       // ex_1_PhotoClick();
        ex_3_paoma();
        //ex_4_input();
        //ex_5_selectbButton();
    }

    private void ex_5_selectbButton() {
        setContentView(R.layout.user_select);
//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                String tip = checkedId == R.id.male?"是男人":"是女人";
//                show.setText(tip);
//            }
//        });
//        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @SuppressLint("WrongConstant")
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    linearLayout.setOrientation(1);
//                    tb.setChecked(true);
//                    st.setChecked(true);
//                } else {
//                    linearLayout.setOrientation(0);
//                    tb.setChecked(false);
//                    st.setChecked(false);
//                }
//            }
//        });

    }

    private void ex_4_input() {
        setContentView(R.layout.user_input);
    }


    public void ex_1_PhotoClick() {
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

    public void ex_2_BallGoesByFinger() {
        setContentView(R.layout.draw_view);
        LinearLayout drawView = (LinearLayout) findViewById(R.id.root);
        final DrawView drawView1 = new DrawView(this);
        drawView1.setMinimumHeight(500);
        drawView1.setMinimumWidth(300);
        drawView.addView(drawView1);
    }
    public void ex_3_paoma() {

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
