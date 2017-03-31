package com.example.posstrsoftware.posonline.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.activity.ProductListActivity;
import com.example.posstrsoftware.posonline.activity.ReceiveActivity;
import com.example.posstrsoftware.posonline.activity.TransferActivity;
import com.gc.materialdesign.views.ButtonRectangle;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ProductMainFragment extends Fragment implements View.OnClickListener {
    ButtonRectangle btn_ProductList;
    ButtonRectangle btn_Upproduct;
    ButtonRectangle btn_Receiveproduct;

    public ProductMainFragment() {
        super();
    }

    public static ProductMainFragment newInstance() {
        ProductMainFragment fragment = new ProductMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_product, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        btn_ProductList = (ButtonRectangle) rootView.findViewById(R.id.btn_ProductList);
        btn_Upproduct = (ButtonRectangle) rootView.findViewById(R.id.btn_Upproduct);
        btn_Receiveproduct = (ButtonRectangle) rootView.findViewById(R.id.btn_Receiveproduct);

        btn_ProductList.setOnClickListener(this);
        btn_Upproduct.setOnClickListener(this);
        btn_Receiveproduct.setOnClickListener(this);


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    @Override
    public void onClick(View view) {
        if (view == btn_ProductList) {
            Intent intent = new Intent(getActivity(), ProductListActivity.class);
            startActivity(intent);
        }else if(view == btn_Upproduct){

            Intent intent = new Intent(getActivity(), TransferActivity.class);
            startActivity(intent);
        }else if(view == btn_Receiveproduct){

            Intent intent = new Intent(getActivity(), ReceiveActivity.class);
            startActivity(intent);
        }

    }
}
