package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;

import android.os.Handler;
import java.util.logging.LogRecord;

public class SharedActivity extends AppCompatActivity {

    private Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
        getSupportActionBar().hide();
        h= new Handler();

            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SharedActivity.this, AttendanceActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);

    }

}