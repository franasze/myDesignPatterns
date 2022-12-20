package com.apkaSklepu.core;

import com.apkaSklepu.database.UserDB;
import com.apkaSklepu.model.User;

public class Authenticator {

    UserDB userDB = UserDB.getInstance();
    private static final Authenticator instance = new Authenticator();
    public User loggedUser = null;

    private Authenticator() {

    }

    public void authenticate(User user) {
        User userFromDB = this.userDB.findByLogin(user.getLogin());
        if(userFromDB != null &&
                userFromDB.getPassword().equals(
                        (user.getPassword()))) {
            loggedUser = userFromDB;
        }
    }


    public final String seed = "12312312312312asdqw1@r";

     public static Authenticator getInstance() {
        return instance;
    }

//    public String getSeed() {
//        return seed;
//    }
}