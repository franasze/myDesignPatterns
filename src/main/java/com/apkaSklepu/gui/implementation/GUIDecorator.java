package com.apkaSklepu.gui.implementation;


import com.apkaSklepu.gui.IGUIDecorator;

import java.util.Scanner;

public class GUIDecorator implements IGUIDecorator {
    private final GUI gui;
    private final Color foreground;
    private final Color background;
    private static final Scanner scanner = new Scanner(System.in);

    public GUIDecorator(GUI gui, Color foreground, Color background) {
        this.gui = gui;
        this.foreground = foreground;
        this.background = background;
    }

    @Override
    public String showLogMenu() {
        String foregroundColor = foreground.getForeground();
        String backgroundColor = background.getBackground();
        String resetColor = "\u001B[0m";
        String menu =  backgroundColor + foregroundColor + """
                1.Registration
                2.Login
                3.Exit
                 """ + resetColor;
        System.out.print(menu);

        return scanner.nextLine();
    }

}
