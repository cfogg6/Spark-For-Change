package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.SearchView;

import com.sparkforchange.R;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String query = getIntent().getStringExtra("query");
        SearchView sv = findViewById(R.id.sv_search);
        sv.setQuery(query, false);
        sv.setFocusable(false);
        sv.setIconified(false);
        sv.clearFocus();
        sv.setFocusable(true);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                update(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        rv = findViewById(R.id.rv_search_results);
        rv.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        update(query);
    }

    private void update(String query) {
        final SearchRecyclerViewAdapter adapter = new SearchRecyclerViewAdapter(query);
        rv.setAdapter(adapter);
        (rv.getAdapter()).notifyDataSetChanged();
    }
}
