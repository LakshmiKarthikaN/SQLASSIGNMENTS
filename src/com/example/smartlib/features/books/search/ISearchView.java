package com.example.smartlib.features.books.search;

import com.example.smartlib.repository.dto.Books;

import java.util.List;

public interface ISearchView {
    void displayBooks(List<Books> books);

    void showMessage(String pleaseEnterAValidName);
}
