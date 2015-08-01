package com.twu.biblioteca;

import java.io.BufferedReader;


public class Input {

    BufferedReader bufferedReader;

    public Input(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int acceptInput() {
        int choice = 0;
        try {
            choice = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
        }
        return choice;
    }

    public String acceptBookName() {
        String bookName = "";
        try {
            bookName = bufferedReader.readLine();
            return bookName;
        } catch (Exception e) {
        }
        return bookName;
    }
}
