package com.example.smartlib.features.books;

import com.example.smartlib.features.base.BaseView;
import com.example.smartlib.features.books.Details.DetailsView;
import com.example.smartlib.features.books.Manage.ManageView;
import com.example.smartlib.features.books.search.SearchView;
import com.example.smartlib.repository.dto.Books;

import java.util.List;
import java.util.Scanner;

public class BooksView  extends BaseView implements IBooksView {
    private final IBooksPresenter presenter;
    private final Scanner scanner = new Scanner(System.in);
    public BooksView(){
        presenter = new BooksPresenter(this);
    }
    public void init(){
          showMenu();
    }


    private void showMenu() {
        while(true){
            System.out.println("\n ===Books===\n");
            System.out.println("1. View All BOoks");
            System.out.println("2. Search Books");
            System.out.println("3. Manage Books");
            System.out.println("4. View Book Details");
            System.out.println("5. Back to Main Menu");
            System.out.println("6. Logout");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            try{
               int choice = Integer.parseInt(scanner.nextLine());
               switch (choice){
                   case 1 :
                       presenter.viewAllBooks();
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
    public void displayBooks(List<Books> books){
        if(books.isEmpty()){
            System.out.println("\nNo Books found");
            return;
        }
        System.out.println("\n ===Books List ===");
        System.out.printf("%-10s %-30s %-20s %-15s %-10s %-10s %-10s%n",
                "ID", "Name", "Author", "Genre", "Volume", "Year", "Available");
        System.out.println("--------------------------------------------------------------------------------");
  for(Books book : books){
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


}
