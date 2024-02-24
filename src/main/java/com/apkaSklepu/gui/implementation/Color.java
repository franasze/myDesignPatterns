package com.apkaSklepu.gui.implementation;

public enum Color {
    RED("\u001b[31m", "\u001b[41m"),
    GREEN("\u001b[32m", "\u001b[42m"),
    BLUE("\u001b[34m", "\u001b[44m"),
    WHITE("\u001b[37m", "\u001b[47m"),
    BLACK("\u001b[30m", "\u001b[40m");

    private final String foreground;
    private final String background;

    Color(String foreground, String background) {
        this.foreground = foreground;
        this.background = background;
    }

    public String getForeground() {
        return foreground;
    }

    public String getBackground() {
        return background;
    }
}
