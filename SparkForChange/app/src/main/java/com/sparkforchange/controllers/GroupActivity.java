package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.Group;

public class GroupActivity extends ToolbarDrawerActivity {
    TextView groupNameTv, sparksTv, dateTv;
    Button addMemberBtn;
    EditText newmembernameEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Groups");
        }
        groupNameTv = findViewById(R.id.tv_groupname);
        sparksTv = findViewById(R.id.tv_sparks);

        dateTv = findViewById(R.id.tv_date);
        String groupName = getIntent().getStringExtra("groupKey");
        Group group = Facade.getInstance().getGroupByName(groupName);
        groupNameTv.setText(group.getName());
        sparksTv.setText("Sparks gained: " + group.getGroupsSparks());
        dateTv.setText("Created: "+group.getDate());

        final MemberRvAdapter groupsAdapter = new MemberRvAdapter(groupName);
        RecyclerView rvMembers = findViewById(R.id.rv_members);
        rvMembers.setHasFixedSize(true);
        final LinearLayoutManager llmGroups = new LinearLayoutManager(this);
        llmGroups.setOrientation(LinearLayoutManager.VERTICAL);
        rvMembers.setLayoutManager(llmGroups);

        rvMembers.setAdapter(groupsAdapter);
        (rvMembers.getAdapter()).notifyDataSetChanged();
        groupsAdapter.dataSetChanged();

        newmembernameEt = findViewById(R.id.et_newmembername);
        addMemberBtn = findViewById(R.id.btn_addmember);
        addMemberBtn.setOnClickListener(view -> {
            Facade.getInstance().addUserToGroup(group,newmembernameEt.getText().toString() );
            // group.addUser(Facade.getInstance().getUserByEmail(newmembernameEt.getText().toString()));
            Toast.makeText(getApplicationContext(), "Added new member",
                    Toast.LENGTH_SHORT).show();
            newmembernameEt.setText("");
            groupsAdapter.dataSetChanged();

        });



    }


}
