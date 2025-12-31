package com.example.smartlib.features.users.manage;

import com.example.smartlib.repository.dto.Users;

import java.util.List;

public class ManagePresenter implements IManagePresenter {
    private final IManageView view ;
    private final IManageModal modal;
    public ManagePresenter(IManageView manageView){
     view  = manageView;
     modal = new ManageModal(this);
    }

    public void viewAllUsers() {
        modal.viewAllUsers();
    }

    public void addUser(Users user) {
        modal.addUser(user);
    }

    public void showSuccessMessage(String userAddedSuccessfully) {
        view.showSuccessMessage(userAddedSuccessfully);
    }

    public void showErrorMessage(String s) {
        view.showErrorMessage(s);
    }

    public void displayUsers(List<Users> user) {
        view.displayUsers(user);
    }
}
