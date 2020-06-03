package com.fyp.appmaker.FragmentTemplate2;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyp.appmaker.ProductDetails.ProductDetailsActivity;
import com.fyp.appmaker.R;
import com.fyp.appmaker.databinding.FragmentTemplate2Binding;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Template2Fragment extends Fragment implements View.OnClickListener {

    FragmentTemplate2Binding binding;
    int defaultColor=android.R.color.darker_gray;
    int themeColor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_template2, container, false);
        initViews(binding.getRoot());
        return binding.getRoot();

    }

    private void initViews(View root) {
        root.findViewById(R.id.colorEditor).setOnClickListener(this);
        root.findViewById(R.id.number1).setOnClickListener(this);
        root.findViewById(R.id.number2).setOnClickListener(this);
        root.findViewById(R.id.number3).setOnClickListener(this);
        root.findViewById(R.id.number4).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.colorEditor: {
                openColorEditor();
                break;
            }
        }

        if (view.getId()==R.id.number1 || view.getId()==R.id.number2
                || view.getId()==R.id.number3 || view.getId()==R.id.number4){
            if (String.valueOf(themeColor)!=null){
                Intent intent = new Intent(getContext(),ProductDetailsActivity.class);
                intent.putExtra("themeColor",String.valueOf(themeColor));
                startActivity(intent);
            }
        }
    }

    private void openColorEditor() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(getContext(), defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                themeColor=color;
                binding.gridLayout.setBackgroundColor(color);
                binding.productsTextView.setTextColor(color);
            }
        });
        colorPicker.show();
    }
}
