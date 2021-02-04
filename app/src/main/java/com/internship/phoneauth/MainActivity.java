package com.internship.phoneauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    EditText phone;
    Button sendotp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryCodePicker = findViewById(R.id.countryCodePicker);
        phone = findViewById(R.id.phone_no);
        countryCodePicker.registerCarrierNumberEditText(phone);
        sendotp = findViewById(R.id.send_otp);

        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                intent.putExtra("mobile", countryCodePicker.getFullNumberWithPlus().replace(" ",""));
                startActivity(intent);
            }
        });

    }
}