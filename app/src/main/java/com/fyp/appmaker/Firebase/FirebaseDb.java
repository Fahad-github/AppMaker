package com.fyp.appmaker.Firebase;

import android.text.TextUtils;
import android.widget.Toast;

import com.fyp.appmaker.Authenticaiton.SignUpActivity;
import com.fyp.appmaker.Models.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDb {


    public static void addUser(UserModel userModel,String userId){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        if (TextUtils.isEmpty(userId)) {
            userId = mDatabase.push().getKey();
        }

        UserModel user = userModel;

        mDatabase.child(userId).setValue(user);

        addUserChangeListener(mDatabase,userId);
    }

    private static void addUserChangeListener(DatabaseReference mDatabase,String userId) {
        mDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserModel user = dataSnapshot.getValue(UserModel.class);

                // Check for null
                if (user == null) {

                    return;
                }

              //  Toast.makeText(SignUpActivity.this, "User data is changed!" + user.name + ", " + user.email, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
