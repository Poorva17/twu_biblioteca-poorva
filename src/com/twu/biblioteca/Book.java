package com.twu.biblioteca;


public class Book {
    private String title;
    private String author;
    private String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public boolean hasTitle(String bookNameToCheckout) {
        if (bookNameToCheckout.equalsIgnoreCase(title))
            return true;
        return false;
    }

    public String getDetails() {
        return title+"\t"+author+"\t"+yearPublished+"\n";

    }
}
