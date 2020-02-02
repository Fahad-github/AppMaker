package com.fyp.appmaker.Functionality;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fyp.appmaker.R;

import java.util.List;

public class TemplateRecyclerViewAdapter extends RecyclerView.Adapter<TemplateRecyclerViewAdapter.TemplateRVViewHolder> {

    private List<Bitmap> images;
    private List<String> names;
    private Context context;
    public TemplateRecyclerViewAdapter(Context context,List<Bitmap> images,List<String> names)
    {
        this.context=context;
        this.images=images;
        this.names=names;
    }

    @NonNull
    @Override
    public TemplateRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_choose_template,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateRVViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class TemplateRVViewHolder extends RecyclerView.ViewHolder
    {

        public TemplateRVViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
