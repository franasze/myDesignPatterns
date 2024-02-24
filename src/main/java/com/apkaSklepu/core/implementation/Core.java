package com.apkaSklepu.core.implementation;

import com.apkaSklepu.database.IProductDB;
import com.apkaSklepu.database.IUserDB;
import com.apkaSklepu.database.implementation.ProductDB;
import com.apkaSklepu.database.implementation.UserDB;
import com.apkaSklepu.exceptions.IncorrectPasswordException;
import com.apkaSklepu.exceptions.UserNotFoundException;
import com.apkaSklepu.gui.implementation.Color;
import com.apkaSklepu.gui.implementation.GUI;
import com.apkaSklepu.gui.implementation.GUIDecorator;
import com.apkaSklepu.model.implementation.User;

import java.util.InputMismatchException;

public class Core {
    private static final IProductDB productDB = ProductDB.getInstance();
    private static final IUserDB userDB = UserDB.getInstance();
    private static final GUI gui = GUI.getInstance();
    private static final Authenticator authenticator = Authenticator.getInstance();
    private static final Core instance = new Core();
    private static final GUIDecorator guiDecorator = new GUIDecorator(gui, Color.RED,Color.BLACK);



    public void start() {
        boolean isRunning = false;

        while (true) {
            while (!isRunning) {
                switch (guiDecorator.showLogMenu()) {
                    case "1" -> userDB.register(Registration.createNewUser());
                    case "2" -> {
                        try {
                            authenticator.authenticate(gui.readLoginAndPassword());
                            isRunning = authenticator.loggedUser != null;
                        } catch (UserNotFoundException | IncorrectPasswordException e) {
                            System.out.println("Incorrect authentication");
                        }
                    }
                    case "3" -> System.exit(0);
                    default -> System.out.println("Wrong choose !!");
                }
            }

            while (isRunning) {
                switch (gui.showMenu()) {
                    case "1" -> {
                        gui.showProductsList();
                        try {
                            gui.showBuyEffect(productDB.buyProduct(gui.readName(), gui.readQuantity()));
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid value\n");
                        }
                        gui.showProductsList();
                    }
                    case "2" -> isRunning = false;
                    case "3" -> {
                        if (authenticator.loggedUser != null && authenticator
                                .loggedUser.getRole().equals(User.Role.ADMIN)) {
                            gui.showProductsList();
                            try {
                                gui.showChangeQuantityEffect(productDB.changeProductQuantity(
                                        gui.readName(), gui.readQuantity()));
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid value\n");
                            }
                            gui.showProductsList();
                        }
                    }
                    case "4" -> {
                        if (authenticator.loggedUser != null && authenticator
                                .loggedUser.getRole().equals(User.Role.ADMIN)) {
                            gui.showUsersList();
                            gui.showAdminStatus(userDB.giveAdminStatus(gui.readUser()));
                        }
                    }
                    default -> System.out.println("Wrong choose!");
                }
            }
        }
    }

    public static Core getInstance() {
        return instance;
    }
}
