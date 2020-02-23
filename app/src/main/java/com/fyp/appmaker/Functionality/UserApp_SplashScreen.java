package com.fyp.appmaker.Functionality;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fyp.appmaker.Firebase.FirebaseDb;
import com.fyp.appmaker.R;
import com.fyp.appmaker.Utilities.UtilitiesClass;

public class UserApp_SplashScreen extends AppCompatActivity implements FirebaseDb.FirebaseCallBack {

    ImageView logo;
    boolean addName=false;
    LinearLayout parent;
    Animation x = null;
    ImageView icon;
    FirebaseDb db;
    UtilitiesClass utilitiesClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_app__splash_screen);

        db=new FirebaseDb(this);
        utilitiesClass=new UtilitiesClass(this);

        parent=findViewById(R.id.userAppSplashLayout);
        icon=findViewById(R.id.userAppLogo);

        db.getAppNameIcon(utilitiesClass.loadappIDFromPrefs(this),this);

        Intent intent1=getIntent();
        if (intent1.getBooleanExtra("addName",false))
        {
            TextView name=new TextView(this);
            name.setText("My App");
            name.setTextColor(getResources().getColor(R.color.black));
            name.setTextSize(22);

            name.setTypeface(Typeface.create("cursive",Typeface.NORMAL));

            name.setTypeface(name.getTypeface(), Typeface.BOLD);
            name.setGravity(Gravity.CENTER);
            parent.addView(name);
        }

        String type=intent1.getStringExtra("animType");
        final Intent intent11=new Intent(this, Template1new.class);
        Thread thread1,thread2,thread3;

        switch (type)
        {
            case "Fade In":
                x= AnimationUtils.loadAnimation(this,R.anim.fade_in);
                parent.startAnimation(x);
                thread1=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
//                            parent.setVisibility(View.INVISIBLE);
                            startActivity(intent11);
                            finish();
                        }
                    }
                };
                thread1.start();
                break;
            case "Fade Out":
                x= AnimationUtils.loadAnimation(this,R.anim.fadeout);
                parent.startAnimation(x);
                thread1=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            parent.setVisibility(View.INVISIBLE);
                            startActivity(intent11);
                            finish();
                        }
                    }
                };
                thread1.start();
                break;
            case "Fade In > Fade Out":
                x= AnimationUtils.loadAnimation(this,R.anim.fade_in);
                parent.startAnimation(x);
                thread1=new Thread()
                {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            x=AnimationUtils.loadAnimation(UserApp_SplashScreen.this,R.anim.fadeout);
                            parent.startAnimation(x);
                        }
                    }
                };
                thread1.start();
                thread2=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(7000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            parent.setVisibility(View.INVISIBLE);
                            startActivity(intent11);
                            finish();
                        }
                    }
                };
                thread2.start();
                break;
            case "Rotate > Scale":
                x= AnimationUtils.loadAnimation(this,R.anim.rotate);
                thread3=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            parent.startAnimation(x);
                        }
                    }
                };
                thread3.start();
                thread1=new Thread()
                {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(4500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            x=AnimationUtils.loadAnimation(UserApp_SplashScreen.this,R.anim.scale);
                            parent.startAnimation(x);
                        }
                    }
                };
                thread1.start();
                thread2=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(5550);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            parent.setVisibility(View.INVISIBLE);
                            startActivity(intent11);
                            finish();
                        }
                    }
                };
                thread2.start();
                break;
            case "Fade In > Rotate > Scale":
                x= AnimationUtils.loadAnimation(this,R.anim.fade_in);
                parent.startAnimation(x);
                thread2=new Thread()
                {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            x=AnimationUtils.loadAnimation(UserApp_SplashScreen.this,R.anim.rotate);
                            parent.startAnimation(x);
                        }
                    }
                };
                thread2.start();

                thread1=new Thread()
                {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(7000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            x=AnimationUtils.loadAnimation(UserApp_SplashScreen.this,R.anim.scale);
                            parent.startAnimation(x);
                        }
                    }
                };
                thread1.start();

                thread3=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(8000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            parent.setVisibility(View.INVISIBLE);
                            startActivity(intent11);
                            finish();
                        }
                    }
                };
                thread3.start();
                break;
            case "Left to Right":
                x= AnimationUtils.loadAnimation(this,R.anim.left_to_centre);
                parent.startAnimation(x);
                thread1=new Thread()
                {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            x=AnimationUtils.loadAnimation(UserApp_SplashScreen.this,R.anim.centre_to_right);
                            parent.startAnimation(x);
                        }
                    }
                };
                thread1.start();
                thread2=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(5500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            parent.setVisibility(View.INVISIBLE);
                            startActivity(intent11);
                            finish();
                        }
                    }
                };
                thread2.start();
                break;
            case "Right to Left":
                x= AnimationUtils.loadAnimation(this,R.anim.right_to_centre);
                parent.startAnimation(x);
                thread1=new Thread()
                {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            x=AnimationUtils.loadAnimation(UserApp_SplashScreen.this,R.anim.center_to_left);
                            parent.startAnimation(x);
                        }
                    }
                };
                thread1.start();
                thread2=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            parent.setVisibility(View.INVISIBLE);
                            startActivity(intent11);
                            finish();
                        }
                    }
                };
                thread2.start();
                break;
            case "Top to Bottom":
                x= AnimationUtils.loadAnimation(this,R.anim.top_to_center);
                parent.startAnimation(x);
                thread1=new Thread()
                {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            x=AnimationUtils.loadAnimation(UserApp_SplashScreen.this,R.anim.center_to_bottom);
                            parent.startAnimation(x);
                        }
                    }
                };
                thread1.start();
                thread2=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(5500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            parent.setVisibility(View.INVISIBLE);
                            startActivity(intent11);
                            finish();
                        }
                    }
                };
                thread2.start();
                break;
            case "Bottom to Top":
                x= AnimationUtils.loadAnimation(this,R.anim.bottom_to_center);
                parent.startAnimation(x);
                thread1=new Thread()
                {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            x=AnimationUtils.loadAnimation(UserApp_SplashScreen.this,R.anim.center_to_top);
                            parent.startAnimation(x);
                        }
                    }
                };
                thread1.start();
                thread2=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(5500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            parent.setVisibility(View.INVISIBLE);
                            startActivity(intent11);
                            finish();
                        }
                    }
                };
                thread2.start();
                break;
        }



    }

    @Override
    public void LoadAppName(String name, String icon) {

    }
}
