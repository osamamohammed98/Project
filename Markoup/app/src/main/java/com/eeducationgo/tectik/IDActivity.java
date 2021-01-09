package com.eeducationgo.tectik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eeducationgo.tectik.databinding.ActivityIDBinding;

public class IDActivity extends AppCompatActivity {

    private ActivityIDBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(IDActivity.this ,R.layout.activity_i_d);
        binding.buttonNextEmailRegisteration.setOnClickListener(v -> startActivity(new Intent(getBaseContext() , MainActivity.class)));
    }
}