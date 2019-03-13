package com.musicalcoder.inspireme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//import butterknife.BindView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.register_btn)
    public void onClick(View view) {
        Intent registerIntent = new Intent(this, UserRegistration.class);
        startActivity(registerIntent);
        finish();
    }
    @OnClick(R.id.login_btn)
    public void launchLogin(View view) {
        Intent loginIntent = new Intent(this, UserLogin.class);
        startActivity(loginIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
}
