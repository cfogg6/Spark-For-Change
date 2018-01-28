package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;

import java.util.ArrayList;
import java.util.List;

public class ChooseCharityActivity extends AppCompatActivity {

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
        final CharityListviewAdapter adapter = new CharityListviewAdapter();
        rv.setAdapter(adapter);
        (rv.getAdapter()).notifyDataSetChanged();
    }
}
