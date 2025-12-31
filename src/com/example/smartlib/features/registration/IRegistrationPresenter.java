package com.example.smartlib.features.registration;

import com.example.smartlib.repository.dto.RegistrationInfo;

public interface IRegistrationPresenter {

    void init();

    void validateCredentials(String userName, String passwordLogin);

    void registeruser(RegistrationInfo info);


    void proceedRegistration();

    void proceedLogin();

    void showErrorMessage(String s);

    void onRegistrationSuccess();

    void onSuccessLogin(String username);

    void onInvalidCredentials();
}
