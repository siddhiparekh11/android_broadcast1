package com.example.siddhiparekh11.farmiotapp;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
/**
 * Created by siddhiparekh11 on 3/12/17.
 */

public class TempBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("com.example.siddhiparekh11.temperaturehumidity.TEMPRES_BROADCAST")) {

            Log.d("Debug -->", "I am in Farm IOT");

            Intent i=new Intent(context,MainActivity.class);
            i.putExtra("value1",intent.getStringExtra("tempValue"));

            i.putExtra("value2",intent.getStringExtra("humidValue"));
            i.putExtra("intenttype","fromtemperatureapp");
            context.startActivity(i);

        }

    }
}
