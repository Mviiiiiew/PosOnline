package com.example.posstrsoftware.posonline.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.activity.InsertActivity;
import com.example.posstrsoftware.posonline.activity.MainActivity;
import com.example.posstrsoftware.posonline.dao.RegisterDataDao;
import com.example.posstrsoftware.posonline.manager.HttpManager;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class LoginMainFragment extends Fragment implements View.OnClickListener {
    Button btn_login;
    EditText et_username;
    EditText et_password;
    TextView txt_register;

    public LoginMainFragment() {
        super();
    }

    public static LoginMainFragment newInstance() {
        LoginMainFragment fragment = new LoginMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_login, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        btn_login = (Button) rootView.findViewById(R.id.btn_login);
        et_username = (EditText) rootView.findViewById(R.id.et_username);
        et_password = (EditText) rootView.findViewById(R.id.et_password);
        txt_register = (TextView) rootView.findViewById(R.id.txt_register);

        txt_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
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
        if (view == txt_register) {
            Intent intent = new Intent(getActivity(), InsertActivity.class);
            startActivity(intent);
        } else if (view == btn_login) {
            Login();
        }
    }

    private void Login() {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        Call<RegisterDataDao> call = HttpManager.getInstance().getService().Login(username, password);
        call.enqueue(new Callback<RegisterDataDao>() {
            @Override
            public void onResponse(Call<RegisterDataDao> call, Response<RegisterDataDao> response) {
                if (response.body().getSuccess()) {
                    RegisterDataDao dao = response.body();
                    Toast.makeText(getActivity(),dao.getName().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(getActivity(), "LoginFail !!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterDataDao> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
