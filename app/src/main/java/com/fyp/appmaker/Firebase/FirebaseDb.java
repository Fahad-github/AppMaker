package com.fyp.appmaker.Firebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.appmaker.Authenticaiton.SignUpActivity;
import com.fyp.appmaker.Functionality.Template1new;
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

    private DatabaseReference mDatabaseUser,mDatabaseAppDetails;
    private UtilitiesClass utilitiesClass;
    private Context context;

    public interface FirebaseCallBack
    {
        void LoadAppName(String name,String icon);
    }

    public FirebaseDb(Context context)
    {
        this.context=context;
        utilitiesClass=new UtilitiesClass(context);
        mDatabaseUser = FirebaseDatabase.getInstance().getReference("users");
        mDatabaseAppDetails=FirebaseDatabase.getInstance().
                getReference("appDetails").child(utilitiesClass.loadIDFromPrefs());
    }

    public void addUser(UserModel user) {
        String userId=mDatabaseUser.push().getKey();
        user.setId(userId);
        mDatabaseUser.child(userId).setValue(user);

    }

    public void addAppDetails(AppDetailsModel appDetailsModel)
    {
        String id=mDatabaseAppDetails.push().getKey();
        utilitiesClass.saveAppId(id);
        appDetailsModel.setId(id);
        appDetailsModel.setUserId(utilitiesClass.loadIDFromPrefs());
        mDatabaseAppDetails.child(id).setValue(appDetailsModel);
    }


    public void getAppNameIcon(String currentApp, final FirebaseCallBack callBack)
    {
        mDatabaseAppDetails.child(currentApp).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot!=null)
                {
                    AppDetailsModel app=dataSnapshot.getValue(AppDetailsModel.class);
                    callBack.LoadAppName(app.getAppName(),app.getIcon());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
