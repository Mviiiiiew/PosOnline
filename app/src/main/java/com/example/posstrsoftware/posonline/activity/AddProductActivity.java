package com.example.posstrsoftware.posonline.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.fragment.AddProductFragment;

public class AddProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainerAddProduct, AddProductFragment.newInstance())
                .commit();
    }
}
