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
    private Context context;

    public FirebaseDb(Context context)
    {
        this.context=context;
        utilitiesClass=new UtilitiesClass(context);
    }

    public void addUser(UserModel user) {
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        String userId=mDatabase.push().getKey();
        user.setId(userId);
        mDatabase.child(userId).setValue(user);

    }

    public void addAppDetails(AppDetailsModel appDetailsModel)
    {

        mDatabase=FirebaseDatabase.getInstance().
                getReference("appDetails").child(utilitiesClass.loadIDFromPrefs());
        String id=mDatabase.push().getKey();
        appDetailsModel.setId(id);
        appDetailsModel.setUserId(utilitiesClass.loadIDFromPrefs());
        mDatabase.child(id).setValue(appDetailsModel);
    }


}
