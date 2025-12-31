package com.example.smartlib.features.users.manage;

import com.example.smartlib.repository.dto.Users;

public interface IManageModal {
    void viewAllUsers();

    void addUser(Users user);
}
