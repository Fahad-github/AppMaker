package com.fyp.appmaker.Splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.fyp.appmaker.Authenticaiton.LoginActivity;
import com.fyp.appmaker.Functionality.UserMainScreen;
import com.fyp.appmaker.R;
import com.fyp.appmaker.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    int SPLASH_TIME_OUT = 2500;
    Animation animation;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivitySplashBinding splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.zoom_in);
        splashBinding.mainLogo.animate().rotation(180).setDuration(1200).setStartDelay(600);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashBinding.mainLogo.startAnimation(animation);
                splashBinding.textViewAppMaker.setVisibility(View.INVISIBLE);
            }
        }, 2000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedPreferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                String email=sharedPreferences.getString("email","");
                String password=sharedPreferences.getString("password","");

                Intent i;
                if (email.equals("") && password.equals(""))
                {
                    i = new Intent(SplashActivity.this, LoginActivity.class);
                }else
                {
                    i = new Intent(SplashActivity.this, UserMainScreen.class);
                }

                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
