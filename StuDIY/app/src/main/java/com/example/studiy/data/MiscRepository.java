package com.example.studiy.data;

import android.annotation.SuppressLint;

import com.example.studiy.R;

import java.util.List;

public class MiscRepository {
    private static MiscRepository myInstance;

    public static MiscRepository getInstance() {
        if (myInstance == null) myInstance = new MiscRepository();
        return myInstance;
    }

    @SuppressLint("NewApi")
    public List<String> getSubjectList() {
        return List.of(
                "Math",
                "English",
                "Chinese",
                "Chemistry",
                "Physics",
                "Biology",
                "History",
                "Geography",
                "Literature");
    }

    @SuppressLint("NewApi")
    public List<Integer> getSubjectIDs() {
        return List.of(
                R.drawable.subject_math,
                R.drawable.subject_english,
                R.drawable.subject_chinese,
                R.drawable.subject_chemistry,
                R.drawable.subject_physics,
                R.drawable.subject_biology,
                R.drawable.subject_history,
                R.drawable.subject_geography,
                R.drawable.subject_literature
        );
    }

}
