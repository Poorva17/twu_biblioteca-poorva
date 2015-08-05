package com.twu.biblioteca;

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
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        ArrayList<Book> checkoutBookList = new ArrayList<Book>();
        Movie movie1 = new Movie("Krish", "2011", "Rakesh Roshan", "4");
        Movie movie2 = new Movie("Krish2", "2013", "Rakesh Roshan", "4");
        ArrayList<Movie> availableMovieList = new ArrayList<Movie>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        ArrayList<Movie> checkoutMovieList = new ArrayList<Movie>();
        availableBookList.add(book1);
        availableBookList.add(book2);
        HashMap<User, ArrayList<Book>> userBookList = new HashMap<User, ArrayList<Book>>();
        HashMap<User, ArrayList<Movie>> userMovieList = new HashMap<User, ArrayList<Movie>>();
        Library library = new Library(availableBookList, checkoutBookList, availableMovieList, checkoutMovieList, userBookList, userMovieList);
        User user1 = new User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "poorva3", "poorva@3", "user");
        User user2 = new User("Poorva1", "poorvasgokhale@gmail.com", "9604590231", "poorva17", "poorva@17", "user");
        User user3 = new User("Admin", "poorvasgokhale@gmail.com", "9604590231", "poorva17", "admin1", "admin");
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        UserAccounts userAccounts = new UserAccounts(userList);
        Dispatcher dispatcher = new Dispatcher(view, library, input);
        Login login = new Login(userAccounts, input, view);
        BibliotecaApp bibliotecaapp = new BibliotecaApp(view, dispatcher, login, input);
        bibliotecaapp.start();
    }
}

