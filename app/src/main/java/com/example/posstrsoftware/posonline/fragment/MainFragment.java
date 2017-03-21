package com.example.posstrsoftware.posonline.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.posstrsoftware.posonline.R;
import com.inthecheesefactory.thecheeselibrary.view.SlidingTabLayout;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MainFragment extends Fragment {
    ViewPager viewPager;
    SlidingTabLayout slidingTabLayout;
    TextView Company;

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
                        return CancelbillMainFragment.newInstance();
                    case 3:
                        return TransferMainFragment.newInstance();
                    case 4:
                        return InformationMainFragment.newInstance();
                    case 5:
                        return ConnectDatabaseMainFragment.newInstance();
                    case 6:
                        return ContactSTRMainFragment.newInstance();

                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 7;
            }


            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "ขายสินค้า";
                    case 1:
                        return "ข้อมูลสินค้า";
                    case 2:
                        return "ยกเลิกบิล";
                    case 3:
                        return "โอนสินค้า";
                    case 4:
                        return "ข้อมูลทั่วไป";
                    case 5:
                        return "เชื่อมต่อ";
                    case 6:
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
}
