package com.example.smartlib.features.books.Manage;


import com.example.smartlib.repository.db.SmartLib;
import com.example.smartlib.repository.dto.Books;

import java.util.List;
import java.util.UUID;

public class ManageModal implements IManageModal{
    private IManagePresenter presenter;
    public ManageModal(IManagePresenter managePresenter){
        presenter = managePresenter;
    }
    void init(){

    }

    public void viewAllBooks() {
        List<Books> book = SmartLib.getInstance().getAllBooks();
        presenter.displayBooks(book);
    }
    private boolean validateBook(Books book){
        return book !=null &&
                book.getName()!=null && !book.getName().trim().isEmpty() &&
                book.getAuthor()!=null && !book.getAuthor().trim().isEmpty() &&
                book.getGenre()!=null && !book.getGenre().trim().isEmpty() &&
                book.getVolume() >0 &&
                book.getPublishedYear()!=null && book.getPublishedYear()>=1800 && book.getPublishedYear()<=2025 &&
                book.getNoOfCopy() >0 &&
                book.getAvailableCount() >= 0 && book.getAvailableCount() <= book.getNoOfCopy();
    }
    private String generateBookId() {
        return "BK" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

    public void addBook(Books book) {

        if(validateBook(book)){
            book.setId(generateBookId());
            SmartLib.getInstance().addBook(book);
            presenter.showSuccessMessage("Book added Successfully");

        }else{
            presenter.showErrorMessage("Invalid book information.please try again");
        }
    }
}
