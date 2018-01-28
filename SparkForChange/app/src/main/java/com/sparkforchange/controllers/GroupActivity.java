package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;

public class GroupActivity extends ToolbarDrawerActivity {
    TextView groupNameTv, sparksTv, dateTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Groups");
        }
        groupNameTv = findViewById(R.id.tv_groupname);
        Integer index = 0;
        Facade.getInstance().getGroups().get(index).getName();
        groupNameTv.setText(Facade.getInstance().getGroups().get(index).getName());
        sparksTv.setText(Facade.getInstance().getGroups().get(index).getGroupsSparks());
        dateTv.setText(Facade.getInstance().getGroups().get(index).getDate());
    }
}
