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

    public void dispatch(int choice, User currentUser) {
        switch (choice) {
            case 0:
                view.printMessage(currentUser.displayInformation());
                break;
            case 1:
                view.printMessage(String.format("\n\n\n%-20s %-20s %-20s\n","Book Title", "Author", "Year Published"));
                view.printMessage("-------------------------------------------------------------------------\n");
                view.printListOfBooks(library.getAvailableBooklist());
                break;
            case 2:
                view.printMessage("Enter book name:\n");
                String bookNameToCheckout = input.acceptInput();
                view.printBookCheckoutStatus(library.bookCheckout(bookNameToCheckout, currentUser));
                break;
            case 3:
                view.printMessage("Enter book name:\n");
                String bookNameToCheckin = input.acceptInput();
                view.printBookCheckinStatus(library.bookCheckin(bookNameToCheckin, currentUser));
                break;
            case 4:
                view.printMessage(String.format("\n%-20s %-20s %-20s %-20s\n","Movie Title", "Year published", "Director", "Movie Rating"));
                view.printMessage("-----------------------------------------------------------------------------------\n");
                view.printListOfMovies(library.getAvailableMovieList());
                break;
            case 5:
                view.printMessage("Enter movie name:\n");
                String movieNameToCheckout = input.acceptInput();
                view.printMovieCheckoutStatus(library.movieCheckout(movieNameToCheckout, currentUser));
                break;
            case 6:
                view.printMessage("Enter movie name:\n");
                String movieNameToCheckin = input.acceptInput();
                view.printMovieCheckinStatus(library.movieCheckin(movieNameToCheckin, currentUser));
                break;
            case 7:
                view.printMessage("\n\nList of Checkout Books\n");
                view.printMessage(String.format("\n%-20s %-20s %-20s\n","Book Title", "Author", "Year Published\n"));
                view.printMessage("-----------------------------------------------------------------------------------\n");
                view.printHashMapBook(library.getBookCheckoutList());
                break;
            case 8:
                view.printMessage("List of Checkout Movies\n");
                view.printMessage(String.format("\n\n\n%-20s %-20s %-20s %-20s","Movie Title", "Year published", "Director", "Movie Rating\n"));
                view.printMessage("------------------------------------------------------------------------------------\n");
                view.printHashMapMovie(library.getMovieCheckoutList());
                break;
            default:
                view.printMessage("Select valid option!\n");
        }
    }
}