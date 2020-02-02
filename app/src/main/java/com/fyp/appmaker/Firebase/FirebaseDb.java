package com.fyp.appmaker.Firebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.appmaker.Authenticaiton.SignUpActivity;
import com.fyp.appmaker.Models.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDb extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private boolean exists;
    public void addUser(UserModel userModel, String userId){
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        if (TextUtils.isEmpty(userId)) {
            userId = mDatabase.push().getKey();
        }
        UserModel user = userModel;
        mDatabase.child(userId).setValue(user);

    }


}
