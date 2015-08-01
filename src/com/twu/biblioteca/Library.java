package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<Book> availableBookList;
    private ArrayList<Book> checkedOutBookList;

    public Library(ArrayList<Book> availableBookList, ArrayList<Book> checkedOutBookList) {
        this.availableBookList = availableBookList;
        this.checkedOutBookList = checkedOutBookList;
    }

    public boolean checkout(String bookNameToCheckout) {
        for (Book book : availableBookList) {
            if (book.hasTitle(bookNameToCheckout)) {
                addToCheckoutList(book);
                return true;
            }
        }
        return false;
    }

    private void addToCheckoutList(Book book) {
        availableBookList.remove(book);
        checkedOutBookList.add(book);
    }

    public ArrayList<Book> getBooklist() {
        return availableBookList;
    }

    public boolean checkin(String bookNameToCheckin) {
        for (Book book : checkedOutBookList) {
            if (book.hasTitle(bookNameToCheckin)) {
                addToCheckinList(book);
                return true;
            }
        }
        return false;
    }

    private void addToCheckinList(Book book) {
        availableBookList.add(book);
        checkedOutBookList.remove(book);
    }
}
