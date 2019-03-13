package com.musicalcoder.inspireme.network;

import com.musicalcoder.inspireme.model.LoginModel;
import com.musicalcoder.inspireme.model.User;
import com.musicalcoder.inspireme.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {

    @POST("auth/register")
    Call<User> createAccount(@Body User user);

    @POST("auth/login")
    Call<UserResponse> userLogin(@Body LoginModel user);
}
