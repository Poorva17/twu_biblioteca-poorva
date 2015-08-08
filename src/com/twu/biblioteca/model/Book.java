package com.twu.biblioteca.model;

public class Book extends Item {
    private String author;
    private String yearPublished;

    public Book(String title, String author, String yearPublished) {
        super(title);
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String getDetails() {
        return String.format("%-20s %-20s %-20s\n", title, author, yearPublished);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (!author.equals(book.author)) return false;
        return yearPublished.equals(book.yearPublished);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + yearPublished.hashCode();
        return result;
    }
}
