package com.sparkforchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class HomeActivity extends AppCompatActivity {

    Button donateBtn, volunteerBtn, redeemBtn, profileBtn, settingsBtn;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        donateBtn = findViewById(R.id.btn_donate);
        volunteerBtn = findViewById(R.id.btn_volunteer);
        redeemBtn = findViewById(R.id.btn_redeem);
        profileBtn = findViewById(R.id.btn_profile);
        settingsBtn = findViewById(R.id.btn_settings);
        searchView = findViewById(R.id.sv_search);

        donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
