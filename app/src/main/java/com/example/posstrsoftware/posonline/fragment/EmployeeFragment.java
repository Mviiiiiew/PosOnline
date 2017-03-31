package com.example.posstrsoftware.posonline.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.activity.MainActivity;
import com.example.posstrsoftware.posonline.adapter.EmployeeAdapter;
import com.example.posstrsoftware.posonline.dao.EmployeeposDao;
import com.example.posstrsoftware.posonline.manager.EmployeeListManager;
import com.example.posstrsoftware.posonline.manager.HttpManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class EmployeeFragment extends Fragment implements View.OnClickListener {
    ListView listview;
    ImageButton btn_back;
    EmployeeAdapter employeeAdapter;


    public EmployeeFragment() {
        super();
    }

    public static EmployeeFragment newInstance() {
        EmployeeFragment fragment = new EmployeeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_employee, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        listview = (ListView) rootView.findViewById(R.id.listview);
        btn_back = (ImageButton) rootView.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);

        Call<ArrayList<EmployeeposDao>> call = HttpManager.getInstance().getService().GetEmployeeListDao();
        call.enqueue(new Callback<ArrayList<EmployeeposDao>>() {
            @Override
            public void onResponse(Call<ArrayList<EmployeeposDao>> call, Response<ArrayList<EmployeeposDao>> response) {
                ArrayList<EmployeeposDao> dao = response.body();
                EmployeeListManager.getInstance().setDao(dao);
                employeeAdapter = new EmployeeAdapter(getActivity(), dao);
                employeeAdapter.notifyDataSetChanged();
                listview.setAdapter(employeeAdapter);
                Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ArrayList<EmployeeposDao>> call, Throwable t) {
                Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
            }
        });


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
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);

        }
    }
}
