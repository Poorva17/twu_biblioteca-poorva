package com.twu.biblioteca;

public class User {
    private String userName;
    private String email;
    private String phoneNumber;
    private String userId;
    private String password;
    private String role;

    public User(String userName, String email, String phoneNumber, String userId, String password, String role) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    public String displayInformation() {
        return role + " "+ userName + " " + email + " " + phoneNumber + "\n";
    }

    public boolean matchCredentials(String userName, String password) {
        return (this.userId.equals(userName) && this.password.equals(password));
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;

        User user = (User) that;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public boolean isAdmin() {
        if (role.equals("admin"))
            return true;
        return false;
    }

    public boolean isUser() {
        if (role.equals("user"))
            return true;
        return false;
    }
}
