package com.rx1226.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PaintView extends View {
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;

    public PaintView(Context context) {
        super(context);
        init();
    }
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(bitmap != null) {
            canvas.drawBitmap(bitmap, 0, 0, paint);
        }
    }

    private float startX;
    private float startY ;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float stopX = event.getX();
                float stopY = event.getY();
                canvas.drawLine(startX, startY, stopX, stopY, paint);
                startX = event.getX();
                startY = event.getY();
                invalidate();//call onDraw()
                break;
            case MotionEvent.ACTION_UP:
                if(isClick(startX, event.getX(), startY, event.getY())){
                    canvas.drawPoint(startX, startY, paint);
                    invalidate();
                    return false;
                }
                break;
        }
        return true;
    }

    private static final float CLICK_THRESHOLD = 0.05f;
    private boolean isClick(float startX, float endX, float startY, float endY) {
        return ((Math.abs(startX - endX) < CLICK_THRESHOLD) && (Math.abs(startY - endY) < CLICK_THRESHOLD));
    }
}
