package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import static org.junit.Assert.assertEquals;


public class InputTest {

    @Before
    public void setUpStreams() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
    }

    @Test
    public void shouldReturnInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input(bufferedReader);

        int choice = input.acceptInput();

        assertEquals(1, choice);
    }

    @After
    public void cleanUpStreams() {
        System.setIn(System.in);
    }
}
