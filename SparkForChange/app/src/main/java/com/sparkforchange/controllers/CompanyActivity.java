package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;
import com.sparkforchange.model.Company;
import com.sparkforchange.model.Facade;

public class CompanyActivity extends ToolbarDrawerActivity {
    TextView blurbTv, websiteTv, charititesTv, amountTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        String companyKey = getIntent().getStringExtra("companyKey");
        Company c = Facade.getInstance().getCompanyByName(companyKey);
        blurbTv = findViewById(R.id.tv_blurb);
        websiteTv = findViewById(R.id.tv_website);
        charititesTv = findViewById(R.id.tv_charity_list);
        amountTv = findViewById(R.id.tv_amount);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(c.getName());
        }
        blurbTv.setText(c.getDescription());
        websiteTv.setText(c.getLink());
        StringBuilder charities = new StringBuilder();
        for (Charity charity : c.getCharityList()) {
            charities.append(charity.getName()).append("\n");
        }
        if (charities.length() > 0) {
            charities = new StringBuilder(charities.substring(0, charities.length() - 1));
        }
        charititesTv.setText(charities.toString());
        amountTv.setText("Donated " + c.getSparkBalance() + " Sparks.");
        TextView empSparkstv = findViewById(R.id.tv_employeesparks);
        empSparkstv.setText("Employees have gained " + Facade.getInstance().getCompanyByName(companyKey).getEmployeeSparks() + " Sparks");
    }
}
