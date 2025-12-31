package com.example.smartlib.features.librarysetup;

import com.example.smartlib.repository.dto.LibrarySetup;
public interface ILibrarySetupPresenter {
    void init() ;

    void setupLibrary(LibrarySetup library);
}
