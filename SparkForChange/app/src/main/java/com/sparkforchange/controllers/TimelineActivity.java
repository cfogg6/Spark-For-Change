package com.sparkforchange.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sparkforchange.R;

public class TimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Timeline");
        }
    }
}
