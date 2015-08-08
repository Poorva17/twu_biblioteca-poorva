package com.twu.biblioteca.model;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class SectionTest
{
    @Test
    public void shouldCheckoutItemIfAvailable() {
        User user = Mockito.mock(User.class);
        Book book = Mockito.mock(Book.class);
        Item expectedBook = new Book("Computer Networks", "Tanenbaum", "2011");
        ArrayList<Item> availableList = new ArrayList<Item>();
        availableList.add(expectedBook);
        HashMap<Item, User> checkedoutList = new HashMap<Item, User>();
        checkedoutList.put(book, user);
        Section section = new Section(availableList, checkedoutList);
        Mockito.when(book.hasTitle("Computer Networks")).thenReturn(true);

        assertEquals(expectedBook, section.itemCheckout("Computer NetWorks", user));
    }

    @Test
    public void shouldReturnValidItem() {
        Item book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        ArrayList<Item> availableList = new ArrayList<Item>();
        User currentUser = Mockito.mock(User.class);
        HashMap<Item, User> checkedoutList = new HashMap<Item, User>();
        checkedoutList.put(book1, currentUser);
        Section section = new Section(availableList, checkedoutList);

        assertEquals(book1, section.itemCheckin("Computer Networks", currentUser));
    }

    @Test
    public void shouldReturnAvailableItemList() {
        Item book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Item book2 = new Book("Data Structures", "Forouzan", "2011");
        ArrayList<Item> availableList = new ArrayList<Item>();
        availableList.add(book1);
        availableList.add(book2);
        HashMap<Item, User> checkedoutList = new HashMap<Item, User>();
        Section section = new Section(availableList, checkedoutList);

        assertEquals(availableList, section.getAvailableItemList());
    }

    @Test
    public void shouldReturnCheckedoutItemList() {
        Item book1 = new Book("Computer Networks", "Taneunbaum", "2008");
        Item book2 = new Book("Data Structures", "Forouzan", "2011");
        ArrayList<Item> availableList = new ArrayList<Item>();
        availableList.add(book1);
        User currentUser = Mockito.mock(User.class);
        HashMap<Item, User> checkedoutList = new HashMap<Item, User>();
        checkedoutList.put(book2, currentUser);
        Section section = new Section(availableList, checkedoutList);

        assertEquals(checkedoutList, section.getCheckoutList());
    }
}
