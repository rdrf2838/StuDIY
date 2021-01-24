package com.example.studiy.ui.signup.subject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studiy.R;

public class SignupFragmentSubject extends Fragment {

    public SignupFragmentSubject() {
        // Required empty public constructor
    }

    public static SignupFragmentSubject newInstance() {
        SignupFragmentSubject fragment = new SignupFragmentSubject();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup_fragment_subject, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_subject);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
        SignupFragmentSubjectAdapter adapter = new SignupFragmentSubjectAdapter();
        recyclerView.setAdapter(adapter);
        return view;
    }
}