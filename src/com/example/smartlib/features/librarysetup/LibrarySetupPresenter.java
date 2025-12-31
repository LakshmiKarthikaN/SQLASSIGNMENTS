package com.example.smartlib.features.librarysetup;

import com.example.smartlib.repository.dto.LibrarySetup;

public class LibrarySetupPresenter implements ILibrarySetupPresenter {
    private final ILibrarySetupView view;
    private final ILibrarySetupModal modal;
    public LibrarySetupPresenter(LibrarySetupView librarySetupView){
        view = librarySetupView;
        modal = new LibrarySetupModal(this);
    }

    public void init() {
        modal.init();
    }

    public void setupLibrary(LibrarySetup library) {
        modal.setupLibrary(library);

    }

    public void proceedToSetTheLibrary() {
        view.proceedToSetTheLibrary();
    }

    public void onLibrarySetupCompleted() {
        view.onLibrarySetupCompleted();
    }


    public void showErrorMessage(String s) {
     view.showErrorMessage(s);
    }
}
