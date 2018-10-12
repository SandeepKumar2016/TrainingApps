package com.example.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> getPersonName = new ArrayList<>();
    private ArrayList<String> getAddress = new ArrayList<>();
    private ArrayList<String> imageURLs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("MainActivity","Main activity is created");

        displayData();
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

    private void displayData(){


        Log.d("Images", "preparing Images");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.worldatlas.com%2Fr%2Fw728-h425-c728x425%2Fupload%2Fa1%2Fb2%2F8a%2Famsterdam.jpg&imgrefurl=https%3A%2F%2Fwww.worldatlas.com%2Farticles%2Fbiggest-cities-in-the-netherlands.html&docid=wQ81I8mSnwmjtM&tbnid=2meGAZ0bXhWeaM%3A&vet=10ahUKEwjtpZesooHeAhWRzqQKHfFTBQkQMwhNKAAwAA..i&w=728&h=424&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwjtpZesooHeAhWRzqQKHfFTBQkQMwhNKAAwAA&iact=mrc&uact=8");
        getPersonName.add("Amsterdam ");
        getAddress.add("Peter ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=http%3A%2F%2Finternationalisering.frieslandcollege.nl%2Fenglish%2Fwp-content%2Fuploads%2Fsites%2F3%2F2015%2F02%2Fcycle.jpg&imgrefurl=http%3A%2F%2Finternationalisering.frieslandcollege.nl%2Fenglish%2Fthe-netherlands%2F&docid=WnFqrVVbRKMgJM&tbnid=Zwia-GVBU87KfM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhdKBAwEA..i&w=980&h=552&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhdKBAwEA&iact=mrc&uact=8");
        getPersonName.add("Rotterdam");
        getAddress.add("Henry ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.wur.nl%2Fupload_mm%2Fb%2Fa%2F0%2Fdb73d453-019d-4f91-80f1-ffd87918df22_nacht_stad_donker_licht_rotterdam_NL%252520kopie_490x330_8a2953f0_490x330.jpg&imgrefurl=https%3A%2F%2Fwww.wur.nl%2Fen%2Fshow%2FClimate-change-in-Dutch-cities.htm&docid=LwTU6tAVBzAtyM&tbnid=BF4CLUXPqYTrOM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhfKBIwEg..i&w=490&h=330&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhfKBIwEg&iact=mrc&uact=8");
        getPersonName.add("Utrecht");
        getAddress.add("Croy");

        imageURLs.add("https://www.google.nl/imgres?imgurl=http%3A%2F%2Ftrinitycountrystudy.weebly.com%2Fuploads%2F2%2F7%2F8%2F7%2F27874649%2F6216685_orig.jpg&imgrefurl=https%3A%2F%2Ftrinitycountrystudy.weebly.com%2Fnetherlands.html&docid=mKyb1o2rWijV-M&tbnid=NuVUrCzIwZ6OHM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh1KBswGw..i&w=1100&h=733&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh1KBswGw&iact=mrc&uact=8");
        getPersonName.add("Eindhoven");
        getAddress.add("Haritha");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fimages.oyster.com%2Farticles%2F17761-11052805223-47e12b1da2-k.jpg&imgrefurl=https%3A%2F%2Fwww.oyster.com%2Farticles%2F57837-9-of-the-most-charming-towns-in-the-netherlands%2F&docid=GnZIviNBMRVBnM&tbnid=wx1VpJs_JJUoEM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh4KB4wHg..i&w=640&h=428&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh4KB4wHg&iact=mrc&uact=8");
        getPersonName.add("Dordrecht ");
        getAddress.add("Pepsi");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.holland.com%2Fupload_mm%2F2%2Fb%2Fc%2F47229_fullimage_skyline%2520rotterdam%2520560x350.jpg&imgrefurl=https%3A%2F%2Fwww.holland.com%2Fglobal%2Fmeetings%2Fdutch-conference-cities.htm&docid=MMj7havuGi57jM&tbnid=byLUnSg_HQCPgM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiFASgrMCs..i&w=560&h=350&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiFASgrMCs&iact=mrc&uact=8");
        getPersonName.add("Amsterdam ");
        getAddress.add("Peter ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fbasicincome.org%2Fwp-content%2Fuploads%2F2017%2F05%2F3862179845_bea6e906c6_z-420x280.jpg&imgrefurl=https%3A%2F%2Fbasicincome.org%2Fnews%2F2017%2F05%2Fnetherlands-social-assistance-experiments-review%2F&docid=MszIsGhEbzL8CM&tbnid=NQTRhS6XS3WAYM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiJASgvMC8..i&w=420&h=280&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiJASgvMC8&iact=mrc&uact=8");
        getPersonName.add("Rotterdam");
        getAddress.add("Henry ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.touropia.com%2Fgfx%2Fd%2Fworld-famous-canals%2Famsterdam.jpg%3Fv%3D64e57ea195038647f0e4e0f1079b4fbf&imgrefurl=https%3A%2F%2Fwww.touropia.com%2Fbest-places-to-visit-in-the-netherlands%2F&docid=sWULTZU5Wel3-M&tbnid=rI3lnqoh_awfnM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiMASgyMDI..i&w=810&h=539&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiMASgyMDI&iact=mrc&uact=8");
        getPersonName.add("Utrecht");
        getAddress.add("Croy");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.wanderlustingk.com%2Fwp-content%2Fuploads%2F2017%2F05%2Fdelft-0011705121-copy_orig.jpg&imgrefurl=https%3A%2F%2Fwww.wanderlustingk.com%2Ftravel-blog%2Fbest-cities-netherlands-besides-amsterdam&docid=u-lZAhj4d0eMVM&tbnid=Uwe4XLOb5Ey9jM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiRASg3MDc..i&w=800&h=533&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiRASg3MDc&iact=mrc&uact=8");
        getPersonName.add("Eindhoven");
        getAddress.add("Haritha");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fnomadlist.com%2Fassets%2Fimg%2Fcities%2Fbreda-netherlands-400px.jpg&imgrefurl=https%3A%2F%2Fnomadlist.com%2Fnetherlands&docid=dPZBWf8Obkyl7M&tbnid=uFOhhEGJ6huzRM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiaAShAMEA..i&w=400&h=300&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiaAShAMEA&iact=mrc&uact=8");
        getPersonName.add("Dordrecht ");
        getAddress.add("Pepsi");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.worldatlas.com%2Fr%2Fw728-h425-c728x425%2Fupload%2Fa1%2Fb2%2F8a%2Famsterdam.jpg&imgrefurl=https%3A%2F%2Fwww.worldatlas.com%2Farticles%2Fbiggest-cities-in-the-netherlands.html&docid=wQ81I8mSnwmjtM&tbnid=2meGAZ0bXhWeaM%3A&vet=10ahUKEwjtpZesooHeAhWRzqQKHfFTBQkQMwhNKAAwAA..i&w=728&h=424&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwjtpZesooHeAhWRzqQKHfFTBQkQMwhNKAAwAA&iact=mrc&uact=8");
        getPersonName.add("Amsterdam ");
        getAddress.add("Peter ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=http%3A%2F%2Finternationalisering.frieslandcollege.nl%2Fenglish%2Fwp-content%2Fuploads%2Fsites%2F3%2F2015%2F02%2Fcycle.jpg&imgrefurl=http%3A%2F%2Finternationalisering.frieslandcollege.nl%2Fenglish%2Fthe-netherlands%2F&docid=WnFqrVVbRKMgJM&tbnid=Zwia-GVBU87KfM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhdKBAwEA..i&w=980&h=552&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhdKBAwEA&iact=mrc&uact=8");
        getPersonName.add("Rotterdam");
        getAddress.add("Henry ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.wur.nl%2Fupload_mm%2Fb%2Fa%2F0%2Fdb73d453-019d-4f91-80f1-ffd87918df22_nacht_stad_donker_licht_rotterdam_NL%252520kopie_490x330_8a2953f0_490x330.jpg&imgrefurl=https%3A%2F%2Fwww.wur.nl%2Fen%2Fshow%2FClimate-change-in-Dutch-cities.htm&docid=LwTU6tAVBzAtyM&tbnid=BF4CLUXPqYTrOM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhfKBIwEg..i&w=490&h=330&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhfKBIwEg&iact=mrc&uact=8");
        getPersonName.add("Utrecht");
        getAddress.add("Croy");

        imageURLs.add("https://www.google.nl/imgres?imgurl=http%3A%2F%2Ftrinitycountrystudy.weebly.com%2Fuploads%2F2%2F7%2F8%2F7%2F27874649%2F6216685_orig.jpg&imgrefurl=https%3A%2F%2Ftrinitycountrystudy.weebly.com%2Fnetherlands.html&docid=mKyb1o2rWijV-M&tbnid=NuVUrCzIwZ6OHM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh1KBswGw..i&w=1100&h=733&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh1KBswGw&iact=mrc&uact=8");
        getPersonName.add("Eindhoven");
        getAddress.add("Haritha");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fimages.oyster.com%2Farticles%2F17761-11052805223-47e12b1da2-k.jpg&imgrefurl=https%3A%2F%2Fwww.oyster.com%2Farticles%2F57837-9-of-the-most-charming-towns-in-the-netherlands%2F&docid=GnZIviNBMRVBnM&tbnid=wx1VpJs_JJUoEM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh4KB4wHg..i&w=640&h=428&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh4KB4wHg&iact=mrc&uact=8");
        getPersonName.add("Dordrecht ");
        getAddress.add("Pepsi");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.holland.com%2Fupload_mm%2F2%2Fb%2Fc%2F47229_fullimage_skyline%2520rotterdam%2520560x350.jpg&imgrefurl=https%3A%2F%2Fwww.holland.com%2Fglobal%2Fmeetings%2Fdutch-conference-cities.htm&docid=MMj7havuGi57jM&tbnid=byLUnSg_HQCPgM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiFASgrMCs..i&w=560&h=350&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiFASgrMCs&iact=mrc&uact=8");
        getPersonName.add("Amsterdam ");
        getAddress.add("Peter ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fbasicincome.org%2Fwp-content%2Fuploads%2F2017%2F05%2F3862179845_bea6e906c6_z-420x280.jpg&imgrefurl=https%3A%2F%2Fbasicincome.org%2Fnews%2F2017%2F05%2Fnetherlands-social-assistance-experiments-review%2F&docid=MszIsGhEbzL8CM&tbnid=NQTRhS6XS3WAYM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiJASgvMC8..i&w=420&h=280&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiJASgvMC8&iact=mrc&uact=8");
        getPersonName.add("Rotterdam");
        getAddress.add("Henry ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.touropia.com%2Fgfx%2Fd%2Fworld-famous-canals%2Famsterdam.jpg%3Fv%3D64e57ea195038647f0e4e0f1079b4fbf&imgrefurl=https%3A%2F%2Fwww.touropia.com%2Fbest-places-to-visit-in-the-netherlands%2F&docid=sWULTZU5Wel3-M&tbnid=rI3lnqoh_awfnM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiMASgyMDI..i&w=810&h=539&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiMASgyMDI&iact=mrc&uact=8");
        getPersonName.add("Utrecht");
        getAddress.add("Croy");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.wanderlustingk.com%2Fwp-content%2Fuploads%2F2017%2F05%2Fdelft-0011705121-copy_orig.jpg&imgrefurl=https%3A%2F%2Fwww.wanderlustingk.com%2Ftravel-blog%2Fbest-cities-netherlands-besides-amsterdam&docid=u-lZAhj4d0eMVM&tbnid=Uwe4XLOb5Ey9jM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiRASg3MDc..i&w=800&h=533&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiRASg3MDc&iact=mrc&uact=8");
        getPersonName.add("Eindhoven");
        getAddress.add("Haritha");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fnomadlist.com%2Fassets%2Fimg%2Fcities%2Fbreda-netherlands-400px.jpg&imgrefurl=https%3A%2F%2Fnomadlist.com%2Fnetherlands&docid=dPZBWf8Obkyl7M&tbnid=uFOhhEGJ6huzRM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiaAShAMEA..i&w=400&h=300&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiaAShAMEA&iact=mrc&uact=8");
        getPersonName.add("Dordrecht ");
        getAddress.add("Pepsi");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.worldatlas.com%2Fr%2Fw728-h425-c728x425%2Fupload%2Fa1%2Fb2%2F8a%2Famsterdam.jpg&imgrefurl=https%3A%2F%2Fwww.worldatlas.com%2Farticles%2Fbiggest-cities-in-the-netherlands.html&docid=wQ81I8mSnwmjtM&tbnid=2meGAZ0bXhWeaM%3A&vet=10ahUKEwjtpZesooHeAhWRzqQKHfFTBQkQMwhNKAAwAA..i&w=728&h=424&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwjtpZesooHeAhWRzqQKHfFTBQkQMwhNKAAwAA&iact=mrc&uact=8");
        getPersonName.add("Amsterdam ");
        getAddress.add("Peter ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=http%3A%2F%2Finternationalisering.frieslandcollege.nl%2Fenglish%2Fwp-content%2Fuploads%2Fsites%2F3%2F2015%2F02%2Fcycle.jpg&imgrefurl=http%3A%2F%2Finternationalisering.frieslandcollege.nl%2Fenglish%2Fthe-netherlands%2F&docid=WnFqrVVbRKMgJM&tbnid=Zwia-GVBU87KfM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhdKBAwEA..i&w=980&h=552&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhdKBAwEA&iact=mrc&uact=8");
        getPersonName.add("Rotterdam");
        getAddress.add("Henry ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.wur.nl%2Fupload_mm%2Fb%2Fa%2F0%2Fdb73d453-019d-4f91-80f1-ffd87918df22_nacht_stad_donker_licht_rotterdam_NL%252520kopie_490x330_8a2953f0_490x330.jpg&imgrefurl=https%3A%2F%2Fwww.wur.nl%2Fen%2Fshow%2FClimate-change-in-Dutch-cities.htm&docid=LwTU6tAVBzAtyM&tbnid=BF4CLUXPqYTrOM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhfKBIwEg..i&w=490&h=330&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwhfKBIwEg&iact=mrc&uact=8");
        getPersonName.add("Utrecht");
        getAddress.add("Croy");

        imageURLs.add("https://www.google.nl/imgres?imgurl=http%3A%2F%2Ftrinitycountrystudy.weebly.com%2Fuploads%2F2%2F7%2F8%2F7%2F27874649%2F6216685_orig.jpg&imgrefurl=https%3A%2F%2Ftrinitycountrystudy.weebly.com%2Fnetherlands.html&docid=mKyb1o2rWijV-M&tbnid=NuVUrCzIwZ6OHM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh1KBswGw..i&w=1100&h=733&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh1KBswGw&iact=mrc&uact=8");
        getPersonName.add("Eindhoven");
        getAddress.add("Haritha");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fimages.oyster.com%2Farticles%2F17761-11052805223-47e12b1da2-k.jpg&imgrefurl=https%3A%2F%2Fwww.oyster.com%2Farticles%2F57837-9-of-the-most-charming-towns-in-the-netherlands%2F&docid=GnZIviNBMRVBnM&tbnid=wx1VpJs_JJUoEM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh4KB4wHg..i&w=640&h=428&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwh4KB4wHg&iact=mrc&uact=8");
        getPersonName.add("Dordrecht ");
        getAddress.add("Pepsi");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.holland.com%2Fupload_mm%2F2%2Fb%2Fc%2F47229_fullimage_skyline%2520rotterdam%2520560x350.jpg&imgrefurl=https%3A%2F%2Fwww.holland.com%2Fglobal%2Fmeetings%2Fdutch-conference-cities.htm&docid=MMj7havuGi57jM&tbnid=byLUnSg_HQCPgM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiFASgrMCs..i&w=560&h=350&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiFASgrMCs&iact=mrc&uact=8");
        getPersonName.add("Amsterdam ");
        getAddress.add("Peter ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fbasicincome.org%2Fwp-content%2Fuploads%2F2017%2F05%2F3862179845_bea6e906c6_z-420x280.jpg&imgrefurl=https%3A%2F%2Fbasicincome.org%2Fnews%2F2017%2F05%2Fnetherlands-social-assistance-experiments-review%2F&docid=MszIsGhEbzL8CM&tbnid=NQTRhS6XS3WAYM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiJASgvMC8..i&w=420&h=280&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiJASgvMC8&iact=mrc&uact=8");
        getPersonName.add("Rotterdam");
        getAddress.add("Henry ");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.touropia.com%2Fgfx%2Fd%2Fworld-famous-canals%2Famsterdam.jpg%3Fv%3D64e57ea195038647f0e4e0f1079b4fbf&imgrefurl=https%3A%2F%2Fwww.touropia.com%2Fbest-places-to-visit-in-the-netherlands%2F&docid=sWULTZU5Wel3-M&tbnid=rI3lnqoh_awfnM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiMASgyMDI..i&w=810&h=539&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiMASgyMDI&iact=mrc&uact=8");
        getPersonName.add("Utrecht");
        getAddress.add("Croy");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fwww.wanderlustingk.com%2Fwp-content%2Fuploads%2F2017%2F05%2Fdelft-0011705121-copy_orig.jpg&imgrefurl=https%3A%2F%2Fwww.wanderlustingk.com%2Ftravel-blog%2Fbest-cities-netherlands-besides-amsterdam&docid=u-lZAhj4d0eMVM&tbnid=Uwe4XLOb5Ey9jM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiRASg3MDc..i&w=800&h=533&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiRASg3MDc&iact=mrc&uact=8");
        getPersonName.add("Eindhoven");
        getAddress.add("Haritha");

        imageURLs.add("https://www.google.nl/imgres?imgurl=https%3A%2F%2Fnomadlist.com%2Fassets%2Fimg%2Fcities%2Fbreda-netherlands-400px.jpg&imgrefurl=https%3A%2F%2Fnomadlist.com%2Fnetherlands&docid=dPZBWf8Obkyl7M&tbnid=uFOhhEGJ6huzRM%3A&vet=10ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiaAShAMEA..i&w=400&h=300&bih=579&biw=1272&q=netherland%20cities&ved=0ahUKEwidz7bHooHeAhXI3KQKHVA4BVsQMwiaAShAMEA&iact=mrc&uact=8");
        getPersonName.add("Dordrecht ");
        getAddress.add("Pepsi");

        initRecyclerView();
    }


    private void initRecyclerView(){
        Log.d("Recycler view", "Recycler view in Main activity is created");

        RecyclerView recyclerView = findViewById(R.id.recyclerContainer);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, imageURLs, getPersonName, getAddress);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }











}
