package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.User;

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
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonateActivity.this, PaymentMethodActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }
}
