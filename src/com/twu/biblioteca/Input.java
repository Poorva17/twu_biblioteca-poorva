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
            System.out.print("Error!!!");
        }
        return this.choice;
    }
}
