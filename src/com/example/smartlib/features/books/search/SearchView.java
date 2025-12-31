package com.example.smartlib.features.books.search;

import com.example.smartlib.features.base.BaseView;
import com.example.smartlib.features.librarysetup.LibrarySetupView;
import com.example.smartlib.repository.dto.Books;

import java.util.Scanner;

public class SearchView extends BaseView implements ISearchView{
   private final ISearchPresenter presenter;
   private final Scanner scanner = new Scanner(System.in);
    public SearchView(){
        presenter = new SearchPresenter(this);
    }
    public void init(){
    showMenu();
    }
    private void showMenu(){
        while(true){
            System.out.println("\n=== Search Books ===");
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Author");
            System.out.println("3. Search by Genre");
            System.out.println("4. Back to Main Menu");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice){
                    case 1:
                        System.out.println("Enter book Name : ");
                        presenter.searchByName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter author Name");
                        presenter.searchByAuthor(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Enter genre :");
                        presenter.searchByGenre(scanner.nextLine());
                        break;
                    case 4:
                        new LibrarySetupView().showMainMenu();
                        return;
                    case 5:
                        System.out.println("Logging out");
                        break;
                    case 6:
                        logOut();
                        return;
                    default:
                        exitApp();
                }
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid number :");
            }
        }
    }
    public void displayBooks(java.util.List<Books> books) {
        if (books.isEmpty()) {
            System.out.println("\nNo books found.");
            return;
        }

        System.out.println("\n=== Search Results ===");
        System.out.printf("%-10s %-30s %-20s %-15s %-10s %-10s %-10s%n",
                "ID", "Name", "Author", "Genre", "Volume", "Year", "Available");
        System.out.println("--------------------------------------------------------------------------------");

        for (Books book: books) {
            System.out.printf("%-10s %-30s %-20s %-15s %-10d %-10d %-10d%n",
                    book.getId(),
                    book.getName(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getVolume(),
                    book.getPublishedYear(),
                    book.getAvailableCount());
        }
    }
    public void showMessage(String message) {
        System.out.println(message);
    }

}
