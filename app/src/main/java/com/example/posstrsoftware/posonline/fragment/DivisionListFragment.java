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
import com.example.posstrsoftware.posonline.activity.MainActivity;
import com.example.posstrsoftware.posonline.adapter.DivisionAdapter;
import com.example.posstrsoftware.posonline.dao.DivisionDao;
import com.example.posstrsoftware.posonline.manager.DivisionListManager;
import com.example.posstrsoftware.posonline.manager.HttpManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DivisionListFragment extends Fragment implements View.OnClickListener {
    ImageButton btn_back;
    ListView listviewDivision;
    DivisionAdapter divisionAdapter;
    DivisionDao divisionDao;

    public DivisionListFragment() {
        super();
    }

    public static DivisionListFragment newInstance() {
        DivisionListFragment fragment = new DivisionListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_divisionlist, container, false);
        initInstances(rootView);
        return rootView;
    }


    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        listviewDivision = (ListView) rootView.findViewById(R.id.listviewDivision);
        btn_back = (ImageButton) rootView.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        listviewDivision.setAdapter(divisionAdapter);

        Call<ArrayList<DivisionDao>> call = HttpManager.getInstance().getService().GetDivisionListDao();
        call.enqueue(new Callback<ArrayList<DivisionDao>>() {
            @Override
            public void onResponse(Call<ArrayList<DivisionDao>> call, Response<ArrayList<DivisionDao>> response) {
                ArrayList<DivisionDao> dao = response.body();
                DivisionListManager.getInstance().setDao(dao);
                divisionAdapter = new DivisionAdapter(getActivity(),dao);
                divisionAdapter.notifyDataSetChanged();
                listviewDivision.setAdapter(divisionAdapter);
                Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ArrayList<DivisionDao>> call, Throwable t) {
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
