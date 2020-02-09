package com.fyp.appmaker.Firebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.appmaker.Authenticaiton.SignUpActivity;
import com.fyp.appmaker.Functionality.TemplateRecyclerViewAdapter;
import com.fyp.appmaker.Models.AppDetailsModel;
import com.fyp.appmaker.Models.UserModel;
import com.fyp.appmaker.Utilities.UtilitiesClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDb extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private UtilitiesClass utilitiesClass;

    public void addUser(UserModel user) {
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        String userId=mDatabase.push().getKey();
        user.setId(userId);
        mDatabase.child(userId).setValue(user);

    }

    public void addAppDetails(AppDetailsModel appDetailsModel)
    {
        utilitiesClass=new UtilitiesClass();
        mDatabase=FirebaseDatabase.getInstance().
                getReference("appDetails").child(utilitiesClass.loadIDFromPrefs(this));
        appDetailsModel.setId(mDatabase.push().getKey());
        appDetailsModel.setUserId(utilitiesClass.loadIDFromPrefs(this));
    }


}
