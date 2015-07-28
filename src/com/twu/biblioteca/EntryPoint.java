package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntryPoint {

    public static void main(String[] args) {
        View view = new View();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(view);
        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.createBookList();
        bibliotecaApp.showMenu();
        view.printMessage("Enter your choice:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int ch =Integer.parseInt(br.readLine());
            switch (ch)
            {
                case 1: bibliotecaApp.showList();
                        break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

