package com.fyp.appmaker.Authenticaiton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fyp.appmaker.R;
import com.fyp.appmaker.databinding.ActivityLoginActivitiyBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityLoginActivitiyBinding loginBinding;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_activitiy);
        initListeners();


    }

    private void initListeners() {
        findViewById(R.id.loginButton).setOnClickListener(this);
        findViewById(R.id.createAccountButton).setOnClickListener(this);

    }


    private void action() {
        name = loginBinding.emailEditText.getText().toString();
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginButton:{
                action();
                break;
            }
            case R.id.createAccountButton:{
                startActivity(new Intent(this,SignUpActivity.class));
                break;
            }
        }
    }
}
