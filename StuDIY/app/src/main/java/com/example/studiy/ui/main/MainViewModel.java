package com.example.studiy.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.studiy.classes.Person;
import com.example.studiy.classes.UninitialisedViewModelException;
import com.example.studiy.data.PersonRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    // TODO: link up using the observer pattern
    // TODO: store favourites in database

    private static MainViewModel mvm;
    private MutableLiveData<List<Person>> personListLiveData;

    public MainViewModel() {
        mvm = this;
        personListLiveData = new MutableLiveData<>(PersonRepository.getInstance().getPersonList());
    }

    public static MainViewModel getInstance() {
        if (mvm == null) throw new UninitialisedViewModelException("MainViewModel");
        return mvm;
    }

    public MutableLiveData<List<Person>> getPersonListLiveData() {
//        if(personListLiveData!=null)personListLiveData = new MutableLiveData<>(PersonDatabase.getInstance().getPersonList());
        return personListLiveData;
    }
    // TODO: When database is done, need to have threads that update data in the background
}