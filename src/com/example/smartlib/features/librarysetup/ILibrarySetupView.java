package com.example.smartlib.features.librarysetup;

public interface ILibrarySetupView {
    void proceedToSetTheLibrary();

    void onLibrarySetupCompleted();

    void init();

    void showErrorMessage(String s);
}
