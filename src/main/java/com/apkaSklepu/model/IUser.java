package com.apkaSklepu.model;

import com.apkaSklepu.model.implementation.User;

public interface IUser {
    String getLogin();

    void setLogin(String login);

    String getPassword();

    void setPassword(String password);

    User.Role getRole();

    void setRole(User.Role role);

    String toString();
}
