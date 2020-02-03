package com.fyp.appmaker.Functionality;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fyp.appmaker.Models.TemplateListModel;
import com.fyp.appmaker.R;

import java.util.ArrayList;

public class ChooseTemplate extends AppCompatActivity {

    ArrayList<TemplateListModel> list;
    RecyclerView recyclerView;
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
