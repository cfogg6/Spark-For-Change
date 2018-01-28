package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;

public class ManageGroupsActivity extends ToolbarDrawerActivity {
    Button createGroupBtn;
    final GroupRecyclerViewAdapter groupsAdapter = new GroupRecyclerViewAdapter();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_groups);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("New Group");
        }
        createGroupBtn = findViewById(R.id.btn_manage_groups_create);
       createGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(ManageGroupsActivity.this, CreateGroupActivity.class);
                startActivityForResult(it, 1);
                groupsAdapter.notifyDataSetChanged();
            }
        });

        RecyclerView rvGroups = findViewById(R.id.rv_groups);
        rvGroups.setHasFixedSize(true);
        final LinearLayoutManager llmGroups = new LinearLayoutManager(this);
        llmGroups.setOrientation(LinearLayoutManager.VERTICAL);
        rvGroups.setLayoutManager(llmGroups);

        rvGroups.setAdapter(groupsAdapter);
        (rvGroups.getAdapter()).notifyDataSetChanged();
    }
}
