package com.sparkforchange.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.User;

public class PaymentMethodActivity extends AppCompatActivity {
    Button updateBtn;
    EditText addressEt;
    EditText creditCardEt;
    EditText cvvEt;
    EditText expDateEt;
    EditText paymentNameEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Payment Method");
        }

        addressEt = findViewById(R.id.et_address);
        creditCardEt = findViewById(R.id.et_creditcard);
        cvvEt = findViewById(R.id.et_cvv);
        expDateEt = findViewById(R.id.et_expiration_date);
        paymentNameEt = findViewById(R.id.et_name);
        User curUser = Facade.getInstance().getCurrentUser();
        if (curUser.getAddress() != null)
            addressEt.setText(curUser.getAddress());
        if (curUser.getCreditCard() != null)
            creditCardEt.setText(curUser.getCreditCard());
        if (curUser.getCvv() != null)
            cvvEt.setText(curUser.getCvv());
        if (curUser.getExpDate() != null)
            expDateEt.setText(curUser.getExpDate());
        if (curUser.getPaymentName() != null)
            paymentNameEt.setText(curUser.getPaymentName());

        updateBtn = findViewById(R.id.btn_update);
        updateBtn.setOnClickListener(view -> {
            User currentUser = Facade.getInstance().getCurrentUser();
            currentUser.setAddress(addressEt.getText().toString());
            currentUser.setCreditCard(creditCardEt.getText().toString());
            currentUser.setCvv(cvvEt.getText().toString());
            currentUser.setExpDate(expDateEt.getText().toString());
            currentUser.setPaymentName(paymentNameEt.getText().toString());
            Toast.makeText(getApplicationContext(), "$$$ Payment Method Updated $$$",
                    Toast.LENGTH_LONG).show();
            finish();
        });
    }
}
