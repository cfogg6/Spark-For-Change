package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.sparkforchange.R;

public class HomeActivity extends ToolbarDrawerActivity {

    Button donateBtn, volunteerBtn, redeemBtn, profileBtn;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        donateBtn = findViewById(R.id.btn_home_donate);
        volunteerBtn = findViewById(R.id.btn_home_serve);
        redeemBtn = findViewById(R.id.btn_home_sendsparks);
        profileBtn = findViewById(R.id.btn_home_profile);
        searchView = findViewById(R.id.sv_home_search);

        donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        volunteerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        redeemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
