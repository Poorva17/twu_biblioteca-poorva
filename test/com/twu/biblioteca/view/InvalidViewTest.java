package com.twu.biblioteca.view;

import com.twu.biblioteca.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class InvalidViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream original;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
        original = System.out;
    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }

    @Test
    public void shouldPrintErrorMessage() {
        InvalidView invalidView = new InvalidView();
        String errorMessage = "\nAuthentication Error!!!\n";
        User currentUser = Mockito.mock(User.class);

        invalidView.render(currentUser);
        assertEquals(errorMessage, outputStream.toString());
    }
}
