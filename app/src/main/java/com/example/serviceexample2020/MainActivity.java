package com.example.serviceexample2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_background_task);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountPrimeActivity();
            }
        });

        Button button2 = findViewById(R.id.button_countdown_service);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountdownActivity();
            }
        });
    }

    private void startCountPrimeActivity() {
        Intent intent = new Intent(this, CountPrimeActivity.class);
        startActivity(intent);
    }

    private void startCountdownActivity() {
        Intent intent = new Intent(this, CountdownActivity.class);
        startActivity(intent);
    }
}
