package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.Group;

public class GroupActivity extends ToolbarDrawerActivity {
    TextView groupNameTv, sparksTv, dateTv;
    Button addMemberBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Groups");
        }
        groupNameTv = findViewById(R.id.tv_groupname);
        sparksTv = findViewById(R.id.tv_sparks);
        dateTv =findViewById(R.id.tv_date);
        Integer index = getIntent().getIntExtra("groupIndex",0 );
        Group group = Facade.getInstance().getGroups().get(index);
        groupNameTv.setText(group.getName());
        sparksTv.setText(""+group.getGroupsSparks());
        dateTv.setText(""+group.getDate());

        addMemberBtn = findViewById(R.id.btn_addmember);

    }
}
