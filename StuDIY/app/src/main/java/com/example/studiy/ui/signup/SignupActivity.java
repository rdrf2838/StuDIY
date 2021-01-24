package com.example.studiy.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.studiy.ui.signup.subject.SignupFragmentSubject;
import com.example.studiy.ui.signup.test.SignupFragmentTest;
import com.example.studiy.ui.signup.test.SignupFragmentTestresult;
import com.example.studiy.ui.signup.test.SignupViewModelTest;
import com.example.studiy.MainActivity;
import com.example.studiy.R;

public class SignupActivity extends AppCompatActivity {
    SignupViewModelTest stvm;
    SignupViewModelPerson svmp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stvm = new ViewModelProvider(this).get(SignupViewModelTest.class);
//        SignupViewModelTest.setSTVM(stvm);
        svmp = new ViewModelProvider(this).get(SignupViewModelPerson.class);

        setContentView(R.layout.signup_activity);
        if (savedInstanceState == null) {
            replace(R.id.signup_activity_container, SignupFragmentChoice.newInstance(), false);
        }

    }

    public void onSubjectButtonPressed(View view) {
        replace(R.id.signup_activity_container, SignupFragmentTest.newInstance(), true);
    }

    public void onChoiceButtonPressed(View view) {
        replace(R.id.signup_activity_container, SignupFragmentSubject.newInstance(), true);
    }

    public void onTestButtonPressed(View view) {
        replace(R.id.signup_activity_container, SignupFragmentTestresult.newInstance(), true);
    }

    public void onTestresultButtonPressed(View view) {
        replace(R.id.signup_activity_container, SignupFragmentAccount.newInstance(), true);
    }

    public void onAccountButtonPressed(View view) {
//        replace(R.id.signup_activity_container, SignupFragmentInformation.newInstance(), true);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
//    public void onInformationButtonPressed(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }

    public void replace(@IdRes int containerViewId,
                        @NonNull androidx.fragment.app.Fragment fragment, boolean addToStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
        if (addToStack) fragmentTransaction.addToBackStack("Ayy Lmao");
        fragmentTransaction.commit();
    }
}
