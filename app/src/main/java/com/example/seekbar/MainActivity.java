package com.example.seekbar;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seekbar.ProgressIndicator.ProgressIndicator;
import com.example.seekbar.databinding.ActivityMainBinding;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ProgressIndicator progressIndicator;
    AttributeSet attr;
    int progress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressIndicator = new ProgressIndicator(this,attr);
        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressIndicator.setProgress(progress + 1);
            }
        });
    }
}