package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;
import com.sparkforchange.model.Facade;

public class CompanyActivity extends ToolbarDrawerActivity {
    TextView blurbTv, websiteTv, charititesTv, amountTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        Integer index = 0;        
        blurbTv.setText(Facade.getInstance().getCompanies().get(index).getDescription());
        websiteTv.setText(Facade.getInstance().getCompanies().get(index).getLink());
        String charities = "";
        for (Charity charity : Facade.getInstance().getCompanies().get(index).getCharityList()) {
            charities += charity.getName() + ", ";
        }
        charities.substring(0, charities.length() - 2);
        charititesTv.setText(charities);
        amountTv.setText(Facade.getInstance().getCompanies().get(index).getSparkBalance());
    }
}
