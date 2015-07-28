package com.twu.biblioteca;

import java.util.ArrayList;

public class ListOfBooks {
    private ArrayList<Book> bookList;

    public ListOfBooks(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void showList() {
        for (Book book : bookList) {
            System.out.println(book.getName());
        }
    }

    public void addBooks() {
        Book book1 = new Book("Harry Potter");
        Book book2 = new Book("Head First Java");
        bookList.add(book1);
        bookList.add(book2);
    }
}
