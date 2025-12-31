package com.example.smartlib.features.books.Details;

import com.example.smartlib.repository.dto.Books;

public interface IDetailsView {

    void showErrorMessage(String s);

    void displayBookDetails(Books books);
}
