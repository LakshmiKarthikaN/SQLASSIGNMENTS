package com.example.smartlib.features.books;

import com.example.smartlib.repository.db.SmartLib;
import com.example.smartlib.repository.dto.Books;

import java.util.List;

public class BooksModal implements IBooksModal{
   private final IBooksPresenter presenter;
    public BooksModal(IBooksPresenter booksPresenter){
        presenter = booksPresenter;
    }
   public void viewAllBooks(){
        List<Books> books = SmartLib.getInstance().getAllBooks();
        presenter.displayBooks(books);
   }


}
