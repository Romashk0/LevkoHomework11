package com.levko.roma.levkohomework11.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20.03.2016.
 */
public class PaintView extends View {

    private Paint mPaint;
    private List<Paint> paintList;
    private Path mPath;
    private List<Path> pathList;

    public PaintView(Context context) {
        super(context);
        init(null, 0);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        mPaint = new Paint();
        paintList = new ArrayList<>();
        pathList = new ArrayList<>();
        addNewLayer(mPaint, true, Paint.Style.STROKE, 10.0f, Color.BLACK);
    }

    private void addNewLayer(Paint paint, boolean AntiAlias, Paint.Style style, float strokeWidth, int color) {
        paint.setAntiAlias(AntiAlias);
        paint.setStyle(style);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
        paintList.add(mPaint);
        mPath = new Path();
        pathList.add(mPath);
    }

    public void setPaintColor(int color) {
        mPaint = new Paint();
        addNewLayer(mPaint, true, Paint.Style.STROKE, 10.0f, color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        for (Path path : pathList) {
            canvas.drawPath(path, paintList.get(i++));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }
}
