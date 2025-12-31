package com.example.smartlib.features.books.Manage;

import com.example.smartlib.repository.dto.Books;

import java.util.List;

public class ManagePresenter implements IManagePresenter{
    private final IManageModal modal;
    private final IManageView view;
    public ManagePresenter(IManageView manageView){
        view =  manageView;
        modal = new ManageModal(this);
    }

    public void displayBooks(List<Books> book) {
        view.displayBooks(book);
    }

    public void showSuccessMessage(String bookAddedSuccessfully) {
        view.showSuccessMessage(bookAddedSuccessfully);
    }



    public void viewAllBooks() {
        modal.viewAllBooks();
    }

    public void addBook(Books book) {
        modal.addBook(book);
    }

    public void showErrorMessage(String s) {
        view.showErrorMessage(s);
    }
}
