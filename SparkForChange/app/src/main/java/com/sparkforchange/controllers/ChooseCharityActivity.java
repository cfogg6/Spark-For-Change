package com.sparkforchange.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;

import java.util.ArrayList;
import java.util.List;

public class ChooseCharityActivity extends ToolbarDrawerActivity {

    private final List<Charity> charities = new ArrayList<>();
    /**
     * Recycler View
     */
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_charity);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Charities");
        }
        rv = (RecyclerView) findViewById(R.id.rv_choose_charity_charities);
        rv.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        final CharityRecycleViewAdapter adapter = new CharityRecycleViewAdapter(context -> new Intent(context, CharityActivity.class));
        rv.setAdapter(adapter);
        (rv.getAdapter()).notifyDataSetChanged();
    }
}
