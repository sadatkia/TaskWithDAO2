package com.example.myannuallytasks.Controller;


import  android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Adapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myannuallytasks.R;
import com.google.android.material.tabs.TabLayout;

import java.util.UUID;

import static com.example.myannuallytasks.Controller.Log_in_Fragment.EXTRA_LOGIN_FRAGMENT_ID;

public class TaskActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Adapter mAdapter;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        final UUID uuid_user= (UUID) getIntent().getSerializableExtra(EXTRA_LOGIN_FRAGMENT_ID);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        // setActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        mViewPager =  findViewById(R.id.pager);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                    { TabsFragment tab1 = TabsFragment.newInstance( State.TODO ,uuid_user);
                        return tab1;}
                    case 1:
                    {TabsFragment tab2 = TabsFragment.newInstance(State.DOING,uuid_user);

                        return tab2;}
                    case 2:
                    {TabsFragment tab3 = TabsFragment.newInstance(State.DONE,uuid_user);

                        return tab3;}
                    default:
                        return null;
                }

            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        mViewPager.setOffscreenPageLimit(2);
        ////////////////////////////////////////////////////////////

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {




            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setAdapter(mViewPager.getAdapter());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                // ((TabsFragment) ((PagerAdapter) viewPager.getAdapter()).getItem(tab.getPosition())).updateUI();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, TaskActivity.class);
        return intent;
    }
}