package com.example.seekbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;

public class StepsSeekBar extends androidx.appcompat.widget.AppCompatSeekBar {

    int mSteps;
    int mCurrentStep;
    int mStepWidth;

    public StepsSeekBar(Context context, AttributeSet attrs, int steps) {
        super(context, attrs);
        mSteps = steps;
        mCurrentStep = 0;
        mStepWidth = 100 / mSteps;
    }

    public void nextStep() {
        // Animate progress to next step
        ObjectAnimator animator = ObjectAnimator.ofInt(this, "progress", mStepWidth * mCurrentStep, mStepWidth * (++mCurrentStep));
        animator.setDuration(1000);
        animator.start();
    }
}
