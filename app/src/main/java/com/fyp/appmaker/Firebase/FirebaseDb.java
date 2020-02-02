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

    //    saveUserDetails(user);

    }

    private void saveUserDetails(UserModel user) {
        SharedPreferences sharedPreferences=getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("Email",user.getEmail());
        editor.putString("Password",user.getPassword());
        editor.commit();
    }

    public boolean checkIfUserExists(final String email)
    {
        System.out.println("hereeeeeeeeeeeee 2");
        exists=false;
        mDatabase=FirebaseDatabase.getInstance().getReference("users");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    UserModel user=dataSnapshot1.getValue(UserModel.class);
                    System.out.println(user.getEmail());
                    System.out.println(email);
                    if (user.getEmail().equals(email))
                    {
                        exists = true;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return exists;
    }

    private void setExists() {
        exists=true;
    }

    public boolean getExists()
    {
        System.out.println(exists);
        return this.exists;
    }

}
