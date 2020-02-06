package com.fyp.appmaker.Functionality;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fyp.appmaker.Authenticaiton.LoginActivity;
import com.fyp.appmaker.Firebase.FirebaseDb;
import com.fyp.appmaker.Models.AppDetailsModel;
import com.fyp.appmaker.Models.TemplateListModel;
import com.fyp.appmaker.R;
import com.fyp.appmaker.Utilities.UtilitiesClass;
import com.fyp.appmaker.databinding.AddAppDetailsDialogBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class TemplateRecyclerViewAdapter extends RecyclerView.Adapter<TemplateRecyclerViewAdapter.TemplateRVViewHolder> {


    private ArrayList<TemplateListModel> list;
    private Context context;
    public static UtilitiesClass utilities;



    public TemplateRecyclerViewAdapter(Context context,ArrayList<TemplateListModel> list)
    {
        this.context=context;
        this.list=list;
        utilities=new UtilitiesClass();

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
        AddAppDetailsDialogBinding dialogBinding;
        ImageView imageView;
        TextView textView;
        Context context;
        public TemplateRVViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            this.context=context;
            imageView=itemView.findViewById(R.id.templateImage);
            textView=itemView.findViewById(R.id.templateName);
            itemView.setOnClickListener(this);
            dialogBinding= DataBindingUtil.setContentView((Activity) context,R.layout.add_app_details_dialog);
        }

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context, Template1new.class);

            LayoutInflater inflater=LayoutInflater.from(context);
            View view1=inflater.inflate(R.layout.add_app_details_dialog,null);

//            final EditText appNameEditText=view1.findViewById(R.id.appNameEditText);
//            final EditText creatorNameEditText=view1.findViewById(R.id.creatorsNameEditText);
//            EditText appDescEditText=view1.findViewById(R.id.appDescEditText);
//            EditText appIconText=view1.findViewById(R.id.addIconText);
//            ImageButton addIconButton=view1.findViewById(R.id.addIconButton);


            TextInputLayout appName=view1.findViewById(R.id.appNameEditText);
            TextInputLayout creatorName=view1.findViewById(R.id.creatorsNameEditText);
            final TextInputEditText appNameEditText = new TextInputEditText(appName.getContext());
            appName.addView(appNameEditText);
            final TextInputEditText creatorNameEditText = new TextInputEditText(creatorName.getContext());
            creatorName.addView(creatorNameEditText);
            ImageButton insertImage=view1.findViewById(R.id.insertIconButton);
            TextView addImage=view1.findViewById(R.id.addIconTextView);
            TextInputLayout appDesc=view1.findViewById(R.id.appDesc);
            TextInputEditText appDescEditText = new TextInputEditText(appDesc.getContext());
//            appDesc.addView(appDescEditText);

            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setView(view1);
            builder.setTitle("App Details");
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    FirebaseDb firebaseDb=new FirebaseDb();
                    firebaseDb.addAppDetails(new AppDetailsModel("","",appNameEditText.getText().toString(),
                            creatorNameEditText.getText().toString(),));

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            addIconButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new ChooseTemplate().checkPermissions();
                }
            });
            Dialog dialog=builder.create();
            dialog.show();
//            context.startActivity(intent);
        }
    }
}
