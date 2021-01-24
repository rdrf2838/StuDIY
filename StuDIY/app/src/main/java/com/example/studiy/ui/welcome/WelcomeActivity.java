package com.example.studiy.ui.welcome;

import android.content.Intent;
import android.os.Bundle;

import com.example.studiy.MainActivity;
import com.example.studiy.ui.signup.SignupActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.TextView;

import com.example.studiy.R;

public class WelcomeActivity extends AppCompatActivity {
    // TODO: remember to skip login if person has already signed in
    // TODO: use google accounts to sign in
    TextView login_button;
    TextView signup_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        login_button = findViewById(R.id.login_button);
        signup_button = findViewById(R.id.signup_button);

        setContentView(R.layout.welcome_activity);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.welcome_activity_container, LoginFragment.newInstance());
            fragmentTransaction.commit();
        }

    }

    public void onLogin(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onSignup(View v) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

}