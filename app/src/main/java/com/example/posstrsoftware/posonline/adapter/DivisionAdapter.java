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
import com.example.posstrsoftware.posonline.manager.DivisionListManager;
import com.example.posstrsoftware.posonline.manager.HttpManager;

import java.util.ArrayList;

/**
 * Created by Wasabi on 3/27/2017.
 */

public class DivisionAdapter extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<DivisionDao> divisionList = DivisionListManager.getInstance().getDao();

    public DivisionAdapter(Activity activity, ArrayList<DivisionDao> divisionDao) {
        this.divisionList = divisionDao;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        if (divisionList == null)
            return 0;
        return divisionList.size();
    }

    @Override
    public Object getItem(int position) {
        return divisionList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = view;
        v = inflater.inflate(R.layout.list_item_division, null);


        TextView txt_companyCode = (TextView) v.findViewById(R.id.txt_companyCode);
        TextView txt_divisionCode = (TextView) v.findViewById(R.id.txt_divisionCode);
        TextView txt_divisionNameTh = (TextView) v.findViewById(R.id.txt_divisionNameTh);
        TextView txt_divisionAddressShop = (TextView) v.findViewById(R.id.txt_divisionAddressShop);
        TextView txt_divisionTel = (TextView) v.findViewById(R.id.txt_divisionTel);
        TextView txt_divisionFax = (TextView) v.findViewById(R.id.txt_divisionFax);
        TextView txt_divisionEmail = (TextView) v.findViewById(R.id.txt_divisionEmail);
        TextView txt_CusTaxId = (TextView) v.findViewById(R.id.txt_CusTaxId);

        DivisionDao divisionDao = divisionList.get(position);
        txt_companyCode.setText(divisionDao.getCompanyCode() + "");
        txt_divisionCode.setText(divisionDao.getDivisionCode() + "");
        txt_divisionNameTh.setText(divisionDao.getDivisionNameTh() + "");
        txt_divisionAddressShop.setText(divisionDao.getDivisionAddressShop() + "");
        txt_divisionTel.setText(divisionDao.getDivisionTel() + "");
        txt_divisionFax.setText(divisionDao.getDivisionFax() + "");
        txt_divisionEmail.setText(divisionDao.getDivisionEmail() + "");
        txt_CusTaxId.setText(divisionDao.getCusTaxId() + "");
        return v;


    }
}
