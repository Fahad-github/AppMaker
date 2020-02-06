package com.fyp.appmaker.Functionality;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.fyp.appmaker.Models.TemplateListModel;
import com.fyp.appmaker.R;

import java.util.ArrayList;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class ChooseTemplate extends AppCompatActivity {

    ArrayList<TemplateListModel> list;
    RecyclerView recyclerView;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==1)
        {
            if (grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                getImage();
            }
        }
    }

    public boolean checkPermissions()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
            }
            else
            {
                return true;
            }
        }
        return false;
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
}
