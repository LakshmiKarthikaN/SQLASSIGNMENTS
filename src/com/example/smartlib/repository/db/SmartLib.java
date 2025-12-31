package com.example.smartlib.repository.db;

import com.example.smartlib.repository.dto.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SmartLib {
    private static SmartLib smartLib;
    private LibrarySetup library;
    private Users users;
private List<Users> userForAdd = new ArrayList<>();
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    private List<BorrowedBooks> borrowedBook = new ArrayList<>();

    public LibrarySetup getLibrary() {
        return library;
    }

    public void setLibrary(LibrarySetup library) {
        this.library = library;
    }

    private List<RegistrationInfo> user = new ArrayList<>();
private List<Books> books = new ArrayList<>();
private Books book;

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public RegistrationInfo getRegistrationInfo() {
        return registrationInfo;
    }

    public void setRegistrationInfo(RegistrationInfo registrationInfo) {
        this.registrationInfo = registrationInfo;
    }

    private RegistrationInfo registrationInfo;
    public SmartLib(){

    }

    public static SmartLib getInstance() {
        if(smartLib==null){
            smartLib =new SmartLib();
        }
        return smartLib;
    }

    public List<RegistrationInfo> getAllRegisteredUsers() {
        return new ArrayList<>(user);
    }

    public boolean validateLoginInfo(String username, String password) {
        for(RegistrationInfo users: user){
            if(users.getUserName().equalsIgnoreCase(username) && users.getPassword().equalsIgnoreCase(password)){
                return true;
            }

        }
        return false;
    }
  public void borrowBook(String userId,String bookId){
       BorrowedBooks borrowedBooks = new BorrowedBooks();
       borrowedBooks.setBookId(bookId);
       borrowedBooks.setUserId(userId);
       borrowedBooks.setBorrowDate(System.currentTimeMillis());
       long dueDate = System.currentTimeMillis()+(7L * 24 *60*60*1000);
       borrowedBooks.setDueDate(dueDate);
       borrowedBooks.setReturned(false);
       borrowedBooks.setFineAmount(0);
       borrowedBook.add(borrowedBooks);
  }
    public void addUser(RegistrationInfo info) {
        // Generate unique ID


        user.add(info);

        // Also store the last registered user
    }
public void addUserForManual(Users user){
        userForAdd.add(user);
}
public List<Users> getAllUsers(){
        return new ArrayList<>(userForAdd);
}
    public void addBook(Books book){
        books.add(book);
   }
    public List<Books> getAllBooks() {
        return new ArrayList<>(books);
    }
    public List<BorrowedBooks> getBorrowedBookByUser(String userId){
        List<BorrowedBooks> userBooks = new ArrayList<>();
        for(BorrowedBooks book : borrowedBook){
            if(book.getUserId().equals(userId)){
                userBooks.add(book);
            }
        }return userBooks;
    }
}
