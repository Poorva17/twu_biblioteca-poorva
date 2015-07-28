package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class ViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream original;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));

    }

    @After
    public void cleanUpStreams() {
        System.setOut(original);
    }

    @Test
    public void  shouldPrintCorrectWelcomeMessage() {
        View view = new View();

        view.printWelcomeMessage();

        assertEquals("Welcome to Biblioteca!!!", outputStream.toString());
    }
}

