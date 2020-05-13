package com.example.serviceexample2020;

import android.view.View;
import android.widget.TextView;

public class PrimeWorker implements Runnable {

    private View view;
    private int n;

    public PrimeWorker(View view, int n) {
        this.view = view;
        this.n = n;
    }

    @Override
    public void run() {
        int numOfPrimes = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                numOfPrimes++;
            }
        }

        // ne ovako, view treba menjati samo iz UI thread-a
        //((TextView) view).setText(String.valueOf(numOfPrimes));

        final int answer = numOfPrimes;

        view.post(new Runnable() {
            @Override
            public void run() {
                ((TextView) view).setText(String.valueOf(answer));
            }
        });
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
