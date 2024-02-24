package com.apkaSklepu.core.implementation;

import com.apkaSklepu.core.IAuthenticator;
import com.apkaSklepu.database.implementation.UserDB;
import com.apkaSklepu.exceptions.IncorrectPasswordException;
import com.apkaSklepu.exceptions.UserNotFoundException;
import com.apkaSklepu.model.IUser;


import java.util.Optional;

public class Authenticator implements IAuthenticator {

    private final UserDB userDB = UserDB.getInstance();
    private static final Authenticator instance = new Authenticator();
    public IUser loggedUser = null;
    public final String seed = "12312312312312asdqw1@r";

    private Authenticator() {
    }

    public void authenticate(IUser user) {
        Optional<IUser> userFromDB = userDB.findByLogin(user.getLogin());

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