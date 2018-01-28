package com.sparkforchange.controllers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;

public class CreateGroupActivity extends ToolbarDrawerActivity {
    Button addMemberBtn;
    EditText nameEt, emailEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("New Group");
        }
        addMemberBtn = findViewById(R.id.btn_addmember);
        nameEt = findViewById(R.id.et_group_name);
        emailEt = findViewById(R.id.et_newmember);

        addMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Facade.getInstance().getGroupByName(nameEt.getText().toString()) != null) {
                    Facade.getInstance().createGroup(nameEt.getText().toString());
                }
                Facade.getInstance().getGroupByName(nameEt.getText().toString()).addUser(Facade.getInstance().getUserByEmail(emailEt.getText().toString()));
                emailEt.setTag("");
            }
        });
    }
}
