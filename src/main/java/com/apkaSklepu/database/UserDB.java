package com.apkaSklepu.database;

import com.apkaSklepu.model.User;


public class UserDB {

    private User[] users = new User[1];
    private static final UserDB instance = new UserDB();


    public UserDB() {
        this.users[0] = new User("admin", "a5c110f5ec7cda3eb0b241b1a2ca73e0", User.Role.ADMIN);
    }

    public User[] getUsers() {
        return users;
    }

    public User findByLogin(String login) {
        for (User user : this.users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public static UserDB getInstance(){
        return instance;
    }
    public void register(User user){
        User[] newUsers = new User[this.users.length + 1];
        for(int i = 0; i < this.users.length; i++) {
            newUsers[i] = this.users[i];
        }
        newUsers[newUsers.length - 1] = user;
        this.users = newUsers;
    }

    public boolean ifUserExist(String login) {
        for (User user : this.users){
            if(user.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public boolean giveAdminStatus(String name){
        for(User user : this.users){
            if(user.getLogin().equals(name) && user.getRole().equals(User.Role.USER)){
                user.setRole(User.Role.ADMIN);
                return true;
            }
        }
        return false;
    }
}

