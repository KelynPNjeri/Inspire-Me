package com.musicalcoder.inspireme.model;

import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    //Constructor.
    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
