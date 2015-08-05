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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!author.equals(book.author)) return false;
        return yearPublished.equals(book.yearPublished);

    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + yearPublished.hashCode();
        return result;
    }
}
