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

    public void dispatch() {
        switch (input.acceptInput()) {
            case 1:
                view.printMessage("Book title\tAuthor\tYear published\n");
                view.printMessage("----------------------------------\n");
                view.printListOfBooks(bookList);
                break;
            case 2:
                view.printMessage("Enter book name:\n");
                if(bookList.checkout(input.acceptBookName())) {
                    view.printMessage("Thank you! Enjoy the book\n");
                }
                else {
                    view.printMessage("That book is not available.\n");
                }
                break;
            case 3:
                view.printMessage("Enter book name:\n");
                if(bookList.checkin(input.acceptBookName())) {
                    view.printMessage("Thank you for returning the book.\n");
                }
                else {
                    view.printMessage("That is not a valid book to return.\n");
                }
                break;

            case 4:
                System.exit(0);
                break;
            default:
                view.printMessage("Select valid option!\n");
        }
    }
}