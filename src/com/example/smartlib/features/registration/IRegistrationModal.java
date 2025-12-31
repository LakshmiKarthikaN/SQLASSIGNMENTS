package com.example.smartlib.features.registration;

import com.example.smartlib.repository.dto.RegistrationInfo;

public interface IRegistrationModal {

    void init();

    void registeruser(RegistrationInfo info);

    void validateCredentials(String userName, String passwordLogin);
}
