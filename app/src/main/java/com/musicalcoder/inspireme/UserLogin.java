package com.musicalcoder.inspireme;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.musicalcoder.inspireme.model.LoginModel;
import com.musicalcoder.inspireme.model.UserResponse;
import com.musicalcoder.inspireme.network.InspireClient;
import com.musicalcoder.inspireme.network.Service;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLogin extends AppCompatActivity {
    Service service;
    @BindView(R.id.login_email) EditText loginEmail;
    @BindView(R.id.login_password) EditText loginPassword;

    @OnClick(R.id.submit_login)
    public void submitLogin(View v) {
        userLogin();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);
    }

    public void userLogin() {
        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        service = InspireClient.fetchClient().create(Service.class);

        LoginModel user = new LoginModel(email, password);

        Call<UserResponse> login = service.userLogin(user);

        login.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()) {
                    UserResponse loginResponse = response.body();
                    Toast.makeText(UserLogin.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                call.cancel();

            }
        });

    }
}
