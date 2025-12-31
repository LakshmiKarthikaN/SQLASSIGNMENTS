package com.example.smartlib.features.registration;

import com.example.smartlib.repository.db.SmartLib;
import com.example.smartlib.repository.dto.RegistrationInfo;

import java.util.List;

public class RegistrationModal implements IRegistrationModal{
    private final IRegistrationPresenter presenter;
    public RegistrationModal(IRegistrationPresenter registrationPresenter){
         presenter =  registrationPresenter;
    }

     public void init() {
        if(SmartLib.getInstance().getAllRegisteredUsers().isEmpty()){
            presenter.proceedRegistration();
        }
        else{
            presenter.proceedLogin();
        }
    }
    public void registeruser(RegistrationInfo info){
        if(ifAlreadyExist(info.getUserName())){
           presenter.showErrorMessage("user name already exists....");
        }else if(isWeakPassword(info)){
            presenter.showErrorMessage("Please enter a Strong Password ");
        }
        else{
            SmartLib.getInstance().addUser(info);
            SmartLib.getInstance().setRegistrationInfo(info);
            presenter.onRegistrationSuccess();
        }
//        System.out.println("registered users ");
//        for(RegistrationInfo u : SmartLib.getInstance().getAllRegisteredUsers()){
//            System.out.println(u.getUserName());
//
//        }
    }

    private boolean isWeakPassword(RegistrationInfo info) {
        String password = String.valueOf(info.getPassword());
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        return !(hasUppercase && hasDigit && hasLowercase && hasSpecialChar);
    }
    private boolean ifAlreadyExist(String username){
        List<RegistrationInfo> allUsers = SmartLib.getInstance().getAllRegisteredUsers();
        for(RegistrationInfo user : allUsers){
            if(user.getUserName().equalsIgnoreCase(username)){
                return true;
            }
        }return false;
    }
    

    public void validateCredentials(String username, String password){
        if(SmartLib.getInstance().validateLoginInfo(username,password)){
            presenter.onSuccessLogin(username);
        }else{
            presenter.onInvalidCredentials();
        }
    }
}
