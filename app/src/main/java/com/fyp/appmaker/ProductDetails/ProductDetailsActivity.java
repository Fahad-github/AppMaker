package com.fyp.appmaker.ProductDetails;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fyp.appmaker.R;
import com.fyp.appmaker.databinding.ActivityAccountBinding;
import com.fyp.appmaker.databinding.ActivityProductDetailsBinding;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityProductDetailsBinding binding;
    boolean filled=false;
    Intent intent;
    int themeColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_product_details);
        initListeners();
        intent = getIntent();
        themeColor = Integer.parseInt(intent.getStringExtra("themeColor"));
        initViews();
    }

    private void initViews() {
        binding.relativeLayout.setBackgroundColor(themeColor);
        binding.buyNowButton.setBackgroundColor(themeColor);
    }

    private void initListeners() {
        binding.small.setOnClickListener(this);
        binding.medium.setOnClickListener(this);
        binding.large.setOnClickListener(this);
        binding.extraLarge.setOnClickListener(this);
        binding.heartImage.setOnClickListener(this);
        binding.backButton.setOnClickListener(this);

    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.small:{

                binding.small.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.mainBlue));
                binding.medium.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                binding.large.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                binding.extraLarge.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                break;
            }case R.id.medium:{
                binding.small.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                binding.medium.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.mainBlue));
                binding.large.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                binding.extraLarge.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                break;
            }case R.id.large:{
                binding.small.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                binding.medium.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                binding.large.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.mainBlue));
                binding.extraLarge.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                break;
            }case R.id.extraLarge:{
                binding.small.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                binding.medium.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                binding.large.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.grey));
                binding.extraLarge.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.mainBlue));
                break;
            }case R.id.heartImage:{
                if (filled==false){
                    binding.heartImage.setBackgroundResource(R.drawable.heart_filled);
                    Toast.makeText(this, "Added to wish list", Toast.LENGTH_SHORT).show();
                    filled = true;
                    break;
                }else{
                    binding.heartImage.setBackgroundResource(R.drawable.heart_unfilled);
                    Toast.makeText(this, "Removed from wish list", Toast.LENGTH_SHORT).show();
                    filled=false;
                    break;
                }
            }case R.id.backButton:{
                onBackPressed();
                break;
            }
        }
    }
}
