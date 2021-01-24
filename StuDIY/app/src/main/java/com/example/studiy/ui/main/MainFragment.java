package com.example.studiy.ui.main;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studiy.ui.profile.ProfileFragment;
import com.example.studiy.ui.profile.ProfileViewModel;
import com.example.studiy.R;
import com.example.studiy.classes.Person;

public class MainFragment extends Fragment implements MainRecyclerAdapter.ItemClickListener {

    private MainViewModel mViewModel;
    private RecyclerView recyclerView;
    private MainRecyclerAdapter adapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_persongrid, container, false);

        recyclerView = view.findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        adapter = new MainRecyclerAdapter();
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public void onItemClick(View view, int position) {
        // Pass information to ProfileViewModel
        Person p = mViewModel.getPersonListLiveData().getValue().get(position);
        ProfileViewModel.getInstance().setPerson(p);

        // Fragment transition, remember to add onto stack!
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout1, ProfileFragment.newInstance());
        fragmentTransaction.addToBackStack("name2"); // name can be null
        fragmentTransaction.commit();
    }
}