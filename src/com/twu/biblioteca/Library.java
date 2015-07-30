package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<Book> bookList;

    public Library(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public boolean checkout(String bookNameToCheckout) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookNameToCheckout)) {
                return book.ckeckout();
            }
        }
        return false;
    }

    public ArrayList<Book> getBooklist() {
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        for (Book book : this.bookList) {
            if(book.isAvailable()) {
                availableBookList.add(book);
            }
        }
        return availableBookList;
    }

    public boolean checkin(String bookNameToCheckin) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(bookNameToCheckin)) {
                return book.ckeckin();
            }
        }
        return false;
    }
}
