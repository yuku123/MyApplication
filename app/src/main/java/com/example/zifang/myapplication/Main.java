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

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

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

    public void clickHander(View souruce) {
        TextView textView = findViewById(R.id.show);
        textView.setText("hellow-" + new Date());
    }


}
