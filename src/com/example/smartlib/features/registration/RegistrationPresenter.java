package com.example.smartlib.features.registration;

import com.example.smartlib.repository.dto.RegistrationInfo;

public class RegistrationPresenter  implements IRegistrationPresenter{
    private final IRegistrationView view;
    private final IRegistrationModal modal;
    public RegistrationPresenter(IRegistrationView registrationview){
        view = registrationview;
        modal = new RegistrationModal(this);

    }
    public void proceedRegistration() {
        view.proceedRegistration();
    }

    public void proceedLogin() {
        view.proceedLogin();

    }

    public void validateCredentials(String userName, String passwordLogin) {
        modal.validateCredentials(userName, passwordLogin);
    }



    public void onRegistrationSuccess() {
        view.onRegistrationSuccess();
    }

    public void onSuccessLogin(String username) {
        view.onSuccessLogin(username);
    }

    public void onInvalidCredentials() {
        view.onInvalidCredentials();
    }

    public void showErrorMessage(String s) {
        view.showErrorMessage(s);
    }

    public void init() {
        modal.init();
    }

    public void registeruser(RegistrationInfo info) {
        modal.registeruser(info);
    }
}
