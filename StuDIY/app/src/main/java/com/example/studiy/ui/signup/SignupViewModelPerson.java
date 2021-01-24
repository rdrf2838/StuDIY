package com.example.studiy.ui.signup;

import androidx.lifecycle.ViewModel;

import com.example.studiy.data.MiscRepository;
import com.example.studiy.classes.Person;

import java.util.List;

public class SignupViewModelPerson extends ViewModel {
    // This ViewModel stores the Person object that is filled up by details during the signup activity

    private Person p;

    private List<String> subjectList;
    private List<Integer> subjectPictureList;
    private static SignupViewModelPerson svmp;

    public SignupViewModelPerson() {
        svmp = this;
        p = new Person();
        subjectList = MiscRepository.getInstance().getSubjectList();
        subjectPictureList = MiscRepository.getInstance().getSubjectIDs();
        p.setSubjects(new boolean[subjectList.size()]);
    }

    public static SignupViewModelPerson getInstance() {
        return svmp;
    }

    public List<String> getSubjectList() {
        return subjectList;
    }

    public List<Integer> getSubjectPictureList() {
        return subjectPictureList;
    }

    public Person getPerson() {
        return p;
    }
}
