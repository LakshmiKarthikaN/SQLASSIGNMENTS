package com.example.smartlib.features.users.manage;

import com.example.smartlib.repository.db.SmartLib;
import com.example.smartlib.repository.dto.Users;

import java.util.List;
import java.util.UUID;

public class ManageModal implements IManageModal{
    private final IManagePresenter presenter;
    public ManageModal(ManagePresenter managePresenter){
        presenter = managePresenter;
    }
   public void addUser(Users user){
        if(validateUser(user)){
            user.setUserId(generateUserId());
            SmartLib.getInstance().addUserForManual(user);
            presenter.showSuccessMessage("User added Successfully");
        }
        else{
            presenter.showErrorMessage("Invalid User information.Please try again.");
        }
    }
    private String generateUserId(){
        return "SL" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
    public void viewAllUsers(){
        List<Users> user = SmartLib.getInstance().getAllUsers();
        presenter.displayUsers(user);
    }
    private boolean validateUser(Users user){
        return user!= null &&
                user.getName() != null && !user.getName().trim().isEmpty() &&
                user.getAddress() != null && !user.getAddress().isEmpty() &&
                user.getEmail() != null && user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$") &&
                user.getPhoneNo() != null && user.getPhoneNo().matches("\\d{10}");
    }
}
