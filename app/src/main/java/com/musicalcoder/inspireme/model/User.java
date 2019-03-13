package com.musicalcoder.inspireme.model;


import com.google.gson.annotations.SerializedName;

public class User {
    private Integer id;
    @SerializedName("full_name")
    private String fullname;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("confirm_password")
    private String confirm_password;

    public User(String fullname, String email, String password, String confirm_password) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }
}
