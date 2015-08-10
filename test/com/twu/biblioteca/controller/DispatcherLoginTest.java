package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.view.AdminMenuView;
import com.twu.biblioteca.view.InvalidView;
import com.twu.biblioteca.view.UserMenuView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


public class DispatcherLoginTest {

    @Test
    public void shouldReturnLoginIfChoiceIs1() {
        Login login = Mockito.mock(Login.class);
        InvalidView invalidView = Mockito.mock(InvalidView.class);
        AdminMenuView adminMenuView = Mockito.mock(AdminMenuView.class);
        UserMenuView userMenuView = Mockito.mock(UserMenuView.class);
        DispatcherLogin dispatcherLogin = new DispatcherLogin(login, adminMenuView, userMenuView, invalidView);
        User user1 = new User("Poorva", "poorvasgokhale@gmail.com", "9604590231", "111-1111", "poorva@3", "user");
        Mockito.when(login.checkLogin()).thenReturn(user1);

        assertEquals(user1, dispatcherLogin.dispatch("1"));
    }

    @Test
    public void shouldReturnAdminMenuIfUserIsAdmin() {
        Login login = Mockito.mock(Login.class);
        InvalidView invalidView = Mockito.mock(InvalidView.class);
        AdminMenuView adminMenuView = Mockito.mock(AdminMenuView.class);
        UserMenuView userMenuView = Mockito.mock(UserMenuView.class);
        DispatcherLogin dispatcherLogin = new DispatcherLogin(login, adminMenuView, userMenuView, invalidView);
        User user = Mockito.mock(User.class);
        Mockito.when(user.isAdmin()).thenReturn(true);

        assertEquals(adminMenuView, dispatcherLogin.dispatchMenu(user));
    }

    @Test
    public void shouldReturnUserMenuIfUserIsNotAdmin() {
        Login login = Mockito.mock(Login.class);
        InvalidView invalidView = Mockito.mock(InvalidView.class);
        AdminMenuView adminMenuView = Mockito.mock(AdminMenuView.class);
        UserMenuView userMenuView = Mockito.mock(UserMenuView.class);
        DispatcherLogin dispatcherLogin = new DispatcherLogin(login, adminMenuView, userMenuView, invalidView);
        User user = Mockito.mock(User.class);
        Mockito.when(user.isAdmin()).thenReturn(false);
        Mockito.when(user.isUser()).thenReturn(true);

        assertEquals(userMenuView, dispatcherLogin.dispatchMenu(user));
    }
}
