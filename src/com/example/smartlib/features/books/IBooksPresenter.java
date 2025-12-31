package com.example.smartlib.features.books;

import com.example.smartlib.repository.dto.Books;

import java.util.List;

public interface IBooksPresenter {
    void displayBooks(List<Books> books);

    void viewAllBooks();
}
