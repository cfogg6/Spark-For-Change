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
import com.sparkforchange.model.Charity;
import com.sparkforchange.model.Facade;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DonateActivity extends ToolbarDrawerActivity {
    Button updateBtn, donateBtn;
    TextView charityTv;
    EditText amountEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Donate");
        }

        String charityKey = getIntent().getStringExtra("charityKey");
        Charity charity = Facade.getInstance().getCharityByName(charityKey);
        charityTv = findViewById(R.id.tv_charity);
        charityTv.setText(charity.getName());
        updateBtn = findViewById(R.id.btn_update_payment);
        donateBtn = findViewById(R.id.btn_donate);
        amountEt = findViewById(R.id.et_donate_dollar_amount);
        updateBtn.setOnClickListener(view -> {
            Intent intent = new Intent(DonateActivity.this, PaymentMethodActivity.class);
            startActivityForResult(intent, 1);
        });
        donateBtn.setOnClickListener(view -> {
            Intent intent = new Intent(DonateActivity.this, HomeActivity.class);
            double amount;
            if (amountEt.getText().toString().length() <= 1) {
                amount = 0;
            } else {
                amount = Double.parseDouble(amountEt.getText().toString().substring(1));
            }
            Facade.getInstance().getCurrentUser().addDonation(charity, amount);
            Toast.makeText(getApplicationContext(), "Donation sent!", Toast.LENGTH_LONG).show();
            startActivity(intent);
        });

        amountEt.addTextChangedListener(new NumberTextWatcher(amountEt, "#,###"));
    }
}

class NumberTextWatcher implements TextWatcher {

    private final DecimalFormat df;
    private final DecimalFormat dfnd;
    private final EditText et;
    private boolean hasFractionalPart;
    private int trailingZeroCount;

    public NumberTextWatcher(EditText editText, String pattern) {
        df = new DecimalFormat(pattern);
        df.setDecimalSeparatorAlwaysShown(true);
        dfnd = new DecimalFormat("#,###.00");
        this.et = editText;
        hasFractionalPart = false;
    }

    @Override
    public void afterTextChanged(Editable s) {
        et.removeTextChangedListener(this);

        if (s != null && !s.toString().isEmpty()) {
            try {
                int inilen, endlen;
                inilen = et.getText().length();
                String v = s.toString().replace(String.valueOf(df.getDecimalFormatSymbols().getGroupingSeparator()), "").replace("$","");
                Number n = df.parse(v);
                int cp = et.getSelectionStart();
                if (hasFractionalPart) {
                    StringBuilder trailingZeros = new StringBuilder();
                    while (trailingZeroCount-- > 0)
                        trailingZeros.append('0');
                    et.setText(df.format(n) + trailingZeros.toString());
                } else {
                    et.setText(dfnd.format(n));
                }
                et.setText("$".concat(et.getText().toString()));
                endlen = et.getText().length();
                int sel = (cp + (endlen - inilen));
                if (sel > 0 && sel < et.getText().length()) {
                    et.setSelection(sel);
                } else if (trailingZeroCount > -1) {
                    et.setSelection(et.getText().length() - 3);
                } else {
                    et.setSelection(et.getText().length());
                }
            } catch (NumberFormatException | ParseException e) {
                e.printStackTrace();
            }
        }

        et.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        int index = s.toString().indexOf(String.valueOf(df.getDecimalFormatSymbols().getDecimalSeparator()));
        trailingZeroCount = 0;
        if (index > -1) {
            for (index++; index < s.length(); index++) {
                if (s.charAt(index) == '0')
                    trailingZeroCount++;
                else {
                    trailingZeroCount = 0;
                }
            }
            hasFractionalPart = true;
        } else {
            hasFractionalPart = false;
        }
    }
}