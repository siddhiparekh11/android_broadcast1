package com.example.siddhiparekh11.farmiotapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.R.id;
import android.widget.Button;
import android.R.color.*;

public class MainActivity extends Activity {

    double temperature, humidity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getStringExtra("intenttype")!=null) {
            Intent i=getIntent();
            if (i != null) {
                Log.d("Debug-->","bundle is not null");
            Log.d("Debug-->",i.getStringExtra("value1").toString());
                temperature = Double.valueOf(i.getStringExtra("value1"));
                humidity = Double.valueOf(i.getStringExtra("value2"));
            }
        }
    }
    @Override
    protected void onResume()
    {
        super.onResume();

        if(temperature!=0 && humidity!=0)
        {
            if(temperature >70 && temperature <90)
            {

                Log.d("Debug-->","onFan....");
                Button b1=(Button)findViewById(R.id.button_fan);
                b1.setBackgroundColor(Color.parseColor("#B2EBF2"));
                  b1.setEnabled(true);
            }
            else if(temperature>90 && temperature<125)
            {
                Log.d("Debug-->","onSprinkler....");
                Button b2=(Button)findViewById(R.id.button_fan_sprinkler);
                b2.setBackgroundColor(Color.parseColor("#B2EBF2"));
                b2.setEnabled(true);
            }
        }
    }

    public void getTempHumidity(View v)
    {
       Intent getTemp=new Intent("com.example.siddhiparekh11.farmiotapp.TEMP_BROADCAST");
       sendBroadcast(getTemp);


    }
    public void onFan(View v)
    {
        Log.d("Debug-->","onFan is enabled");
        Intent sendTemp=new Intent("com.example.siddhiparekh11.farmiotapp.FAN_BROADCAST");
        sendBroadcast(sendTemp);

    }

    public void onSprinkler(View v)
    {
        Log.d("Debug-->","onSprinkler is enabled");
        Intent sendSprinkler=new Intent("com.example.siddhiparekh11.farmiotapp.SPRINKLER_BROADCAST");
        sendBroadcast(sendSprinkler);
    }
    public void onFinishActivity(View v)
    {
        this.finish();
    }
}
