package com.apkaSklepu.core;

import com.apkaSklepu.database.UserDB;
import com.apkaSklepu.model.User;

import java.util.Optional;

public class Authenticator {

    UserDB userDB = UserDB.getInstance();
    private static final Authenticator instance = new Authenticator();
    public User loggedUser = null;

    private Authenticator() {

    }

    public void authenticate(User user) {
        Optional<User> userFromDB = this.userDB.findByLogin(user.getLogin());
        if(userFromDB.isPresent() &&
                userFromDB.get().getPassword().equals(
                        (user.getPassword()))) {
            this.loggedUser = userFromDB.get();
        }
    }


    public final String seed = "12312312312312asdqw1@r";

     public static Authenticator getInstance() {
        return instance;
    }

}