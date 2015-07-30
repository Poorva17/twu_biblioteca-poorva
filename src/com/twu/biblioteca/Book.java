package com.twu.biblioteca;


public class Book {
    private String title;
    private String author;
    private String yearPublished;
    private Boolean isAvailable;

    public Book(String title, String author, String yearPublished, Boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isAvailable = isAvailable;
    }

    public boolean ckeckout() {
        if(this.isAvailable) {
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return yearPublished;
    }
}
