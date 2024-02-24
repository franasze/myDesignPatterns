package com.apkaSklepu.model.implementation;

import com.apkaSklepu.model.IUser;

public class User implements IUser {
    private String login;
    private String password;
    private Role role;

    public User(String login, String password, Role role){
        this.login = login;
        this.password = password;
        this.role = role;
    }


    public User(){
        this.role=Role.USER;
    }
    @Override
    public String getLogin() {
        return login;
    }
    @Override
    public void setLogin(String login) {
        this.login = login;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public Role getRole() {
        return role;
    }
    @Override
    public void setRole(Role role) {
        this.role = role;
    }
    public enum Role{
        ADMIN,
        USER
    }
    @Override
    public String toString() {
        return "User" +
                "login = " + login +
                ", password = " + password +
                ", role = " + role;
    }
}