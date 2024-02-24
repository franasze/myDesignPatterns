package com.apkaSklepu.database.implementation;

import com.apkaSklepu.database.IUserDB;
import com.apkaSklepu.model.IUser;
import com.apkaSklepu.model.implementation.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDB implements IUserDB {

    private final List<IUser> users = new ArrayList<>();
    private static final UserDB instance = new UserDB();


    public UserDB() {
        this.users.add(new User("admin", "a5c110f5ec7cda3eb0b241b1a2ca73e0", User.Role.ADMIN));
    }

    @Override
    public List<IUser> getUsers() {
        return users;
    }

    @Override
    public Optional<IUser> findByLogin(String login) {
        return this.users.stream().filter(u -> u.getLogin().equals(login))
                .findFirst();
    }

    @Override
    public void register(IUser user) {
        users.add(user);
    }

    @Override
    public boolean ifUserExist(String login) {
        Optional<IUser> user = this.users.stream().filter(u -> u.getLogin().equals(login)).findFirst();
        return user.isPresent() && user.get().getLogin().equals(login);
    }

    @Override
    public boolean giveAdminStatus(String name) {
        Optional<IUser> user = this.users.stream()
                .filter(u -> u.getLogin().equals(name)).findFirst();
        if (user.isPresent() && user.get().getRole().equals(User.Role.USER)) {
            user.get().setRole(User.Role.ADMIN);
            return true;
        }
        return false;
    }

    public static UserDB getInstance() {
        return instance;
    }
}

