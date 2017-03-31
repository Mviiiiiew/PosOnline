package com.example.posstrsoftware.posonline.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.dao.DivisionDao;
import com.example.posstrsoftware.posonline.dao.ProductListDao;
import com.example.posstrsoftware.posonline.manager.DivisionListManager;
import com.example.posstrsoftware.posonline.manager.ProductListManager;

import java.util.ArrayList;

/**
 * Created by Wasabi on 3/27/2017.
 */

public class ProductListAdapter extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<ProductListDao> dao = ProductListManager.getInstance().getDao();

    public ProductListAdapter(Activity activity, ArrayList<ProductListDao> dao) {
        this.dao = dao;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        if (dao == null)
            return 0;
        return dao.size();
    }

    @Override
    public Object getItem(int position) {
        return dao.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = view;
        v = inflater.inflate(R.layout.list_item_productlist, null);


        TextView txt_prodCode = (TextView) v.findViewById(R.id.txt_prodCode);
        TextView txt_prodTName = (TextView) v.findViewById(R.id.txt_prodTName);
        TextView txt_prodIsVat = (TextView) v.findViewById(R.id.txt_prodIsVat);
        TextView txt_uomName = (TextView) v.findViewById(R.id.txt_uomName);
        TextView txt_prodQty = (TextView) v.findViewById(R.id.txt_prodQty);
        TextView txt_prodUnitPrice = (TextView) v.findViewById(R.id.txt_prodUnitPrice);
        TextView txt_prodUnitBarcode = (TextView) v.findViewById(R.id.txt_prodUnitBarcode);
        TextView txt_prodGroupName = (TextView) v.findViewById(R.id.txt_prodGroupName);

        ProductListDao productListDao = dao.get(position);
        txt_prodCode.setText(productListDao.getProdCode() + "");
        txt_prodTName.setText(productListDao.getProdTName() + "");
        txt_prodIsVat.setText(productListDao.getProdIsVat() + "");
        txt_uomName.setText(productListDao.getUomName() + "");
        txt_prodQty.setText(productListDao.getProdQty() + "");
        txt_prodUnitPrice.setText(productListDao.getProdUnitPrice() + "");
        txt_prodUnitBarcode.setText(productListDao.getProdUnitBarcode() + "");
        txt_prodGroupName.setText(productListDao.getProdGroupName() + "");
        return v;


    }
}
