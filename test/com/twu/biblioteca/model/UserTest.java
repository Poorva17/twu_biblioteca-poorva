package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserTest {

    @Test
    public void shouldPrintUserInformation() {
        com.twu.biblioteca.model.User user = new com.twu.biblioteca.model.User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "poorva3", "poorva@3", "user");

        assertEquals("user Poorva poorvasgokhale@gmail.com 9604590231\n", user.displayInformation());
    }

    @Test
    public void shouldReturnTrueWhenCredentialsMatch() {
        com.twu.biblioteca.model.User user = new com.twu.biblioteca.model.User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "poorva3", "poorva@3", "user");

        assertEquals(true, user.matchCredentials("poorva3", "poorva@3"));
    }

    @Test
    public void shouldReturnFaleWhenCredentialsDoesNotMatch() {
        com.twu.biblioteca.model.User user = new com.twu.biblioteca.model.User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "poorva3", "poorva@3", "user");

        assertEquals(false, user.matchCredentials("poorva", "poorva12"));
    }
}
