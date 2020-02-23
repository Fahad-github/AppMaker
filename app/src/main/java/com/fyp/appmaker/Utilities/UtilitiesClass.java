package com.fyp.appmaker.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class UtilitiesClass extends AppCompatActivity {

    String myPrefs = "MyPrefs";
    SharedPreferences sharedPreferences;
    private Context context;

    public UtilitiesClass(Context context)
    {
        this.context=context;

    }

    public UtilitiesClass() {
    }

    public void saveToPrefs(Context context,String userId,String email,String password) {
        sharedPreferences = getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userId", userId);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.commit();
    }

    public void saveAppId(Context context,String appId)
    {
        sharedPreferences = context.getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("appId",appId);
        editor.commit();
    }

    public String loadEmailFromPrefs(Context context) {
        sharedPreferences = context.getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        return email;
    }

    public String loadIDFromPrefs(Context context) {
        sharedPreferences = context.getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        String userId = sharedPreferences.getString("userId", "");
        return userId;
    }

    public String loadappIDFromPrefs(Context context) {
        sharedPreferences = context.getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        String userId = sharedPreferences.getString("appId", "");
        return userId;
    }

    public void deleteFromPrefs(Context context){
        sharedPreferences = context.getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }


}