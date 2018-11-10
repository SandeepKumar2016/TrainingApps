package com.example.codelab_tablayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding toolbar in main screen
        Toolbar toolbar = findViewById(R.id.toolbar);


        //adding tablayout in main screen
        TabLayout tabs = findViewById(R.id.tabs);

        // Setting ViewPager for each Tabs
        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabs.setupWithViewPager(viewPager);//??ask

//
//        tabs.addTab(tabs.newTab().setText("Tab 1"));
//        tabs.addTab(tabs.newTab().setText("Tab 2"));
//        tabs.addTab(tabs.newTab().setText("Tab 3"));

    }

    //Add Fragments to tabs

    private void setupViewPager(ViewPager viewPager) {

        ListContentFragment listContentFragment = new ListContentFragment();


        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragment(new ListContentFragment(), "List");
        adapter.addFragment(new TIleContentFragment(), "Tile");
        adapter.addFragment(new CardContentFragment(), "Card");

        viewPager.setAdapter(adapter);

    }


    static class Adapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


//    public class SectionPageAdapter extends FragmentPagerAdapter{
//
//        public SectionPageAdapter(FragmentManager fm) {
//            super(fm);
//        }

//        @Override
//        public Fragment getItem(int position) {
//            switch(position){
//                case 0:
//                    return new ListContentFragment();
//                case 1:
//                    return new TIleContentFragment();
//                case 2:
//                    return new CardContentFragment();
//                default:
//                    return new ListContentFragment();
//
//            }        }
//
//        @Override
//        public int getCount() {
//            return 3;
//        }
//
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch(position){
//                case 0:
//                    return "List";
//                case 1:
//                    return "Tile";
//                case 2:
//                    return  "Cards";
//                default:
//                    return null;
//
//            }
//        }
//    }


}

