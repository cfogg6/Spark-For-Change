package com.sparkforchange.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;
import com.sparkforchange.model.Facade;

public class LogVolunteerActivity extends ToolbarDrawerActivity {

    Button submitBtn;
    EditText hoursEt;
    TextView charityTv;
    Charity charity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_volunteer);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Volunteer Hours");
        }
        int charityIndex = getIntent().getIntExtra("charityIndex", 0);
        charity = Facade.getInstance().getCharities().get(charityIndex);
        submitBtn = findViewById(R.id.btn_submit);
        hoursEt = findViewById(R.id.et_num_hours);
        charityTv = findViewById(R.id.tv_loghours_volunteer);

        charityTv.setText(charity.getName());
        submitBtn.setOnClickListener(view -> {
            Intent it = new Intent(LogVolunteerActivity.this, HomeActivity.class);
            if (hoursEt.length() > 0) {
                Facade.getInstance().getCurrentUser().addHours(Facade.getInstance().getCharityByName(charityTv.getText().toString()), Double.parseDouble(hoursEt.getText().toString()));
            }
            startActivity(it);
        });
    }
}
