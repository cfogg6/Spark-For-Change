package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;
import com.sparkforchange.model.Company;
import com.sparkforchange.model.Facade;

public class CharityActivity extends ToolbarDrawerActivity {
    TextView blurbTv, websiteTv, raisedTv, companyListTv, sponsoredTv;
    Button donateBtn, volunteerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity);
        String charityKey = getIntent().getStringExtra("charityKey");
        Charity charity = Facade.getInstance().getCharityByName(charityKey);
        blurbTv = findViewById(R.id.tv_blurb);
        websiteTv = findViewById(R.id.tv_website);
        raisedTv = findViewById(R.id.tv_raised);
        companyListTv = findViewById(R.id.tv_company_list);
        donateBtn = findViewById(R.id.btn_donate);
        volunteerBtn = findViewById(R.id.btn_volunteer);
        sponsoredTv = findViewById(R.id.tv_charity_sponsored_companies);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(charity.getName());
        }
        blurbTv.setText("Charity description: " + charity.getDescription());
        websiteTv.setText("Website: " + charity.getWebsite());
        raisedTv.setText("Funds raised: " + String.valueOf(charity.getRaisedSparks()));
        StringBuilder sponsoredCompanies = new StringBuilder();
        for (Company c: charity.getCompaniesSponsoring()) {
            sponsoredCompanies.append(c.getName()).append("\n");
        }
        sponsoredTv.setText(sponsoredCompanies.toString());
        donateBtn.setOnClickListener(view -> {
            Intent intent = new Intent(CharityActivity.this, DonateActivity.class);
            intent.putExtra("charityKey", charity.getName());
            startActivity(intent);
        });

        volunteerBtn.setOnClickListener(view -> {
            Intent intent = new Intent(CharityActivity.this, LogVolunteerActivity.class);
            intent.putExtra("charityKey", charity.getName());
            startActivity(intent);
        });
    }
}
