package com.twu.biblioteca.model;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class UserAccountsTest {

    @Test
    public void shouldReturnTrueIfUserCredentialsMatch() {
        User user = Mockito.mock(User.class);
        Mockito.when(user.matchCredentials("000-0000", "admin1")).thenReturn(true);
        ArrayList <User> users = new ArrayList<>();
        users.add(user);
        UserAccounts userAccounts = new UserAccounts(users);

        assertEquals(true, userAccounts.checkLogin("000-0000", "admin1"));
    }

    @Test
    public void shouldReturnUserIfUserCredentialsMatch() {
        User user = Mockito.mock(User.class);
        Mockito.when(user.matchCredentials("000-0000", "admin1")).thenReturn(true);
        ArrayList <User> users = new ArrayList<>();
        users.add(user);
        UserAccounts userAccounts = new UserAccounts(users);

        assertEquals(user, userAccounts.getUser("000-0000", "admin1"));
    }
}
