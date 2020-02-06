package com.fyp.appmaker.Authenticaiton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fyp.appmaker.Firebase.FirebaseDb;
import com.fyp.appmaker.Functionality.UserMainScreen;
import com.fyp.appmaker.Models.UserModel;
import com.fyp.appmaker.R;
import com.fyp.appmaker.Utilities.UtilitiesClass;
import com.fyp.appmaker.databinding.ActivityLoginActivitiyBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends UtilitiesClass implements View.OnClickListener {

    ActivityLoginActivitiyBinding loginBinding;
    String email = "";
    String password = "";

    private FirebaseDb db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_activitiy);
        initListeners();

        db = new FirebaseDb();
    }

    private void initListeners() {
        findViewById(R.id.loginButton).setOnClickListener(this);
        findViewById(R.id.createAccountButton).setOnClickListener(this);

    }


    private void action() {
        loginBinding.loadingBar.setVisibility(View.VISIBLE);

        email = loginBinding.emailEditText.getText().toString();
        password = loginBinding.passwordEditText.getText().toString();

        boolean empty = false;
        if (email.equals("") || email.replace(" ", "").equals("")) {
            empty = true;
            loginBinding.emailEditText.setError("Email field empty");
            loginBinding.loadingBar.setVisibility(View.INVISIBLE);

        }
        if (password.equals("") || password.replace(" ", "").equals("")) {
            empty = true;
            loginBinding.passwordEditText.setError("Password field empty");
            loginBinding.loadingBar.setVisibility(View.INVISIBLE);
        }
        System.out.println("here");
        System.out.println(empty);

        if (!empty) {
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                boolean loginAllowed = false;

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        UserModel user = dataSnapshot1.getValue(UserModel.class);

                        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                            loginAllowed = true;
                            saveToPrefs(user.getId(),email, password);
                            loginBinding.loadingBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, UserMainScreen.class));
                            finish();
                        }
                    }

                    if (!loginAllowed) {
                        loginBinding.loadingBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(LoginActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    loginBinding.loadingBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginButton: {
                action();
                break;
            }
            case R.id.createAccountButton: {
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            }
        }
    }
}
