package com.apkaSklepu.database;

import com.apkaSklepu.model.IUser;

import java.util.List;
import java.util.Optional;

public interface IUserDB {

    List<IUser> getUsers();

    Optional<IUser> findByLogin(String login);

    boolean giveAdminStatus(String name);

    boolean ifUserExist(String login);

    void register(IUser user);

}
