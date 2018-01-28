package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;

public class ManageGroupsActivity extends ToolbarDrawerActivity {
    Button createGroupBtn;

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
                startActivity(it);
            }
        });
    }
}
