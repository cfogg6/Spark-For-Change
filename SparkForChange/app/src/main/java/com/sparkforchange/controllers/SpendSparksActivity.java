package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;

public class SpendSparksActivity extends ToolbarDrawerActivity {

    TextView availableSparks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend_sparks);

        availableSparks = findViewById(R.id.tv_sparks);
        availableSparks.setText("" + Facade.getInstance().getCurrentUser().getSparkBalance());
    }
}
