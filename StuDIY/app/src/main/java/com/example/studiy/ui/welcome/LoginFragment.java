package com.example.studiy.ui.welcome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.studiy.R;

public class LoginFragment extends Fragment {
    TextView login_button;
    TextView signup_button;

    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.welcome_fragment_login, container, false);
        login_button = view.findViewById(R.id.login_button);
        signup_button = view.findViewById(R.id.signup_button);
        return view;
    }
}