package com.fyp.appmaker.Models;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserModel {

    public String id,name,email,password;

    public  UserModel(){

    }

    public UserModel(String id,String name, String email, String password) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
