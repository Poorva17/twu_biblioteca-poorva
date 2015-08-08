package com.twu.biblioteca.model;

public class Item {
    String title;

    public Item(String title) {
        this.title = title;
    }

    public String getDetails() {
        return String.format("%-20s", title);
    }

    public boolean hasTitle(String titleToCheck) {
        return title.equalsIgnoreCase(titleToCheck);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return title.equals(item.title);

    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
