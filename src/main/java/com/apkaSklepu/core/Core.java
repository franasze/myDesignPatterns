package com.apkaSklepu.core;

import com.apkaSklepu.database.ProductDB;
import com.apkaSklepu.database.UserDB;
import com.apkaSklepu.gui.GUI;
import com.apkaSklepu.model.User;

public class Core {

    public static void start() {
        final ProductDB productDB = ProductDB.getInstance();
        final UserDB userDB = UserDB.getInstance();
        final Authenticator authenticator = Authenticator.getInstance();
        boolean isRunning = false;

        while(true) {
            while (!isRunning) {
                switch (GUI.showLogMenu()) {
                    case "1":
                        userDB.register(Registration.createNewUser());
                        break;
                    case "2":
                        authenticator.authenticate(GUI.readLoginAndPassword());
                        isRunning = authenticator.loggedUser != null;
                        if (!isRunning)
                            System.out.println("Not authorized !");
                        break;
                    case "3":
                        System.exit(0);
                    default:
                        System.out.println("Wrong choose !!");
                        break;
                }
            }

            while (isRunning) {
                switch (GUI.showMenu()) {
                    case "1":
                        GUI.showProductsList();
                        GUI.showBuyEffect(productDB.buyProduct(GUI.readName(),GUI.readQuantity()));
                        GUI.showProductsList();
                        break;
                    case "2":
                        isRunning = false;
                        break;
                    case "3":
                        if (authenticator.loggedUser != null && authenticator
                                .loggedUser.getRole().equals(User.Role.ADMIN)) {
                            GUI.showProductsList();
                            GUI.showChangeQuantityEffect(productDB.changeProductQuantity(
                                    GUI.readName(),GUI.readQuantity()));
                            GUI.showProductsList();
                        }
                        break;
                    case "4":
                        if (authenticator.loggedUser != null && authenticator
                                .loggedUser.getRole().equals(User.Role.ADMIN)) {
                            GUI.showUsersList();
                            GUI.showAdminStatus(userDB.giveAdminStatus(GUI.readUser()));
                        }
                        break;
                    default:
                        System.out.println("Wrong choose!");
                        break;
                }
            }
        }
    }
}
