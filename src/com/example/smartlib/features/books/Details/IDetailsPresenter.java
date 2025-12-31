package com.example.smartlib.features.books.Details;

import com.example.smartlib.repository.dto.Books;

public interface IDetailsPresenter {
     Integer age = 0;

    void getBookDetails(String bookId);

    void init();

     void showErrorMessage(String s);

  void displayBookDetails(Books books);


}
