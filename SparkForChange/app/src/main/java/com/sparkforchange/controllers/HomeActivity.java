package com.sparkforchange.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.sparkforchange.R;

public class HomeActivity extends ToolbarDrawerActivity {

    Button donateBtn, serveBtn, spendSparksBtn, profileBtn, groupsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Home");
        }
        donateBtn = findViewById(R.id.btn_home_donate);
        serveBtn = findViewById(R.id.btn_home_serve);
        spendSparksBtn = findViewById(R.id.btn_home_sendsparks);
        profileBtn = findViewById(R.id.btn_home_profile);
        groupsBtn = findViewById(R.id.btn_groups);

        donateBtn.setOnClickListener(view -> {
            Intent it = new Intent(HomeActivity.this, ChooseCharityActivity.class);
            it.putExtra("nextActivity", "DonateActivity");
            startActivity(it);
        });

        serveBtn.setOnClickListener(view -> {
            Intent it = new Intent(HomeActivity.this, ServeActivity.class);
            startActivity(it);
        });

        spendSparksBtn.setOnClickListener(view -> {
            Intent it = new Intent(HomeActivity.this, ChooseCharityActivity.class);
            it.putExtra("nextActivity", "SpendSparksActivity");
            startActivity(it);
        });

        profileBtn.setOnClickListener(view -> {
            Intent it = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(it);
        });

        groupsBtn.setOnClickListener(view -> {
            Intent it = new Intent(HomeActivity.this, ManageGroupsActivity.class);
            startActivity(it);
        });
    }
}
