package com.example.posstrsoftware.posonline.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.fragment.LoginMainFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainerLogin, LoginMainFragment.newInstance())
                .commit();
    }
}
