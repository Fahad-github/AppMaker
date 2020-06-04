package com.fyp.appmaker.FragmentTemplate2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fyp.appmaker.Functionality.Template2Adapter;
import com.fyp.appmaker.Models.ItemsModel;
import com.fyp.appmaker.ProductDetails.ProductDetailsActivity;
import com.fyp.appmaker.R;
import com.fyp.appmaker.databinding.FragmentTemplate2Binding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Template2Fragment extends Fragment implements View.OnClickListener, Template2Adapter.OnItemClicked {

    FragmentTemplate2Binding binding;
    int defaultColor = android.R.color.darker_gray;
    int themeColor = 000;
    Template2Adapter adapter;
    ProgressDialog progressDialog;
    MaterialAlertDialogBuilder alertDialogBuilder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_template2, container, false);
        initViews(binding.getRoot());

        alertDialogBuilder = new MaterialAlertDialogBuilder(getContext());


        progressDialog = new ProgressDialog(getContext());

        ArrayList<ItemsModel> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(new ItemsModel("", "Item Name" + i));
        }

        adapter = new Template2Adapter(getContext(), list);
        adapter.setOnItemClicked(this);
        binding.template2Recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.template2Recycler.setAdapter(adapter);
        binding.template2Recycler.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        return binding.getRoot();


    }

    private void initViews(View root) {
        root.findViewById(R.id.colorEditor).setOnClickListener(this);
        root.findViewById(R.id.createApkButton).setOnClickListener(this);
//        root.findViewById(R.id.number1).setOnClickListener(this);
//        root.findViewById(R.id.number2).setOnClickListener(this);
//        root.findViewById(R.id.number3).setOnClickListener(this);
//        root.findViewById(R.id.number4).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.colorEditor: {
                openColorEditor();
                break;
            }
            case R.id.createApkButton: {

                alertDialogBuilder
                        .setTitle("Apk Creation")
                        .setMessage("Are you done customizing the template?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                createApk();
                            }
                        }).setNegativeButton("No", null)
                        .show();

                break;
            }
        }

//        if (view.getId()==R.id.number1 || view.getId()==R.id.number2
//                || view.getId()==R.id.number3 || view.getId()==R.id.number4){
//            if (String.valueOf(themeColor)!=null){
//                Intent intent = new Intent(getContext(),ProductDetailsActivity.class);
//                intent.putExtra("themeColor",String.valueOf(themeColor));
//                startActivity(intent);
//            }
//        }
    }

    private void createApk() {

        Toast.makeText(getContext(), "Wait while your APK is being processed", Toast.LENGTH_SHORT).show();

        progressDialog.setTitle("APK Creation");
        progressDialog.setMessage("Creating your APK...");
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Your APK is created", Toast.LENGTH_SHORT).show();
            }
        }, 5000);


    }

    private void openColorEditor() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(getContext(), defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                themeColor = color;
                binding.template2Recycler.setBackgroundColor(color);
                binding.productsTextView.setTextColor(color);
            }
        });
        colorPicker.show();
    }

    @Override
    public void onItemClick(int position) {

        String.valueOf(themeColor);
        Intent intent = new Intent(getContext(), ProductDetailsActivity.class);
        intent.putExtra("themeColor", String.valueOf(themeColor));
        startActivity(intent);
    }
}
