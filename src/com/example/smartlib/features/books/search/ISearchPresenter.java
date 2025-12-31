package com.example.smartlib.features.books.search;

import com.example.smartlib.repository.dto.Books;

import java.util.List;

public interface ISearchPresenter {
    void searchByName(String s);

    void searchByAuthor(String s);

    void searchByGenre(String s);

    void showMessage(String pleaseEnterAValidName);

    void displayBooks(List<Books> books);
}
