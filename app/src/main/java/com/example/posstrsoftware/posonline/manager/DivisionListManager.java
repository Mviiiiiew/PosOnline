package com.example.posstrsoftware.posonline.manager;

import android.content.Context;

import com.example.posstrsoftware.posonline.dao.DivisionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DivisionListManager {

    private static DivisionListManager instance;

    public static DivisionListManager getInstance() {
        if (instance == null)
            instance = new DivisionListManager();
        return instance;
    }

    private Context mContext;
    private ArrayList<DivisionDao> dao;

    private DivisionListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public ArrayList<DivisionDao> getDao() {
        return dao;
    }

    public void setDao(ArrayList<DivisionDao> dao) {
        this.dao = dao;
    }
}
