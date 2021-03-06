package com.example.studiy.ui.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studiy.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupFragmentInformation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragmentInformation extends Fragment {

    public SignupFragmentInformation() {
        // Required empty public constructor
    }

    public static SignupFragmentInformation newInstance() {
        SignupFragmentInformation fragment = new SignupFragmentInformation();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.signup_fragment_information, container, false);
    }
}