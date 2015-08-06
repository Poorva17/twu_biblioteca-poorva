package com.twu.biblioteca.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class EntryPoint {

    public static void main(String[] args) {
        com.twu.biblioteca.view.View view = new com.twu.biblioteca.view.View();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        com.twu.biblioteca.view.Input input = new com.twu.biblioteca.view.Input(bufferedReader);
        com.twu.biblioteca.model.Book book1 = new com.twu.biblioteca.model.Book("Computer Networks", "Taneunbaum", "2008");
        com.twu.biblioteca.model.Book book2 = new com.twu.biblioteca.model.Book("Data Structures", "Forouzan", "2002");
        ArrayList<com.twu.biblioteca.model.Book> availableBookList = new ArrayList<com.twu.biblioteca.model.Book>();
        com.twu.biblioteca.model.Movie movie1 = new com.twu.biblioteca.model.Movie("Krish", "2011", "Rakesh Roshan", "4");
        com.twu.biblioteca.model.Movie movie2 = new com.twu.biblioteca.model.Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<com.twu.biblioteca.model.Movie> availableMovieList = new ArrayList<com.twu.biblioteca.model.Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        availableBookList.add(book1);
        availableBookList.add(book2);
        HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User> userBookList = new HashMap<com.twu.biblioteca.model.Book, com.twu.biblioteca.model.User>();
        HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User> userMovieList = new HashMap<com.twu.biblioteca.model.Movie, com.twu.biblioteca.model.User>();
        com.twu.biblioteca.model.Library library = new com.twu.biblioteca.model.Library(availableBookList, availableMovieList, userBookList, userMovieList);
        com.twu.biblioteca.model.User user1 = new com.twu.biblioteca.model.User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "poorva3", "poorva@3", "user");
        com.twu.biblioteca.model.User user2 = new com.twu.biblioteca.model.User("Poorva1", "poorvasgokhale@gmail.com", "9604590231", "poorva17", "poorva@17", "user");
        com.twu.biblioteca.model.User user3 = new com.twu.biblioteca.model.User("Admin", "poorvasgokhale@gmail.com", "9604590231", "poorva17", "admin1", "admin");
        ArrayList<com.twu.biblioteca.model.User> userList = new ArrayList<com.twu.biblioteca.model.User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        com.twu.biblioteca.model.UserAccounts userAccounts = new com.twu.biblioteca.model.UserAccounts(userList);
        com.twu.biblioteca.controller.Dispatcher dispatcher = new com.twu.biblioteca.controller.Dispatcher(view, library, input);
        com.twu.biblioteca.controller.Login login = new com.twu.biblioteca.controller.Login(userAccounts, input, view);
        com.twu.biblioteca.view.AdminMenuView adminMenuView = new com.twu.biblioteca.view.AdminMenuView(input, dispatcher);
        com.twu.biblioteca.view.UserMenuView userMenuView = new com.twu.biblioteca.view.UserMenuView(input, dispatcher);
        com.twu.biblioteca.view.InvalidView invalidView = new com.twu.biblioteca.view.InvalidView();
        com.twu.biblioteca.controller.DispatcherLogin dispatcherLogin = new com.twu.biblioteca.controller.DispatcherLogin(login, adminMenuView, userMenuView, invalidView);
        com.twu.biblioteca.view.WelcomeView welcomeView = new com.twu.biblioteca.view.WelcomeView(input, dispatcherLogin);
        com.twu.biblioteca.controller.BibliotecaApp bibliotecaapp = new com.twu.biblioteca.controller.BibliotecaApp(welcomeView);
        bibliotecaapp.start();
    }
}

