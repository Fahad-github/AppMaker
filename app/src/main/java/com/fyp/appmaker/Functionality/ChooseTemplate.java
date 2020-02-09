package com.fyp.appmaker.Functionality;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;

import com.fyp.appmaker.Models.TemplateListModel;
import com.fyp.appmaker.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static androidx.core.app.ActivityCompat.requestPermissions;
import static androidx.core.app.ActivityCompat.startActivityForResult;

public class ChooseTemplate extends AppCompatActivity implements TemplateRecyclerViewAdapter.CallbackInterface {

    ArrayList<TemplateListModel> list;
    RecyclerView recyclerView;
    byte[] byteImage;
    String imageFile;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            System.out.println("here");
            Uri selectedImage=data.getData();
            try {

                //Bitmap to byte[]
                Bitmap imagebitmap=MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);

                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                imagebitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
                byteImage=byteArrayOutputStream.toByteArray();
                imageFile = Base64.encodeToString(byteImage, Base64.DEFAULT);
                TemplateRecyclerViewAdapter.imagefile=imageFile;
                TemplateRecyclerViewAdapter.dialogBinding.addIconTextView.setText(imageFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_template);

        list=new ArrayList<>();
        for (int i=1;i<=10;i++)
        {
            list.add(new TemplateListModel(Integer.valueOf(R.drawable.logoapp),"Sample "+i));
        }

        recyclerView=findViewById(R.id.templatesRecyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        TemplateRecyclerViewAdapter adapter=new TemplateRecyclerViewAdapter(this,list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void handleImageInsertion() {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1);
    }
}
