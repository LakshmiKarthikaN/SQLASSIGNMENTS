package com.example.smartlib.features.books.Manage;

import com.example.smartlib.repository.dto.Books;

import java.util.List;

public interface IManagePresenter {
    void viewAllBooks();

    void addBook(Books book);

    void displayBooks(List<Books> book);

    void showSuccessMessage(String bookAddedSuccessfully);

    void showErrorMessage(String s);
}
