package com.example.studiy.ui.signup.test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.studiy.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupFragmentTest#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragmentTest extends Fragment {
    //    private SignupViewModelTest svmt;
    private static ProgressBar progressBar;

    public SignupFragmentTest() {
        // Required empty public constructor
    }

    public static SignupFragmentTest newInstance() {
        SignupFragmentTest fragment = new SignupFragmentTest();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        svmt = new ViewModelProvider(requireActivity()).get(SignupViewModelTest.class);

        View view = inflater.inflate(R.layout.signup_fragment_test, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.test_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        SignupFragmentTestAdapter adapter = new SignupFragmentTestAdapter();
        recyclerView.setAdapter(adapter);

        progressBar = view.findViewById(R.id.progressBar);
        return view;
    }

    public static void updateProgress() {
        progressBar.setProgress(SignupViewModelTest.getInstance().getProgress());
    }
}