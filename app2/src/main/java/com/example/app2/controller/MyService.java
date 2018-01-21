package com.example.app2.controller;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.example.app2.controller.model.backend.factory_dal;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;
import static java.lang.String.valueOf;

/**
 * Created by Shirly on 1/18/2018.
 */



public class MyService extends IntentService {
    public static final String ACTION = "com.example.app2.controller.MyService";

    public MyService() {
        // Used to name the worker thread, important only for debugging.
        super("test-service");
    }


    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.


    }


    /**
     * @param intent
     */
    @Override
    protected void onHandleIntent(Intent intent) {




        // This describes what will happen when service is triggered

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            int size=factory_dal.get_dal().getCars().size();
            @Override
            public void run() {

                Intent in = new Intent(ACTION);
                boolean answer= factory_dal.get_dal().getClosedOrders();
                if(answer==true)
                {

                    Log.i(TAG, "refresh car list");

                    in.putExtra("resultValue", "New cars available...");
                    LocalBroadcastManager.getInstance(MyService.this).sendBroadcast(in);








                }
                else
                {

                        int size2=factory_dal.get_dal().getCars().size();
                        if(valueOf(size2).toString()==null)
                        {
                            size2=0;
                        }
                        if(size2!=size)
                        {
                            in.putExtra("resultValue", "New cars available...");
                            LocalBroadcastManager.getInstance(MyService.this).sendBroadcast(in);
                           size=size2;




                        }








                }





            }

        }, 0, 5000);



    }
}
