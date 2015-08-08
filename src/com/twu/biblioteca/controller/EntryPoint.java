package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.AdminMenuView;
import com.twu.biblioteca.view.Input;
import com.twu.biblioteca.view.InvalidView;
import com.twu.biblioteca.view.UserMenuView;
import com.twu.biblioteca.view.View;
import com.twu.biblioteca.view.WelcomeView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class EntryPoint {

    public static void main(String[] args) {
        View view = new View();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Input input = new Input(bufferedReader);
        Book book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Book book2 = new Book("Data Structures", "Forouzan", "2002");
        ArrayList<Item> availableBookList = new ArrayList<Item>();
        Movie movie1 = new Movie("Krish", "2011", "Rakesh Roshan", "4");
        Movie movie2 = new Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<Item> availableMovieList = new ArrayList<Item>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        availableBookList.add(book1);
        availableBookList.add(book2);
        HashMap<Item, User> userBookList = new HashMap<Item, User>();
        HashMap<Item, User> userMovieList = new HashMap<Item, User>();
        Section bookSection = new Section(availableBookList, userBookList);
        Section movieSection = new Section(availableMovieList, userMovieList);
      //  Library library = new Library(availableBookList, availableMovieList, userBookList, userMovieList);
        User user1 = new User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "111-1111", "poorva@3", "user");
        User user2 = new User("Poorva1", "poorvasgokhale@gmail.com", "9604590231", "222-2222", "poorva@17", "user");
        User user3 = new User("Admin", "poorvasgokhale@gmail.com", "9604590231", "000-0000", "admin1", "admin");
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        UserAccounts userAccounts = new UserAccounts(userList);
        Dispatcher dispatcher = new Dispatcher(view, bookSection, movieSection, input);
        Login login = new Login(userAccounts, input, view);
        AdminMenuView adminMenuView = new AdminMenuView(input, dispatcher);
        UserMenuView userMenuView = new UserMenuView(input, dispatcher);
        InvalidView invalidView = new InvalidView();
        DispatcherLogin dispatcherLogin = new DispatcherLogin(login, adminMenuView, userMenuView, invalidView);
        WelcomeView welcomeView = new WelcomeView(input, dispatcherLogin);
        BibliotecaApp bibliotecaapp = new BibliotecaApp(welcomeView);
        bibliotecaapp.start();
    }
}

