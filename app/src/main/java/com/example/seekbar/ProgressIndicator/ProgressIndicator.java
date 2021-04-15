package com.example.seekbar.ProgressIndicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seekbar.R;

import java.util.ArrayList;

public class ProgressIndicator extends LinearLayout {

    private final ArrayList<Drawable> icons;
    private int progress;
    private final Context context;

    public ProgressIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        icons = new ArrayList<>();
        progress = 0;
        inflate(context, R.layout.progress_indicator, this);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ProgressIndicator);
        loadIcons(attributes);
        updateRecyclerView();
        attributes.recycle();
    }

    private void updateRecyclerView() {
        ProgressAdapter adapter = new ProgressAdapter(icons);
        RecyclerView progressBar = findViewById(R.id.progress_bar);
        progressBar.setHasFixedSize(true);
        progressBar.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        progressBar.setAdapter(adapter);
    }

    private void loadIcons(TypedArray attributes) {
        for (int i = 0; i < progress; i++) {
            icons.add(attributes.getDrawable(R.styleable.ProgressIndicator_processedIcon));
            icons.add(attributes.getDrawable(R.styleable.ProgressIndicator_processedProgressLine));
        }
        icons.add(attributes.getDrawable(R.styleable.ProgressIndicator_progressIcon));
        for (int i = progress + 1; i < attributes.getInt(R.styleable.ProgressIndicator_max, 3); i++) {
            icons.add(attributes.getDrawable(R.styleable.ProgressIndicator_defaultProgressLine));
            icons.add(attributes.getDrawable(R.styleable.ProgressIndicator_defaultIcon));
        }
    }
}
