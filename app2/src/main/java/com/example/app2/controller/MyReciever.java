package com.example.app2.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Shirly on 1/9/2018.
 */

public class MyReciever extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent background = new Intent(context,MyReciever.class);
        context.startService(background);
    }

}
