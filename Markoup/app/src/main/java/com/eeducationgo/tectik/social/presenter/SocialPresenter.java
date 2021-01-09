package com.eeducationgo.tectik.social.presenter;

import android.app.Activity;
import android.content.Intent;

import com.eeducationgo.tectik.MainActivity;
import com.eeducationgo.tectik.NameActivity;
import com.eeducationgo.tectik.R;
import com.eeducationgo.tectik.social.view.SocialView;
import com.eeducationgo.tectik.util.AppShareData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class SocialPresenter {
   private Activity activity;
   private SocialView view;

    public SocialPresenter(Activity activity, SocialView socialView) {
        this.activity = activity;
        this.view = socialView;
    }

    public void validationInput(TextInputEditText inputUserEmail, TextInputEditText inputPassword, FirebaseAuth auth) {

        clearError(inputUserEmail, inputPassword);
        if (AppShareData.checkIsEmptyEmailEdieText(inputUserEmail)) {
            AppShareData.errorInput(inputUserEmail, activity.getString(R.string.enter_email));
            return;
        }
        if (AppShareData.matcherTemplateEmailEditText(inputUserEmail)) {
            AppShareData.errorInput(inputUserEmail, activity.getString(R.string.matcher_email));
            return;
        }
        if (AppShareData.checkIsEmptyPasswordEdieText(inputPassword)) {
            AppShareData.errorInput(inputPassword, activity.getString(R.string.required_filed));
            return;
        }
        if (AppShareData.checkLengthOFTextPass(inputPassword)) {
            AppShareData.errorInput(inputPassword, activity.getString(R.string.password_matcher));
            return;
        }

        loginFirebase(inputUserEmail, inputPassword, auth);
    }

    private void loginFirebase(TextInputEditText inputUserEmail, TextInputEditText inputPassword, FirebaseAuth auth) {
        view.showProgress();
        String email = AppShareData.returnTextFromEditText(inputUserEmail);
        String password = AppShareData.returnTextFromEditText(inputPassword);
        try {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isComplete()) {
                    view.showSuccessMessage(task.toString());
                    activity.startActivity(new Intent(activity, NameActivity.class));
                    view.hideProgress();
                    activity.finish();
                }
            }).addOnFailureListener(e -> {
                view.showErrorMessage(e.toString());
                view.hideProgress();
            });
        } catch (Exception e) {
            e.printStackTrace();
            view.showErrorMessage(e.toString());
            view.hideProgress();
        }
    }

    private void clearError(TextInputEditText inputUserEmail, TextInputEditText inputPassword) {
        inputUserEmail.setError(null);
        inputPassword.setError(null);
    }
}
