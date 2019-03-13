package com.musicalcoder.inspireme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.musicalcoder.inspireme.model.User;
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

public class UserRegistration extends AppCompatActivity {
    Service service;
    @BindView(R.id.fullname_txt) EditText name;
    @BindView(R.id.email_txt) EditText email;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.confirm_password) EditText confirmPassword;

    @OnClick(R.id.create_account)
    public void submitData(View view) {
        registerUser();
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
        finish();
    }
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        ButterKnife.bind(this);

    }

    public void registerUser() {
        String fullName = name.getText().toString();
        String emailText = email.getText().toString();
        String enteredPassword = password.getText().toString();
        String confirmation = confirmPassword.getText().toString();

        service = InspireClient.fetchClient().create(Service.class);

        User user = new User(fullName, emailText, enteredPassword, confirmation);

        Call<User> userCall = service.createAccount(user);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User newUser = response.body();
                    Log.d("Message", "User created!");
                    Toast.makeText(getApplicationContext(), "User "+ newUser.getId() + " Created"  , Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("Code", String.valueOf(response.code()));
                    Log.d("Response Body", String.valueOf(response.body()));
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
