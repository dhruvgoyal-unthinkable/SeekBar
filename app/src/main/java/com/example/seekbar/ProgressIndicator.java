package com.example.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ProgressIndicator extends View {
    public ProgressIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.progress_indicator, null);
    }
}
