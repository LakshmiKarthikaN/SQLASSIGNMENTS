package com.example.smartlib.features.books.Manage;

import com.example.smartlib.repository.dto.Books;

import java.util.List;

public interface IManageView {
    void displayBooks(List<Books> book);

    void showSuccessMessage(String bookAddedSuccessfully);

    void showErrorMessage(String s);


}
