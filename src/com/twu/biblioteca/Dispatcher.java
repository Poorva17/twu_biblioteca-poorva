package com.twu.biblioteca;

public class Dispatcher {
    private View view;
    private Library library;
    private Input input;

    public Dispatcher(View view, Library library, Input input) {
        this.view = view;
        this.library = library;
        this.input = input;
    }

    public void dispatch() {
        switch (input.acceptInput()) {
            case 1:
                view.printMessage("Book title\tAuthor\tYear published\n");
                view.printMessage("----------------------------------\n");
                view.printListOfBooks(library.getAvailableBooklist());
                break;
            case 2:
                view.printMessage("Enter book name:\n");
                String bookNameToCheckout = input.acceptBookName();
                view.printCheckoutStatus(library.bookCheckout(bookNameToCheckout));
                break;
            case 3:
                view.printMessage("Enter book name:\n");
                String bookNameToCheckin = input.acceptBookName();
                view.printCheckinStatus(library.bookCheckin(bookNameToCheckin));
                break;
            case 4:
                view.printMessage("List of Checkout Books\n");
                view.printMessage("Book title\tAuthor\tYear published\n");
                view.printMessage("----------------------------------\n");
                view.printListOfBooks(library.getBookCheckoutList());
                break;
            case 5:
                view.printMessage("Movie tiltle\tYear published\tDirector\tMovie rating\n");
                view.printMessage("----------------------------------------------------\n");
                view.printListOfMovies(library.getAvailableMovieList());
                break;
            case 6:
                System.exit(0);
                break;
            default:
                view.printMessage("Select valid option!\n");
        }
    }
}