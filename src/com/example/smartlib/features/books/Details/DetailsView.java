package com.example.smartlib.features.books.Details;


import com.example.smartlib.features.base.BaseView;
import com.example.smartlib.features.books.Manage.IManageView;
import com.example.smartlib.features.borrowbooks.BorrowBooksView;
import com.example.smartlib.features.librarysetup.LibrarySetupView;
import com.example.smartlib.features.registration.RegistrationView;
import com.example.smartlib.repository.dto.Books;

import java.util.Scanner;

public class DetailsView extends BaseView implements IDetailsView {
    private final IDetailsPresenter presenter;
    private final Scanner scanner = new Scanner(System.in);
    public DetailsView(){
        presenter = new DetailsPresenter(this);
    }
   public void init(){
        showMenu();
   }
public void showMenu(){
    while (true) {
        System.out.println("\n=== Book Details ===");
        System.out.println("1. View Book Details");
        System.out.println("2.Borrow Book Details");
        System.out.println("3. Back to Main Menu");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    viewBookDetails();
                    break;
                case 2:
                    new BorrowBooksView().init();
                    break;
                case 3:
                    new LibrarySetupView().showMainMenu();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    new RegistrationView().init();
                    break;
                case 5:
                    logOut();
                    return;
                default:
                    exitApp();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }

    }

}

    private void viewBookDetails() {
        System.out.println("Enter Book Id");
        String bookId = scanner.nextLine();
        presenter.getBookDetails(bookId);
    }
    public void displayBookDetails(Books book) {
        if (book == null) {
            System.out.println("\nBook not found.");
            return;
        }

        System.out.println("\n=== Book Details ===");
        System.out.println("Book ID: " + book.getId());
        System.out.println("Name: " + book.getName());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Volume: " + book.getVolume());
        System.out.println("Published Year: " + book.getPublishedYear());
        System.out.println("Total Copies: " + book.getNoOfCopy());
        System.out.println("Available Copies: " + book.getAvailableCount());
    }
    public void showErrorMessage(String message){
        System.out.println(message);

    }
}
