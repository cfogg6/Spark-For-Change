package com.sparkforchange.controllers;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
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

        RecyclerView rvSparkContribution = findViewById(R.id.rv_spark_contribution);
        rvSparkContribution.setHasFixedSize(true);
        final LinearLayoutManager llmSparks = new LinearLayoutManager(this);
        llmSparks.setOrientation(LinearLayoutManager.VERTICAL);
        rvSparkContribution.setLayoutManager(llmSparks);
        final SparkContributionRvAdapter sparkAdapter = new SparkContributionRvAdapter();
        rvSparkContribution.setAdapter(sparkAdapter);
        (rvSparkContribution.getAdapter()).notifyDataSetChanged();

        RecyclerView rvHours = findViewById(R.id.rv_service_hours);
        rvHours.setHasFixedSize(true);
        final LinearLayoutManager llmHours = new LinearLayoutManager(this);
        llmHours.setOrientation(LinearLayoutManager.VERTICAL);
        rvHours.setLayoutManager(llmHours);
        final VolunteerHoursRvAdapter hoursAdapter = new VolunteerHoursRvAdapter();
        rvHours.setAdapter(hoursAdapter);
        (rvHours.getAdapter()).notifyDataSetChanged();

        RecyclerView rvDonations = findViewById(R.id.rv_donations);
        rvDonations.setHasFixedSize(true);
        final LinearLayoutManager llmDonations = new LinearLayoutManager(this);
        llmDonations.setOrientation(LinearLayoutManager.VERTICAL);
        rvDonations.setLayoutManager(llmDonations);
        final DonationsRvAdapter donationsAdapter = new DonationsRvAdapter();
        rvDonations.setAdapter(donationsAdapter);
        (rvDonations.getAdapter()).notifyDataSetChanged();

        // set up spinner of choosing which timeline to view
        String[] timelineSpinnerChoices = new String[] {"Spark Contributions", "Service Hours", "Donations"};
        Spinner spinner = findViewById(R.id.spinner_timeline);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timelineSpinnerChoices);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        rvSparkContribution.setVisibility(View.VISIBLE);
                        rvHours.setVisibility(View.GONE);
                        rvDonations.setVisibility(View.GONE);
                        return;
                    case 1:
                        rvSparkContribution.setVisibility(View.GONE);
                        rvHours.setVisibility(View.VISIBLE);
                        rvDonations.setVisibility(View.GONE);
                        return;
                    case 2:
                        rvSparkContribution.setVisibility(View.GONE);
                        rvHours.setVisibility(View.GONE);
                        rvDonations.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
}
