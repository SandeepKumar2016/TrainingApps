package com.example.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class BoundedService extends Service {
    public BoundedService() {
    }

    public IBinder iBinder=new LocalBinder();


    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder{
       BoundedService getService(){//so that activity can get the service instance to call its public methods
           return BoundedService.this;
       }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return iBinder;
    }

    private Random random=new Random();
    public int getRandomNumber(){ //function provided by service to be used by client
        return random.nextInt();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("Bindedservice","Service un binded");
        return super.onUnbind(intent);
    }


}
