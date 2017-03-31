package com.example.posstrsoftware.posonline.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.activity.AddProductActivity;
import com.example.posstrsoftware.posonline.activity.MainActivity;
import com.example.posstrsoftware.posonline.adapter.ProductListAdapter;
import com.example.posstrsoftware.posonline.dao.ProductListDao;
import com.example.posstrsoftware.posonline.manager.HttpManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ProductListFragment extends Fragment implements View.OnClickListener {
    ImageButton btn_addproduct;
    ImageButton btn_back;
    ListView listView;
    ProductListAdapter adapter;

    public ProductListFragment() {
        super();
    }

    public static ProductListFragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_productlist, container, false);
        initInstances(rootView);
        GetProductList();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        GetProductList();
    }

    private void GetProductList() {
        Call<ArrayList<ProductListDao>> call = HttpManager.getInstance().getService().GetProductListDao();
        call.enqueue(new Callback<ArrayList<ProductListDao>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductListDao>> call, Response<ArrayList<ProductListDao>> response) {
                ArrayList<ProductListDao> dao = response.body();
                adapter = new ProductListAdapter(getActivity(),dao);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
            }

            @Override

                public void onFailure(Call<ArrayList<ProductListDao>> call, Throwable t) {
                Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        btn_addproduct = (ImageButton) rootView.findViewById(R.id.btn_addproduct);
        btn_back = (ImageButton) rootView.findViewById(R.id.btn_back);
        listView = (ListView)rootView.findViewById(R.id.listview);
        btn_back.setOnClickListener(this);
        btn_addproduct.setOnClickListener(this);
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
        if (view == btn_back) {
            getActivity().finish();
        } else if (view == btn_addproduct) {
            Intent intent = new Intent(getActivity(), AddProductActivity.class);
            startActivity(intent);
        }
    }
}
