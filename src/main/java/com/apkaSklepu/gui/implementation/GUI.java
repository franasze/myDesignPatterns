package com.apkaSklepu.gui.implementation;

import com.apkaSklepu.core.implementation.Authenticator;
import com.apkaSklepu.database.implementation.ProductDB;
import com.apkaSklepu.database.implementation.UserDB;
import com.apkaSklepu.gui.IGUI;
import com.apkaSklepu.model.implementation.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Scanner;

public class GUI implements IGUI {

    private static final GUI instance = new GUI();
    private static final Scanner scanner = new Scanner(System.in);

    private GUI() {
    }

    @Override
    public String showLogMenu() {
        String menu = """
                1.Registration
                2.Login
                3.Exit
                 """;
        System.out.print(menu);

        return scanner.nextLine();
    }
    @Override
    public String showMenu() {
        Authenticator authenticator = Authenticator.getInstance();
        System.out.println("1. Buy product");
        System.out.println("2. Logout");

        if (authenticator.loggedUser != null &&
                authenticator.loggedUser.getRole().equals(User.Role.ADMIN)) {
            System.out.println("3. Add quantity of product");
            System.out.println("4. Give admin status");
        }
        return scanner.nextLine();
    }
    @Override
    public User readLoginAndPassword() {
        Authenticator authenticator = Authenticator.getInstance();
        User user = new User();
        System.out.println("Login:");
        user.setLogin(scanner.nextLine());
        System.out.println("Password:");
        user.setPassword(DigestUtils.md5Hex(scanner.nextLine() + authenticator.seed));
        return user;
    }
    @Override
    public String readName() {
        System.out.println("Product name:");
        return scanner.nextLine();
    }
    @Override
    public int readQuantity() {
        System.out.println("Product quantity:");
        return scanner.nextInt();
    }
    @Override
    public String readUser() {
        System.out.println("User name:");
        return scanner.nextLine();
    }
    @Override
    public void showEffectRegistration(boolean effect) {
        if (effect)
            System.out.println("Registered successful");
        else
            System.out.println("login is taken, please try again");
    }
    @Override
    public void showProductsList() {
        ProductDB productDB = ProductDB.getInstance();
        System.out.println("Name\t\tPrice\t\t\t Quantity");
        productDB.getProducts().forEach(System.out::println);
        System.out.println("\n");
    }
    @Override
    public void showUsersList() {
        UserDB userDB = UserDB.getInstance();
        System.out.println("Login   Role");
        userDB.getUsers().forEach(System.out::println);
    }
    @Override
    public void showBuyEffect(boolean effect) {
        if (effect) {
            System.out.println("The Products successful bought\n");
        } else {
            System.out.println("The Product doesn't exist \n");
        }
    }
    @Override
    public void showChangeQuantityEffect(boolean effect) {
        if (effect) {
            System.out.println("Quantity successful changed\n");
        } else {
            System.out.println("The Product doesn't exist\n");
        }
    }
    @Override
    public void showAdminStatus(boolean effect) {
        if (effect) {
            System.out.println("User is admin now\n");
        } else {
            System.out.println("User doesn't exist or is already admin\n");
        }
    }

    public static GUI getInstance() {
        return instance;
    }

}