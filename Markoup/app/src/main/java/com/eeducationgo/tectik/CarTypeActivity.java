package com.eeducationgo.tectik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eeducationgo.tectik.databinding.ActivityCarTypeBinding;

public class CarTypeActivity extends AppCompatActivity {

    private ActivityCarTypeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(CarTypeActivity.this , R.layout.activity_car_type);
        binding.buttonNextEmailRegisteration.setOnClickListener(v -> startActivity(new Intent(getBaseContext() , IDActivity.class)));
    }
}