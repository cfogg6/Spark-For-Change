package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;

public class LogVolunteerActivity extends AppCompatActivity {

    Button submitBtn;
    EditText hoursEt;
    TextView charityTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_volunteer);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Volunteer Hours");
        }
        submitBtn = findViewById(R.id.btn_submit);
        hoursEt = findViewById(R.id.et_num_hours);
        charityTv = findViewById(R.id.tv_loghours_volunteer);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(LogVolunteerActivity.this, HomeActivity.class);
                Facade.getInstance().getCurrentUser().addHours(Facade.getInstance().getCharityByName(charityTv.getText().toString()),
                        Integer.parseInt(hoursEt.getText().toString()));
                startActivity(it);
            }
        });
    }
}
