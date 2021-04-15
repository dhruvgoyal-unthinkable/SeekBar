package com.example.seekbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seekbar.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int progress;
    ArrayList<Images> imagesList;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    Adapter adapter;
    LinearLayoutManager HorizontalLayout;
    View ChildView;
    int RecyclerViewItemPosition;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RecyclerViewLayoutManager
                = new LinearLayoutManager(
                getApplicationContext());
        binding.recyclerView.setLayoutManager(RecyclerViewLayoutManager);
        AddItemsToRecyclerViewArrayList();
        adapter = new Adapter(imagesList);
        HorizontalLayout
                = new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        binding.recyclerView.setLayoutManager(HorizontalLayout);
        binding.recyclerView.setAdapter(adapter);
        binding.nextBtn.setOnClickListener(view -> {
            progress = binding.seekBar.getProgress();
            binding.seekBar.setProgress(progress + 1);
        });
    }
    public void AddItemsToRecyclerViewArrayList()
    {   int pos = 4;
        // Adding items to ArrayList
        imagesList = new ArrayList<>();
        for(int i=0; i< pos ;i++){
            Images images = new Images();
            images.setProgress_circular(R.drawable.ic_default_thumb);
            images.setProgress_line(R.drawable.ic_progress_line);
            imagesList.add(images);
        }
    }
}