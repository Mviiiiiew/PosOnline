package com.example.posstrsoftware.posonline.manager;

import android.content.Context;

import com.example.posstrsoftware.posonline.dao.EmployeeposDao;
import com.example.posstrsoftware.posonline.dao.ProductListDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ProductListManager {

    private static ProductListManager instance;

    public static ProductListManager getInstance() {
        if (instance == null)
            instance = new ProductListManager();
        return instance;
    }

    private Context mContext;
    private ArrayList<ProductListDao> dao;

    private ProductListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public ArrayList<ProductListDao> getDao() {
        return dao;
    }

    public void setDao(ArrayList<ProductListDao> dao) {
        this.dao = dao;
    }
}
