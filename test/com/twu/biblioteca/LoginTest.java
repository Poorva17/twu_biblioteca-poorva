package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void shouldReturnRole() {
        View view = Mockito.mock(View.class);
        Input input = Mockito.mock(Input.class);
        UserAccounts userAccounts = Mockito.mock(UserAccounts.class);
        Login login = new Login(userAccounts, input, view);
        Mockito.when(input.acceptInput()).thenReturn("poorva3 poorva@3");
        view.printMessage(userAccounts.checkLogin("poorva3 poorva@3"));
        Mockito.when(userAccounts.checkLogin("poorva3 poorva@3")).thenReturn("user Poorva poorvasgokhale@gmail.com 9604590231\n");

        assertEquals("user", login.checkLogin());
    }
}
