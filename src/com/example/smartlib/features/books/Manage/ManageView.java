package com.example.smartlib.features.books.Manage;

import com.example.smartlib.features.base.BaseView;
import com.example.smartlib.features.librarysetup.LibrarySetupView;
import com.example.smartlib.features.registration.RegistrationView;
import com.example.smartlib.repository.dto.Books;

import java.util.List;
import java.util.Scanner;

public class ManageView extends BaseView implements IManageView {
    private final IManagePresenter presenter;
    private final Scanner scanner = new Scanner(System.in);

    public ManageView() {
        presenter = new ManagePresenter(this);
    }

    public void init() {
        showMenu();
    }

    private void showMenu() {
        while (true) {

            System.out.println("\n === Book Management ===");
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Back to Main Menu");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addNewBook();
                        break;
                    case 2:
                        presenter.viewAllBooks();
                        break;
                    case 3:
                        new LibrarySetupView().showMainMenu();
                        return;
                    case 4:
                        System.out.println("Logging out ...");
                        new RegistrationView().init();
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

    private void addNewBook() {
        System.out.println("\n === Add new book===");
        Books book = new Books();
        book.setName(getName());
        book.setAuthor(getAuthor());
        book.setGenre(getGenre());
        book.setPublishedYear(getPublishedYear());
        book.setVolume(getVolume());
        book.setAvailableCount(getAvailableCount());
        book.setNoOfCopy(getNoOfCopy());
        presenter.addBook(book);
    }

    private byte getVolume() {
        byte volume = 0;
        System.out.println("Enter Volume Number :");
        do {
            try {
                volume = Byte.parseByte(scanner.nextLine());
                if (volume <= 0) {
                    System.out.println("Voulme should be greater than 0\nEnter valid Volume:");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number\nEnter valid Volume:");
            }
        } while (true);
        return volume;

    }

    private String getGenre() {
        String genre = "";
        System.out.println("Enter a Book Genre :");
        do {
            genre = scanner.nextLine();
            if (genre.length() < 2 || genre.length() > 30) {
                System.out.println("Genre should be between 2 and 30 charactors\nEnter valid genre:");
            } else break;

        } while (true);
        return genre;

    }


    private String getAuthor() {
        String author = "";
        System.out.println("Enter a Book Author  :");
        do {
            author = scanner.nextLine();
            if (author.length() < 2 || author.length() > 30) {
                System.out.println("Author should be between 2 and 30 charactors\nEnter valid Author:");
            } else break;

        } while (true);
        return author;
    }

    private String getName() {
        String name = "";
        System.out.println("Enter a Book Name :");
        do {
            name = scanner.nextLine();
            if (name.length() < 2 || name.length() > 30) {
                System.out.println("Book name should be between 2 and 30 charactors\nEnter valid Book Name:");
            } else break;

        } while (true);
        return name;

    }

    private Integer getPublishedYear() {
        Integer year = null;
        System.out.println("Enter published year :");
        do {
            try {
                year = Integer.parseInt(scanner.nextLine());
                if (year < 1800 || year > 2025) {
                    System.out.println("Year should be between 1800 and 2025\nEnter valid year:");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid year\nEnter valid year:");
            }
        } while (true);
        return year;

    }

    private Byte getAvailableCount() {
        byte count = 0;
        System.out.println("Enter the book Available Count:");
        do {
            try {
                count = Byte.parseByte(scanner.nextLine());
                if (count <= 0)
                    System.out.println("Available Count should be greater than 0\nEnter valid number:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number\nEnter valid number:");
            }
        } while (true);
        return count;
    }


    private byte getNoOfCopy() {
        byte copies = 0;
        System.out.println("Enter Number of Copies:");
        do {
            try {
                copies = Byte.parseByte(scanner.nextLine());
                if (copies <= 0)
                    System.out.println("Number of copies should be greater than 0\nEnter valid number:");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number\nEnter valid number:");
            }
        } while (true);
        return copies;
    }

    public void displayBooks(List<Books> book) {
        if(book.isEmpty()){
            System.out.println("\nNo Books available in the library.");
            return;
        }
        System.out.println("\n=== Available books===");
        System.out.printf("%-10s %-30s %-20s %-15s %-10s %-10s %-10s%n",
                "ID", "Name", "Author", "Genre", "Volume", "Year", "Available");
        System.out.println("--------------------------------------------------------------------------------");
      for(Books books : book){
          System.out.printf("%-10s %-30s %-20s %-15s %-10d %-10d %-10d%n",
                  books.getId(),
                  books.getName(),
                  books.getAuthor(),
                  books.getGenre(),
                  books.getVolume(),
                  books.getPublishedYear(),
                  books.getAvailableCount());      }
    }
    public void showErrorMessage(String s) {
        System.out.println(s);
    }

    public void showSuccessMessage(String bookAddedSuccessfully) {
        System.out.println(bookAddedSuccessfully);
    }
}