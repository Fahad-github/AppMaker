package com.fyp.appmaker.Authenticaiton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.fyp.appmaker.R;
import com.fyp.appmaker.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding signUpBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding= DataBindingUtil.setContentView(this,R.layout.activity_sign_up);


    }
}
