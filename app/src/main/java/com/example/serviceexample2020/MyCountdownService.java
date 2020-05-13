package com.example.serviceexample2020;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;

import androidx.annotation.Nullable;

public class MyCountdownService extends IntentService {

    public static final String INC_MSG = "inc_msg";
    public static final String OUT_MSG = "out_msg";

    public MyCountdownService(String name) {
        super(name);
    }

    public MyCountdownService() {
        super("MyCountdownService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        if (intent != null) {
            int n = intent.getIntExtra(INC_MSG, 0);

            for (int i = n; i >= 0; i--) {
                SystemClock.sleep(1000);

                Intent broadcastIntent = new Intent();
                broadcastIntent.putExtra(OUT_MSG, i);
                broadcastIntent.setAction(MyCountdownBroadcastReceiver.RESPONSE_ACTION);
                sendBroadcast(broadcastIntent);
            }
        }

    }
}
