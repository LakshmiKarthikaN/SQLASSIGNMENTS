package com.example.smartlib.features.books.Details;


import com.example.smartlib.repository.dto.Books;

public class DetailsPresenter implements IDetailsPresenter {
    private final IDetailsModal modal;
    private final IDetailsView view;
    public DetailsPresenter(DetailsView detailsView){
        view = detailsView;
        modal = new DetailsModal(this);
    }
    public void init(){
        modal.init();
    }
    public void getBookDetails(String bookId) {
        modal.getBookDetails(bookId);
    }

    public void showErrorMessage(String s) {
        view.showErrorMessage(s);
    }

    public void displayBookDetails(Books books) {
        view.displayBookDetails(books);
    }
}
