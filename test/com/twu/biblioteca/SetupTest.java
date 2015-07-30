package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

public class SetupTest {

    @Test
    public void shouldPrintWelcomeMessage() {
        View view = Mockito.mock(View.class);
        Setup setup = new Setup(view);

        setup.showWelcomeMessage();

        Mockito.verify(view).printMessage("Welcome to Biblioteca");
    }

    @Test
    public void shouldShowMenu() {
        View view = Mockito.mock(View.class);
        Setup setup = new Setup(view);

        setup.showMenu();

        Mockito.verify(view).printMessage("Menu");
        Mockito.verify(view).printMessage("1.List Of Books");
        Mockito.verify(view).printMessage("2.Checkout Book");
        Mockito.verify(view).printMessage("3.Return Book");
        Mockito.verify(view).printMessage("4.Quit");
    }
}
