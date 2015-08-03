package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserTest {

    @Test
    public void shouldPrintUserInformation() {
        User user = new User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "poorva3", "poorva@3");

        assertEquals("Poorva poorvasgokhale@gmail.com 9604590231 poorva3 poorva@3", user.displayInformation());
    }

    @Test
    public void shouldReturnTrueWhenCredentialsMatch() {
        User user = new User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "poorva3", "poorva@3");

        assertEquals(true, user.matchCredentials("poorva3", "poorva@3"));
    }

    @Test
    public void shouldReturnFaleWhenCredentialsDoesNotMatch() {
        User user = new User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "poorva3", "poorva@3");

        assertEquals(false, user.matchCredentials("poorva", "poorva@3"));
    }
}
