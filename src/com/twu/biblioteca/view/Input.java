package com.twu.biblioteca.view;

import java.io.BufferedReader;


public class Input {

    BufferedReader bufferedReader;

    public Input(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String acceptChoice() {
        String choice = "";
        try {
            choice = bufferedReader.readLine();
        }
        catch (Exception e) {
            System.out.print("Select valid option!!!");
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
