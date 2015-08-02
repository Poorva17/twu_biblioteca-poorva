package com.twu.biblioteca;

public abstract class Item {
    String title;

    public boolean hasTitle(String titleToCheck) {
        return title.equalsIgnoreCase(titleToCheck);
    }
}
