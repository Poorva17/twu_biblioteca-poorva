package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Input {
    private int choice;
    View view;

    public Input(int choice, View view) {
        this.choice = choice;
        this.view = view;
    }

    public int acceptInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            view.printMessage("Enter your choice:");
            this.choice = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            view.printMessage("Error!!!");
        }
        return this.choice;
    }

    public String acceptBookName() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bookName = "";
        try {
            view.printMessage("Enter book name:");
            bookName = br.readLine();
            return bookName;
        } catch (Exception e) {
            view.printMessage("Error!!!");
        }
        return bookName;
    }
}
