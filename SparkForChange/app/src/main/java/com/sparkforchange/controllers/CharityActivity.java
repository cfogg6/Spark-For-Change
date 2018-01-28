package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sparkforchange.R;

public class CharityActivity extends ToolbarDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity);
        int charityIndex = getIntent().getIntExtra("charityIndex", 0);
    }
}
