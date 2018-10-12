package com.example.servicespractice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class BoundedService extends Service {
//    A bound service is an implementation of the Service class that allows other applications
//            to bind to it and interact with it.
    public BoundedService() {
    }


    public IBinder myBinder = new MyActCanCall(); //This is the binder given to Activity.

    public Random mGen = new Random();

    public class MyActCanCall extends Binder{//why extends Binder?

        BoundedService getService(){

            // Return this instance of BoundedService so Activity can call public methods
            //This MyActCanCall provides getService() method for Activity to retrieve the current
            //instance of BoundedService.
            //This allows Activity to call public methods in the service.
            // For example, clients can call getRandomNumber() from the service.

            return BoundedService.this;
        }

    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        To provide binding for a service, you must implement the onBind() callback method.
//        This method returns an IBinder object that defines the programming interface that
//                clients can use to interact with the service.


        //throw new UnsupportedOperationException("Not yet implemented");
        return myBinder;
    }


    //Method for activity
    public int getRandomNum(){
        return mGen.nextInt(100);
    }

}
