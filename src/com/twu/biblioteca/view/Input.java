package com.twu.biblioteca.view;

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
        String inputString = "";
        try {
            inputString = bufferedReader.readLine();
            return inputString;
        }
        catch (Exception e) {
        }
        return inputString;
    }
}
