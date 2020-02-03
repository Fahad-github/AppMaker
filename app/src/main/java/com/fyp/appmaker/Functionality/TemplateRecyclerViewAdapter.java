package com.fyp.appmaker.Functionality;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fyp.appmaker.Authenticaiton.LoginActivity;
import com.fyp.appmaker.Models.TemplateListModel;
import com.fyp.appmaker.R;

import java.util.ArrayList;
import java.util.List;

public class TemplateRecyclerViewAdapter extends RecyclerView.Adapter<TemplateRecyclerViewAdapter.TemplateRVViewHolder> {

    private ArrayList<TemplateListModel> list;
    private Context context;
    public TemplateRecyclerViewAdapter(Context context,ArrayList<TemplateListModel> list)
    {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public TemplateRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.template_list_row,parent,false);
        return new TemplateRVViewHolder(view,this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateRVViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage().intValue());
        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TemplateRVViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        Context context;
        public TemplateRVViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            this.context=context;
            imageView=itemView.findViewById(R.id.templateImage);
            textView=itemView.findViewById(R.id.templateName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context, LoginActivity.class);
            context.startActivity(intent);
        }
    }
}
