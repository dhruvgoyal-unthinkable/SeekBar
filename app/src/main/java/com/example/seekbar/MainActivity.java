package com.example.seekbar;

import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seekbar.ProgressIndicator.ProgressIndicator;
import com.example.seekbar.databinding.ActivityMainBinding;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ProgressIndicator progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressIndicator = binding.progressIndicator;
        binding.nextBtn.setOnClickListener(view ->
        {
            int progress = progressIndicator.getProgress();
            progressIndicator.setProgress(progress + 1);
        });
    }
}