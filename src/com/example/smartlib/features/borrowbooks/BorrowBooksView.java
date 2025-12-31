package com.example.smartlib.features.borrowbooks;

import com.example.smartlib.features.librarysetup.LibrarySetupView;
import com.example.smartlib.repository.dto.BorrowedBooks;

import java.util.List;
import java.util.Scanner;

public class BorrowBooksView {
    private final BorrowBooksModal modal;
    private final Scanner scanner = new Scanner(System.in);
    public BorrowBooksView(){
        modal = new BorrowBooksModal(this);
    }
    public void init(){
        while (true) {
            System.out.println("\n=== Borrow Book Menu ===");
            System.out.println("1. Borrow Book");
            System.out.println("2. View Borrowed Books (by User)");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        borrowBook();
                        break;
                    case 2:
                        viewBorrowedBooksByUser();
                        return;
                    case 3:
                        new LibrarySetupView().init();
                        break;
                    default:
                        showMessage("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                showMessage("Please enter a number.");
            }
        }
    }
    private void borrowBook(){
        System.out.println("Enter user Id:");
        String userId = scanner.nextLine();
        System.out.println("Enter Book Id:");
        String bookId = scanner.nextLine();
        modal.borrowBookForUser(userId, bookId);

    }
    private void viewBorrowedBooksByUser() {
        System.out.println("Enter user Id view borrow records");
        String userId = scanner.nextLine();
        modal.showBorrowedBookdetails(userId);
    }
    public void displayBorrowedBooks(List<BorrowedBooks> books) {
        if (books == null || books.isEmpty()) {
            showMessage("No borrowed books found for this user.");
            return;
        }
        System.out.println("\n--- Borrowed Books List ---");
        for (BorrowedBooks book : books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Borrow Date: " + book.getBorrowDate());
            System.out.println("Due Date: " + book.getDueDate());
            System.out.println("Returned: " + (book.isReturned() ? "Yes" : "No"));
            if (book.isReturned()) {
                System.out.println("Return Date: " + book.getReturnDate());
            }
            System.out.println("Fine: ₹" + book.getFineAmount());
            System.out.println("------------------------");
        }
    }

    private void showMessage(String s) {
        System.out.println(s);
    }
    public void displaySuccessMessage() {
        showMessage("Book borrowed successfully!");
    }

    public void displayErrorMessage() {
        showMessage("User Id and Book Id cannot be empty.");
    }

}
