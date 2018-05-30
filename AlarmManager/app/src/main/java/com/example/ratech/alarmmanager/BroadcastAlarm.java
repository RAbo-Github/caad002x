package com.example.ratech.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by aboro on 10/05/2018.
 */

public class BroadcastAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "10 Seconds Pass!", Toast.LENGTH_LONG).show();
    }

}
