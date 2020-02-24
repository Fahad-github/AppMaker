package com.fyp.appmaker.ProductDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;

import com.fyp.appmaker.R;
import com.fyp.appmaker.databinding.ActivityAccountBinding;
import com.fyp.appmaker.databinding.ActivityProductDetailsBinding;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityProductDetailsBinding binding;
    boolean filled=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_product_details);
        initListeners();
    }

    private void initListeners() {
        binding.small.setOnClickListener(this);
        binding.medium.setOnClickListener(this);
        binding.large.setOnClickListener(this);
        binding.extraLarge.setOnClickListener(this);
        binding.heartImage.setOnClickListener(this);

    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.small:{
                binding.small.getBackground().setColorFilter(getResources().getColor(R.color.mainBlue), PorterDuff.Mode.SRC_ATOP);
                binding.medium.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                binding.large.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                binding.extraLarge.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                break;
            }case R.id.medium:{
                binding.small.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                binding.medium.getBackground().setColorFilter(getResources().getColor(R.color.mainBlue), PorterDuff.Mode.SRC_ATOP);
                binding.large.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                binding.extraLarge.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                break;
            }case R.id.large:{
                binding.small.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                binding.medium.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                binding.large.getBackground().setColorFilter(getResources().getColor(R.color.mainBlue), PorterDuff.Mode.SRC_ATOP);
                binding.extraLarge.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                break;
            }case R.id.extraLarge:{
                binding.small.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                binding.medium.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                binding.large.getBackground().setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
                binding.extraLarge.getBackground().setColorFilter(getResources().getColor(R.color.mainBlue), PorterDuff.Mode.SRC_ATOP);
                break;
            }case R.id.heartImage:{

                if (filled==false){
                    binding.heartImage.setBackgroundResource(R.drawable.heart_filled);
                    filled = true;
                }else{
                    binding.heartImage.setBackgroundResource(R.drawable.heart_unfilled);
                    filled=false;
                }
            }
        }
    }
}
