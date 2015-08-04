package com.twu.biblioteca;

import java.io.BufferedReader;


public class Input {

    BufferedReader bufferedReader;

    public Input(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int acceptChoice() {
        int choice = 0;
        try {
            choice = Integer.parseInt(bufferedReader.readLine());
        }
        catch (Exception e) {
        }
        return choice;
    }

    public String acceptInput() {
        String bookName = "";
        try {
            bookName = bufferedReader.readLine();
            return bookName;
        }
        catch (Exception e) {
        }
        return bookName;
    }
}
