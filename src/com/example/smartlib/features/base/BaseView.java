package com.example.smartlib.features.base;

public abstract class BaseView {
   protected void exitApp(){
        System.out.println("Thanks for using SmartLib");
        System.exit(0);
    }
    protected void logOut(){
        System.out.println("Logging out....");
    }

}
