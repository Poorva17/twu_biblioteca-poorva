package com.twu.biblioteca;

public class Dispatcher {
    private View view;
    private Library bookList;
    private Input input;

    public Dispatcher(View view, Library bookList, Input input) {
        this.view = view;
        this.bookList = bookList;
        this.input = input;
    }

    public void dispatch(int choice) {
        switch (choice) {
            case 1:
                view.printListOfBooks(bookList);
                break;
            case 2:
                if(bookList.checkout(input.acceptBookName())) {
                    view.printMessage("Thank you! Enjoy the book");
                }
                else {
                    view.printMessage("That book is not available.");
                }
                break;
            case 3:
                if(bookList.checkin(input.acceptBookName())) {
                    view.printMessage("Thank you for returning the book.");
                }
                else {
                    view.printMessage("That is not a valid book to return.");
                }
                break;

            case 4:
                System.exit(0);
                break;
            default:
                view.printMessage("Select valid option!");
        }
    }
}