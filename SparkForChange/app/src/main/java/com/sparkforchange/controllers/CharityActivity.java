package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;
import com.sparkforchange.model.Facade;

public class CharityActivity extends ToolbarDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity);
        String charityKey = getIntent().getStringExtra("charityKey");
        //TODO: use the charity email to fill charity info
        Charity c = Facade.getInstance().getCharityByName(charityKey);
    }
}
