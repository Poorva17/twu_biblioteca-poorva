package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;


public class BibliotecaAppTest {

    @Test
    public void shouldPrintWelcomeMessage() {
        View view = Mockito.mock(View.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(view);

        bibliotecaApp.printWelcomeMessage();
        Mockito.verify(view).printMessage("Welcome to Biblioteca");
    }

    @Test
    public void shouldPrintListOfBooks() {
        View view = Mockito.mock(View.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(view);
        ArrayList<String[]> bookList = bibliotecaApp.createBookList();
        bibliotecaApp.showList();

        Mockito.verify(view).printListOfBooks(bookList);
    }

    @Test
    public void shouldPrintMenu() {
        View view = Mockito.mock(View.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(view);
        bibliotecaApp.createBookList();
        bibliotecaApp.showMenu();

        Mockito.verify(view).printMessage("Menu");
        Mockito.verify(view).printMessage("1.List Of Books");
        Mockito.verify(view).printMessage("2.Quit");
    }
}
