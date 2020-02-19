package com.fyp.appmaker.Functionality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.fyp.appmaker.Models.ItemsModel;
import com.fyp.appmaker.R;

import java.util.ArrayList;

public class Template1ItemListAdapter extends RecyclerView.Adapter<Template1ItemListAdapter.Template1Viewholder> {

    Context context;
    ArrayList<ItemsModel> list;
    ViewGroup parent;
    boolean editCardview=false;
    float radius;
    float elevation;
    float maxElevation;
    int cardColor;

    public Template1ItemListAdapter(@NonNull Context context, ArrayList<ItemsModel> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public Template1Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.parent=parent;
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.template1_grid_cell,parent,false);
        return new Template1Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Template1Viewholder holder, int position) {
        if (editCardview)
        {
            holder.cardView.setRadius(this.radius);
            holder.cardView.setCardElevation(this.elevation);
            holder.cardView.setMaxCardElevation(this.maxElevation);
            holder.cardView.setCardBackgroundColor(this.cardColor);
            holder.textView.setText(list.get(position).getItemTitle());
//            editCardview=false;
        }else
        {
            holder.textView.setText(list.get(position).getItemTitle());
        }

    }

    void updateEditCardview(boolean x,int color, float radius, float elevation,float maxElevation)
    {
        editCardview=x;
        this.cardColor=color;
        this.radius=radius;
        this.elevation=elevation;
        this.maxElevation=maxElevation;
        notifyDataSetChanged();
    }

//    void setCardviewAttributes(float radius, float elevation,float maxElevation)
//    {
//        holder.cardView.setRadius(30);
//        holder.cardView.setCardElevation(8);
//        holder.cardView.setMaxCardElevation(20);
//    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Template1Viewholder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        CardView cardView;

        public Template1Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.itemImage);
            itemView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,700));
            imageView.setLayoutParams(new LinearLayout.LayoutParams(500,500));
            textView=itemView.findViewById(R.id.itemTitle);
            cardView=itemView.findViewById(R.id.template1_list_cardview);
        }
    }
}
