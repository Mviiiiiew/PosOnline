package com.example.posstrsoftware.posonline.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.dao.ProductListDao;
import com.example.posstrsoftware.posonline.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class AddProductFragment extends Fragment implements View.OnClickListener {

    ImageButton btn_back;
    EditText et_prodCode;
    EditText et_prodTName;
    EditText et_prodIsVat;
    EditText et_prodGroupName;
    EditText et_uomName;
    EditText et_prodQty;
    EditText et_prodUnitPrice;
    EditText et_prodUnitBarcode;
    Button btn_ok;


    public AddProductFragment() {
        super();
    }

    public static AddProductFragment newInstance() {
        AddProductFragment fragment = new AddProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_product, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        btn_ok = (Button)rootView.findViewById(R.id.btn_ok);
        btn_back = (ImageButton) rootView.findViewById(R.id.btn_back);
        et_prodCode = (EditText) rootView.findViewById(R.id.et_prodCode);
        et_prodTName = (EditText) rootView.findViewById(R.id.et_prodTName);
        et_prodIsVat = (EditText) rootView.findViewById(R.id.et_prodIsVat);
        et_prodGroupName = (EditText) rootView.findViewById(R.id.et_prodGroupName);
        et_uomName = (EditText) rootView.findViewById(R.id.et_uomName);
        et_prodQty = (EditText) rootView.findViewById(R.id.et_prodQty);
        et_prodUnitPrice = (EditText) rootView.findViewById(R.id.et_prodUnitPrice);
        et_prodUnitBarcode = (EditText) rootView.findViewById(R.id.et_prodUnitBarcode);
        btn_back.setOnClickListener(this);
        btn_ok.setOnClickListener(this);


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
        if (btn_back == view) {
            getActivity().finish();
        }else  if (btn_ok == view){
            AddProduct();
            getActivity().finish();
        }

    }

    private void AddProduct() {
        String prodCode = et_prodCode.getText().toString();
        String prodTName = et_prodTName.getText().toString();
        String prodIsVat = et_prodIsVat.getText().toString();
        String prodGroupName = et_prodGroupName.getText().toString();
        String uomName = et_uomName.getText().toString();
        String prodQty = et_prodQty.getText().toString();
        String prodUnitPrice = et_prodUnitPrice.getText().toString();
        String prodUnitBarcode = et_prodUnitBarcode.getText().toString();


      Call<ProductListDao> call = HttpManager.getInstance().getService().addproduct(  prodCode
              , prodTName
              , prodIsVat
              , prodGroupName
              , uomName
              , prodQty
              , prodUnitPrice
              ,prodUnitBarcode);
        call.enqueue(new Callback<ProductListDao>() {
            @Override
            public void onResponse(Call<ProductListDao> call, Response<ProductListDao> response) {
                Log.d("onResponse", "" + response.code()
                        + "  response body " + response.body()
                        + " responseError " + response.errorBody()
                        + " responseMessage " +
                        response.message());
            }

            @Override
            public void onFailure(Call<ProductListDao> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });


    }
}
