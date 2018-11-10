package com.example.apiservicecalls;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apiservicecalls.models.GitHubFeed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        getGitHubCommitsData();
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

ArrayList<GitHubFeed> gitHubFeedArrayList=new ArrayList<>();

    void getGitHubCommitsData() {
//progressbar visibily
        StringRequest jsonRequest = new StringRequest(Request.Method.GET,

                "https://api.github.com/search/commits?q=rails/rails",


        new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
//progresbar hide in runonuithread
                        try {
                            JSONObject jsonObject=new JSONObject(response);

                            JSONArray itemsJsonArray=jsonObject.getJSONArray("items");

                            for (int index=0;index<itemsJsonArray.length();index++){

                                JSONObject item=itemsJsonArray.getJSONObject(index);

                                gitHubFeedArrayList.add(new GitHubFeed(item.getJSONObject("commit")
                                        .getJSONObject("author").getString("name"),
                                        item.getJSONObject("commit")
                                                .getJSONObject("author").getString("email"),
                                        item.getJSONObject("author").getString("avatar_url")));

                            }
                            Log.d("git arraylist",gitHubFeedArrayList.size()+ "");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       Log.e("error","Something went wrong . Please pull to refresh"+error.getMessage());

                   }
               });
            }
        }) {
//            @Override
//            protected Response parseNetworkResponse(NetworkResponse response) {
//               Log.d("respone code",response.statusCode+"");
//                return Response.success(response, HttpHeaderParser.parseCacheHeaders(response));
//
//                //return null;
//            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers=new HashMap<>();
                headers.put("User-Agent","avi2108");
                headers.put("Accept","application/vnd.github.cloak-preview+json");
                return headers;
            }

            //            @Override
//            public int compareTo(@NonNull Object o) {
//                return 0;
//            }
        };
        Volley.newRequestQueue(getApplicationContext()).add(jsonRequest);
    }
}
