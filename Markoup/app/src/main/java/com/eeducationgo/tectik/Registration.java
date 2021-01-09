package com.eeducationgo.tectik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.eeducationgo.tectik.databinding.ActivityRegistrationBinding;
import com.google.android.material.textfield.TextInputEditText;

public class Registration extends AppCompatActivity {

    Button login, register, nextRegister, nextConfirmation, nextEmailRegistration, nextFinalRegistration;
    String state = "";
    LinearLayout containerLogin, containerRegister, containerConfirmation, containerEmailRegistration, containerFinalRegistration;
    TextInputEditText first, second, third, fourth, displayName;
    ProgressBar progress;

    private ActivityRegistrationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(Registration.this ,R.layout.activity_registration);

        linkUp();

    }

    private void linkUp() {
        state = "login";
        login = findViewById(R.id.button_login);
        register = findViewById(R.id.button_register_new_user);
        containerLogin = findViewById(R.id.container_login);
        containerRegister = findViewById(R.id.content_register_new_account);
        containerConfirmation = findViewById(R.id.container_confirm_phone_number);
        nextRegister = findViewById(R.id.button_next_register_new_account);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
            }
        });
        register.setOnClickListener(view -> {
           // performRegister();
            startActivity(new Intent(getBaseContext() , PhoneActivity.class));
        });

        binding.buttonRegisterCompany.setOnClickListener(v -> startActivity(new Intent(getBaseContext() , PhoneActivity.class)));


        nextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performNextRegister();
            }
        });

    }

    private void performLogin() {
        startActivity(new Intent(Registration.this, MainActivity.class));
    }

    private void performRegister() {
        state = "register";
        containerLogin.setVisibility(View.GONE);
        containerRegister.setVisibility(View.VISIBLE);
    }

    private void performNextRegister() {
        state = "confirm";
        containerRegister.setVisibility(View.GONE);
        containerConfirmation.setVisibility(View.VISIBLE);
        confirmation();
    }

    private void confirmation() {
        first = findViewById(R.id.first_digit);
        second = findViewById(R.id.second_digit);
        third = findViewById(R.id.third_digit);
        fourth = findViewById(R.id.fourth_digit);
        progress = findViewById(R.id.progress);
        nextConfirmation = findViewById(R.id.button_next_confirm_phone_number);
        containerConfirmation = findViewById(R.id.container_confirm_phone_number);
        containerEmailRegistration = findViewById(R.id.container_email_registeration);
        containerFinalRegistration = findViewById(R.id.container_final_registration);


        first.requestFocus();
        first.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    second.setEnabled(true);
                    second.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        second.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    third.setEnabled(true);
                    third.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        third.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    fourth.setEnabled(true);
                    fourth.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        nextConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = "email_registration";
                containerConfirmation.setVisibility(View.GONE);
                containerEmailRegistration.setVisibility(View.VISIBLE);
                emailRegistration();
            }
        });
    }

    private void emailRegistration() {
        nextEmailRegistration = findViewById(R.id.button_next_email_registeration);
        nextEmailRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = "final_registration";
                containerEmailRegistration.setVisibility(View.GONE);
                containerFinalRegistration.setVisibility(View.VISIBLE);
                finalRegistration();
            }
        });
    }

    private void finalRegistration() {
        nextFinalRegistration = findViewById(R.id.next_final_registration);
        nextFinalRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        switch (state) {
            case "login":
                super.onBackPressed();
                break;
            case "register":
                state = "login";
                containerLogin.setVisibility(View.VISIBLE);
                containerRegister.setVisibility(View.GONE);
                break;
            case "confirm":
                state = "register";
                containerRegister.setVisibility(View.VISIBLE);
                containerConfirmation.setVisibility(View.GONE);
                break;
            case "email_registration":
                state = "confirm";
                containerConfirmation.setVisibility(View.VISIBLE);
                containerEmailRegistration.setVisibility(View.GONE);
                break;
            case "final_registration":
                state = "email_registration";
                containerEmailRegistration.setVisibility(View.VISIBLE);
                containerFinalRegistration.setVisibility(View.GONE);
                break;
        }

    }
}