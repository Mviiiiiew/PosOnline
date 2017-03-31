package com.example.posstrsoftware.posonline.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.dao.RegisterDataDao;
import com.example.posstrsoftware.posonline.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class InsertFragment extends Fragment implements View.OnClickListener {
    Button btn_Register;
    EditText et_password;
    EditText et_username;
    EditText et_name;


    private ProgressDialog pDialog;

    public InsertFragment() {
        super();
    }

    public static InsertFragment newInstance() {
        InsertFragment fragment = new InsertFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_insert, container, false);
        initInstances(rootView);
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        btn_Register = (Button) rootView.findViewById(R.id.btn_Register);
        et_password = (EditText) rootView.findViewById(R.id.et_password);
        et_username = (EditText) rootView.findViewById(R.id.et_username);
        et_name = (EditText) rootView.findViewById(R.id.et_name);
        btn_Register.setOnClickListener(this);
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
        if (view == btn_Register) {
            RegisterData();
            getActivity().finish();
        }
    }

    private void RegisterData() {
        //showpDialog();
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        String name = et_name.getText().toString();


        Call<RegisterDataDao> call = HttpManager.getInstance().getService().RegisterData(name, username, password);
        call.enqueue(new Callback<RegisterDataDao>() {
            @Override
            public void onResponse(Call<RegisterDataDao> call, Response<RegisterDataDao> response) {
                //hidepDialog();
                Log.d("onResponse", "" + response.code()
                        + "  response body " + response.body()
                        + " responseError " + response.errorBody()
                        + " responseMessage " +
                        response.message());
                //   Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterDataDao> call, Throwable t) {
                //   hidepDialog();
                Log.d("onFailure", t.toString());
            }
        });
        getActivity().finish();
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


}
