package com.example.smartlib.features.registration;

import com.example.smartlib.features.base.BaseView;
import com.example.smartlib.features.librarysetup.LibrarySetupView;
import com.example.smartlib.repository.dto.RegistrationInfo;
import java.util.Scanner;

public class RegistrationView extends BaseView implements IRegistrationView{
    private final IRegistrationPresenter presenter;
    private final Scanner scanner = new Scanner(System.in);
    public RegistrationView(){

        presenter = new RegistrationPresenter(this);
    }
 public void init(){
        presenter.init();
 }


    public void proceedLogin() {
        System.out.println("Do you want to continue (Y/N)");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("Y")){
            presenter.validateCredentials(getUserName("Enter user name :","Enter password :"),getPasswordLogin());
        }
        else{
           exitApp();
        }
    }

    public void proceedRegistration() {
        System.out.println("please provide the following information for registration ");
        RegistrationInfo info = new RegistrationInfo();
      info.setName(getName());
      info.setUserName(getUserName("Enter user name : " , "username should not be empty and length min 3 and max 20\n\nEnter valid username: "));
      info.setPassword(getPassword());
      info.setAddress(getAddress());
      presenter.registeruser(info);
    }

    private String getUserName(String initialInfo , String errorInfo) {
        String username = " ";
        System.out.println(initialInfo);
        do{
            username = scanner.nextLine();
            if(username.length() < 5 || username.length() > 32){
                System.out.println(errorInfo);
            }
            else break;
        }while(true);
        return username;
    }

    private String getName(){
        String name = "";
        System.out.println("Enter your name : ");
        do {
            name = scanner.nextLine();
            if (name.length() < 3 || name.length() > 32) {
                System.out.println("Name should not be empty and length min 3 and Max 50\n\nEnter valid name:");
            }
            else break;

        } while(true);
        return name;
    }
       private String getPassword(){
        String password = "";
        System.out.println("Enter your Password");
        do{
            password = scanner.nextLine();
            if(password.length()<8 || password.length()>32){
                System.out.println("Password should not be empty and length min 8 and max 32\n\nEnter valid password:");
            }
            else break;

        }while(true);
           System.out.println("Confirm Password : ");
         do{
             String confirmPassword = "";
             confirmPassword = scanner.nextLine();
             if(!password.equals(confirmPassword)){
                 System.out.println("password and Confirm Password should not be match\n\nEnter valid password :");
             }
             else break;
         }while(true);
           return password;
    }
    private String getAddress(){
        String address = " ";
        System.out.println("Enter your Address :");
        do{
            address = scanner.nextLine();
            if(address.length() < 20 || address.length() >100 ){
                System.out.println("Address should be not be empty and length min 20 and max 32\n\nEnter valid address :");
            }
            else break;
        }while(true);
        return address;
    }
    private String getPasswordLogin() {
        String password = "";
        System.out.println("Enter your Password");
        do {
            password = scanner.nextLine();
            if (password.length() < 8 || password.length() > 32) {
                System.out.println("Password should not be empty and length min 8 and max 32\n\nEnter valid password:");
            } else break;

        } while (true);
        return password;
    }

    public void onSuccessLogin(String username) {
        System.out.println("Logged in Successfully ");
        System.out.println("Welcome " +username);
        new LibrarySetupView().init();
    }

    public void onInvalidCredentials() {
        System.out.println("Username and Password did not match");
        System.out.println("Do you want to continue : (Y/N");
        if(scanner.nextLine().equalsIgnoreCase("Y")){
            proceedLogin();
        }
    }

    public void showErrorMessage(String usernameAlreadyExist) {
        System.out.println(usernameAlreadyExist);
        proceedRegistration();
    }

    public void onRegistrationSuccess() {
        System.out.println("Registration completed Successfully");
        proceedLogin();
    }
}

