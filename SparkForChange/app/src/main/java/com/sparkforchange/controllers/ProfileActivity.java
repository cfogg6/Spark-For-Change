package com.sparkforchange.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.User;

public class ProfileActivity extends ToolbarDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Profile");
        }

        User currentUser = Facade.getInstance().getCurrentUser();

        Button volunteerHistoryBtn = findViewById(R.id.btn_timeline);
        Button updateBtn = findViewById(R.id.btn_payment_method);
        TextView tvCurrentSparks = findViewById(R.id.tv_current_sparks);
        TextView tvLifetimeSparks = findViewById(R.id.tv_lifetime_sparks);
        TextView tvSparksToBadge = findViewById(R.id.tv_sparks_next_badge);
        EditText etemployer = findViewById(R.id.et_employer);
        Button employerBtn = findViewById(R.id.btn_updateemployer);

        volunteerHistoryBtn.setOnClickListener(view -> {
            Facade.getInstance().addFakeVolunteerData();
            startActivity(new Intent(ProfileActivity.this, TimelineActivity.class));
        });

        updateBtn.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, PaymentMethodActivity.class);
            startActivityForResult(intent, 1);
        });

        employerBtn.setOnClickListener(view -> {
            Facade.getInstance().getCurrentUser().editEmployer(etemployer.getText().toString(), Facade.getInstance().getCurrentUser());
            Toast.makeText(getApplicationContext(),"Updated your employer",
                    Toast.LENGTH_LONG).show();
        });

        // set spark balance info
        tvCurrentSparks.setText(getString(R.string.current_sparks, currentUser.getSparkBalance()));
        tvLifetimeSparks.setText(getString(R.string.lifetime_sparks, currentUser.getSparkLifetimeTotal()));
        tvSparksToBadge.setText(
                getString(
                        R.string.sparks_to_next_badge,
                        1000 - (currentUser.getSparkLifetimeTotal() % 1000)));
    }
}
