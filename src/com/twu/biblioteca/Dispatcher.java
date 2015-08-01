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
                String bookNameToCheckout = input.acceptBookName();
                view.printCheckoutStatus(bookList.checkout(bookNameToCheckout));
                break;
            case 3:
                view.printMessage("Enter book name:\n");
                String bookNameToCheckin = input.acceptBookName();
                view.printCheckinStatus(bookList.checkin(bookNameToCheckin));
                break;

            case 4:
                System.exit(0);
                break;
            default:
                view.printMessage("Select valid option!\n");
        }
    }
}