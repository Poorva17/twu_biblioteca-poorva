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
            int choice;
            String choiceForMenu;

            do {
                choice = Integer.parseInt(br.readLine());
                switch (choice)
                {
                    case 1:
                        bibliotecaApp.showList();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        view.printMessage("Select valid option!");

                }
                view.printMessage("Do you want to continue (Y/N):");
                choiceForMenu = br.readLine();
                view.printMessage("Enter your choice:");
            } while (choiceForMenu.equals("Y"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

