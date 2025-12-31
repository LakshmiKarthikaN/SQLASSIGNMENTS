package com.example.smartlib.features.books.search;

import com.example.smartlib.features.books.Details.IDetailsPresenter;
import com.example.smartlib.repository.dto.Books;

import java.util.List;

public class SearchPresenter implements ISearchPresenter {
  private final ISearchModal modal;
  private final ISearchView view;
  public SearchPresenter(ISearchView searchView){
      view  = searchView;
      modal = new SearchModal(this);
  }

    public void searchByName(String s) {
      modal.searchByName(s);
    }

    public void displayBooks(List<Books> books) {
      view.displayBooks(books);
    }

    public void showMessage(String pleaseEnterAValidName) {
      view.showMessage(pleaseEnterAValidName);
    }

    public void searchByAuthor(String s) {
      modal.searchByAuthor(s);
    }

    public void searchByGenre(String s) {
      modal.searchByGenre(s);
    }
}
