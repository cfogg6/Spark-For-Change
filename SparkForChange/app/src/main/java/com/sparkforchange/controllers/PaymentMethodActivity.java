package com.sparkforchange.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sparkforchange.R;
import com.sparkforchange.model.Facade;
import com.sparkforchange.model.User;

public class PaymentMethodActivity extends AppCompatActivity {
    Button updateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        updateBtn = findViewById(R.id.btn_update);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User curUser = Facade.getInstance().getCurrentUser();
                EditText et = findViewById(R.id.et_address);
                curUser.setAddress(et.getText().toString());
                et = findViewById(R.id.et_creditcard);
                curUser.setCreditCard(et.getText().toString());
                et = findViewById(R.id.et_cvv);
                curUser.setCvv(et.getText().toString());
                et = findViewById(R.id.et_expiration_date);
                curUser.setExpDate(et.getText().toString());
                et = findViewById(R.id.et_name);
                curUser.setPaymentName(et.getText().toString());

                Toast.makeText(getApplicationContext(), "$$$ Payment Method Updated $$$",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
