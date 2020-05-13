package com.example.serviceexample2020;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyCountdownBroadcastReceiver extends BroadcastReceiver {

    public static final String RESPONSE_ACTION ="response_action";

    public MyCountdownBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            int val = intent.getIntExtra(MyCountdownService.OUT_MSG, 0);
            ((CountdownActivity) context).updateCounter(val);
        }
    }
}
