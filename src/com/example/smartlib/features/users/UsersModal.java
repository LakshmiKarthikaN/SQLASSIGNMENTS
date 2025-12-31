package com.example.smartlib.features.users;

import com.example.smartlib.repository.db.SmartLib;
import com.example.smartlib.repository.dto.Users;

import java.util.List;
import java.util.UUID;

public class UsersModal {

    private final UsersView view;
    public UsersModal(UsersView usersView){
        view = usersView;
    }
    void viewAllUsers() {
        List<Users> user = SmartLib.getInstance().getAllUsers();
        view.displayUsers(user);
    }


}
