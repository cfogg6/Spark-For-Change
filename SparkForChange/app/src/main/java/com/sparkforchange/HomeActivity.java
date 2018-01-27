package com.sparkforchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button donateBtn, volunteerBtn, redeemBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        donateBtn = findViewById(R.id.btn_donate);
        volunteerBtn = findViewById(R.id.btn_volunteer);
        redeemBtn = findViewById(R.id.btn_redeem);
    }
}
