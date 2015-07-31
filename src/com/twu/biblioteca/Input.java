package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Input {

    public int acceptInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (Exception e) {
        }
        return choice;
    }

    public String acceptBookName() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bookName = "";
        try {
            bookName = br.readLine();
            return bookName;
        } catch (Exception e) {
        }
        return bookName;
    }
}
