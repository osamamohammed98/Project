package com.eeducationgo.tectik.social.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eeducationgo.tectik.NameActivity;
import com.eeducationgo.tectik.R;
import com.eeducationgo.tectik.databinding.ActivitySocialBinding;
import com.eeducationgo.tectik.social.presenter.SocialPresenter;
import com.eeducationgo.tectik.util.BaseActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SocialActivity extends BaseActivity implements SocialView {

    private ActivitySocialBinding binding;
    private FirebaseAuth auth;
    private SocialPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(SocialActivity.this , R.layout.activity_social);


        init();
        initLisetenr();
        /*binding.buttonNextEmailRegisteration.setOnClickListener(v -> {
            startActivity(new Intent(getBaseContext() , NameActivity.class));
        });*/
    }

    private void initLisetenr() {
        registerBtn();
    }

    private void registerBtn() {
        binding.buttonNextEmailRegisteration.setOnClickListener(v -> presenter.validationInput(binding.inputUserEmail, binding.inputPassword, auth));

    }

    private void init() {
        presenter = new SocialPresenter(this , this);
        auth = FirebaseAuth.getInstance();
    }
}