package com.example.studiy.ui.profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.studiy.classes.Person;
import com.example.studiy.classes.UninitialisedViewModelException;

public class ProfileViewModel extends ViewModel {
    private static ProfileViewModel pvm;
    private MutableLiveData<Person> personLiveData;

    public ProfileViewModel() {
        pvm = this;
    }

    //    public static void setPvm(ProfileViewModel p){pvm = p;}
    public static ProfileViewModel getInstance() {
        if (pvm == null) throw new UninitialisedViewModelException("ProfileViewModel");
        return pvm;
    }

    public void setPerson(Person p) {
        personLiveData = new MutableLiveData<>(p);
    }

    public MutableLiveData<Person> getPersonLiveData() {
        return personLiveData;
    }
}
