package com.fyp.appmaker.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class UtilitiesClass extends AppCompatActivity {

    String myPrefs = "MyPrefs";
    SharedPreferences sharedPreferences;


    public void saveToPrefs(String email,String password) {
        sharedPreferences = getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.commit();
    }

    public String loadFromPrefs() {
        sharedPreferences= getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        return email;
    }

    public void deleteFromPrefs(){
        sharedPreferences=getSharedPreferences(myPrefs,MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }


}