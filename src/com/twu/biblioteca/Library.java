package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<Book> bookList;

    public Library(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public boolean checkout(String bookNameToCheckout) {
        for (Book book : bookList) {
            if (book.getTitle().equals(bookNameToCheckout)) {
                return book.ckeckout();
            }
        }
        return false;
    }

    public ArrayList<Book> getBooklist() {
        return bookList;
    }
}
