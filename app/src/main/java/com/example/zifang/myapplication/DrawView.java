package com.example.zifang.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zifang on 2018/2/4.
 */

public class DrawView extends View {

    public float currentX = 40;
    public float currentY = 50;

    Paint p = new Paint();
    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        currentX = motionEvent.getX();
        currentY = motionEvent.getY();
        invalidate();
        return true;
    }


    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,15,p);

    }
}
