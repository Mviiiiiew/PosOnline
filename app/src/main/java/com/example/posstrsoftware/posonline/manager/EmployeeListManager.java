package com.example.posstrsoftware.posonline.manager;

import android.content.Context;

import com.example.posstrsoftware.posonline.dao.DivisionDao;
import com.example.posstrsoftware.posonline.dao.EmployeeposDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class EmployeeListManager {

    private static EmployeeListManager instance;

    public static EmployeeListManager getInstance() {
        if (instance == null)
            instance = new EmployeeListManager();
        return instance;
    }

    private Context mContext;
    private ArrayList<EmployeeposDao> dao;

    private EmployeeListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public ArrayList<EmployeeposDao> getDao() {
        return dao;
    }

    public void setDao(ArrayList<EmployeeposDao> dao) {
        this.dao = dao;
    }
}
