package com.example.studiy.ui.signup.test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.studiy.R;

public class SignupFragmentTestresult extends Fragment {
    SignupViewModelTest svmt = SignupViewModelTest.getInstance();
    TextView test_result;
    TextView test_description;
    TextView test_result_description;

    public static SignupFragmentTestresult newInstance() {
        SignupFragmentTestresult fragment = new SignupFragmentTestresult();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup_fragment_testresult, container, false);
        test_result = view.findViewById(R.id.test_result);
        test_description = view.findViewById(R.id.test_description);
        test_result_description = view.findViewById(R.id.test_result_description);
        if (!svmt.isFinished()) {
            test_description.setText(view.getResources().getString(R.string.test_description_incomplete));
            test_result_description.setText(view.getResources().getString(R.string.test_result_description_incomplete));
        } else {
            test_result.setText(svmt.getResult());
        }
        return view;
    }
}