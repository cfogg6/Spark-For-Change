package com.sparkforchange.controllers;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timelineSpinnerChoices);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timelineChoices.setAdapter(spinnerAdapter);

        RecyclerView rvSparkContribution = findViewById(R.id.rv_spark_contribution);
        rvSparkContribution.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvSparkContribution.setLayoutManager(llm);
        final SparkContributionRvAdapter sparkAdapter = new SparkContributionRvAdapter();
        rvSparkContribution.setAdapter(sparkAdapter);
        (rvSparkContribution.getAdapter()).notifyDataSetChanged();
    }
}
