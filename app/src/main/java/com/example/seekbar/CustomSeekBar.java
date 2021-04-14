package com.example.seekbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;

public class CustomSeekBar extends AppCompatSeekBar {

    /**
     * The value that the canvas is translated by in order to show progress values
     * This value is dependent on progress values text size
     */
    private final int DY = 35;

    public CustomSeekBar(Context context) {
        super(context);
    }

    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        drawTickMarks(canvas);
        drawProgress(canvas);
        drawThumb(canvas);
    }

    @TargetApi(Build.VERSION_CODES.N)
    void drawProgress(Canvas canvas) {
        final Drawable d = getProgressDrawable();
        Drawable mTickMark = getTickMark();
        if (d != null) {
            final int saveCount = canvas.save();
            canvas.translate(getPaddingLeft(), DY);
            Rect rectE = new Rect(-mTickMark.getBounds().width(), getHeight() / 4,
                    getWidth() - 2 * mTickMark.getBounds().width(), 3 * getHeight() / 4);
            d.setBounds(rectE);
            d.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    private void drawTickMarks(Canvas canvas) {
        Drawable mTickMark = getTickMark();
        if (mTickMark != null) {
            int count = getMax();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                count = getMax() - getMin();
            }
            if (count > 1) {
                final int w = mTickMark.getIntrinsicWidth();
                final int h = mTickMark.getIntrinsicHeight();
                final int halfW = w >= 0 ? w / 2 : 1;
                final int halfH = h >= 0 ? h / 2 : 1;
                mTickMark.setBounds(-halfW, -halfH, halfW, halfH);

                final float spacing = (getWidth() - getPaddingLeft() - getPaddingRight()) / (float) count;
                final int saveCount = canvas.save();
                canvas.translate(getPaddingLeft(), getHeight() / 2);
                canvas.translate(0, DY);

                Log.d("Hello", getProgress() + " " + count);


                //change here
                for (int i = 0; i <= count; i++) {
                    if (i <= getMax())
                        mTickMark.draw(canvas);
                    // else
                    //   mTickMark.draw();
                    canvas.translate(spacing, 0);
                }
                canvas.restoreToCount(saveCount);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    void drawThumb(Canvas canvas) {
        Drawable mThumb = getThumb();
        if (mThumb != null) {
            final int saveCount = canvas.save();
            canvas.translate(getPaddingLeft() - getThumbOffset(), DY + getPaddingTop());
            mThumb.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

}
