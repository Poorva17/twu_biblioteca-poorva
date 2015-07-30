package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.*;

import static org.junit.Assert.assertEquals;


public class InputTest {

    @Before
    public void setUpStreams() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
    }

    @Test
    public void shouldReturnInput() {
        View view = Mockito.mock(View.class);
        int choice = 0;
        Input input = new Input(choice, view);

        choice = input.acceptInput();

        assertEquals(1, choice);
    }

    @After
    public void cleanUpStreams() {
        System.setIn(System.in);
    }
}
