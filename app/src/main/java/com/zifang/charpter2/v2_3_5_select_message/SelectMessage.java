package com.zifang.charpter2.v2_3_5_select_message;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.zifang.myapplication.R;

public class SelectMessage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
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
}
