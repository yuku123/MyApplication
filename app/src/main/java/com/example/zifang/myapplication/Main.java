package com.example.zifang.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends AppCompatActivity {

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

        // 图片点击测试
        //ex_1_PhotoClick();
        // 跟随手指走动的球
        //ex_2_BallGoesByFinger();
        // 跑马灯效果
        //ex_3_paoma();
        // 输入框
        //ex_4_input();
        // 各种选择按钮的代码
        ex_5_selectbButton();
    }

    private void ex_5_selectbButton() {

        setContentView(R.layout.user_select);

        final TextView show = findViewById(R.id.radiogroup_show);
        final RadioGroup rg = findViewById(R.id.radiogroup);
        final ToggleButton tb = findViewById(R.id.toggleButton);
        final Switch st = findViewById(R.id.switcher);
        final LinearLayout linearLayout = findViewById(R.id.linear_test);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String tip = checkedId == R.id.male?"是男人":"是女人";
                show.setText(tip);
            }
        });
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout.setOrientation(1);
                    tb.setChecked(true);
                    st.setChecked(true);
                } else {
                    linearLayout.setOrientation(0);
                    tb.setChecked(false);
                    st.setChecked(false);
                }
            }
        });

    }

    private void ex_4_input() {
        setContentView(R.layout.user_input);
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
        @SuppressLint("HandlerLeak") final Handler handler = new Handler(){
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

    public void clickHander(View souruce) {
        TextView textView = findViewById(R.id.show);
        textView.setText("hellow-" + new Date());
    }


}
