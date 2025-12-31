package com.example.smartlib.features.librarysetup;

import com.example.smartlib.repository.db.SmartLib;
import com.example.smartlib.repository.dto.LibrarySetup;

public class LibrarySetupModal implements ILibrarySetupModal{
    private final LibrarySetupPresenter presenter;


    public LibrarySetupModal(LibrarySetupPresenter librarySetupPresenter) {
        presenter = librarySetupPresenter;
    }

    public void init() {
        if (SmartLib.getInstance().getLibrary() == null) {
            presenter.proceedToSetTheLibrary();
        } else {
            presenter.onLibrarySetupCompleted();
        }
    }

    public void setupLibrary(LibrarySetup library) {
        if (validateLibraryInfo(library)) {
            SmartLib.getInstance().setLibrary(library);
            presenter.onLibrarySetupCompleted();
        } else {
            presenter.showErrorMessage("Invalid library information please try again.");
        }
    }

    private boolean validateLibraryInfo(LibrarySetup library) {
        return library != null &&
                library.getName() != null && !library.getName().trim().isEmpty() &&
                library.getAddress() != null && !library.getAddress().trim().isEmpty() &&
                library.getPhoneNo() != null && library.getPhoneNo().matches("\\d{10}") &&
                library.getEmailId() != null && library.getEmailId().matches("^[A-Za-z0-9+_.-]+@(.+)$") &&
                library.getIncharge() != null && !library.getIncharge().trim().isEmpty();
    }
}