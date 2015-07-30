package com.twu.biblioteca;

public class Dispatcher {
    private View view;
    private Library bookList;

    public Dispatcher(View view, Library bookList) {
        this.view = view;
        this.bookList = bookList;
    }

    public void dispatch(int choice) {
        switch (choice) {
            case 1:
                view.printListOfBooks(this.bookList);
                break;
            case 2:
                System.exit(0);
                break;
            default:
                view.printMessage("Select valid option!");
        }
    }
}