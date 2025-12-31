package com.example.smartlib.features.librarysetup;

import com.example.smartlib.repository.dto.LibrarySetup;

public interface ILibrarySetupModal {
    void setupLibrary(LibrarySetup library);

    void init();
}
