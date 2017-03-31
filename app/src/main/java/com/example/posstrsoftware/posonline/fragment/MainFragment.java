package com.example.posstrsoftware.posonline.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.posstrsoftware.posonline.R;
import com.example.posstrsoftware.posonline.activity.LoginActivity;
import com.inthecheesefactory.thecheeselibrary.view.SlidingTabLayout;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    ViewPager viewPager;
    SlidingTabLayout slidingTabLayout;
    TextView Company;
    Button btn_logout;

    public MainFragment() {
        super();
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here

        btn_logout = (Button)rootView.findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(this);
        Company = (TextView) rootView.findViewById(R.id.Company);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return SaleMainFragment.newInstance();
                    case 1:
                        return ProductMainFragment.newInstance();
                    case 2:
                        return CloserSaleFragment.newInstance();
                    case 3:
                        return CancelbillMainFragment.newInstance();
                    case 4:
                        return EditproductMainFragment.newInstance();
                    case 5:
                        return InformationMainFragment.newInstance();
                    case 6:
                        return ConnectDatabaseMainFragment.newInstance();
                    case 7:
                        return ContactSTRMainFragment.newInstance();

                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 8;
            }


            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "ขายสินค้า";
                    case 1:
                        return "สินค้า";
                    case 2:
                        return "ปิดรายวัน";
                    case 3:
                        return "ยกเลิกบิล";
                    case 4:
                        return "ปรับปรุงสินค้า";
                    case 5:
                        return "ข้อมูลทั่วไป";
                    case 6:
                        return "เชื่อมต่อ";
                    case 7:
                        return "ติดต่อ";
                    default:
                        return "";
                }
            }
        });


        slidingTabLayout = (SlidingTabLayout) rootView.findViewById(R.id.slidingTabLayout);
        slidingTabLayout.setDistributeEvenly(true);


       slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        slidingTabLayout.setViewPager(viewPager);




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
        if(view == btn_logout){
            Intent intent  = new Intent(getActivity(),LoginActivity.class);
            startActivity(intent);

        }
    }
}
