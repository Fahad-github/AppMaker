package com.fyp.appmaker.Functionality;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import androidx.recyclerview.widget.RecyclerView;

import com.fyp.appmaker.Models.AppDetailsModel;
import com.fyp.appmaker.Models.ItemsModel;
import com.fyp.appmaker.R;

import java.util.ArrayList;

public class Template1ItemListAdapter extends RecyclerView.Adapter<Template1ItemListAdapter.Template1Viewholder> {

    Context context;
    ArrayList<ItemsModel> list;
    ArrayList<AppDetailsModel> arrayList;
    ViewGroup parent;
    boolean editCardview=false;
    float radius;
    float elevation;
    float maxElevation;
    byte[] bytes;
    Bitmap bitmap;
    String type;
    int cardColor;




    public Template1ItemListAdapter(@NonNull Context context, ArrayList<ItemsModel> list,String type) {
        this.context=context;
        this.list=list;
        this.type=type;
    }
    public Template1ItemListAdapter(@NonNull Context context,String type, ArrayList<AppDetailsModel> list,OnItemDetailsClicked onClick) {
        this.context=context;
        this.arrayList=list;
        this.type=type;
        this.onClick=onClick;
    }

    private OnItemDetailsClicked onClick;

    public interface OnItemDetailsClicked{
        void OnItemDetailsClicked(int position);
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
    public void onBindViewHolder(@NonNull Template1Viewholder holder, final int position) {

       if (type.equals("item")){

           if (editCardview)
           {
               holder.cardView.setRadius(this.radius);
               holder.cardView.setCardElevation(this.elevation);
               holder.cardView.setMaxCardElevation(this.maxElevation);
               holder.cardView.setCardBackgroundColor(this.cardColor);
               holder.textView.setText(list.get(position).getItemTitle());
               holder.cardView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       onClick.OnItemDetailsClicked(position);
                   }
               });
//            editCardview=false;
           }else
           {
               holder.textView.setText(list.get(position).getItemTitle());

           }
       }else{
           holder.textView.setText(arrayList.get(position).getAppName());
           bytes = Base64.decode(arrayList.get(position).getIcon(),Base64.DEFAULT);
           bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
           holder.imageView.setImageBitmap(bitmap);
           holder.imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   onClick.OnItemDetailsClicked(position);
               }
           });
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
        if (type.equals("item")){
            return list.size();
        }
        else{
            return arrayList.size();
        }

    }

    public class Template1Viewholder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        CardView cardView;

        public Template1Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.itemImage);
          //  itemView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,700));
           // imageView.setLayoutParams(new LinearLayout.LayoutParams(500,500));
            textView=itemView.findViewById(R.id.itemTitle);
            cardView=itemView.findViewById(R.id.template1_list_cardview);
        }
    }


}
