package com.example.studiy.misc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studiy.R;

public class SignupFragmentSubjectCopy extends Fragment {

    public SignupFragmentSubjectCopy() {
        // Required empty public constructor
    }

    public static SignupFragmentSubjectCopy newInstance() {
        SignupFragmentSubjectCopy fragment = new SignupFragmentSubjectCopy();
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
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        SignupFragmentSubjectAdapterCopy adapter = new SignupFragmentSubjectAdapterCopy();
        recyclerView.setAdapter(adapter);
        return view;
    }
}