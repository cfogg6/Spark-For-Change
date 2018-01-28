package com.sparkforchange.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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
        String className = getIntent().getStringExtra("nextActivity");
        rv = (RecyclerView) findViewById(R.id.rv_choose_charity_charities);
        rv.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        final CharityRecycleViewAdapter adapter = new CharityRecycleViewAdapter(new Function<Context, Intent>() {
            @Override
            public Intent apply(Context context) {
                try {
                    Log.d("class", className);
                    return new Intent(context, Class.forName("com.sparkforchange.controllers." + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
        rv.setAdapter(adapter);
        (rv.getAdapter()).notifyDataSetChanged();
    }
}
