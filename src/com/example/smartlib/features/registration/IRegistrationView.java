package com.example.smartlib.features.registration;

public interface IRegistrationView {
    void proceedLogin();

    void proceedRegistration();

    void onRegistrationSuccess();


    void onInvalidCredentials();
    void showErrorMessage(String s);

    void onSuccessLogin(String username);
}