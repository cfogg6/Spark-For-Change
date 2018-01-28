package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        sparkQRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ServeActivity.this, QRActivity.class);
                startActivity(it);
            }
        });

        loghoursBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ServeActivity.this, LogVolunteerActivity.class);
                startActivity(it);
            }
        });

        volunteerTimelineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ServeActivity.this, TimelineActivity.class);
                startActivity(it);
            }
        });
    }
}
