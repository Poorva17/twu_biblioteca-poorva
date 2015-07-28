package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<String> bookList;

    public Library(ArrayList<String> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<String> showList() {
        return bookList;
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;

        Library that = (Library) other;

        return !(bookList != null ? !bookList.equals(that.bookList) : that.bookList != null);

    }

    @Override
    public int hashCode() {
        return bookList != null ? bookList.hashCode() : 0;
    }
}
