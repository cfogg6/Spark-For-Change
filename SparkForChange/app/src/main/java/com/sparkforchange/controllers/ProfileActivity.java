package com.sparkforchange.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.sparkforchange.R;

public class ProfileActivity extends ToolbarDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button volunteerHistoryBtn = findViewById(R.id.btn_timeline);

        volunteerHistoryBtn.setOnClickListener(view -> {
            startActivity(new Intent(ProfileActivity.this, TimelineActivity.class));
        });
    }
}
