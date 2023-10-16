package com.apkaSklepu.core;

import com.apkaSklepu.database.ProductDB;
import com.apkaSklepu.database.UserDB;
import com.apkaSklepu.exceptions.IncorrectPasswordException;
import com.apkaSklepu.exceptions.UserNotFoundException;
import com.apkaSklepu.gui.GUI;
import com.apkaSklepu.model.User;

import java.util.InputMismatchException;

public class Core {
    private final ProductDB productDB = ProductDB.getInstance();
    private final UserDB userDB = UserDB.getInstance();
    private final Authenticator authenticator = Authenticator.getInstance();
    private static final Core instance = new Core();

    public void start() {
        boolean isRunning = false;

        while(true) {
            while (!isRunning) {
                switch (GUI.showLogMenu()) {
                    case "1" -> userDB.register(Registration.createNewUser());
                    case "2" -> {
                        try {
                            authenticator.authenticate(GUI.readLoginAndPassword());
                            isRunning = authenticator.loggedUser != null;
                        }catch(UserNotFoundException | IncorrectPasswordException e){
                            System.out.println("Incorrect authentication");
                        }
                    }
                    case "3" -> System.exit(0);
                    default -> System.out.println("Wrong choose !!");
                }
            }

            while (isRunning) {
                switch (GUI.showMenu()) {
                    case "1" -> {
                        GUI.showProductsList();
                        try {
                            GUI.showBuyEffect(productDB.buyProduct(GUI.readName(), GUI.readQuantity()));
                        }catch(InputMismatchException e){
                            System.out.println("Invalid value\n");
                        }
                        GUI.showProductsList();
                    }
                    case "2" -> isRunning = false;
                    case "3" -> {
                        if (authenticator.loggedUser != null && authenticator
                                .loggedUser.getRole().equals(User.Role.ADMIN)) {
                            GUI.showProductsList();
                            try{
                            GUI.showChangeQuantityEffect(productDB.changeProductQuantity(
                                    GUI.readName(), GUI.readQuantity()));
                            }catch(InputMismatchException e){
                                System.out.println("Invalid value\n");
                            }
                            GUI.showProductsList();
                        }
                    }
                    case "4" -> {
                        if (authenticator.loggedUser != null && authenticator
                                .loggedUser.getRole().equals(User.Role.ADMIN)) {
                            GUI.showUsersList();
                            GUI.showAdminStatus(userDB.giveAdminStatus(GUI.readUser()));
                        }
                    }
                    default -> System.out.println("Wrong choose!");
                }
            }
        }
    }
    public static Core getInstance(){
        return instance;
    }
}
