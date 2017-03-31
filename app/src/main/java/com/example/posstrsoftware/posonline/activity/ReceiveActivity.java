package com.example.posstrsoftware.posonline.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.fragment.ReceiveFragment;

public class ReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainerReceive, ReceiveFragment.newInstance())
                .commit();
    }
}
