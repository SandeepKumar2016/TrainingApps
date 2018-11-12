package com.example.codelab_tablayout;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {




//    Hello Allemaal!
//
//    Godenavaond!
//
//    Op January maand bezocht ik St.Anton met mijn collegas. Dat is een prachtige trip.
//    We beginnen om 11 uur nachts. We zijn zes mensen in een auto. We hebben 3 pauzen voor elke drie uur.
//    In de morgen hebben we berg Alpen ingevoerd. De bergen was bedekt met sneeuw en ze zijn mooi.
//
//    Op eerste dag wandelen we over de bergen en kijken we heel mooi landschap. Soms plaats was het sunny en soms niets.
//    Ik maakte fotos aan de mooi scenario. Daarna eten we in een restaurant.
//    In de avonds bezochten we Intersport winkel en hebben we ski uitrusting gekocht.

    private DrawerLayout mDrawerLayout;

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

        //setting navigation drawer

        // Create Navigation drawer and inflate layout
        NavigationView navigationView = findViewById(R.id.nav_view);
        mDrawerLayout = findViewById(R.id.drawer);

        ActionBar supportActionBar = getSupportActionBar();

        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Set behavior of Navigation drawer

        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // Set item in checked state

                        menuItem.setChecked(true);
                        // TODO: handle navigation
                        // Closing drawer on item click
                        mDrawerLayout.closeDrawers();

                        return true;
                    }
                }
        );


        // Adding Floating Action Button to bottom right of main view

        FloatingActionButton btnFab = findViewById(R.id.fab);
        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Hello message from snackbar", Snackbar.LENGTH_LONG).show();
            }
        });


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
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

