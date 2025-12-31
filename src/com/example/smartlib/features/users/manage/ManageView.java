package com.example.smartlib.features.users.manage;

import com.example.smartlib.features.base.BaseView;
import com.example.smartlib.features.librarysetup.LibrarySetupView;
import com.example.smartlib.repository.dto.Users;

import java.util.List;
import java.util.Scanner;

public class ManageView extends BaseView implements IManageView{
    private final IManagePresenter presenter;
    private final Scanner scanner = new Scanner(System.in);
    public ManageView(){
        presenter = new ManagePresenter(this);
    }
   public void init() {
         showMenu();
    }
    private void showMenu(){
        while(true){
            System.out.println("\n === Users Management ===");
            System.out.println("1. Add New User");
            System.out.println("2. View All Users");
            System.out.println("3.Back to Main Menu");
            System.out.println("4.Log out");
            System.out.println("5. Exit");
            System.out.println("Enter your choice :");
            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice){
                    case 1:
                        addNewUser();
                        break;
                    case 2:
                        presenter.viewAllUsers();
                        break;
                    case 3:
                        new LibrarySetupView().showMainMenu();
                        return;
                    case 4:
                        logOut();
                        return;
                    case 5:
                        exitApp();
                    default:
                        System.out.println("invalid choice. please try again");

                }
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid number");
            }
        }

    }

    private void addNewUser() {
        System.out.println("\n === Add New User ===");
        Users user = new Users();
        user.setName(getName());
        user.setAddress(getAddress());
        user.setPhoneNo(getPhoneNo());
        user.setEmail(getEmail());
      user.setDob(getDob());
      presenter.addUser(user);
    }


    private String getName(){
      String name = "";
        System.out.println("Enter the Name :");
        do{
            name = scanner.nextLine();
            if(name.length() < 3 || name.length()>50){
                System.out.println("The name should not be empty and the charactors should be 3 between 50 charactors\nEnter valid  Name:");
            }else break;
        }while(true);
        return name;
    }
    private String getAddress(){
        String address = "";
        System.out.println("Enter the Address :");
        do{
            address = scanner.nextLine();
            if(address.length()<3 || address.length()>50){
                System.out.println("The Address should not be empty and the charactors should be 3 between 50 charactors\nEnter valid Address:");
            }else break;
        }while(true);
        return address;
    }
    private String getEmail(){
        String email ="";
        System.out.println("Enter the Email:");
        do {
            email = scanner.nextLine();
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                System.out.println("Invalid email format\nEnter valid email:");
            } else break;
        }while(true);
        return email;
    }
    private String getPhoneNo(){
        String phoneNo = "";
        System.out.println("Enter the Phone NO:");
        do{
            phoneNo = scanner.nextLine();
            if(!phoneNo.matches("\\d{10}")){
                System.out.println("Phone No must be a 10 digit number\n\nEnter valid PhoneNo");
            }
            else break;
        }while(true);
        return phoneNo;
    }
    private String getDob() {
        String dob = "";
        System.out.println("Enter Date of Birth (DD/MM/YYYY):");
        do {
            dob = scanner.nextLine();
            if (!dob.matches("\\d{2}/\\d{2}/\\d{4}"))
                System.out.println("Invalid date format. Please use DD/MM/YYYY\nEnter valid date:");
            else break;
        } while (true);
        return dob;
    }


    public void displayUsers(List<Users> user) {
        if (user.isEmpty()) {
            System.out.println("No users found ");
            return;
        }

        System.out.println("\n === Users List ===");
        System.out.printf("%-10s %-30s %-20s %-15s %-20s %-15s%n",
                "ID", "Name", "Address", "PhoneNo", "Email", "DOB");
        System.out.println("--------------------------------------------------------------------------------");

        for (Users u : user) {
            System.out.printf("%-10s %-30s %-20s %-15s %-20s %-15s%n",
                    u.getUserId(),
                    u.getName(),
                    u.getAddress(),
                    u.getPhoneNo(),
                    u.getEmail(),
                    u.getDob());
        }
    }


    public void showSuccessMessage(String userAddedSuccessfully) {
        System.out.println(userAddedSuccessfully);
    }
    public void showErrorMessage(String s){
        System.out.println(s);
    }
}