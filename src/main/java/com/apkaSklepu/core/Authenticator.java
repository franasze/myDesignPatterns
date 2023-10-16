package com.apkaSklepu.core;

import com.apkaSklepu.database.UserDB;
import com.apkaSklepu.exceptions.IncorrectPasswordException;
import com.apkaSklepu.exceptions.UserNotFoundException;
import com.apkaSklepu.model.User;


import java.util.Optional;

public class Authenticator {//need to fix

    private UserDB userDB = UserDB.getInstance();
    private static final Authenticator instance = new Authenticator();
    public User loggedUser = null;
    public final String seed = "12312312312312asdqw1@r";

    private Authenticator() {
    }

    public void authenticate(User user) {
        Optional<User> userFromDB = this.userDB.findByLogin(user.getLogin());

        if(userFromDB.isEmpty()){
            throw new UserNotFoundException();
        }

        if(!userFromDB.get().getPassword().equals((user.getPassword()))) {
            throw new IncorrectPasswordException();
        }
        this.loggedUser = userFromDB.get();
    }


     public static Authenticator getInstance() {
        return instance;
    }

}