package com.example.smartlib.features.librarysetup;

import com.example.smartlib.features.base.BaseView;
import com.example.smartlib.repository.dto.LibrarySetup;

import java.util.Scanner;

public class LibrarySetupView extends BaseView implements ILibrarySetupView{
    private final ILibrarySetupPresenter presenter;
    private final Scanner scanner = new Scanner(System.in);
     public LibrarySetupView(){
         presenter = new LibrarySetupPresenter(this);
     }
    public void init(){
         presenter.init();
    }
    public  void proceedToSetTheLibrary() {
         System.out.println("\n === Library Set up ===");
         LibrarySetup library = new LibrarySetup();
         library.setName(getLibraryName());
         library.setAddress(getAddress());
         library.setPhoneNo(getPhoneNo());
        library.setEmailId(getEmail());
        library.setIncharge(getIncharge());
        library.setCapacity(getCapacity());
        library.setOpenTime(getOpenTime());
        library.setCloseTime(getCloseTime());
        library.setNoAvailableDays(getAvailableDays());
        presenter.setupLibrary(library);
    }

    private String getLibraryName() {
         String name = " ";
        System.out.println("Enter the Library Name :");
        do{
            name = scanner.nextLine();
            if(name.length()<3 || name.length()>50){
                System.out.println("The library name should be min 3 and max 50 characters\n\nEnter valid Library Name:");
            }
            else break;

        }while(true);
        return name;
    }

    private  String getAddress() {
        String name = " ";
        System.out.println("Enter the Address :");
        do{
            name = scanner.nextLine();
            if(name.length()<10 || name.length()>100){
                System.out.println("The Address should be min 10 and max 100 characters\n\nEnter valid Address:");
            }
            else break;

        }while(true);
        return name;
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
    private String getIncharge(){
         String incharge = "";
        System.out.println("Enter the Incharge Name :");
        do{
            incharge = scanner.nextLine();
            if(incharge.length()<3 || incharge.length()>32){
                System.out.println("Incharge name should be between 3 and 32 charactors\n Enter valid Incharge Name:");
            }else break;

        }while(true);
        return incharge;
    }
    private Integer getCapacity(){
         Integer capacity = null;
         System.out.println("Enter the capacity:");
         do{
             try {
                 capacity = Integer.parseInt(scanner.nextLine());
                 if (capacity <= 0) {
                     System.out.println("The capacity should be greater than 0\nEnter valid capacity:");
                 } else break;
             }
                 catch(NumberFormatException e){
                     System.out.println("Please enter a valid capacity number");
                 }
             }while(true);
         return capacity;
         }

    private Long getOpenTime() {
        Long openTime = null;
        System.out.println("Enter the Opening Time (in 24hours format,e.g.,900 for 9:00AM:");
     do{
         try{
             openTime = Long.parseLong(scanner.nextLine());
             if(openTime<0 || openTime>2359){
                 System.out.println("Time should be between 0000 and 2359\nEnter valid Opening Time:");
             }
             else break;
         }
         catch(NumberFormatException e){
             System.out.println("Please enter a valid time\nEnter valid Time:");
         }

     }while(true);
     return openTime;
    }
    private Long getCloseTime(){
         Long closeTime = null;
        System.out.println("Enter Closing Time(in 24 hours format,e.g.,1800 for 6:))PM):");
        do{
            try{
                 closeTime = Long.parseLong(scanner.nextLine());
                if(closeTime<0 || closeTime>2359){
                    System.out.println("Time should be between 0000 and 2359\nEnter valid closing time : ");
                }else break;

            }catch(NumberFormatException e){
                System.out.println("Please enter a valid time\nEnter valid Time:");            }
        }while(true);
        return closeTime;
    }
    private Integer getAvailableDays(){
          Integer days = null;
        System.out.println("Enter the Available Days :");
        do {
            try {
                days = Integer.parseInt(scanner.nextLine());
                if (days < 0 || days > 8) {
                    System.out.println("Days should be between 1 and 7\nEnter valid available days :");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number\nEnter valid days :");
            }
        }while(true);
        return days;
    }
    public void onLibrarySetupCompleted(){
        System.out.println("\nLibrary setup completed successfully!");
        showMainMenu();
    }
    public void showMainMenu(){
         while(true){
             System.out.println("\n===SmartLib Main Menu ===");
             System.out.println("1. Manage Books");
             System.out.println("2. View Books");
             System.out.println("3. Manage Users");
             System.out.println("4. View Users");
             System.out.println("5. View Library Details");
             System.out.println("6. Logout");
             System.out.println("7. Exit");
             System.out.print("Enter your choice: ");
             try {
                 int choice = Integer.parseInt(scanner.nextLine());
                 switch (choice) {
                     case 1:
                         new com.example.smartlib.features.books.Manage.ManageView().init();
                         break;
                     case 2:
                         new com.example.smartlib.features.books.BooksView().init();
                         break;
                     case 3:
                         new com.example.smartlib.features.users.manage.ManageView().init();
                         break;
                     case 4:
                         new com.example.smartlib.features.users.UsersView().init();
                         break;
                     case 5:
                         displayLibraryDetails();
                         break;
                     case 6:
                         logOut();
                         return;
                     case 7:
                        exitApp();
                     default:
                         System.out.println("please enter the correct choice");
                 }
             } catch (NumberFormatException e) {
                 System.out.println("Enter a valid number");
             }
         }
         }
    public void showErrorMessage(String message){
        System.out.println(message);
        proceedToSetTheLibrary();
    }
    private String formatTime(Long time) {
        if (time == null) return "-";

        String t = String.format("%04d", time); // pad left with zeros
        String hours = t.substring(0, 2);
        String minutes = t.substring(2, 4);

        return hours + ":" + minutes;
    }

    public void displayLibraryDetails() {
        LibrarySetup library = com.example.smartlib.repository.db.SmartLib.getInstance().getLibrary();

        if (library == null) {
            System.out.println("\nLibrary is not yet set up!");
            return;
        }

        System.out.println("\n=== Library Details ===");

        System.out.println("Library Name      : " + library.getName());
        System.out.println("Address           : " + library.getAddress());
        System.out.println("Phone Number      : " + library.getPhoneNo());
        System.out.println("Email             : " + library.getEmailId());
        System.out.println("Incharge Name     : " + library.getIncharge());
        System.out.println("Capacity          : " + library.getCapacity());
        System.out.println("Opening Time      : " + formatTime(library.getOpenTime()));
        System.out.println("Closing Time      : " + formatTime(library.getCloseTime()));
        System.out.println("Available Days    : " + library.getNoAvailableDays() + " days");

        System.out.println("=============================");
    }


}
