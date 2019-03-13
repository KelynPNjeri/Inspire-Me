package com.musicalcoder.inspireme;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserLogin extends AppCompatActivity {
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

    }
}
