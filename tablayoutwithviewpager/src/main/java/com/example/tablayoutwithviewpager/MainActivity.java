package com.example.tablayoutwithviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TabLayout tabLayout=findViewById(R.id.tablayout);
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 1")); add tab with the name

        ViewPager pagerForFragments=findViewById(R.id.pagerForFragments);

        pagerForFragments.setOffscreenPageLimit(getResources().getStringArray(R.array.tablayout_titles).length);//Set the number of pages that should be retained to either side of the current page in the view hierarchy in an idle state
        PagerAdapterForFragments pagerAdapterForFragments=new PagerAdapterForFragments(getSupportFragmentManager());
        pagerForFragments.setAdapter(pagerAdapterForFragments);
        tabLayout.setupWithViewPager(pagerForFragments);

        pagerForFragments.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * this adapter will fill viewpager with fragments  which we decided to display as pager items
     */

    class PagerAdapterForFragments extends FragmentStatePagerAdapter{


        public PagerAdapterForFragments(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return BlankFragment.newInstance("Section A"," Ravi ");
                case 1:
                    return BlankFragment.newInstance("Section B"," Uma ");

                case 2:
                    return BlankFragment.newInstance("Section C"," Ajay ");

                default:
                    return BlankFragment.newInstance("Section C"," Ajay ");


            }

        }

        @Override
        public int getCount() {
            return getResources().getStringArray(R.array.tablayout_titles).length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return getResources().getStringArray(R.array.tablayout_titles)[position];
        }
    }
}
