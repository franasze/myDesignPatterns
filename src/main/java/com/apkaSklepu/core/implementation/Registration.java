package com.apkaSklepu.core.implementation;

import com.apkaSklepu.core.IRegistration;
import com.apkaSklepu.database.IUserDB;
import com.apkaSklepu.database.implementation.UserDB;
import com.apkaSklepu.gui.implementation.GUI;
import com.apkaSklepu.model.IUser;
import com.apkaSklepu.model.implementation.User;


public class Registration implements IRegistration {
    private static final IUserDB userDB = UserDB.getInstance();
    private static final GUI gui = GUI.getInstance();


    public static IUser createNewUser() {
        IUser newUser = new User();
        boolean registered = false;
        while (!registered) {
            newUser = gui.readLoginAndPassword();
            if (!userDB.ifUserExist(newUser.getLogin()))
                registered = true;
            gui.showEffectRegistration(registered);
        }
        return newUser;

    }
}
