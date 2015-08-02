package com.twu.biblioteca;


public class Book extends Item {
    private String author;
    private String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getDetails() {
        return title + "\t" + author + "\t" + yearPublished + "\n";
    }
}
