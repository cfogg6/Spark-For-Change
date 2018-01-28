package com.sparkforchange.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sparkforchange.R;
import com.sparkforchange.model.Charity;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.User;

public class SpendSparksActivity extends ToolbarDrawerActivity {

    TextView availableSparks;
    TextView charityView;
    Button spendBtn;
    EditText sparkAmountText;
    Button historyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend_sparks);

        int charityIndex = getIntent().getIntExtra("charityIndex", 0);
        Charity charity = Facade.getInstance().getCharities().get(charityIndex);
        User user = Facade.getInstance().getCurrentUser();
        availableSparks = findViewById(R.id.tv_sparks);
        availableSparks.setText("" + user.getSparkBalance());
        charityView = findViewById(R.id.tv_spend_charity);
        charityView.setText(charity.getName());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Spend Sparks");
        }

        historyBtn = findViewById(R.id.btn_spend_sparks_viewhistory);

        spendBtn = findViewById(R.id.btn_spend_now);
        sparkAmountText = findViewById(R.id.et_spend_sparks);
        historyBtn.setOnClickListener(view -> {
            Intent it = new Intent(SpendSparksActivity.this, TimelineActivity.class);
            startActivity(it);
        });


        spendBtn.setOnClickListener(view -> {
            String number = sparkAmountText.getText().toString();
            if(number.equals("")) {
                Toast.makeText(getApplicationContext(), "Enter in a valid number...plz",
                        Toast.LENGTH_SHORT).show();
            } else {
                int sparks = Integer.parseInt(number);
                if(sparks > user.getSparkBalance()) {
                    Toast.makeText(getApplicationContext(), "Bruh... You aren't Sparkly enough.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Facade.getInstance().makeSparkDonation(user, charity.getCompaniesSponsoring().get(0), charity, sparks);
                    Toast.makeText(getApplicationContext(), "Tran$action proce$$ed",
                            Toast.LENGTH_LONG).show();
                    Intent it = new Intent(SpendSparksActivity.this, HomeActivity.class);
                    startActivity(it);
                }
            }



        });
    }
}
