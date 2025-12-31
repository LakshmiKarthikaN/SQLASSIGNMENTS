package com.example.smartlib.features.books.Manage;

import com.example.smartlib.repository.dto.Books;

public interface IManageModal {

    void viewAllBooks();

    void addBook(Books book);
}
