package com.sparkforchange.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.sparkforchange.R;

public class ServeActivity extends ToolbarDrawerActivity {
    Button sparkQRBtn, loghoursBtn, volunteerTimelineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serve);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Serve");
        }
        sparkQRBtn = findViewById(R.id.btn_qr);
        loghoursBtn = findViewById(R.id.btn_loghours);
        volunteerTimelineBtn = findViewById(R.id.btn_volunteer_history);

        sparkQRBtn.setOnClickListener(view -> {
            Intent it = new Intent(ServeActivity.this, QRActivity.class);
            startActivity(it);
        });

        loghoursBtn.setOnClickListener(view -> {
            Intent it = new Intent(ServeActivity.this, ChooseCharityActivity.class);
            it.putExtra("nextActivity", "LogVolunteerActivity");
            startActivity(it);
        });

        volunteerTimelineBtn.setOnClickListener(view -> {
            Intent it = new Intent(ServeActivity.this, TimelineActivity.class);
            it.putExtra("timelineType", 1);
            startActivity(it);
        });
    }
}
