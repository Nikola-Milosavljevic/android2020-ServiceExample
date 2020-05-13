package com.example.serviceexample2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CountdownActivity extends AppCompatActivity {

    private MyCountdownBroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        Button button = findViewById(R.id.button_start_countdown);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountdown();
            }
        });
    }

    private void startCountdown() {

        broadcastReceiver = new MyCountdownBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(MyCountdownBroadcastReceiver.RESPONSE_ACTION);
        registerReceiver(broadcastReceiver, intentFilter);

        EditText editText = findViewById(R.id.edit_text_countdown_start_value);
        int startValue = Integer.parseInt(editText.getText().toString());

        Intent intent = new Intent(this, MyCountdownService.class);
        intent.putExtra(MyCountdownService.INC_MSG, startValue);
        startService(intent);

    }

    public void updateCounter(int val) {
        TextView textView = findViewById(R.id.text_view_curr_countdown_value);
        textView.setText(String.valueOf(val));

        if (val == 0) {
            Toast.makeText(this, "END!", Toast.LENGTH_SHORT).show();
            unregisterReceiver(broadcastReceiver);
        }
    }
}
