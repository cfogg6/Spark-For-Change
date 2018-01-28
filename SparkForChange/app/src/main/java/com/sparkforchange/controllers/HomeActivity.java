package com.sparkforchange.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.sparkforchange.R;

public class HomeActivity extends ToolbarDrawerActivity {

    Button donateBtn, serveBtn, spendSparksBtn, profileBtn;
    SearchView searchView;

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
        searchView = findViewById(R.id.sv_home_search);

        donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HomeActivity.this, DonateActivity.class);
                startActivity(it);
            }
        });

        serveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HomeActivity.this, ServeActivity.class);
                startActivity(it);
            }
        });

        spendSparksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HomeActivity.this, SpendSparksActivity.class);
                startActivity(it);
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(it);
            }
        });
    }
}
