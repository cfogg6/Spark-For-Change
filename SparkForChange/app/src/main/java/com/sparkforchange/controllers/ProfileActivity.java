package com.sparkforchange.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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

        Button volunteerHistoryBtn = findViewById(R.id.btn_timeline);
        Button updateBtn = findViewById(R.id.btn_payment_method);
        TextView tvCurrentSparks = findViewById(R.id.tv_current_sparks);
        TextView tvLifetimeSparks = findViewById(R.id.tv_lifetime_sparks);
        TextView tvSparksToBadge = findViewById(R.id.tv_sparks_next_badge);

        volunteerHistoryBtn.setOnClickListener(view -> {
            startActivity(new Intent(ProfileActivity.this, TimelineActivity.class));
        });

        updateBtn.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, PaymentMethodActivity.class);
            startActivityForResult(intent, 1);
        });

        User currentUser = Facade.getInstance().getCurrentUser();

        // set spark balance info
        tvCurrentSparks.setText(getString(R.string.current_sparks, currentUser.getSparkBalance()));
        tvLifetimeSparks.setText(getString(R.string.lifetime_sparks, currentUser.getSparkLifetimeTotal()));
        tvSparksToBadge.setText(getString(R.string.sparks_to_next_badge, 10));
    }
}
