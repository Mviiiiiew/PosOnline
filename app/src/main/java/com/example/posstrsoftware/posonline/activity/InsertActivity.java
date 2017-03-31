package com.example.posstrsoftware.posonline.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.fragment.InsertFragment;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
if(savedInstanceState == null){
    getSupportFragmentManager().beginTransaction()
            .replace(R.id.contentContainerInsert, InsertFragment.newInstance())
            .commit();
}

    }
}
