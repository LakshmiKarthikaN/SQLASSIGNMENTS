package com.example.smartlib.features.users;

import com.example.smartlib.features.base.BaseView;
import com.example.smartlib.features.books.Details.DetailsView;
import com.example.smartlib.features.books.Manage.ManageView;
import com.example.smartlib.features.books.search.SearchView;
import com.example.smartlib.features.registration.RegistrationView;
import com.example.smartlib.repository.dto.Books;
import com.example.smartlib.repository.dto.RegistrationInfo;
import com.example.smartlib.repository.dto.Users;

import java.util.List;
import java.util.Scanner;

public class UsersView extends BaseView {
    private final UsersModal modal;
    private final Scanner scanner = new Scanner(System.in);

    public UsersView(){
        modal = new UsersModal(this);
    }
    public void init() {
      showMenu();
    }
    private void showMenu() {
        while(true){
            System.out.println("\n ===Users===\n");
            System.out.println("1. View All Users");
            System.out.println("2. Search Users");
            System.out.println("3. Manage Users");
            System.out.println("4. View User Details");
            System.out.println("5. Back to Main Menu");
            System.out.println("6. Logout");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1 :
                        modal.viewAllUsers();
                        break;
                    case 2:
                        new SearchView().init();
                        break;
                    case 3:
                        new ManageView().init();
                        break;
                    case 4:
                        new DetailsView().init();
                        break;
                    case 5:
                        showMenu();
                        break;
                    case 6:
                        logOut();
                        return;
                    case 7:
                        exitApp();
                    default:
                        System.out.println("Invalid Choice. please try again ");
                }
            }catch(NumberFormatException e){
                System.out.println("please enter a valid number");
            }
        }
    }

    public void displayUsers(List<Users> user) {
        if(user.isEmpty()){
            System.out.println("No users found ");
            return;
        }
        System.out.println("\n ===Books List ===");
        System.out.printf("%-10s %-30s %-20s %-15s %-10s %-10s %-10s%n",
                "ID", "Name", "Address", "PhoneNo", "Email","DOB");
        System.out.println("--------------------------------------------------------------------------------");
        for(Users u : user ){
            System.out.printf("%-10s %-30s %-20s %-15s %-10d %-10d %-10d%n",

                    u.getName(),
                    u.getAddress(),
                    u.getPhoneNo(),
                    u.getDob(),
                    u.getEmail());
        }
    }


}
