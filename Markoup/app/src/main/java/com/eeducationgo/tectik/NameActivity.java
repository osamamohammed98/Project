package com.eeducationgo.tectik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eeducationgo.tectik.databinding.ActivityNameBinding;

public class NameActivity extends AppCompatActivity {

    private ActivityNameBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(NameActivity.this ,R.layout.activity_name);
        binding.buttonNextEmailRegisteration.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext() , CarTypeActivity.class));
        });
    }
}