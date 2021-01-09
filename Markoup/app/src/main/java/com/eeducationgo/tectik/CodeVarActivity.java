package com.eeducationgo.tectik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eeducationgo.tectik.databinding.ActivityCodeVarBinding;

public class CodeVarActivity extends AppCompatActivity {

    private ActivityCodeVarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(CodeVarActivity.this ,R.layout.activity_code_var);
        binding.buttonNextRegisterNewAccount.setOnClickListener(v -> startActivity(new Intent(getBaseContext() , NameActivity.class)));
    }
}