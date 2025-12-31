package com.example.smartlib.features.books;

import com.example.smartlib.repository.dto.Books;

import java.util.List;

public class BooksPresenter implements IBooksPresenter{
           private final IBooksModal modal;
           private final IBooksView view;
       public BooksPresenter(IBooksView booksView){
           view = booksView;
           modal = new BooksModal(this);
      }

    public void displayBooks(List<Books> books) {
           view.displayBooks(books);
    }

    public void viewAllBooks() {
           modal.viewAllBooks();
    }
}
