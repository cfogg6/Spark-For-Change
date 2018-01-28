package com.sparkforchange.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.sparkforchange.R;

public class DonateActivity extends ToolbarDrawerActivity {
    Button updateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Donate");
        }
        updateBtn = findViewById(R.id.btn_update_payment);
        updateBtn.setOnClickListener(view -> {
            Intent intent = new Intent(DonateActivity.this, PaymentMethodActivity.class);
            startActivityForResult(intent, 1);
        });
    }
}
