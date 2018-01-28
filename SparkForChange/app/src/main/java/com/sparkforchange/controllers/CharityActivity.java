package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;
import com.sparkforchange.model.Facade;

public class CharityActivity extends ToolbarDrawerActivity {
    TextView blurbTv, websiteTv, raisedTv, companyListTv;
    Button donateBtn, volunteerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity);
        String charityKey = getIntent().getStringExtra("charityKey");
        Charity charity = Facade.getInstance().getCharityByName(charityKey);
        int charityIndex = getIntent().getIntExtra("charityIndex", 0);
        blurbTv = findViewById(R.id.tv_blurb);
        websiteTv = findViewById(R.id.tv_website);
        raisedTv = findViewById(R.id.tv_raised);
        companyListTv = findViewById(R.id.tv_company_list);
        donateBtn = findViewById(R.id.btn_donate);
        volunteerBtn = findViewById(R.id.btn_volunteer);
        blurbTv.setText(charity.getDescription());
        websiteTv.setText(charity.getWebsite());
        raisedTv.setText(String.valueOf(charity.getRaisedSparks()));

        donateBtn.setOnClickListener(view -> {
            Intent intent = new Intent(CharityActivity.this, DonateActivity.class);
            intent.putExtra("charityIndex", charityIndex);
            startActivity(intent);
        });

        volunteerBtn.setOnClickListener(view -> {
            Intent intent = new Intent(CharityActivity.this, LogVolunteerActivity.class);
            intent.putExtra("charityIndex", charityIndex);
            startActivity(intent);
        });
    }
}
