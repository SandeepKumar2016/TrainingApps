package com.example.threads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

        handler=new Handler(){
            @Override
            public void handleMessage( Message msg) {
                super.handleMessage(msg);

                Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    Handler handler;
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

    String dummyString="dummyText";


    public void threadDemo(View view){
        //threads will perform task parallel to main thread and task must be non UI task
        //we can communicate to ui (main) thread from our thread to perform any ui task
        Thread threadObject=new Thread(){
            @Override
            public void run() {
                super.run();
                for (int index=0;index<20;index++){
                    dummyString+=" dummyText"+index;
                }
                Log.d("thread",dummyString);

                //Runnable is used to define a task that can be executed by any thread
                //A class who implements runnable behaves likes a thread class
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                Toast.makeText(MainActivity.this,dummyString,Toast.LENGTH_SHORT).show();

                    }
                });


            }
        };

        threadObject.start();

    }


    public void threadUsingRunnable(View view){
        Thread threadA=new Thread(runnableObjForTask);

        Thread threadB=new Thread(runnableObjForTask);
        Thread threadC=new Thread(runnableObjForTask);

        try {
            threadA.start();
            Thread.sleep(3000);
            threadB.start();
            Thread.sleep(3000);
threadC.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    Runnable runnableObjForTask=new Runnable() {
        @Override
        public void run() {
            dummyString="";
            for (int index=0;index<5;index++){
                dummyString+=" dummyText"+index;
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this,dummyString,Toast.LENGTH_SHORT).show();

                }
            });
        }
    };


    public void threadAndHandler(View view){
        //threads will perform task parallel to main thread and task must be non UI task
        //we can communicate to ui (main) thread from our thread to perform any ui task
        new Thread(){
            @Override
            public void run() {
                super.run();
                dummyString="";
                for (int index=0;index<20;index++){
                    dummyString+=" dummyText"+index;
                }
                Log.d("thread",dummyString);

                Message message=new Message();
                message.obj=dummyString;
                message.what=100;//randome number to specify a condition
                handler.sendMessage(message);
                //Handler perfomrs inter thread communication on calling thread which it was called

//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(MainActivity.this,dummyString,Toast.LENGTH_SHORT).show();
//
//                    }
//                },2000);
            }
        }.start();
    }
}
