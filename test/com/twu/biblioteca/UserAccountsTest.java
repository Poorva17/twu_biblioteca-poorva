package com.twu.biblioteca;


import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserAccountsTest {

    @Test
    public void shouldReturnUserDetails() {
        User user = Mockito.mock(User.class);
        when(user.displayInformation()).thenReturn("Poorva poorvasgokhale@gmail.com 9604590231 poorva3 poorva@3");
        when(user.matchCredentials("poorva3", "poorva@3")).thenReturn(true);
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user);
        UserAccounts userAccounts = new UserAccounts(userList);

        assertEquals(user, userAccounts.displayInformation("poorva3", "poorva@3"));
    }
}
