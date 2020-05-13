package com.example.serviceexample2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountPrimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_prime);

        Button button = findViewById(R.id.button_calculate_primes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        Button button2 = findViewById(R.id.button_calculate_primes_UI_thread);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate_ui_thread();
            }
        });

        Button button3 = findViewById(R.id.button_test_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test_ui_response();
            }
        });
    }

    private void test_ui_response() {
        Toast.makeText(this, "Radi!", Toast.LENGTH_SHORT).show();
    }

    private void calculate_ui_thread() {
        EditText editText = findViewById(R.id.edit_text_number_n);
        int n = Integer.parseInt(editText.getText().toString());
        TextView textView = findViewById(R.id.text_view_answer);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                answer++;
            }
        }
        textView.setText(String.valueOf(answer));
    }

    private void calculate() {

        EditText editText = findViewById(R.id.edit_text_number_n);
        int n = Integer.parseInt(editText.getText().toString());
        TextView textView = findViewById(R.id.text_view_answer);

        //(new Thread(new PrimeWorker(textView, n))).start();
        PrimeWorker worker = new PrimeWorker(textView, n);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(worker);
        executor.shutdown();
    }

    private boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
