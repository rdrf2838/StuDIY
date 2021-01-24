package com.example.studiy.classes;

public class UninitialisedViewModelException extends RuntimeException {
    public UninitialisedViewModelException(String viewModelName) {
        super("Parent activity has not initialised " + viewModelName);
    }
}
