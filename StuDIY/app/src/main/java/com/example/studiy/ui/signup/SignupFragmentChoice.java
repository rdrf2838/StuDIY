package com.example.studiy.ui.signup;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studiy.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupFragmentChoice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragmentChoice extends Fragment {
    ConstraintLayout tutor_choice;
    ConstraintLayout tutee_choice;
    ConstraintLayout tutee_button;
    ConstraintLayout tutor_button;

    public SignupFragmentChoice() {
        // Required empty public constructor
    }

    public static SignupFragmentChoice newInstance() {
        SignupFragmentChoice fragment = new SignupFragmentChoice();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup_fragment_choice, container, false);
        // Inflate the layout for this fragment
        tutee_choice = view.findViewById(R.id.tutee_choice);
        tutor_choice = view.findViewById(R.id.tutor_choice);
        tutee_button = view.findViewById(R.id.tutee_button);
        tutor_button = view.findViewById(R.id.tutor_button);
        tutee_choice.setAlpha(0.2f);
        tutor_choice.setAlpha(0.2f);
        setClicks();
        return view;
    }

    public void setClicks() {
        tutee_button.setOnClickListener((i) -> {
            tutor_choice.setAlpha(0.6f);
            tutee_choice.setAlpha(0.2f);
        });
        tutor_button.setOnClickListener((i) -> {
            tutor_choice.setAlpha(0.2f);
            tutee_choice.setAlpha(0.6f);
        });
    }
}