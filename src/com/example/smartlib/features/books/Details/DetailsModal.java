package com.example.smartlib.features.books.Details;

import com.example.smartlib.repository.db.SmartLib;
import com.example.smartlib.repository.dto.Books;

import java.util.Optional;

public class DetailsModal implements IDetailsModal {
    private final IDetailsPresenter presenter;
    public DetailsModal(IDetailsPresenter detailsPresenter){
        presenter = detailsPresenter;
    }
 public void init(){
     presenter.init();
 }
  public void getBookDetails(String bookId){
        if(bookId==null || bookId.trim().isEmpty()){
            presenter.showErrorMessage("Please enter a valid Book Id");
            return;
        }
      Optional<Books> book = SmartLib.getInstance().getAllBooks().stream()
              .filter(b ->b.getId().equals(bookId)).findFirst();
        presenter.displayBookDetails(book.orElse(null));
    }

}
