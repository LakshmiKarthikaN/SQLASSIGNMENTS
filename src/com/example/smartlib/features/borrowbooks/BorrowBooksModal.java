package com.example.smartlib.features.borrowbooks;



import com.example.smartlib.repository.db.SmartLib;
import com.example.smartlib.repository.dto.BorrowedBooks;

import java.util.List;
import java.util.Scanner;

public class BorrowBooksModal {
    private final BorrowBooksView view;
    private final Scanner scanner = new Scanner(System.in);
    public BorrowBooksModal(BorrowBooksView borrowBooksView){
        view = borrowBooksView;
    }
    public void borrowBookForUser(String userId, String bookId){
        if(userId == null || bookId == null || userId.isEmpty() || bookId.isEmpty()){
            view.displayErrorMessage();
            return;
        }
        SmartLib.getInstance().borrowBook(userId,bookId);
        view.displaySuccessMessage();
    }
    public void showBorrowedBookdetails(String userId){
        List<BorrowedBooks> borrowedlist = SmartLib.getInstance().getBorrowedBookByUser(userId);
    }

}
