package com.fyp.appmaker.Functionality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fyp.appmaker.Models.ItemsModel;
import com.fyp.appmaker.R;

import java.util.ArrayList;

public class Template2Adapter extends RecyclerView.Adapter<Template2Adapter.Template2Viewholder>{

    Context context;
    ArrayList<ItemsModel> list;


    public Template2Adapter(@NonNull Context context, ArrayList<ItemsModel> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public Template2Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.template1_grid_cell,parent,false);
        return new Template2Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Template2Viewholder holder, final int position) {

        holder.textView.setText(list.get(position).getItemTitle());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClicked.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Template2Viewholder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        CardView cardView;

        public Template2Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.itemImage);
            textView=itemView.findViewById(R.id.itemTitle);
            cardView=itemView.findViewById(R.id.template1_list_cardview);
        }
    }

    private OnItemClicked onItemClicked;

    public interface OnItemClicked{
        void onItemClick(int position);
    }

    public void setOnItemClicked(OnItemClicked onItemClicked){

        this.onItemClicked = onItemClicked;
    }
}
