package com.example.posstrsoftware.posonline.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.activity.DivisionActivity;
import com.example.posstrsoftware.posonline.activity.EmployeeActivity;
import com.gc.materialdesign.views.ButtonRectangle;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class InformationMainFragment extends Fragment implements View.OnClickListener {
    ButtonRectangle btn_employee ;
    ButtonRectangle btn_division;

    public InformationMainFragment() {
        super();
    }

    public static InformationMainFragment newInstance() {
        InformationMainFragment fragment = new InformationMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_information, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        btn_division = (ButtonRectangle)rootView.findViewById(R.id.btn_division);
        btn_employee = (ButtonRectangle)rootView.findViewById(R.id.btn_employee);
        btn_division.setOnClickListener(this);
        btn_employee.setOnClickListener(this);

        btn_division.setRippleSpeed(30);
        btn_employee.setRippleSpeed(30);


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
        if(btn_division == view){
            Intent intent  = new Intent(getActivity(), DivisionActivity.class);
            startActivity(intent);
        }else if(btn_employee == view){
            Intent intent = new Intent(getActivity(), EmployeeActivity.class);
            startActivity(intent);
        }

    }
}
