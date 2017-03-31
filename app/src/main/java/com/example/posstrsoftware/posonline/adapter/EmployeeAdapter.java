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
import com.example.posstrsoftware.posonline.dao.EmployeeposDao;
import com.example.posstrsoftware.posonline.fragment.EmployeeMainFragment;
import com.example.posstrsoftware.posonline.manager.DivisionListManager;
import com.example.posstrsoftware.posonline.manager.EmployeeListManager;

import java.util.ArrayList;

/**
 * Created by Wasabi on 3/27/2017.
 */

public class EmployeeAdapter extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<EmployeeposDao> employeeposDao = EmployeeListManager.getInstance().getDao();

    public EmployeeAdapter(Activity activity, ArrayList<EmployeeposDao> divisionDao) {
        this.employeeposDao = divisionDao;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        if (employeeposDao == null)
            return 0;
        return employeeposDao.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeposDao.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = view;
        v = inflater.inflate(R.layout.list_item_employee, null);


        TextView txt_empCode = (TextView) v.findViewById(R.id.txt_empCode);
        TextView txt_empPOSName = (TextView) v.findViewById(R.id.txt_empPOSName);
        TextView txt_empPOSPeopleId = (TextView) v.findViewById(R.id.txt_empPOSPeopleId);
        TextView txt_empPOSGender = (TextView) v.findViewById(R.id.txt_empPOSGender);
        TextView txt_empPOSAddress = (TextView) v.findViewById(R.id.txt_empPOSAddress);
        TextView txt_empPOSTel = (TextView) v.findViewById(R.id.txt_empPOSTel);
        TextView txt_empPOSEmail = (TextView) v.findViewById(R.id.txt_empPOSEmail);


        EmployeeposDao employeepos = employeeposDao.get(position);
        txt_empCode.setText(employeepos.getEmpCode() + "");
        txt_empPOSName.setText(employeepos.getEmpPOSName() + "");
        txt_empPOSPeopleId.setText(employeepos.getEmpPOSPeopleId() + "");
        txt_empPOSGender.setText(employeepos.getEmpPOSGender() + "");
        txt_empPOSAddress.setText(employeepos.getEmpPOSAddress() + "");
        txt_empPOSTel.setText(employeepos.getEmpPOSTel() + "");
        txt_empPOSEmail.setText(employeepos.getEmpPOSEmail() + "");

        return v;


    }
}
