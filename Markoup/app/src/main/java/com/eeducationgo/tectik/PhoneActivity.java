package com.eeducationgo.tectik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eeducationgo.tectik.databinding.ActivityPhoneBinding;

public class PhoneActivity extends AppCompatActivity {
private ActivityPhoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(PhoneActivity.this ,R.layout.activity_phone);
        binding.buttonNextRegisterNewAccount.setOnClickListener(v -> startActivity(new Intent(getBaseContext() , CodeVarActivity.class)));
    }
}