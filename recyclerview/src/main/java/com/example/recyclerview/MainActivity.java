package com.example.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.onRecyclerItemClickedListener{

    private ArrayList<String> arrayListPersonNames = new ArrayList<>();
    private ArrayList<String> arrayListgetAddress = new ArrayList<>();
    private ArrayList<String> arrayListimageURLs = new ArrayList<>();
    //private ArrayList<Integer> newImageUrls = new ArrayList<>();
    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("MainActivity","Main activity is created");

        prepareData();
        initRecyclerView();

        FloatingActionButton fabToAddItem=findViewById(R.id.fab);
        fabToAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.scrollToPosition(arrayListPersonNames.size()-1);
                arrayListPersonNames.add("Ravi");
               arrayListgetAddress.add("Amsterdam");
               arrayListimageURLs.add(arrayListimageURLs.get(5));
               adapter.notifyItemInserted(arrayListPersonNames.size()-1);
            }
        });

        FloatingActionButton fabTORemoveItem = findViewById(R.id.removeFab);

        fabTORemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 recyclerView.scrollToPosition(arrayListPersonNames.size()-1);


                //recyclerView.removeViewAt(arrayListPersonNames.size()-1);

               // recyclerView.removeAllViewsInLayout();



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

    private void prepareData() {


        Log.d("Images", "preparing Images");


       // imageURLs.add(R.drawable.chained_hearts);

        for(int index =0;index<20;index++){
            arrayListimageURLs.add("https://www.worldatlas.com/r/w728-h425-c728x425/upload/a1/b2/8a/amsterdam.jpg");
            arrayListPersonNames.add("Amsterdam ");
            arrayListgetAddress.add("Peter ");
        }

        }

    private void initRecyclerView(){
        Log.d("Recycler view", "Recycler view in Main activity is created");

        recyclerView= findViewById(R.id.recyclerContainer);
       adapter = new RecyclerViewAdapter(this, arrayListimageURLs, arrayListPersonNames, arrayListgetAddress);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnRecyclerItemClickedListener(this);


    }




    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, arrayListgetAddress.get(position) + " lives at "+arrayListPersonNames.get(position), Toast.LENGTH_SHORT).show();
    }
}
