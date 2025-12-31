package com.example.smartlib.features.users.manage;

import com.example.smartlib.repository.dto.Users;

import java.util.List;

public interface IManageView {
    void showSuccessMessage(String userAddedSuccessfully);

    void showErrorMessage(String s);

    void displayUsers(List<Users> user);
}
