package com.sparkforchange.controllers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.Group;

public class CreateGroupActivity extends ToolbarDrawerActivity {
    Button addCreateGroupBtn;
    EditText nameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("New Group");
        }
        addCreateGroupBtn = findViewById(R.id.btn_createGroup);
        nameEt = findViewById(R.id.et_group_name);

        addCreateGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Facade.getInstance().getGroupByName(nameEt.getText().toString()) == null) {
                    Facade.getInstance().createGroup(nameEt.getText().toString());
                }
                Toast.makeText(getApplicationContext(), "Group Created",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
