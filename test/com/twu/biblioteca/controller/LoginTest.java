package com.twu.biblioteca.controller;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void shouldReturnRole() {
        com.twu.biblioteca.view.View view = Mockito.mock(com.twu.biblioteca.view.View.class);
        com.twu.biblioteca.view.Input input = Mockito.mock(com.twu.biblioteca.view.Input.class);
        com.twu.biblioteca.model.UserAccounts userAccounts = Mockito.mock(com.twu.biblioteca.model.UserAccounts.class);
        com.twu.biblioteca.controller.Login login = new com.twu.biblioteca.controller.Login(userAccounts, input, view);
        Mockito.when(input.acceptInput()).thenReturn("poorva3").thenReturn("poorva@3");
        Mockito.when(userAccounts.checkLogin("poorva3", "poorva@3")).thenReturn(true);
        com.twu.biblioteca.model.User user = new com.twu.biblioteca.model.User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "poorva3", "poorva@3", "user");
        Mockito.when(userAccounts.getUser("poorva3", "poorva@3")).thenReturn(user);

        assertEquals(user, login.checkLogin());
    }
}
