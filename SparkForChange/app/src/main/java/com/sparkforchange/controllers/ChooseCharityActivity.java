package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;

import java.util.ArrayList;
import java.util.List;

public class ChooseCharityActivity extends AppCompatActivity {

    private final List<Charity> charities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_charity);
        ListView lv = findViewById(R.id.lv_choose_charity_charities);

    }
}
