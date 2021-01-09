package com.eeducationgo.tectik.registration.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.eeducationgo.tectik.MainActivity;
import com.eeducationgo.tectik.phone.view.PhoneActivity;
import com.eeducationgo.tectik.R;
import com.eeducationgo.tectik.databinding.ActivityRegistrationBinding;
import com.eeducationgo.tectik.registration.presenter.RegistrationPresenter;
import com.eeducationgo.tectik.util.BaseActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends BaseActivity implements RegistrationView {

    /* Button login, register, nextRegister, nextConfirmation, nextEmailRegistration, nextFinalRegistration;
     String state = "";
     LinearLayout containerLogin, containerRegister, containerConfirmation, containerEmailRegistration, containerFinalRegistration;
     TextInputEditText first, second, third, fourth, displayName;
     ProgressBar progress;
 */
    private ActivityRegistrationBinding binding;
    private RegistrationPresenter presenter;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(Registration.this, R.layout.activity_registration);

        //linkUp();

        init();
        initListener();
    }

    private void init() {
        presenter = new RegistrationPresenter(this, this);
        auth = FirebaseAuth.getInstance();
    }

    private void initListener() {
        loginBtn();
        newDriverBtn();
        companyBtn();
    }

    private void companyBtn() {
        binding.buttonRegisterNewUser.setOnClickListener(v -> startActivity(new Intent(getBaseContext() , PhoneActivity.class)));
    }

    private void newDriverBtn() {
        binding.buttonRegisterCompany.setOnClickListener(v -> startActivity(new Intent(getBaseContext() , PhoneActivity.class)));
    }

    private void loginBtn() {
        binding.buttonLogin.setOnClickListener(v -> {
            presenter.validationInput(binding.inputUsername, binding.inputPassword, auth);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(getBaseContext(), MainActivity.class));
            finish();
        }
    }

    @Override
    public void showErrorMessage(String message) {
        super.showErrorMessage(message);
        snackErrorShow(binding.getRoot(), message);
    }

    @Override
    public void showSuccessMessage(String message) {
        snackSuccessShow(binding.getRoot(), message);
    }


}