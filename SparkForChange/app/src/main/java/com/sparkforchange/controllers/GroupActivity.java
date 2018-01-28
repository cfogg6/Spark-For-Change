package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sparkforchange.R;

public class GroupActivity extends ToolbarDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Groups");
        }
    }
}
