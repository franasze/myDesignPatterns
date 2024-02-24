package com.apkaSklepu.gui;

import com.apkaSklepu.model.implementation.User;

public interface IGUI extends IGUIDecorator {
    String showMenu();

    User readLoginAndPassword();

    String readName();

    int readQuantity();

    String readUser();

    void showEffectRegistration(boolean effect);

    void showProductsList();

    void showUsersList();

    void showBuyEffect(boolean effect);

    void showChangeQuantityEffect(boolean effect);

    void showAdminStatus(boolean effect);
}