package com.example.smartlib.features.users.manage;

import com.example.smartlib.repository.dto.Users;

import java.util.List;

public interface IManagePresenter {

    void showSuccessMessage(String userAddedSuccessfully);

    void showErrorMessage(String s);

    void displayUsers(List<Users> user);

    void viewAllUsers();

    void addUser(Users user);
}
