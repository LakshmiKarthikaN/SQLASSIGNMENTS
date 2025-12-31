package com.example.smartlib.features.books;

import com.example.smartlib.repository.dto.Books;

import java.util.List;

public interface IBooksView {
    void displayBooks(List<Books> books);
}
