package com.example.seekbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyView> {

    private ArrayList<Images> imagesList;

    public class MyView
            extends RecyclerView.ViewHolder {

        ImageView progress_circular, progress_line;


        public MyView(View view)
        {
            super(view);
            progress_circular = (ImageView)view.findViewById(R.id.progress_circular);
            progress_line = (ImageView) view.findViewById(R.id.progress_line);
        }
    }
    public Adapter(ArrayList<Images> imageList)
    {
        this.imagesList = imageList;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item,
                        parent,
                        false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
            holder.progress_circular.setImageResource(imagesList.get(position).getProgress_circular());
            holder.progress_line.setImageResource(imagesList.get(position).getProgress_line());


    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }
}
