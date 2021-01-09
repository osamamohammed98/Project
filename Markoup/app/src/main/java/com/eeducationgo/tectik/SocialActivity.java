package com.eeducationgo.tectik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eeducationgo.tectik.databinding.ActivitySocialBinding;

public class SocialActivity extends AppCompatActivity {

    private ActivitySocialBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(SocialActivity.this , R.layout.activity_social);
        binding.buttonNextEmailRegisteration.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext() , NameActivity.class));
        });
    }
}