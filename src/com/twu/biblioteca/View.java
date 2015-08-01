package com.twu.biblioteca;


public class View {

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printListOfBooks(Library library) {
        for (Book book : library.getBooklist()) {
            System.out.print(book.getDetails());
        }
    }
}




