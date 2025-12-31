package com.example.smartlib.features.books.search;


import com.example.smartlib.repository.db.SmartLib;
import com.example.smartlib.repository.dto.Books;

import java.util.List;
import java.util.stream.Collectors;

public class SearchModal implements ISearchModal {
    private final ISearchPresenter presenter;
    public SearchModal(ISearchPresenter searchPresenter){
        presenter = searchPresenter;
    }
   public void searchByName(String name){
        if(name == null || name.trim().isEmpty()){
            presenter.showMessage("Please enter a valid name");
            return;
        }
        List<Books> books = SmartLib.getInstance().getAllBooks().stream()
                .filter(book->book.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        presenter.displayBooks(books);
   }
   public void searchByAuthor(String author){
        if(author == null || author.trim().isEmpty()){
            presenter.showMessage("Please enter a valid author name.");
            return;
        }
        List<Books> books = SmartLib.getInstance().getAllBooks().stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
        presenter.displayBooks(books);
   }
   public void searchByGenre(String genre){
        if(genre == null || genre.trim().isEmpty()){
            presenter.showMessage("Please enter a valid Genre name.");
            return;
        }
        List<Books> books = SmartLib.getInstance().getAllBooks().stream()
                .filter(book->book.getGenre().toLowerCase().contains(genre.toUpperCase()))
                .collect(Collectors.toList());
        presenter.displayBooks(books);
   }
}
