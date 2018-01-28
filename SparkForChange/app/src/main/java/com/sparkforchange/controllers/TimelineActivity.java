package com.sparkforchange.controllers;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sparkforchange.R;

public class TimelineActivity extends ToolbarDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Timeline");
        }

        // set up spinner of choosing which timeline to view
        String[] timelineSpinnerChoices = new String[] {"Spark Contributions", "Service Hours", "Donations"};
        Spinner timelineChoices = findViewById(R.id.spinner_timeline);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timelineSpinnerChoices);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timelineChoices.setAdapter(adapter);
    }
}
