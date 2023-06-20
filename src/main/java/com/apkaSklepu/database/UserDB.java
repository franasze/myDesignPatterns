package com.apkaSklepu.database;

import com.apkaSklepu.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDB {

    private final List<User> users = new ArrayList<>();
    private static final UserDB instance = new UserDB();


    public UserDB() {
        this.users.add(new User("admin", "a5c110f5ec7cda3eb0b241b1a2ca73e0", User.Role.ADMIN));
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> findByLogin(String login) {
        return this.users.stream().filter(u->u.getLogin().equals(login))
                .findFirst();
    }

    public static UserDB getInstance(){
        return instance;
    }
    public void register(User user){
        users.add(user);
    }

    public boolean ifUserExist(String login) {
        Optional<User> user = this.users.stream().filter(u->u.getLogin().equals(login)).findFirst();
        return user.isPresent() && user.get().getLogin().equals(login);
    }

    public boolean giveAdminStatus(String name){
       Optional<User> user = this.users.stream()
               .filter(u->u.getLogin().equals(name)).findFirst();
            if(user.isPresent() && user.get().getRole().equals(User.Role.USER)){
                user.get().setRole(User.Role.ADMIN);
                return true;
            }
        return false;
    }
}

